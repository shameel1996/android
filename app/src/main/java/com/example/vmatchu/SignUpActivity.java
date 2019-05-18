package com.example.vmatchu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vmatchu.CustomAlert.CustomAlert;
import com.example.vmatchu.Pojo.UserSignup;
import com.example.vmatchu.Rest.APIService;
import com.example.vmatchu.Rest.ApiUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_uname;
    EditText et_password;
    EditText et_email;
    Button btn_signup;
    ProgressDialog progressDialog;
    String uname,pass,email;
    APIService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initialize();
    }

    private void initialize() {
        et_uname = findViewById(R.id.userName);
        et_password = findViewById(R.id.Password);
        et_email = findViewById(R.id.Email);
        btn_signup = findViewById(R.id.signUp);

        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        apiService = ApiUtil.getAPIService();

        btn_signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signUp:
                progressDialog.show();
//                startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
                uname = et_uname.getText().toString();
                pass = et_password.getText().toString();
                email = et_email.getText().toString();

                if(!TextUtils.isEmpty(uname) && !TextUtils.isEmpty(pass) && !TextUtils.isEmpty(email)) {
                    postSignUpApi(uname, email, pass);
                }
                break;

        }
    }

    private void postSignUpApi(String uname, String pass, String email) {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
        Call<UserSignup> call = apiService.postSignUp(uname, email, pass, currentDate);

        call.enqueue(new Callback<UserSignup>() {

            @Override
            public void onResponse(Call<UserSignup> call, Response<UserSignup> response) {
                if(response.isSuccessful()) {
                    progressDialog.dismiss();
                    UserSignup signupResponse = response.body();
                    if(signupResponse.getError().equals("-1")){
                        startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
                    }
                    Log.i("response", "post submitted to API." + signupResponse);
                }
            }

            @Override
            public void onFailure(Call<UserSignup> call, Throwable t) {
                progressDialog.dismiss();
                CustomAlert.alertDialog(SignUpActivity.this,"Response failed");
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }
}
