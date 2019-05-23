package com.example.vmatchu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vmatchu.CustomAlert.CustomAlert;
import com.example.vmatchu.Pojo.UserLogin;
import com.example.vmatchu.Pojo.UserSignup;
import com.example.vmatchu.Prevelent.Prevalent;
import com.example.vmatchu.R;
import com.example.vmatchu.Rest.APIService;
import com.example.vmatchu.Rest.ApiUtil;
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signInActivity extends AppCompatActivity {

    Button signIn;
    TextView newAcc;
    EditText et_username,et_password;
    String uname, pass;
    ProgressDialog progressDialog;
    APIService apiService;
    CheckBox rememberMe;

    public static String  PREFS_NAME="mypre";
    public static String PREF_USERNAME="username";
    public static String PREF_PASSWORD="password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

       initialize();

        //signIn=(Button)findViewById(R.id.signin);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(signInActivity.this,HomeActivity.class));
                progressDialog.show();
                uname = et_username.getText().toString();
                pass = et_password.getText().toString();


                if(!TextUtils.isEmpty(uname) && !TextUtils.isEmpty(pass)) {
                    postLogInApi(uname, pass);
                }
            }
        });

        newAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signInActivity.this,SignUpActivity.class));
            }
        });
    }

    private void postLogInApi(final String uname, final String pass) {
        Call<UserLogin> call = apiService.postLogin(uname, pass);

        call.enqueue(new Callback<UserLogin>() {

            @Override
            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                if(response.isSuccessful()) {
                    progressDialog.dismiss();
                    UserLogin signupResponse = response.body();
                    if(signupResponse.getError().equals("-1")){
                        SaveInSharedPreference.getInSharedPreference(signInActivity.this).saveUserId(signupResponse.getId());
                       // startActivity(new Intent(signInActivity.this,HomeActivity.class));
                        if(rememberMe.isChecked()){
                            rememberme(uname,pass); //save username and password
                        //show logout activity
                        showLogout();

                    }
                    else {

                                rememberme(uname,pass); //save username and password
                                //show logout activity
                                showLogout();
                    }

                }
                    Log.i("response", "post submitted to API." + signupResponse);
                }
            }

            @Override
            public void onFailure(Call<UserLogin> call, Throwable t) {
                progressDialog.dismiss();
                CustomAlert.alertDialog(signInActivity.this,"Response failed");
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }

    private void initialize() {
       signIn=(Button)findViewById(R.id.signin);
        newAcc=(TextView)findViewById(R.id.createAcc);
        et_username = findViewById(R.id.userName);
        et_password = findViewById(R.id.Password);


        rememberMe=findViewById(R.id.remeberMe);
        apiService = ApiUtil.getAPIService();

        progressDialog = new ProgressDialog(signInActivity.this);
        progressDialog.setMessage("Signing in...");
        progressDialog.setCancelable(false);

    }
    @Override
    public void onStart(){
        super.onStart();
        //read username and password from SharedPreferences
        getUser();
    }

    private void getUser() {
        SharedPreferences pref = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String username = pref.getString(PREF_USERNAME, null);
        String password = pref.getString(PREF_PASSWORD, null);

        if (username != null || password != null) {
            //directly show logout form
            showLogout();
        }
    }

    private void showLogout( ) {
        Intent intent=new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void rememberme(String user, String password){
        //save username and password in SharedPreferences
        getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                .edit()
                .putString(PREF_USERNAME,user)
                .putString(PREF_PASSWORD,password)
                .commit();
    }

}
