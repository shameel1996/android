package com.example.vmatchu.Activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vmatchu.DBhelper.DBhelper;
import com.example.vmatchu.Fragments.DetailsFragments;
import com.example.vmatchu.Fragments.Image360Fragment;
import com.example.vmatchu.Fragments.vedioFragment;
import com.example.vmatchu.Pojo.MyPropertyArea;
import com.example.vmatchu.Pojo.MyPropertyAreaType;
import com.example.vmatchu.Pojo.MyPropertyBathrooms;
import com.example.vmatchu.Pojo.MyPropertyBedrooms;
import com.example.vmatchu.Pojo.MyPropertyCity;
import com.example.vmatchu.Pojo.MyPropertyData;
import com.example.vmatchu.Pojo.MyPropertyDescription;
import com.example.vmatchu.Pojo.MyPropertyGarages;
import com.example.vmatchu.Pojo.MyPropertyPropertyType;
import com.example.vmatchu.Pojo.MyPropertyRooms;
import com.example.vmatchu.Pojo.MyPropertySector;
import com.example.vmatchu.Pojo.MyPropertyStatus;
import com.example.vmatchu.Pojo.MyPropertySubArea;
import com.example.vmatchu.R;

import java.util.ArrayList;
import java.util.List;

public class PropertyDetailsActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    DBhelper dBhelper;
    ArrayList<MyPropertyData> propertyList;
    ArrayList<MyPropertySector> propertyListSectors;
    ArrayList<MyPropertyGarages> propertyListGarages;
    ArrayList<MyPropertyBathrooms> propertyListBathrooms;
    ArrayList<MyPropertyBedrooms> propertyListBedrooms;
    ArrayList<MyPropertyRooms> propertyListRooms;
    ArrayList<MyPropertyDescription> propertyListDescription;
    ArrayList<MyPropertyCity> propertyListCity;
    ArrayList<MyPropertyArea> propertyListArea;
    ArrayList<MyPropertySubArea> propertyListSubArea;
    ArrayList<MyPropertyAreaType> propertyListAreaType;
    ArrayList<MyPropertyPropertyType> propertyListPropertyType;
    ArrayList<MyPropertyStatus> propertyListStatus;
    TextView city,area,sub_Area,sector,propertyId,propertyType,bathroom,bedroom,tv_date,tv_desc;
    CollapsingToolbarLayout collapsingToolbarLayout;
    String pid,date,propertyCity,propertyArea,propertySubArea,propertySector,propertyGarages,propertyBathrooms,propertyBedrooms;
    String propertyRooms,propertyDesc,propertyAreaType,propertyPropertyType,propertyStatus,propertyTitle= "";
    String propertyCityId,propertyAreaId,propertySubAreaId,propertySectorId,propertyAreaTypeId,propertyPropertyTypeId,propertyStatusId = "";
    String propertyMinSize,propertyMinSizePid,propertyMinPrice,propertyMinPricePid,propertyMaxSize ,propertyMaxSizePid ,propertyMaxPrice,propertyMaxPricePid ="";
    LinearLayout call,sms, call_sms_linear;
    TextView tv_description,titleText;
    LinearLayout linear_desc_line;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        dBhelper = new DBhelper(this);
        pid = getIntent().getStringExtra("pid");
        date = getIntent().getStringExtra("propertyData");
        propertyTitle = getIntent().getStringExtra("propertyDataTitle");
        propertyGarages = getIntent().getStringExtra("propertyListGarages");
        propertyBathrooms = getIntent().getStringExtra("propertyListBathroom");
        propertyBedrooms =  getIntent().getStringExtra("propertyListBedroom");
        propertyRooms = getIntent().getStringExtra("propertyListRoom");
        propertyDesc = getIntent().getStringExtra("propertyListDescription");
        propertySector = getIntent().getStringExtra("propertyListSector");
        propertySectorId = getIntent().getStringExtra("propertyListSectorID");
        propertyCity = getIntent().getStringExtra("propertyListCity");
        propertyCityId = getIntent().getStringExtra("propertyListCityID");
        propertyArea = getIntent().getStringExtra("propertyListArea");
        propertyAreaId = getIntent().getStringExtra("propertyListAreaID");
        propertySubArea =  getIntent().getStringExtra("propertyListSubArea");
        propertySubAreaId =  getIntent().getStringExtra("propertyListSubAreaID");
        propertyAreaType = getIntent().getStringExtra("propertyListAreaType");
        propertyAreaTypeId = getIntent().getStringExtra("propertyListAreaTypeID");
        propertyPropertyType = getIntent().getStringExtra("propertyListPropertyType");
        propertyPropertyTypeId = getIntent().getStringExtra("propertyListPropertyTypeID");
        propertyStatus =  getIntent().getStringExtra("propertyListStatus");
        propertyStatusId =  getIntent().getStringExtra("propertyListStatusID");
        propertyMinSize =  getIntent().getStringExtra("propertyListMinSize");
        propertyMinSizePid =  getIntent().getStringExtra("propertyListMinSizePid");
        propertyMinPrice =  getIntent().getStringExtra("propertyListMinPrice");
        propertyMinPricePid =  getIntent().getStringExtra("propertyListMinPricePid");
        propertyMaxSize =  getIntent().getStringExtra("propertyListMaxSize");
        propertyMaxSizePid =  getIntent().getStringExtra("propertyListMaxSizePid");
        propertyMaxPrice =  getIntent().getStringExtra("propertyListMaxPrice");
        propertyMaxPricePid =  getIntent().getStringExtra("propertyListMaxPricePid");

        city = findViewById(R.id.tv_city);
        area = findViewById(R.id.tv_area);
        sub_Area = findViewById(R.id.tv_sub_area);
        sector = findViewById(R.id.tv_sector);
        call = findViewById(R.id.call);
        sms = findViewById(R.id.sms);
        call_sms_linear = findViewById(R.id.groupbutton);
//        propertyId = findViewById(R.id.id_value);
//        propertyType = findViewById(R.id.type_value);
//        bathroom = findViewById(R.id.bed_value);
//        bedroom = findViewById(R.id.bath_value);
        tv_date = findViewById(R.id.date_desc);
        tv_desc = findViewById(R.id.desc_text);
        collapsingToolbarLayout = findViewById(R.id.toolbar_title);
        tv_description = findViewById(R.id.description);
        linear_desc_line = findViewById(R.id.linear_desc_line);
        titleText=findViewById(R.id.title_text);
//        propertyList = dBhelper.getMyPropertyAreaSubAreaSector(pid);
//        propertyListGarages = dBhelper.getMyPropertyGarages(pid);
//        propertyListBathrooms = dBhelper.getMyPropertyBathrooms(pid);
//        propertyListBedrooms = dBhelper.getMyPropertyBedrooms(pid);
//        propertyListRooms = dBhelper.getMyPropertyRooms(pid);
//        propertyListDescription = dBhelper.getMyPropertyDescription(pid);
//        propertyListSectors = dBhelper.getMyPropertySectors(pid);
//        propertyListCity = dBhelper.getMyPropertyCityByPid(pid);
//        propertyListArea = dBhelper.getMyPropertyArea(pid);
//        propertyListSubArea = dBhelper.getMyPropertySubArea(pid);
//        propertyListAreaType = dBhelper.getMyPropertyAreaType(pid);
//        propertyListPropertyType = dBhelper.getMyPropertyPropertyType(pid);
//        propertyListStatus = dBhelper.getMyPropertyStatusByPid(pid);
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbardetail);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

        if(getIntent().getStringExtra("matchOrMyProperty").equals("match")){
            call_sms_linear.setVisibility(View.VISIBLE);
        }

        if(propertyDesc.equals("")){
            tv_description.setVisibility(View.GONE);
            linear_desc_line.setVisibility(View.GONE);
        }

        setViews();
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabMode);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PropertyDetailsActivity.this,myProperty.class));
        super.onBackPressed();
    }
    private void setViews() {

//        city.setText(propertyList.get(0).getCity());
//        area.setText(propertyList.get(0).getArea());
//        sub_Area.setText(propertyList.get(0).getSub_area());
//        sector.setText(propertyListSectors.get(0).getSectors());
        //collapsingToolbarLayout.setTitle(propertyTitle);
        titleText.setText(propertyTitle);
//        propertyId.setText(pid);
        tv_date.setText(date);
        tv_desc.setText(propertyDesc);
//        bathroom.setText(propertyListBathrooms.get(0).getBathrooms());
//        bedroom.setText(propertyListBedrooms.get(0).getBedrooms());
//        propertyType.setText(propertyList.get(0).getPropertyType());

        city.setText(propertyCity);
        area.setText(propertyArea);
        sub_Area.setText(propertySubArea);

            sector.setText(propertySector);


//        propertyType.setText(propertyPropertyType);



//            bathroom.setText(propertyBathrooms);



//            bedroom.setText(propertyBedrooms);


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("propertyList", date);
        bundle.putString("propertyListSectors", propertySector);
        bundle.putString("propertyListGarages", propertyGarages);
        bundle.putString("propertyListBathrooms", propertyBathrooms);
        bundle.putString("propertyListBedrooms", propertyBedrooms);
        bundle.putString("propertyListRooms", propertyRooms);
        bundle.putString("propertyListDescription", propertyDesc);
        bundle.putString("propertyListCity", propertyCity);
        bundle.putString("propertyListArea", propertyArea);
        bundle.putString("propertyListSubArea", propertySubArea);
        bundle.putString("propertyListAreaType", propertyAreaType);
        bundle.putString("propertyListPropertyType", propertyPropertyType);
        bundle.putString("propertyListStatus", propertyStatus);
        bundle.putString("propertyListMinSize", propertyMinSize);
        bundle.putString("propertyListMinSizePid", propertyMinSizePid);
        bundle.putString("propertyListMinPrice", propertyMinPrice);
        bundle.putString("propertyListMinPricePid", propertyMinPricePid);
        bundle.putString("propertyListMaxSize", propertyMaxSize);
        bundle.putString("propertyListMaxSizePid", propertyMaxSizePid);
        bundle.putString("propertyListMaxPrice", propertyMaxPrice);
        bundle.putString("propertyListMaxPricePid", propertyMaxPricePid);
        bundle.putString("pid", pid);
        DetailsFragments fragobj = new DetailsFragments();
        fragobj.setArguments(bundle);

        adapter.addFragment(fragobj, "Details");
        adapter.addFragment(new vedioFragment(), "Video");
        adapter.addFragment(new Image360Fragment(), "Image 360");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }


        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }}
