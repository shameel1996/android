package com.example.vmatchu;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.vmatchu.CustomAlert.CustomAlert;
import com.example.vmatchu.DBhelper.DBhelper;
import com.example.vmatchu.Pojo.PropertyType;
import com.example.vmatchu.Pojo.RemainingMoneyResponse;
import com.example.vmatchu.Pojo.UserLogin;
import com.example.vmatchu.Rest.APIService;
import com.example.vmatchu.Rest.ApiUtil;
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button Whatsapp, mypro, subpro;
    ProgressDialog progressDialog;
    APIService apiService;
    DBhelper dBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initialize();

        getPropertyTypeData();
        getRemainingMoneyData();

        final Dialog dialog = new Dialog(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        Whatsapp = (Button) findViewById(R.id.whatsapp);
        mypro = (Button) findViewById(R.id.myProper);
        mypro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, myProperty.class));
            }
        });

        subpro = (Button) findViewById(R.id.mySUb);
        subpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, submitProperty.class));
            }
        });
        Whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contact = "+92 3172504395"; // use country code with your phone number
                String url = "https://api.whatsapp.com/send?phone=" + contact;
                try {

                    PackageManager pm = getPackageManager();
                    pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(HomeActivity.this, "Whatsapp app not installed in your phone", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void getRemainingMoneyData() {

        String userid = SaveInSharedPreference.getInSharedPreference(this).getUserId();
        Call<RemainingMoneyResponse> call = apiService.getRemainingMoney(SaveInSharedPreference.getInSharedPreference(this).getUserId());

        call.enqueue(new Callback<RemainingMoneyResponse>() {

            @Override
            public void onResponse(Call<RemainingMoneyResponse> call, Response<RemainingMoneyResponse> response) {
                if (response.isSuccessful()) {
                    RemainingMoneyResponse remainingMoneyResponse = response.body();
                    if (remainingMoneyResponse.getError().equals("-1")) {

                        SaveInSharedPreference.getInSharedPreference(HomeActivity.this).saveRemainingMoney(remainingMoneyResponse.getValue());

                        progressDialog.dismiss();
                    }
                    Log.i("response", "post submitted to API." + remainingMoneyResponse);
                }
            }

            @Override
            public void onFailure(Call<RemainingMoneyResponse> call, Throwable t) {
                progressDialog.dismiss();
                CustomAlert.alertDialog(HomeActivity.this, "Response failed");
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }

    private void initialize() {
        progressDialog = new ProgressDialog(HomeActivity.this);
        progressDialog.setMessage("Syncing data...");
        progressDialog.setCancelable(false);

        apiService = ApiUtil.getAPIService();

        dBhelper = new DBhelper(this);
    }

    private void getPropertyTypeData() {
        progressDialog.show();

        Call<PropertyType> call = apiService.getProperty();

        call.enqueue(new Callback<PropertyType>() {

            @Override
            public void onResponse(Call<PropertyType> call, Response<PropertyType> response) {
                if (response.isSuccessful()) {
                    PropertyType propertyTypeResponse = response.body();
                    if (propertyTypeResponse.getError().equals("-1")) {
                        for (int i = 0; i < propertyTypeResponse.getData().size(); i++) {
                            dBhelper.addPropertyTypeData(propertyTypeResponse.getData().get(i).getTermId(),
                                    propertyTypeResponse.getData().get(i).getPropertyName());
                        }
                    }
                    Log.i("response", "post submitted to API." + propertyTypeResponse);
                }
            }

            @Override
            public void onFailure(Call<PropertyType> call, Throwable t) {
                progressDialog.dismiss();
                CustomAlert.alertDialog(HomeActivity.this, "Response failed");
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        displaySelectedScreen(item.getItemId());

        return true;
    }


    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_home:
                //fragment = new Home();
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                break;
            case R.id.nav_package:
                fragment = new Package();
                break;
            case R.id.nav_project:
                fragment = new Project();
                break;
            case R.id.nav_contact:
                fragment = new Contact();
                break;
            case R.id.nav_aboutus:
                //fragment = new AboutUs();
                startActivity(new Intent(HomeActivity.this, Home2activity.class));
                break;
            case R.id.nav_myacoount:
                startActivity(new Intent(HomeActivity.this, myProfileActivity.class));
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
