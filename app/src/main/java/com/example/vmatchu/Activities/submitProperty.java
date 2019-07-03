package com.example.vmatchu.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.vmatchu.DemoClass;
import com.example.vmatchu.R;

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


        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbarSubmitProperty);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(submitProperty.this, EnterPropertyDetailActivity.class);
             DemoClass.status="For Sale";
              startActivity(intent);
            }
        });
        rent_give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(submitProperty.this,EnterPropertyDetailActivity.class);
                DemoClass.status="For Rent";
                startActivity(intent);
            }
        });
        rent_take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(submitProperty.this, EnterProperptyDetails2Activity.class);
                DemoClass.status="Want Rent";
                startActivity(intent);            }
        });
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(submitProperty.this,EnterProperptyDetails2Activity.class);
                DemoClass.status="Want Buy";
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(submitProperty.this, HomeActivity.class));
        super.onBackPressed();
    }
}
