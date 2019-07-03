package com.example.vmatchu.Activities;

import android.app.ProgressDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.vmatchu.Adpaters.MatchPropertyAdapter;
import com.example.vmatchu.CustomAlert.CustomAlert;
import com.example.vmatchu.DBhelper.DBhelper;
import com.example.vmatchu.Models.MathchedPropertyForDB;
import com.example.vmatchu.Pojo.MyPropertyArea;
import com.example.vmatchu.Pojo.MyPropertyAreaType;
import com.example.vmatchu.Pojo.MyPropertyBathrooms;
import com.example.vmatchu.Pojo.MyPropertyBedrooms;
import com.example.vmatchu.Pojo.MyPropertyCity;
import com.example.vmatchu.Pojo.MyPropertyData;
import com.example.vmatchu.Pojo.MyPropertyDescription;
import com.example.vmatchu.Pojo.MyPropertyGarages;
import com.example.vmatchu.Pojo.MyPropertyPropertyType;
import com.example.vmatchu.Pojo.MyPropertyResponse;
import com.example.vmatchu.Pojo.MyPropertyRooms;
import com.example.vmatchu.Pojo.MyPropertySector;
import com.example.vmatchu.Pojo.MyPropertyStatus;
import com.example.vmatchu.Pojo.MyPropertySubArea;
import com.example.vmatchu.R;
import com.example.vmatchu.Rest.APIService;
import com.example.vmatchu.Rest.ApiUtil;
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchPropertyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;
    DBhelper dBhelper;
    private ArrayList<MathchedPropertyForDB> matchPropertyList;
    MatchPropertyAdapter matchPropertyAdapter;
    String pid;
    ProgressDialog progressDialog;
    private APIService apiService;
    private List<MyPropertyData> propertyResponsesList1;

    private List<MyPropertyCity> propertyResponsesCityList1;
    private List<MyPropertyStatus> propertyResponsesStatusList1;
    private List<MyPropertyArea> propertyResponsesAreaList1;
    private List<MyPropertySubArea> propertyResponsesSubareaList1;
    private List<MyPropertySector> propertyResponsesSectorList1;
    private List<MyPropertyGarages> propertyResponsesGaragesList1;
    private List<MyPropertyBathrooms> propertyResponsesBathroomList1;
    private List<MyPropertyBedrooms> propertyResponsesBedroomList1;
    private List<MyPropertyRooms> propertyResponsesRoomList1;
    private List<MyPropertyDescription> propertyResponsesDescriptionList1;
    private List<MyPropertyAreaType> propertyResponsesAreaTypeList1;
    private List<MyPropertyPropertyType> propertyResponsesPropertyTypeList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_property);

        pid = getIntent().getStringExtra("pid");
        initViews();
        getMatchPropertyResponse();
//        matchPropertyList = dBhelper.getMatchProperty(pid);

//        if(matchPropertyList.size() == 0){
//            AlertDialog.Builder alert = new AlertDialog.Builder(this);
//            alert.setMessage("No Matches Found");
//            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    finish();
//                }
//            });
//            alert.show();
//        }
//
//        else{
//            setRecyclerView();
//        }

    }

    private void getMatchPropertyResponse() {
        progressDialog.show();
        String userid = SaveInSharedPreference.getInSharedPreference(this).getUserId();
        Call<MyPropertyResponse> call = apiService.getMatchingProperty(SaveInSharedPreference.getInSharedPreference(this).getUserId(), pid);

        call.enqueue(new Callback<MyPropertyResponse>() {

            @Override
            public void onResponse(Call<MyPropertyResponse> call, Response<MyPropertyResponse> response) {
                if (response.isSuccessful()) {
                    MyPropertyResponse matchedPropertyResponse = response.body();
                    if (matchedPropertyResponse.getError().equals("-1")) {

                        if (matchedPropertyResponse.getData().size() == 0) {
                            CustomAlert.alertDialog(MatchPropertyActivity.this, "No Match Found");
                            progressDialog.dismiss();
                        } else {
                            for (int i = 0; i < matchedPropertyResponse.getData().size(); i++) {

                                propertyResponsesList1 = matchedPropertyResponse.getData();
                                propertyResponsesCityList1 = matchedPropertyResponse.getCity();
                                propertyResponsesStatusList1 = matchedPropertyResponse.getStatus();
                                propertyResponsesAreaList1 = matchedPropertyResponse.getArea();
                                propertyResponsesSubareaList1 = matchedPropertyResponse.getSub_area();
                                propertyResponsesSectorList1 = matchedPropertyResponse.getSector();
                                propertyResponsesGaragesList1 = matchedPropertyResponse.getGarages();
                                propertyResponsesBathroomList1 = matchedPropertyResponse.getBathrooms();
                                propertyResponsesBedroomList1 = matchedPropertyResponse.getBedrooms();
                                propertyResponsesRoomList1 = matchedPropertyResponse.getRooms();
                                propertyResponsesDescriptionList1 = matchedPropertyResponse.getDescription();
                                propertyResponsesAreaTypeList1 = matchedPropertyResponse.getAreaType();
                                propertyResponsesPropertyTypeList1 = matchedPropertyResponse.getPropertyType();

                                setRecyclerView();
                            }

                            progressDialog.dismiss();
                        }

                    }

//                        citytxt.setText(dBhelper.getCityById(SaveInSharedPreference.getInSharedPreference(EnterPropertyDetailActivity.this).getCityId()));


                }
//                Log.i("response", "post submitted to API." + areaTypeResponse);
            }


            @Override
            public void onFailure(Call<MyPropertyResponse> call, Throwable t) {
                progressDialog.dismiss();
//                CustomAlert.alertDialog(myProperty.this, "Response Failed");
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }

    private void setRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MatchPropertyActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        matchPropertyAdapter = new MatchPropertyAdapter(MatchPropertyActivity.this, propertyResponsesList1,
                propertyResponsesCityList1, propertyResponsesStatusList1, propertyResponsesAreaList1,
                propertyResponsesSubareaList1,propertyResponsesSectorList1,propertyResponsesGaragesList1,
                propertyResponsesBathroomList1,propertyResponsesBedroomList1,propertyResponsesRoomList1,
                propertyResponsesDescriptionList1,propertyResponsesAreaTypeList1,propertyResponsesPropertyTypeList1);
        recyclerView.setAdapter(matchPropertyAdapter);
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dBhelper = new DBhelper(this);
        recyclerView = (RecyclerView) findViewById(R.id.content_match_property);
        matchPropertyList = new ArrayList<>();

        progressDialog = new ProgressDialog(MatchPropertyActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        apiService = ApiUtil.getAPIService();

        propertyResponsesList1 = new ArrayList<>();

        propertyResponsesCityList1 = new ArrayList<>();
        propertyResponsesStatusList1 = new ArrayList<>();
        propertyResponsesAreaList1 = new ArrayList<>();
        propertyResponsesSubareaList1 = new ArrayList<>();
        propertyResponsesSectorList1 = new ArrayList<>();
        propertyResponsesGaragesList1 = new ArrayList<>();
        propertyResponsesBathroomList1 = new ArrayList<>();
        propertyResponsesBedroomList1 = new ArrayList<>();
        propertyResponsesRoomList1 = new ArrayList<>();
        propertyResponsesDescriptionList1 = new ArrayList<>();
        propertyResponsesAreaTypeList1 = new ArrayList<>();
        propertyResponsesPropertyTypeList1 = new ArrayList<>();

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

//    @Override
//    public void onBackPressed() {
////        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
////        if (drawer.isDrawerOpen(GravityCompat.START)) {
////            drawer.closeDrawer(GravityCompat.START);
////        } else {
////            super.onBackPressed();
////        }
//    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_submit) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
