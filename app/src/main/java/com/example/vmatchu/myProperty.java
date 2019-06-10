package com.example.vmatchu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vmatchu.Adpaters.AreaTypeAdapter;
import com.example.vmatchu.Adpaters.PropertyAdapter;
import com.example.vmatchu.Classes.PropertiesDetails;
import com.example.vmatchu.CustomAlert.CustomAlert;
import com.example.vmatchu.DBhelper.DBhelper;
import com.example.vmatchu.Interface.OnItemDeleteClick;
import com.example.vmatchu.Models.MyPropertyCityForDB;
import com.example.vmatchu.Models.MyPropertyStatusForDB;
import com.example.vmatchu.Pojo.AreaTypeResponse;
import com.example.vmatchu.Pojo.InsertPropertyResponse;
import com.example.vmatchu.Pojo.MatchedPropertyResponse;
import com.example.vmatchu.Pojo.MyPropertyArea;
import com.example.vmatchu.Pojo.MyPropertyAreaType;
import com.example.vmatchu.Pojo.MyPropertyBathrooms;
import com.example.vmatchu.Pojo.MyPropertyBedrooms;
import com.example.vmatchu.Pojo.MyPropertyCity;
import com.example.vmatchu.Pojo.MyPropertyData;
import com.example.vmatchu.Pojo.MyPropertyDescription;
import com.example.vmatchu.Pojo.MyPropertyForDB;
import com.example.vmatchu.Pojo.MyPropertyGarages;
import com.example.vmatchu.Pojo.MyPropertyIsClosed;
import com.example.vmatchu.Pojo.MyPropertyMaxPrice;
import com.example.vmatchu.Pojo.MyPropertyMaxSize;
import com.example.vmatchu.Pojo.MyPropertyMinPrice;
import com.example.vmatchu.Pojo.MyPropertyMinSize;
import com.example.vmatchu.Pojo.MyPropertyPropertyType;
import com.example.vmatchu.Pojo.MyPropertyResponse;
import com.example.vmatchu.Pojo.MyPropertyRooms;
import com.example.vmatchu.Pojo.MyPropertySector;
import com.example.vmatchu.Pojo.MyPropertyStatus;
import com.example.vmatchu.Pojo.MyPropertySubArea;
import com.example.vmatchu.Pojo.PropertyTypeData;
import com.example.vmatchu.Rest.APIService;
import com.example.vmatchu.Rest.ApiUtil;
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class myProperty extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnItemDeleteClick {

    private String[] DropDet = {"", "Deal Close", "Edit", "Delete", "Pause Matching"};
    private ArrayList<String> status = new ArrayList<>();
    private ArrayList<String> title = new ArrayList<>();
    private RecyclerView recyclerView;
    private PropertyAdapter adapter;
    private String status_value="";
    private String[] proType = {"All status", "For Rent", "For Sell", "want Rent", "want Buy"};
    private APIService apiService;
    DBhelper dBhelper;

    ProgressDialog progressDialog;
    ArrayAdapter<String> arrayAdapter;
    SpinnerDialog spinnerDialog;
    AlertDialog dialog;

    private ArrayList<MyPropertyForDB> propertyResponsesList = new ArrayList<>();

    private ArrayList<MyPropertyCityForDB> propertyResponsesCityList = new ArrayList<>();
    private ArrayList<MyPropertyStatusForDB> propertyResponsesStatusList = new ArrayList<>();

    private List<MyPropertyData> propertyResponsesList1 = new ArrayList<>();
    private List<MyPropertyIsClosed> propertyResponsesListIsClosed = new ArrayList<>();

    private List<MyPropertyCity> propertyResponsesCityList1 = new ArrayList<>();
    private List<MyPropertyStatus> propertyResponsesStatusList1 = new ArrayList<>();
    private List<MyPropertyArea> propertyResponsesAreaList1 = new ArrayList<>();
    private List<MyPropertySubArea> propertyResponsesSubareaList1 = new ArrayList<>();
    private List<MyPropertySector> propertyResponsesSectorList1 = new ArrayList<>();
    private List<MyPropertyGarages> propertyResponsesGaragesList1 = new ArrayList<>();
    private List<MyPropertyBathrooms> propertyResponsesBathroomList1 = new ArrayList<>();
    private List<MyPropertyBedrooms> propertyResponsesBedroomList1 = new ArrayList<>();
    private List<MyPropertyRooms> propertyResponsesRoomList1 = new ArrayList<>();
    private List<MyPropertyDescription> propertyResponsesDescriptionList1 = new ArrayList<>();
    private List<MyPropertyAreaType> propertyResponsesAreaTypeList1 = new ArrayList<>();
    private List<MyPropertyPropertyType> propertyResponsesPropertyTypeList1 = new ArrayList<>();
    private List<MyPropertyMinSize> propertyResponsesMinSizeList1 = new ArrayList<>();
    private List<MyPropertyMinPrice> propertyResponsesMinPriceList1 = new ArrayList<>();
    private List<MyPropertyMaxSize> propertyResponsesMaxSizeList1 = new ArrayList<>();
    private List<MyPropertyMaxPrice> propertyResponsesMaxPriceList1 = new ArrayList<>();

    private ArrayList<MyPropertyForDB> propertyResponsesListForFilter = new ArrayList<>();


    private MyPropertyForDB myPropertyForDB;

//    @Override
//    protected void onStart(){
//        super.onStart();
//        progressDialog.show();
//        getMyPropertyResponse();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_property);

//        myPropertyForDB=new MyPropertyForDB();

<<<<<<< HEAD


        Toolbar toolbar=findViewById(R.id.toolbarMyProperty);
=======
        Toolbar toolbar = findViewById(R.id.toolbarMyProperty);
>>>>>>> af700c286b58570ba248232e10954a4e88aba63a
        setSupportActionBar(toolbar);

        status.add("For Rent");
        status.add("For Sell");
        status.add("Want Rent");
        status.add("Want Buy");
        status.add("All Status");

        title.add("Home");
        title.add("Shop");
        title.add("Hall");
        title.add("Office");
        title.add("None");
        apiService = ApiUtil.getAPIService();
        dBhelper = new DBhelper(this);

        progressDialog = new ProgressDialog(myProperty.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        progressDialog.show();
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, DropDet);
        getMyPropertyResponse();

//        recyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(myProperty.this, PropertyDetailsActivity.class);
////                intent.putExtra("pid", propertiesDetails.get(i).getPid());
//                startActivity(new Intent(myProperty.this,PropertyDetailsActivity.class));
//
//            }
//        });


        //Register a callback to be invoked when an item in this AdapterView has been selected


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(myProperty.this);
                View view1 = getLayoutInflater().inflate(R.layout.filter, null);
                Spinner spinner = (Spinner) view1.findViewById(R.id.spinT);

                final EditText tittle_ed = (EditText) view1.findViewById(R.id.proTitle);
                final Button search = (Button) view1.findViewById(R.id.searchBTN);

                builder.setView(view1);
                dialog = builder.create();
                dialog.show();

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int position, long id) {

                        status_value = proType[position];


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {

                    }

                });

                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(myProperty.this, R.layout.spinner_item, proType);

                spinner.setAdapter(spinnerArrayAdapter);

                spinnerDialog = new SpinnerDialog(myProperty.this, title, "select Item");
                spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
                    @Override
                    public void onClick(String item, int position) {
                        tittle_ed.setText(item);
                    }
                });
                tittle_ed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spinnerDialog.showSpinerDialog();
                    }
                });

                search.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

//                        for(int i=0;i<propertyResponsesStatusList.size();i++) {
//                            if (status_value == propertyResponsesStatusList.get(i).getStatus()) {
//
//                                recyclerView = (RecyclerView) findViewById(R.id.content_my_property);
//                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(myProperty.this);
//                                recyclerView.setLayoutManager(layoutManager);
//                                adapter = new PropertyAdapter(arrayAdapter, myProperty.this, propertyResponsesList,propertyResponsesCityList,
//                                        propertyResponsesStatusList);
//                                recyclerView.setAdapter(adapter);
//                                dialog.dismiss();
//
//                            }
//                            else{
//                                Toast.makeText(myProperty.this,status_value,Toast.LENGTH_LONG).show();
//                            }
//                        }
                    }
                });

            }
        });

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_property);
        ImageButton menuRight = (ImageButton) findViewById(R.id.menuRight);
        menuRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.END)) {
                    drawer.closeDrawer(GravityCompat.END);
                } else {
                    drawer.openDrawer(GravityCompat.END);
                }
            }
        });


        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void getMyPropertyResponse() {
        String userid = SaveInSharedPreference.getInSharedPreference(this).getUserId();
        Call<MyPropertyResponse> call = apiService.getListMyProperty(SaveInSharedPreference.getInSharedPreference(this).getUserId());

        call.enqueue(new Callback<MyPropertyResponse>() {

            @Override
            public void onResponse(Call<MyPropertyResponse> call, Response<MyPropertyResponse> response) {
                if (response.isSuccessful()) {
                    final MyPropertyResponse myPropertyResponse = response.body();
                    if (myPropertyResponse.getError().equals("-1")) {

                        dBhelper.emptyTable("myProperty");
                        dBhelper.emptyTable("myPropertySector");
                        dBhelper.emptyTable("myPropertyGarages");
                        dBhelper.emptyTable("myPropertyBathrooms");
                        dBhelper.emptyTable("myPropertyBedrooms");
                        dBhelper.emptyTable("myPropertyRooms");
                        dBhelper.emptyTable("myPropertyDescription");
                        dBhelper.emptyTable("myPropertyCity");
                        dBhelper.emptyTable("myPropertyArea");
                        dBhelper.emptyTable("myPropertySubArea");
                        dBhelper.emptyTable("myPropertyAreaType");
                        dBhelper.emptyTable("myPropertyPropertyType");
                        dBhelper.emptyTable("myPropertyStatus");


                        if (myPropertyResponse.getData().size() == 0) {
                            CustomAlert.alertDialog(myProperty.this, "No Property Found");
                            progressDialog.dismiss();
                        } else {
                            for (int i = 0; i < myPropertyResponse.getData().size(); i++) {


                                propertyResponsesListIsClosed = myPropertyResponse.getIsClosed();
                                propertyResponsesList1 = myPropertyResponse.getData();
                                propertyResponsesCityList1 = myPropertyResponse.getCity();
                                propertyResponsesStatusList1 = myPropertyResponse.getStatus();
                                propertyResponsesAreaList1 = myPropertyResponse.getArea();
                                propertyResponsesSubareaList1 = myPropertyResponse.getSub_area();
                                propertyResponsesSectorList1 = myPropertyResponse.getSector();
                                propertyResponsesGaragesList1 = myPropertyResponse.getGarages();
                                propertyResponsesBathroomList1 = myPropertyResponse.getBathrooms();
                                propertyResponsesBedroomList1 = myPropertyResponse.getBedrooms();
                                propertyResponsesRoomList1 = myPropertyResponse.getRooms();
                                propertyResponsesDescriptionList1 = myPropertyResponse.getDescription();
                                propertyResponsesAreaTypeList1 = myPropertyResponse.getAreaType();
                                propertyResponsesPropertyTypeList1 = myPropertyResponse.getPropertyType();
                                propertyResponsesMinSizeList1 = myPropertyResponse.getMinSize();
                                propertyResponsesMinPriceList1 = myPropertyResponse.getMinPrice();
                                propertyResponsesMaxSizeList1 = myPropertyResponse.getMaxSize();
                                propertyResponsesMaxPriceList1 = myPropertyResponse.getMaxPrice();

                                recyclerView = (RecyclerView) findViewById(R.id.content_my_property);
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(myProperty.this);
                                recyclerView.setLayoutManager(layoutManager);
                                adapter = new PropertyAdapter(arrayAdapter, myProperty.this,propertyResponsesListIsClosed,
                                        propertyResponsesList1,
                                        propertyResponsesCityList1, propertyResponsesStatusList1, propertyResponsesAreaList1,
                                        propertyResponsesSubareaList1,propertyResponsesSectorList1,propertyResponsesGaragesList1,
                                        propertyResponsesBathroomList1,propertyResponsesBedroomList1,propertyResponsesRoomList1,
                                        propertyResponsesDescriptionList1,propertyResponsesAreaTypeList1,propertyResponsesPropertyTypeList1,
                                        propertyResponsesMinSizeList1,propertyResponsesMinPriceList1,propertyResponsesMaxSizeList1,
                                        propertyResponsesMaxPriceList1);
                                recyclerView.setAdapter(adapter);
                                adapter.setOnClick(myProperty.this);

//                                progressDialog.dismiss();

//                                if (myPropertyResponse.getCity().size() == 0) {
//
//                                    if (myPropertyResponse.getSector().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSector().size(); j++) {
//                                            dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSector().get(j).getSector());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getArea().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getArea().size(); j++) {
//                                            dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getArea().get(j).getArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSub_area().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSub_area().size(); j++) {
//                                            dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSub_area().get(j).getSubArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getAreaType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getAreaType().size(); j++) {
//                                            dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getAreaType().get(j).getAreaType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getPropertyType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getPropertyType().size(); j++) {
//                                            dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getPropertyType().get(j).getPropertyType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getStatus().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getStatus().size(); j++) {
//                                            dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getStatus().get(j).getStatus());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getGarages().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getGarages().size(); j++) {
//                                            dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getGarages().get(j).getGarages());
//                                        }
//
//                                    }
//                                    if (myPropertyResponse.getBathrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBathrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBathrooms().get(j).getBathroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getBedrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBedrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBedrooms().get(j).getBedroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getRooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getRooms().size(); j++) {
//                                            dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getRooms().get(j).getRoom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getDescription().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getDescription().size(); j++) {
//                                            dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getDescription().get(j).getDescription());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getData().get(i).getTitle(),
//                                                myPropertyResponse.getData().get(i).getPostDate());
//                                    }


//                                } else if (myPropertyResponse.getArea().size() == 0) {
//
//                                    if (myPropertyResponse.getCity().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getCity().size(); j++) {
//                                            dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getCity().get(j).getCity());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getSector().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSector().size(); j++) {
//                                            dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSector().get(j).getSector());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSub_area().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSub_area().size(); j++) {
//                                            dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSub_area().get(j).getSubArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getAreaType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getAreaType().size(); j++) {
//                                            dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getAreaType().get(j).getAreaType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getPropertyType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getPropertyType().size(); j++) {
//                                            dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getPropertyType().get(j).getPropertyType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getStatus().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getStatus().size(); j++) {
//                                            dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getStatus().get(j).getStatus());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getGarages().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getGarages().size(); j++) {
//                                            dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getGarages().get(j).getGarages());
//                                        }
//
//                                    }
//                                    if (myPropertyResponse.getBathrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBathrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBathrooms().get(j).getBathroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getBedrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBedrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBedrooms().get(j).getBedroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getRooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getRooms().size(); j++) {
//                                            dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getRooms().get(j).getRoom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getDescription().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getDescription().size(); j++) {
//                                            dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getDescription().get(j).getDescription());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getData().get(i).getTitle(),
//                                                myPropertyResponse.getData().get(i).getPostDate());
//                                    }
//
//
//                                } else if (myPropertyResponse.getSub_area().size() == 0) {

//                                    if (myPropertyResponse.getCity().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getCity().size(); j++) {
//                                            dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getCity().get(j).getCity());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getArea().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getArea().size(); j++) {
//                                            dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getArea().get(j).getArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSector().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSector().size(); j++) {
//                                            dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSector().get(j).getSector());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getAreaType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getAreaType().size(); j++) {
//                                            dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getAreaType().get(j).getAreaType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getPropertyType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getPropertyType().size(); j++) {
//                                            dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getPropertyType().get(j).getPropertyType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getStatus().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getStatus().size(); j++) {
//                                            dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getStatus().get(j).getStatus());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getGarages().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getGarages().size(); j++) {
//                                            dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getGarages().get(j).getGarages());
//                                        }
//
//                                    }
//                                    if (myPropertyResponse.getBathrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBathrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBathrooms().get(j).getBathroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getBedrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBedrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBedrooms().get(j).getBedroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getRooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getRooms().size(); j++) {
//                                            dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getRooms().get(j).getRoom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getDescription().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getDescription().size(); j++) {
//                                            dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getDescription().get(j).getDescription());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getData().get(i).getTitle(),
//                                                myPropertyResponse.getData().get(i).getPostDate());
//                                    }
//
//
//                                } else if (myPropertyResponse.getAreaType().size() == 0) {

//                                    if (myPropertyResponse.getCity().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getCity().size(); j++) {
//                                            dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getCity().get(j).getCity());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getArea().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getArea().size(); j++) {
//                                            dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getArea().get(j).getArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSub_area().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSub_area().size(); j++) {
//                                            dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSub_area().get(j).getSubArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSector().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSector().size(); j++) {
//                                            dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSector().get(j).getSector());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getPropertyType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getPropertyType().size(); j++) {
//                                            dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getPropertyType().get(j).getPropertyType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getStatus().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getStatus().size(); j++) {
//                                            dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getStatus().get(j).getStatus());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getGarages().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getGarages().size(); j++) {
//                                            dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getGarages().get(j).getGarages());
//                                        }
//
//                                    }
//                                    if (myPropertyResponse.getBathrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBathrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBathrooms().get(j).getBathroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getBedrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBedrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBedrooms().get(j).getBedroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getRooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getRooms().size(); j++) {
//                                            dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getRooms().get(j).getRoom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getDescription().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getDescription().size(); j++) {
//                                            dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getDescription().get(j).getDescription());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getData().get(i).getTitle(),
//                                                myPropertyResponse.getData().get(i).getPostDate());
//                                    }
//
//
//                                } else if (myPropertyResponse.getPropertyType().size() == 0) {

//                                    if (myPropertyResponse.getCity().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getCity().size(); j++) {
//                                            dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getCity().get(j).getCity());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getArea().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getArea().size(); j++) {
//                                            dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getArea().get(j).getArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSub_area().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSub_area().size(); j++) {
//                                            dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSub_area().get(j).getSubArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getAreaType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getAreaType().size(); j++) {
//                                            dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getAreaType().get(j).getAreaType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSector().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSector().size(); j++) {
//                                            dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSector().get(j).getSector());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getStatus().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getStatus().size(); j++) {
//                                            dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getStatus().get(j).getStatus());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getGarages().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getGarages().size(); j++) {
//                                            dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getGarages().get(j).getGarages());
//                                        }
//
//                                    }
//                                    if (myPropertyResponse.getBathrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBathrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBathrooms().get(j).getBathroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getBedrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBedrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBedrooms().get(j).getBedroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getRooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getRooms().size(); j++) {
//                                            dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getRooms().get(j).getRoom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getDescription().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getDescription().size(); j++) {
//                                            dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getDescription().get(j).getDescription());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getData().get(i).getTitle(),
//                                                myPropertyResponse.getData().get(i).getPostDate());
//                                    }
//
//
//                                } else if (myPropertyResponse.getStatus().size() == 0) {

//                                    if (myPropertyResponse.getCity().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getCity().size(); j++) {
//                                            dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getCity().get(j).getCity());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getArea().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getArea().size(); j++) {
//                                            dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getArea().get(j).getArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSub_area().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSub_area().size(); j++) {
//                                            dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSub_area().get(j).getSubArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getAreaType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getAreaType().size(); j++) {
//                                            dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getAreaType().get(j).getAreaType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getPropertyType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getPropertyType().size(); j++) {
//                                            dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getPropertyType().get(j).getPropertyType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSector().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSector().size(); j++) {
//                                            dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSector().get(j).getSector());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getGarages().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getGarages().size(); j++) {
//                                            dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getGarages().get(j).getGarages());
//                                        }
//
//                                    }
//                                    if (myPropertyResponse.getBathrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBathrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBathrooms().get(j).getBathroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getBedrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBedrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBedrooms().get(j).getBedroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getRooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getRooms().size(); j++) {
//                                            dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getRooms().get(j).getRoom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getDescription().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getDescription().size(); j++) {
//                                            dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getDescription().get(j).getDescription());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getData().get(i).getTitle(),
//                                                myPropertyResponse.getData().get(i).getPostDate());
//                                    }
//
//
//                                }

//                                if (myPropertyResponse.getSector().size() == 0) {
//
//                                    if (myPropertyResponse.getCity().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getCity().size(); j++) {
//                                            dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getCity().get(j).getCity());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getArea().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getArea().size(); j++) {
//                                            dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getArea().get(j).getArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSub_area().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSub_area().size(); j++) {
//                                            dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSub_area().get(j).getSubArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getAreaType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getAreaType().size(); j++) {
//                                            dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getAreaType().get(j).getAreaType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getPropertyType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getPropertyType().size(); j++) {
//                                            dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getPropertyType().get(j).getPropertyType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getStatus().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getStatus().size(); j++) {
//                                            dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getStatus().get(j).getStatus());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getGarages().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getGarages().size(); j++) {
//                                            dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getGarages().get(j).getGarages());
//                                        }
//
//                                    }
//                                    if (myPropertyResponse.getBathrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBathrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBathrooms().get(j).getBathroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getBedrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBedrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBedrooms().get(j).getBedroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getRooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getRooms().size(); j++) {
//                                            dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getRooms().get(j).getRoom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getDescription().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getDescription().size(); j++) {
//                                            dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getDescription().get(j).getDescription());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getData().get(i).getTitle(),
//                                                myPropertyResponse.getData().get(i).getPostDate());
//                                    }
//
//
//                                } else if (myPropertyResponse.getGarages().size() == 0) {

//                                    if (myPropertyResponse.getCity().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getCity().size(); j++) {
//                                            dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getCity().get(j).getCity());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getArea().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getArea().size(); j++) {
//                                            dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getArea().get(j).getArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSub_area().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSub_area().size(); j++) {
//                                            dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSub_area().get(j).getSubArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getAreaType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getAreaType().size(); j++) {
//                                            dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getAreaType().get(j).getAreaType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getPropertyType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getPropertyType().size(); j++) {
//                                            dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getPropertyType().get(j).getPropertyType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getStatus().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getStatus().size(); j++) {
//                                            dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getStatus().get(j).getStatus());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSector().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSector().size(); j++) {
//                                            dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSector().get(j).getSector());
//                                        }
//
//                                    }
//                                    if (myPropertyResponse.getBathrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBathrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBathrooms().get(j).getBathroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getBedrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBedrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBedrooms().get(j).getBedroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getRooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getRooms().size(); j++) {
//                                            dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getRooms().get(j).getRoom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getDescription().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getDescription().size(); j++) {
//                                            dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getDescription().get(j).getDescription());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getData().get(i).getTitle(),
//                                                myPropertyResponse.getData().get(i).getPostDate());
//                                    }
//
//
//                                } else if (myPropertyResponse.getBathrooms().size() == 0) {

//                                    if (myPropertyResponse.getCity().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getCity().size(); j++) {
//                                            dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getCity().get(j).getCity());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getArea().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getArea().size(); j++) {
//                                            dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getArea().get(j).getArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSub_area().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSub_area().size(); j++) {
//                                            dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSub_area().get(j).getSubArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getAreaType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getAreaType().size(); j++) {
//                                            dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getAreaType().get(j).getAreaType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getPropertyType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getPropertyType().size(); j++) {
//                                            dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getPropertyType().get(j).getPropertyType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getStatus().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getStatus().size(); j++) {
//                                            dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getStatus().get(j).getStatus());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getGarages().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getGarages().size(); j++) {
//                                            dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getGarages().get(j).getGarages());
//                                        }
//
//                                    }
//                                    if (myPropertyResponse.getSector().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSector().size(); j++) {
//                                            dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSector().get(j).getSector());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getBedrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBedrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBedrooms().get(j).getBedroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getRooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getRooms().size(); j++) {
//                                            dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getRooms().get(j).getRoom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getDescription().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getDescription().size(); j++) {
//                                            dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getDescription().get(j).getDescription());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getData().get(i).getTitle(),
//                                                myPropertyResponse.getData().get(i).getPostDate());
//                                    }
//
//                                } else if (myPropertyResponse.getBedrooms().size() == 0) {


//                                    if (myPropertyResponse.getCity().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getCity().size(); j++) {
//                                            dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getCity().get(j).getCity());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getArea().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getArea().size(); j++) {
//                                            dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getArea().get(j).getArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSub_area().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSub_area().size(); j++) {
//                                            dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSub_area().get(j).getSubArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getAreaType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getAreaType().size(); j++) {
//                                            dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getAreaType().get(j).getAreaType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getPropertyType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getPropertyType().size(); j++) {
//                                            dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getPropertyType().get(j).getPropertyType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getStatus().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getStatus().size(); j++) {
//                                            dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getStatus().get(j).getStatus());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getGarages().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getGarages().size(); j++) {
//                                            dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getGarages().get(j).getGarages());
//                                        }
//
//                                    }
//                                    if (myPropertyResponse.getBathrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBathrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBathrooms().get(j).getBathroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getSector().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSector().size(); j++) {
//                                            dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSector().get(j).getSector());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getRooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getRooms().size(); j++) {
//                                            dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getRooms().get(j).getRoom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getDescription().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getDescription().size(); j++) {
//                                            dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getDescription().get(j).getDescription());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getData().get(i).getTitle(),
//                                                myPropertyResponse.getData().get(i).getPostDate());
//                                    }
//
//                                } else if (myPropertyResponse.getRooms().size() == 0) {

//                                    if (myPropertyResponse.getCity().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getCity().size(); j++) {
//                                            dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getCity().get(j).getCity());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getArea().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getArea().size(); j++) {
//                                            dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getArea().get(j).getArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSub_area().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSub_area().size(); j++) {
//                                            dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSub_area().get(j).getSubArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getAreaType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getAreaType().size(); j++) {
//                                            dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getAreaType().get(j).getAreaType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getPropertyType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getPropertyType().size(); j++) {
//                                            dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getPropertyType().get(j).getPropertyType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getStatus().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getStatus().size(); j++) {
//                                            dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getStatus().get(j).getStatus());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getGarages().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getGarages().size(); j++) {
//                                            dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getGarages().get(j).getGarages());
//                                        }
//
//                                    }
//                                    if (myPropertyResponse.getBathrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBathrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBathrooms().get(j).getBathroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getBedrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBedrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBedrooms().get(j).getBedroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getSector().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSector().size(); j++) {
//                                            dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSector().get(j).getSector());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getDescription().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getDescription().size(); j++) {
//                                            dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getDescription().get(j).getDescription());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getData().get(i).getTitle(),
//                                                myPropertyResponse.getData().get(i).getPostDate());
//                                    }

//                                } else if (myPropertyResponse.getDescription().size() == 0) {
//
//                                    if (myPropertyResponse.getCity().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getCity().size(); j++) {
//                                            dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getCity().get(j).getCity());
//                                        }
//
//                                    }
//
//
//                                    if (myPropertyResponse.getArea().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getArea().size(); j++) {
//                                            dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getArea().get(j).getArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getSub_area().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSub_area().size(); j++) {
//                                            dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSub_area().get(j).getSubArea());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getAreaType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getAreaType().size(); j++) {
//                                            dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getAreaType().get(j).getAreaType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getPropertyType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getPropertyType().size(); j++) {
//                                            dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getPropertyType().get(j).getPropertyType());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getStatus().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getStatus().size(); j++) {
//                                            dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getStatus().get(j).getStatus());
//                                        }
//
//                                    }
//
//                                    if (myPropertyResponse.getGarages().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getGarages().size(); j++) {
//                                            dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getGarages().get(j).getGarages());
//                                        }
//
//                                    }
//                                    if (myPropertyResponse.getBathrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBathrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBathrooms().get(j).getBathroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getBedrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBedrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBedrooms().get(j).getBedroom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getRooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getRooms().size(); j++) {
//                                            dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getRooms().get(j).getRoom());
//                                        }
//                                    }
//                                    if (myPropertyResponse.getSector().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSector().size(); j++) {
//                                            dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSector().get(j).getSector());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getData().get(i).getTitle(),
//                                                myPropertyResponse.getData().get(i).getPostDate());
//                                    }
//
//                                } else {
//                                    dBhelper.addMyPropertyData(myPropertyResponse.getData().get(i).getPid(),
//                                            myPropertyResponse.getData().get(i).getTitle(),
//                                            myPropertyResponse.getData().get(i).getPostDate());
//
//                                    if (myPropertyResponse.getCity().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getCity().size(); j++) {
//                                            dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getCity().get(j).getCity());
//                                        }
//
//                                    } else {
//                                        dBhelper.addMyPropertyCity(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getCity().get(i).getCity());
//                                    }
//
//                                    if (myPropertyResponse.getArea().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getArea().size(); j++) {
//                                            dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getArea().get(j).getArea());
//                                        }
//
//                                    } else {
//                                        dBhelper.addMyPropertyArea(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getArea().get(i).getArea());
//                                    }
//
//                                    if (myPropertyResponse.getSub_area().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSub_area().size(); j++) {
//                                            dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSub_area().get(j).getSubArea());
//                                        }
//
//                                    } else {
//                                        dBhelper.addMyPropertySubArea(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getSub_area().get(i).getSubArea());
//                                    }
//
//                                    if (myPropertyResponse.getAreaType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getAreaType().size(); j++) {
//                                            dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getAreaType().get(j).getAreaType());
//                                        }
//
//                                    } else {
//                                        dBhelper.addMyPropertyAreaType(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getAreaType().get(i).getAreaType());
//                                    }
//
//                                    if (myPropertyResponse.getPropertyType().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getPropertyType().size(); j++) {
//                                            dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getPropertyType().get(j).getPropertyType());
//                                        }
//
//                                    } else {
//                                        dBhelper.addMyPropertyPropertyType(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getPropertyType().get(i).getPropertyType());
//                                    }
//
//                                    if (myPropertyResponse.getStatus().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getStatus().size(); j++) {
//                                            dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getStatus().get(j).getStatus());
//                                        }
//
//                                    } else {
//                                        dBhelper.addMyPropertyStatus(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getStatus().get(i).getStatus());
//                                    }
//
//
//                                    if (myPropertyResponse.getGarages().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getGarages().size(); j++) {
//                                            dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getGarages().get(j).getGarages());
//                                        }
//
//                                    } else {
//                                        dBhelper.adddMyPropertyGarages(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getGarages().get(i).getGarages());
//                                    }
//                                    if (myPropertyResponse.getBathrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBathrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBathrooms().get(j).getBathroom());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyBathrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getBathrooms().get(i).getBathroom());
//                                    }
//                                    if (myPropertyResponse.getBedrooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getBedrooms().size(); j++) {
//                                            dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getBedrooms().get(j).getBedroom());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyBedrooms(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getBedrooms().get(i).getBedroom());
//                                    }
//                                    if (myPropertyResponse.getRooms().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getRooms().size(); j++) {
//                                            dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getRooms().get(j).getRoom());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyRooms(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getRooms().get(i).getRoom());
//                                    }
//                                    if (myPropertyResponse.getDescription().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getDescription().size(); j++) {
//                                            dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getDescription().get(j).getDescription());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertyDescription(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getDescription().get(i).getDescription());
//                                    }
//
//                                    if (myPropertyResponse.getSector().size() != myPropertyResponse.getData().size()) {
//                                        for (int j = 0; j < myPropertyResponse.getSector().size(); j++) {
//                                            dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                    myPropertyResponse.getSector().get(j).getSector());
//                                        }
//                                    } else {
//                                        dBhelper.addMyPropertySectors(myPropertyResponse.getData().get(i).getPid(),
//                                                myPropertyResponse.getSector().get(i).getSector());
//                                    }


//                                }


                            }
                        }


//                        propertyResponsesList = dBhelper.getMyProperty();
//                        propertyResponsesCityList = dBhelper.getMyPropertyCity();
//                        propertyResponsesStatusList = dBhelper.getMyPropertyStatus();



//                        recyclerView = (RecyclerView) findViewById(R.id.content_my_property);
//                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(myProperty.this);
//                        recyclerView.setLayoutManager(layoutManager);
//                        adapter = new PropertyAdapter(arrayAdapter, myProperty.this, propertyResponsesList,
//                                propertyResponsesCityList, propertyResponsesStatusList);
//                        recyclerView.setAdapter(adapter);


//                        for (int i = 0; i < myPropertyResponse.getData().size(); i++) {
//                            getMatchedPropertyResponse(myPropertyResponse.getData().get(i).getPid());
//                        }

                        progressDialog.dismiss();

                    }


//                        for(int i=0;i<myPropertyResponse.getStatus().size();i++){
//                            dBhelper.addMyPropertyStatus(myPropertyResponse.getStatus().get(i).getStatus());
//                        }
//
//                        dBhelper.addMyPropertyCity(myPropertyResponse.getCity());


                }

//                        citytxt.setText(dBhelper.getCityById(SaveInSharedPreference.getInSharedPreference(EnterPropertyDetailActivity.this).getCityId()));


            }
//                Log.i("response", "post submitted to API." + areaTypeResponse);


            @Override
            public void onFailure(Call<MyPropertyResponse> call, Throwable t) {
                progressDialog.dismiss();
                CustomAlert.alertDialog(myProperty.this, "Response Failed");
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }

//    private void getMatchedPropertyResponse(final String pid) {
//        String userid = SaveInSharedPreference.getInSharedPreference(this).getUserId();
//        Call<MyPropertyResponse> call = apiService.getMatchingProperty(SaveInSharedPreference.getInSharedPreference(this).getUserId(), pid);
//
//        call.enqueue(new Callback<MyPropertyResponse>() {
//
//            @Override
//            public void onResponse(Call<MyPropertyResponse> call, Response<MyPropertyResponse> response) {
//                if (response.isSuccessful()) {
//                    MyPropertyResponse matchedPropertyResponse = response.body();
//                    if (matchedPropertyResponse.getError().equals("-1")) {
//
//                        dBhelper.emptyTable("matchProperty");
//
//
//                        dBhelper.addMatchedProperty(pid, matchedPropertyResponse.getTitle(),
//                                matchedPropertyResponse.getPostDate(),
//                                matchedPropertyResponse.getStatus(),
//                                matchedPropertyResponse.getCity(),
//                                matchedPropertyResponse.getArea(),
//                                matchedPropertyResponse.getSubArea(),
//                                matchedPropertyResponse.getSector());
//
//                    }
//
////                        citytxt.setText(dBhelper.getCityById(SaveInSharedPreference.getInSharedPreference(EnterPropertyDetailActivity.this).getCityId()));
//
//
//                }
////                Log.i("response", "post submitted to API." + areaTypeResponse);
//            }
//
//
//            @Override
//            public void onFailure(Call<MyPropertyResponse> call, Throwable t) {
//                progressDialog.dismiss();
////                CustomAlert.alertDialog(myProperty.this, "Response Failed");
//                Log.e("response_Failed", "Unable to submit post to API." + t);
//            }
//        });
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_property);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            startActivity(new Intent(myProperty.this, HomeActivity.class));
        }
    }


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

        } else if (id == R.id.LogOut_btn_prop) {

            logout();
        } else if (id == R.id.username){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_property);
        drawer.closeDrawer(GravityCompat.END);
        return true;
    }
    public void logout(){
        SharedPreferences sharedPrefs =getSharedPreferences(signInActivity.PREFS_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.clear();
        editor.commit();

        //show login form
        Intent intent=new Intent(this, signInActivity.class);
        startActivity(intent);
    }


    @Override
    public void onItemClick(int position, final String pid) {
        AlertDialog.Builder alert;
                    alert = new AlertDialog.Builder(this);
                    alert.setMessage("Do You Want To Delete Your Property?");
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            progressDialog.show();
                            Call<InsertPropertyResponse> call = apiService.postDeletePropertyResponse( pid,
                                    SaveInSharedPreference.getInSharedPreference(myProperty.this).getUserId());

                            call.enqueue(new Callback<InsertPropertyResponse>() {

                                @Override
                                public void onResponse(Call<InsertPropertyResponse> call, Response<InsertPropertyResponse> response) {
                                    if (response.isSuccessful()) {
                                        InsertPropertyResponse insertPropertyResponse = response.body();
                                        if (insertPropertyResponse.getError().equals("-1")) {
                                            progressDialog.dismiss();
                                            AlertDialog.Builder alertDone;
                                            alertDone = new AlertDialog.Builder(myProperty.this);
                                            alertDone.setMessage("Your Property Has Been Deleted");
                                            alertDone.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {

                                                    startActivity(new Intent(myProperty.this,myProperty.class));
                                                }
                                            });
                                            alertDone.show();

                                        }

                                    }
//
                                }


                                @Override
                                public void onFailure(Call<InsertPropertyResponse> call, Throwable t) {
                                    progressDialog.dismiss();
                                    CustomAlert.alertDialog(myProperty.this, "Response Failed");
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
