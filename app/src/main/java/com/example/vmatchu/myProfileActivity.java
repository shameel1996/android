package com.example.vmatchu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class myProfileActivity extends AppCompatActivity {

    Button agentBTN;
    TextView agentText,terms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        agentBTN=(Button)findViewById(R.id.agentbtn);
        agentText=(TextView)findViewById(R.id.textforagent);
        terms=(TextView)findViewById(R.id.termandcondition);
        agentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agentBTN.setText("Remove Agent Account");
                agentText.setText("Your account need to be approved by admin to become an agent, if you want to return to normal account, you must click the button below");
                terms.setVisibility(View.GONE);

            }
        });


    }
}
