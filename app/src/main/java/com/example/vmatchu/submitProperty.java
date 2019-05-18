package com.example.vmatchu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class submitProperty extends AppCompatActivity {

    ImageView sell,purchase,rent_take,rent_give;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_property);
        sell=(ImageView)findViewById(R.id.selProp);
        rent_take=(ImageView)findViewById(R.id.onRent);
        rent_give=(ImageView)findViewById(R.id.giveOnRent);
        purchase=(ImageView)findViewById(R.id.purProp);

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(submitProperty.this,EnterPropertyDetailActivity.class);
             DemoClass.status="For Sell";
              startActivity(intent);
            }
        });
        rent_give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(submitProperty.this,EnterPropertyDetailActivity.class);
                DemoClass.status="Give On Rent";
                startActivity(intent);
            }
        });
        rent_take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(submitProperty.this,EnterProperptyDetails2Activity.class);
                DemoClass.status="Take On Rent";
                startActivity(intent);            }
        });
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(submitProperty.this,EnterProperptyDetails2Activity.class);
                DemoClass.status="For Purchase";
                startActivity(intent);
            }
        });
    }

}
