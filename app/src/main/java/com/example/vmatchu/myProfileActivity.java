package com.example.vmatchu;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vmatchu.CustomAlert.CustomAlert;
import com.example.vmatchu.Pojo.BecomeAnAgentResponse;
import com.example.vmatchu.Pojo.InsertPropertyResponse;
import com.example.vmatchu.Rest.APIService;
import com.example.vmatchu.Rest.ApiUtil;
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class myProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Button agentBTN;
    TextView agentText,terms;
    ProgressDialog progressDialog;
    private APIService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        Toolbar toolbar=findViewById(R.id.toolbarMyAccount);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

        progressDialog = new ProgressDialog(myProfileActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        apiService = ApiUtil.getAPIService();

        agentBTN=(Button)findViewById(R.id.agentbtn);
        agentText=(TextView)findViewById(R.id.textforagent);
        terms=(TextView)findViewById(R.id.termandcondition);
        agentBTN.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,HomeActivity.class));
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.agentbtn:
                agentBTN.setText("Remove Agent Account");
                agentText.setText("Your account need to be approved by admin to become an agent, if you want to return to normal account, you must click the button below");
                terms.setVisibility(View.GONE);

                postBecomeAnAgent();

                break;


        }
    }

    private void postBecomeAnAgent() {
        AlertDialog.Builder alert;
        alert = new AlertDialog.Builder(this);
        alert.setMessage("Do You Want To Become An Agent?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progressDialog.show();
                Call<BecomeAnAgentResponse> call = apiService.postBecomeAnAgentResponse(
                        SaveInSharedPreference.getInSharedPreference(myProfileActivity.this).getUserId());

                call.enqueue(new Callback<BecomeAnAgentResponse>() {

                    @Override
                    public void onResponse(Call<BecomeAnAgentResponse> call, Response<BecomeAnAgentResponse> response) {
                        if (response.isSuccessful()) {
                            BecomeAnAgentResponse becomeAnAgentResponse = response.body();
                            if (becomeAnAgentResponse.getError().equals("-1")) {
                                progressDialog.dismiss();
                                AlertDialog.Builder alertDone;
                                alertDone = new AlertDialog.Builder(myProfileActivity.this);
                                alertDone.setMessage("You are an agent now !");
                                alertDone.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        startActivity(new Intent(myProfileActivity.this,HomeActivity.class));
                                    }
                                });
                                alertDone.show();

                            }

                        }
//
                    }


                    @Override
                    public void onFailure(Call<BecomeAnAgentResponse> call, Throwable t) {
                        progressDialog.dismiss();
                        CustomAlert.alertDialog(myProfileActivity.this, "Response Failed");
                        Log.e("response_Failed", "Unable to submit post to API." + t);
                    }
                });


            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }
}
