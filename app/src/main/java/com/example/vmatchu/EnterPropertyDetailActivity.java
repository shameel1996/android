package com.example.vmatchu;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vmatchu.Adpaters.AreaAdapter;
import com.example.vmatchu.Adpaters.AreaTypeAdapter;
import com.example.vmatchu.Adpaters.PropertyAdapter;
import com.example.vmatchu.Adpaters.PropertyTypeAdapter;
import com.example.vmatchu.Adpaters.SectorAdapter;
import com.example.vmatchu.Adpaters.SubAreaAdapter;
import com.example.vmatchu.Adpaters.cityAdapter;
import com.example.vmatchu.CustomAlert.CustomAlert;
import com.example.vmatchu.DBhelper.DBhelper;
import com.example.vmatchu.Interfaces.OnItemClick;
import com.example.vmatchu.Pojo.AreaResponse;
import com.example.vmatchu.Pojo.AreaTypeResponse;
import com.example.vmatchu.Pojo.CityAreaSubareaSectorDetailsResponse;
import com.example.vmatchu.Pojo.CityResponse;
import com.example.vmatchu.Pojo.InsertPropertyResponse;
import com.example.vmatchu.Pojo.PropertyTypeData;
import com.example.vmatchu.Pojo.SectorResponse;
import com.example.vmatchu.Pojo.SubAreaResponse;
import com.example.vmatchu.Pojo.UserSignup;
import com.example.vmatchu.Rest.APIService;
import com.example.vmatchu.Rest.ApiUtil;
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnterPropertyDetailActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn;
    int PICK_IMAGE_MULTIPLE = 1;
    private String imageEncoded;
    private List<String> imagesEncodedList;
    private GridView gvGallery;
    private GalleryAdapter galleryAdapter;
    private Spinner spinType, cityED, areaED, subareaED, sectorED;
    private Spinner spinStatus;
    private String spin_val_status;
    private String spin_val_type;
    private Button submit;
    private APIService apiService;
    private ProgressDialog progressDialog;
    private String cityName, areaName, subareaName, sectorName;
    private String cityId, areaId, subareaId, sectorId;
    private String[] proType = {"None", "Agriculture/Dairy", "Apartment/Flat", "Banglow/House", "Commercial Plot", "Commercial Portion/Office Area", "Farm House", "Hotel", "Industrial land", "Industrial Plot", "Land", "Penthouse", "Plot", "Plot File", "Residential Lower Portion", "Residential Upper Portion", "Restuarent", "Shop/Showroom", "villa"};//array of strings used to populate the spinner

    private TextInputEditText title;
    private TextView areaType;
    private ArrayList<String> country = new ArrayList<>();
    private ArrayList<CityAreaSubareaSectorDetailsResponse> city = new ArrayList<>();
    private ArrayList<CityAreaSubareaSectorDetailsResponse> area = new ArrayList<>();
    private ArrayList<CityAreaSubareaSectorDetailsResponse> subArea = new ArrayList<>();
    private ArrayList<CityAreaSubareaSectorDetailsResponse> sector = new ArrayList<>();
    private ArrayList<CityAreaSubareaSectorDetailsResponse> area_type = new ArrayList<>();
    private ArrayList<PropertyTypeData> propertyTypeList = new ArrayList<>();
    private ArrayList<String> areaTypeArray = new ArrayList<>();

    Intent intent2, intent1;

    cityAdapter adapter;
    AreaAdapter areaAdapter;
    SubAreaAdapter subAreaAdapter;
    SectorAdapter sectorAdapter;
    AreaTypeAdapter areaTypeAdapter;
    PropertyTypeAdapter propertyTypeAdapter;
    RecyclerView recyclerView;
    RecyclerView recyclerViewArea;
    RecyclerView recyclerViewSubArea;
    RecyclerView recyclerViewSector;
    RecyclerView recyclerViewAreaType;
    RecyclerView recyclerViewPropertyType;
    int totalMoney;
    int remainingMoney;


    private SpinnerDialog spinnnerDialogue, spinnerDialog, DialogAreaType;

    ArrayList<Uri> mArrayUri;



    private String[] proStatus = {"For Rent", "For Purchase"};

    DBhelper dBhelper;


    private TextView countrytxt, citytxt, areatxt, subareatxt, sectortxt, propertyType, status;
    private TextInputEditText price, size, rooms, bedroom, bathroom, garages, details, video_url, image360_url;

    String statusType;
    String statusTypeID = "";

    private String[] tit = {""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_property_detail);
        Toolbar toolbar=findViewById(R.id.toolbarEnterProprtty);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
        initialize();

        mArrayUri=new ArrayList<>();
        country.add("Pakistan");
        country.add("India");
        country.add("Bangladesh");
        country.add("Iran");
        country.add("Iraq");
        country.add("Dubai");
        country.add("America");


//        if(status.getText().toString()=="For Sell"){
//            Toast.makeText(this,status.getText().toString(),Toast.LENGTH_LONG).show();
//        }
//        else if(status.getText().toString()=="Give On Rent"){
//            Toast.makeText(this,status.getText().toString(),Toast.LENGTH_LONG).show();
//
//        }

//        area = dBhelper.getArea();
//        subArea = dBhelper.getSubArea();
//        sector = dBhelper.getSector();


        areaTypeArray.add("None");
        areaTypeArray.add("Acre");
        areaTypeArray.add("Kanal");
        areaTypeArray.add("Marla");
        areaTypeArray.add("Square Feet");
        areaTypeArray.add("Square Meter");
        areaTypeArray.add("Square Yard");
        spinnerDialog = new SpinnerDialog(this, country, "select Item");
        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                countrytxt.setText(item);
            }
        });
        countrytxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDialog.showSpinerDialog();
            }
        });


        DialogAreaType = new SpinnerDialog(this, areaTypeArray, "select Item");
        DialogAreaType.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                areaType.setText(item);
            }
        });
//        areaType.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DialogAreaType.showSpinerDialog();
//            }
//        });

        btn = findViewById(R.id.btnImage);
        gvGallery = (GridView) findViewById(R.id.gv);
//        spinType = (Spinner) findViewById(R.id.type);//fetching view's id
        //Register a callback to be invoked when an item in this AdapterView has been selected
//        spinType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

//            @Override
//            public void onItemSelected(AdapterView<?> arg0, View arg1,
//                                       int position, long id) {

//                spin_val_type = proType[position];//saving the value selected


//            }

//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {

//            }

//        });
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                this, R.layout.spinner_item, proType);

        gvGallery = (GridView)findViewById(R.id.gv);



        // setting adapteers to spinners
//        spinType.setAdapter(spinnerArrayAdapter1);
//        spinStatus = (Spinner) findViewById(R.id.status);//fetching view's id
        //Register a callback to be invoked when an item in this AdapterView has been selected
//        spinStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> arg0, View arg1,
//                                       int position, long id) {
//
//                spin_val_status = proStatus[position];//saving the value selected
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//
//            }
//
//        });
        //setting array adaptors to spinners
        //ArrayAdapter is a BaseAdapter that is backed by an array of arbitrary objects
        //   ArrayAdapter<String> spin_adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, proStatus);
//        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
//                this,R.layout.spinner_item,proStatus
//        );
        // setting adapteers to spinners
//        spinStatus.setAdapter(spinnerArrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_MULTIPLE);
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
        startActivity(new Intent(EnterPropertyDetailActivity.this,submitProperty.class));
        super.onBackPressed();
    }
    private void getCitiesApi() {
        Call<CityResponse> call = apiService.getCities();

        call.enqueue(new Callback<CityResponse>() {

            @Override
            public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
                if (response.isSuccessful()) {
                    city.clear();
                    CityResponse cityResponse = response.body();
                    if (cityResponse.getError().equals("-1")) {
                        dBhelper.emptyTable("city");
                        for (int i = 0; i < cityResponse.getCity().size(); i++) {
                            dBhelper.addCities(cityResponse.getCity().get(i).getTermId(),
                                    cityResponse.getCity().get(i).getName());


                        }
                        city = dBhelper.getCities();


//                        View view1=getLayoutInflater().inflate(R.layout.show_city,null);
//                        AlertDialog.Builder builder = new AlertDialog.Builder(EnterPropertyDetailActivity.this);
                        final Dialog dialog = new Dialog(EnterPropertyDetailActivity.this);
                        dialog.setContentView(R.layout.show_city);
                        recyclerView = dialog.findViewById(R.id.showCity);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EnterPropertyDetailActivity.this);
                        recyclerView.setLayoutManager(layoutManager);
//                        AlertDialog dialog = builder.create();
//                        builder.setCancelable(false);
//                        builder.setView(view1);

                        adapter = new cityAdapter(city, EnterPropertyDetailActivity.this, dialog, citytxt);
                        recyclerView.setAdapter(adapter);
//                        adapter.setItemClick(EnterPropertyDetailActivity.this);
                        progressDialog.dismiss();
                        dialog.show();

//                        citytxt.setText(dBhelper.getCityById(SaveInSharedPreference.getInSharedPreference(EnterPropertyDetailActivity.this).getCityId()));


                    } else {
                        CustomAlert.alertDialog(EnterPropertyDetailActivity.this, "Cities Not Fetched");
                    }
                    Log.i("response", "post submitted to API." + cityResponse);
                }
            }

            @Override
            public void onFailure(Call<CityResponse> call, Throwable t) {
                progressDialog.dismiss();
                CustomAlert.alertDialog(EnterPropertyDetailActivity.this, "Response Failed");
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }

    private void initialize() {
        title = (TextInputEditText) findViewById(R.id.pro_title_ed);
//        areaType=(TextInputEditText) findViewById(R.id.areaType_ed) ;
        countrytxt = (TextView) findViewById(R.id.Country_ed);
        citytxt = (TextView) findViewById(R.id.City_ed);


        status = (TextView) findViewById(R.id.status1);
        areatxt = (TextView) findViewById(R.id.Area_ed);
        subareatxt = (TextView) findViewById(R.id.Subarea_ed);
        sectortxt = (TextView) findViewById(R.id.sector_ed);
        propertyType = (TextView) findViewById(R.id.type);
        price = (TextInputEditText) findViewById(R.id.price_ed);
        size = (TextInputEditText) findViewById(R.id.size_ed);
        areaType = (TextView) findViewById(R.id.areaType_ed);
        rooms = (TextInputEditText) findViewById(R.id.rooms_ed);
        bedroom = (TextInputEditText) findViewById(R.id.bedrooms_ed);
        bathroom = (TextInputEditText) findViewById(R.id.bathroom_ed);
        garages = (TextInputEditText) findViewById(R.id.garages_ed);
        details = (TextInputEditText) findViewById(R.id.desc_ed);
        video_url = (TextInputEditText) findViewById(R.id.vedioURL_ed);
        image360_url = (TextInputEditText) findViewById(R.id.image360_ed);

        dBhelper = new DBhelper(this);
        submit = findViewById(R.id.submitProp);

        submit.setOnClickListener(this);
        citytxt.setOnClickListener(this);
        areatxt.setOnClickListener(this);
        subareatxt.setOnClickListener(this);
        sectortxt.setOnClickListener(this);
        areaType.setOnClickListener(this);
        propertyType.setOnClickListener(this);
//        submit.setOnClickListener(this);


        status.setText(DemoClass.status);
//        intent2=getIntent();
//        status.setText(intent2.getStringExtra("Sell"));
//        intent1=getIntent();
//        status.setText(intent1.getStringExtra("Rent"));

        statusType = status.getText().toString();


        progressDialog = new ProgressDialog(EnterPropertyDetailActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        apiService = ApiUtil.getAPIService();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            // When an Image is picked
            if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                imagesEncodedList = new ArrayList<String>();
                if (data.getData() != null) {

                    Uri mImageUri = data.getData();

                    // Get the cursor
                    Cursor cursor = getContentResolver().query(mImageUri,
                            filePathColumn, null, null, null);
                    // Move to first row
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imageEncoded = cursor.getString(columnIndex);
                    cursor.close();


                    mArrayUri.add(mImageUri);
                    galleryAdapter = new GalleryAdapter(getApplicationContext(), mArrayUri);
                    gvGallery.setAdapter(galleryAdapter);
                    gvGallery.setVerticalSpacing(gvGallery.getHorizontalSpacing());
                    ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) gvGallery
                            .getLayoutParams();
                    mlp.setMargins(0, gvGallery.getHorizontalSpacing(), 0, 0);

                } else {
                    if (data.getClipData() != null) {
                        ClipData mClipData = data.getClipData();

                        for (int i = 0; i < mClipData.getItemCount(); i++) {

                            ClipData.Item item = mClipData.getItemAt(i);
                            Uri uri = item.getUri();
                            mArrayUri.add(uri);
                            // Get the cursor
                            Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
                            // Move to first row
                            cursor.moveToFirst();

                            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                            imageEncoded = cursor.getString(columnIndex);
                            imagesEncodedList.add(imageEncoded);
                            cursor.close();

                            galleryAdapter = new GalleryAdapter(getApplicationContext(), mArrayUri);
                            gvGallery.setAdapter(galleryAdapter);
                            gvGallery.setVerticalSpacing(gvGallery.getHorizontalSpacing());
                            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) gvGallery
                                    .getLayoutParams();
                            mlp.setMargins(0, gvGallery.getHorizontalSpacing(), 0, 0);

                        }
                        Log.v("LOG_TAG", "Selected Images" + mArrayUri.size());
                    }
                }
            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submitProp:
                if (!title.getText().toString().equals("") && !areatxt.getText().toString().equals("") &&
                        !citytxt.getText().toString().equals("") && !countrytxt.getText().toString().equals("")
                        && !subareatxt.getText().toString().equals("")
                        && !propertyType.getText().toString().equals("") &&
                        !status.getText().toString().equals("") && !size.getText().toString().equals("")
                        && !areaType.getText().toString().equals("")) {
                    progressDialog.show();
                    totalMoney = SaveInSharedPreference.getInSharedPreference(this).getRemainingMoney();
                    remainingMoney = totalMoney - 50;
                    postPropertyDetails();
                } else {
                    CustomAlert.alertDialog(this, "Please Insert Correct Data");
                }

                break;

            case R.id.City_ed:
//                new FetchCity().execute();
                progressDialog.show();
                getCitiesApi();
                break;

            case R.id.Area_ed:
                progressDialog.show();
                getAreaApi();
                // spinnnerDialogue.showSpinerDialog();
                break;

            case R.id.Subarea_ed:
                progressDialog.show();
                getSubAreaApi();
                // spinnnerDialogue.showSpinerDialog();
                break;

            case R.id.sector_ed:
                progressDialog.show();
                getSectorsApi();
                //  spinnnerDialogue.showSpinerDialog();
                break;

            case R.id.areaType_ed:
                progressDialog.show();
                getAreaTypeApi();
//                spinnnerDialogue.showSpinerDialog();
                break;

            case R.id.type:
                getPropertyType();
                break;

//            case R.id.status:
//                progressDialog.show();
//                getCitiesApi();
//                spinnnerDialogue.showSpinerDialog();
//                break;


        }
    }

    private void redirectToWeb() {
        Call<ResponseBody> call = apiService.postRedirectToWeb(SaveInSharedPreference.getInSharedPreference(this).getPidToRedirectToWeb(),
                SaveInSharedPreference.getInSharedPreference(this).getUserId());

        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    ResponseBody insertResponse = response.body();

                    AlertDialog.Builder alert;
                    alert = new AlertDialog.Builder(EnterPropertyDetailActivity.this);
                    alert.setMessage("Your Property Has Been Inserted");
                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(EnterPropertyDetailActivity.this, HomeActivity.class));
                        }
                    });
                    alert.show();


                    Log.i("response", "post submitted to API." + insertResponse);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressDialog.dismiss();
                AlertDialog.Builder alert;
                alert = new AlertDialog.Builder(EnterPropertyDetailActivity.this);
                alert.setMessage("Your Property Has Been Inserted");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(EnterPropertyDetailActivity.this, HomeActivity.class));
                    }
                });
                alert.show();
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }

    private void getPropertyType() {
        propertyTypeList = dBhelper.getPropertyType();

        final Dialog dialogPropertyType = new Dialog(EnterPropertyDetailActivity.this);
        dialogPropertyType.setContentView(R.layout.show_property_type);
        recyclerViewPropertyType = dialogPropertyType.findViewById(R.id.showPropertyType);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EnterPropertyDetailActivity.this);
        recyclerViewPropertyType.setLayoutManager(layoutManager);
//                        AlertDialog dialog = builder.create();
//                        builder.setCancelable(false);
//                        builder.setView(view1);

        propertyTypeAdapter = new PropertyTypeAdapter(propertyTypeList, EnterPropertyDetailActivity.this, dialogPropertyType, propertyType);
        recyclerViewPropertyType.setAdapter(propertyTypeAdapter);
//                        adapter.setItemClick(EnterPropertyDetailActivity.this);
        dialogPropertyType.show();
    }

    private void getAreaTypeApi() {
        Call<AreaTypeResponse> call = apiService.getAreaType();

        call.enqueue(new Callback<AreaTypeResponse>() {

            @Override
            public void onResponse(Call<AreaTypeResponse> call, Response<AreaTypeResponse> response) {
                if (response.isSuccessful()) {
                    AreaTypeResponse areaTypeResponse = response.body();
                    if (areaTypeResponse.getError().equals("-1")) {
                        dBhelper.emptyTable("areaType");
                        for (int i = 0; i < areaTypeResponse.getAreaType().size(); i++) {
                            dBhelper.addAreaType(areaTypeResponse.getAreaType().get(i).getTermId(),
                                    areaTypeResponse.getAreaType().get(i).getName());


                        }
                        area_type = dBhelper.getAreaType();


//                        View view1=getLayoutInflater().inflate(R.layout.show_city,null);
//                        AlertDialog.Builder builder = new AlertDialog.Builder(EnterPropertyDetailActivity.this);
                        final Dialog dialogAreaType = new Dialog(EnterPropertyDetailActivity.this);
                        dialogAreaType.setContentView(R.layout.show_area_type);
                        recyclerViewAreaType = dialogAreaType.findViewById(R.id.showAreaType);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EnterPropertyDetailActivity.this);
                        recyclerViewAreaType.setLayoutManager(layoutManager);
//                        AlertDialog dialog = builder.create();
//                        builder.setCancelable(false);
//                        builder.setView(view1);

                        areaTypeAdapter = new AreaTypeAdapter(area_type, EnterPropertyDetailActivity.this, dialogAreaType, areaType);
                        recyclerViewAreaType.setAdapter(areaTypeAdapter);
//                        adapter.setItemClick(EnterPropertyDetailActivity.this);
                        progressDialog.dismiss();
                        dialogAreaType.show();

//                        citytxt.setText(dBhelper.getCityById(SaveInSharedPreference.getInSharedPreference(EnterPropertyDetailActivity.this).getCityId()));


                    } else {
                        progressDialog.dismiss();
                        CustomAlert.alertDialog(EnterPropertyDetailActivity.this, "Area Type Not Fetched");
                    }
                    Log.i("response", "post submitted to API." + areaTypeResponse);
                }
            }

            @Override
            public void onFailure(Call<AreaTypeResponse> call, Throwable t) {
                progressDialog.dismiss();
                CustomAlert.alertDialog(EnterPropertyDetailActivity.this, "Response Failed");
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }

    private void getSectorsApi() {
        String id = SaveInSharedPreference.getInSharedPreference(this).getSubAreaId();
        Call<SectorResponse> call = apiService.getSector(SaveInSharedPreference.getInSharedPreference(this).getSubAreaId());

        call.enqueue(new Callback<SectorResponse>() {

            @Override
            public void onResponse(Call<SectorResponse> call, Response<SectorResponse> response) {
                if (response.isSuccessful()) {
                    SectorResponse sectorResponse = response.body();
                    if (sectorResponse.getError().equals("-1")) {
                        dBhelper.emptyTable("sector");
                        for (int i = 0; i < sectorResponse.getSectors().size(); i++) {
                            dBhelper.addSector(sectorResponse.getSectors().get(i).getTermId(),
                                    sectorResponse.getSectors().get(i).getName());


                        }
                        sector = dBhelper.getSector();


//                        View view1=getLayoutInflater().inflate(R.layout.show_city,null);
//                        AlertDialog.Builder builder = new AlertDialog.Builder(EnterPropertyDetailActivity.this);
                        final Dialog dialogSector = new Dialog(EnterPropertyDetailActivity.this);
                        dialogSector.setContentView(R.layout.show_sector);
                        recyclerViewSector = dialogSector.findViewById(R.id.showSector);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EnterPropertyDetailActivity.this);
                        recyclerViewSector.setLayoutManager(layoutManager);
//                        AlertDialog dialog = builder.create();
//                        builder.setCancelable(false);
//                        builder.setView(view1);

                        sectorAdapter = new SectorAdapter(sector, EnterPropertyDetailActivity.this, dialogSector, sectortxt);
                        recyclerViewSector.setAdapter(sectorAdapter);
//                        adapter.setItemClick(EnterPropertyDetailActivity.this);
                        progressDialog.dismiss();
                        dialogSector.show();

//                        citytxt.setText(dBhelper.getCityById(SaveInSharedPreference.getInSharedPreference(EnterPropertyDetailActivity.this).getCityId()));


                    } else {
                        progressDialog.dismiss();
                        CustomAlert.alertDialog(EnterPropertyDetailActivity.this, "Sectors Not Fetched");
                    }
                    Log.i("response", "post submitted to API." + sectorResponse);
                }
            }

            @Override
            public void onFailure(Call<SectorResponse> call, Throwable t) {
                progressDialog.dismiss();
                CustomAlert.alertDialog(EnterPropertyDetailActivity.this, "Response Failed");
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }

    //
    private void getSubAreaApi() {
        Call<SubAreaResponse> call = apiService.getSubArea(SaveInSharedPreference.getInSharedPreference(this).getAreaId());

        call.enqueue(new Callback<SubAreaResponse>() {

            @Override
            public void onResponse(Call<SubAreaResponse> call, Response<SubAreaResponse> response) {
                if (response.isSuccessful()) {
                    SubAreaResponse subAreaResponse = response.body();
                    if (subAreaResponse.getError().equals("-1")) {
                        dBhelper.emptyTable("subArea");
                        for (int i = 0; i < subAreaResponse.getSubAreas().size(); i++) {
                            dBhelper.addSubArea(subAreaResponse.getSubAreas().get(i).getTermId(),
                                    subAreaResponse.getSubAreas().get(i).getName());


                        }
                        subArea = dBhelper.getSubArea();


//                        View view1=getLayoutInflater().inflate(R.layout.show_city,null);
//                        AlertDialog.Builder builder = new AlertDialog.Builder(EnterPropertyDetailActivity.this);
                        final Dialog dialogSubArea = new Dialog(EnterPropertyDetailActivity.this);
                        dialogSubArea.setContentView(R.layout.show_subarea);
                        recyclerViewSubArea = dialogSubArea.findViewById(R.id.showSubArea);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EnterPropertyDetailActivity.this);
                        recyclerViewSubArea.setLayoutManager(layoutManager);
//                        AlertDialog dialog = builder.create();
//                        builder.setCancelable(false);
//                        builder.setView(view1);

                        subAreaAdapter = new SubAreaAdapter(subArea, EnterPropertyDetailActivity.this, dialogSubArea, subareatxt);
                        recyclerViewSubArea.setAdapter(subAreaAdapter);
//                        adapter.setItemClick(EnterPropertyDetailActivity.this);
                        progressDialog.dismiss();
                        dialogSubArea.show();

//                        citytxt.setText(dBhelper.getCityById(SaveInSharedPreference.getInSharedPreference(EnterPropertyDetailActivity.this).getCityId()));


                    } else {
                        progressDialog.dismiss();
                        CustomAlert.alertDialog(EnterPropertyDetailActivity.this, "Sub Areas Not Fetched");
                    }
                    Log.i("response", "post submitted to API." + subAreaResponse);
                }
            }

            @Override
            public void onFailure(Call<SubAreaResponse> call, Throwable t) {
                progressDialog.dismiss();
                CustomAlert.alertDialog(EnterPropertyDetailActivity.this, "Response Failed");
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }

    private void getAreaApi() {
        Call<AreaResponse> call = apiService.getArea(SaveInSharedPreference.getInSharedPreference(EnterPropertyDetailActivity.this).getCityId());

        call.enqueue(new Callback<AreaResponse>() {

            @Override
            public void onResponse(Call<AreaResponse> call, Response<AreaResponse> response) {
                if (response.isSuccessful()) {
                    AreaResponse areaResponse = response.body();
                    if (areaResponse.getError().equals("-1")) {
                        dBhelper.emptyTable("area");
                        for (int i = 0; i < areaResponse.getAreas().size(); i++) {
                            dBhelper.addArea(areaResponse.getAreas().get(i).getTermId(),
                                    areaResponse.getAreas().get(i).getName());


                        }
                        area = dBhelper.getArea();


//                        View view1=getLayoutInflater().inflate(R.layout.show_city,null);
//                        AlertDialog.Builder builder = new AlertDialog.Builder(EnterPropertyDetailActivity.this);
                        final Dialog dialogarea = new Dialog(EnterPropertyDetailActivity.this);
                        dialogarea.setContentView(R.layout.show_area);
                        recyclerViewArea = dialogarea.findViewById(R.id.showArea);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EnterPropertyDetailActivity.this);
                        recyclerViewArea.setLayoutManager(layoutManager);
//                        AlertDialog dialog = builder.create();
//                        builder.setCancelable(false);
//                        builder.setView(view1);

                        areaAdapter = new AreaAdapter(area, EnterPropertyDetailActivity.this, dialogarea, areatxt);
                        recyclerViewArea.setAdapter(areaAdapter);
//                        adapter.setItemClick(EnterPropertyDetailActivity.this);
                        progressDialog.dismiss();
                        dialogarea.show();

//                        citytxt.setText(dBhelper.getCityById(SaveInSharedPreference.getInSharedPreference(EnterPropertyDetailActivity.this).getCityId()));


                    } else {
                        CustomAlert.alertDialog(EnterPropertyDetailActivity.this, "Areas Not Fetched");
                    }
                    Log.i("response", "post submitted to API." + areaResponse);
                }
            }

            @Override
            public void onFailure(Call<AreaResponse> call, Throwable t) {
                progressDialog.dismiss();
                CustomAlert.alertDialog(EnterPropertyDetailActivity.this, "Response Failed");
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }

    private void postPropertyDetails() {
        if (statusType.equals("Give On Rent")) {
            statusTypeID = "71";
        } else if (statusType.equals("For Sell")) {
            statusTypeID = "72";
        }
        Call<InsertPropertyResponse> call = apiService.postInsertSellProperty(title.getText().toString(),
                SaveInSharedPreference.getInSharedPreference(this).getUserId(),
                SaveInSharedPreference.getInSharedPreference(this).getPropertyTypeId(), statusTypeID,
                countrytxt.getText().toString(), SaveInSharedPreference.getInSharedPreference(this).getCityId(),
                SaveInSharedPreference.getInSharedPreference(this).getAreaId(),
                SaveInSharedPreference.getInSharedPreference(this).getSubAreaId(),
                SaveInSharedPreference.getInSharedPreference(this).getSectorId(),
                price.getText().toString(), size.getText().toString(), SaveInSharedPreference.getInSharedPreference(this).getAreaTypeId(),
                rooms.getText().toString(), bedroom.getText().toString(), bathroom.getText().toString(), garages.getText().toString(), details.getText().toString(),
                "image", video_url.getText().toString(), image360_url.getText().toString(),
                remainingMoney);

        call.enqueue(new Callback<InsertPropertyResponse>() {

            @Override
            public void onResponse(Call<InsertPropertyResponse> call, Response<InsertPropertyResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    InsertPropertyResponse insertResponse = response.body();
                    if (insertResponse.getError().equals("-1")) {
                        SaveInSharedPreference.getInSharedPreference(EnterPropertyDetailActivity.this).savePidToRedirectToWeb(insertResponse.getPid());
//                        CustomAlert.alertDialog(EnterPropertyDetailActivity.this, "Your Property Has Been Inserted !");
                        redirectToWeb();

                    }
                    Log.i("response", "post submitted to API." + insertResponse);
                }
            }

            @Override
            public void onFailure(Call<InsertPropertyResponse> call, Throwable t) {
                progressDialog.dismiss();
                CustomAlert.alertDialog(EnterPropertyDetailActivity.this, "Property Inserted");
                Log.e("response_Failed", "Unable to submit post to API." + t);
            }
        });
    }
    private TextWatcher textWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                price.removeTextChangedListener(this);

                String orignal_price=s.toString();
                long longVal;
                if(orignal_price.contains(",")){
                    orignal_price=orignal_price.replaceAll(",","");

                }
                longVal=Long.parseLong(orignal_price);
                DecimalFormat format=(DecimalFormat) NumberFormat.getInstance(Locale.US);
                format.applyPattern("#,###,###,###");
                String formaterString=format.format(longVal);
                price.setText(formaterString);
                price.setSelection(price.getText().toString().length());
                price.addTextChangedListener(this);
            }
        };
    }


}

