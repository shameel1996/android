package com.example.vmatchu;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.vmatchu.DBhelper.DBhelper;
import com.example.vmatchu.Fragments.DetailsFragments;
import com.example.vmatchu.Fragments.Image360Fragment;
import com.example.vmatchu.Fragments.vedioFragment;
import com.example.vmatchu.Models.MyPropertyBathroomsForDB;
import com.example.vmatchu.Models.MyPropertyBedroomsForDB;
import com.example.vmatchu.Models.MyPropertyDescriptionForDB;
import com.example.vmatchu.Models.MyPropertyGaragesForDB;
import com.example.vmatchu.Models.MyPropertyRoomsForDB;
import com.example.vmatchu.Models.MyPropertySectorsForDB;
import com.example.vmatchu.Pojo.MyPropertyForDB;

import java.util.ArrayList;
import java.util.List;

public class PropertyDetailsActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    DBhelper dBhelper;
    ArrayList<MyPropertyForDB> propertyList;
    ArrayList<MyPropertySectorsForDB> propertyListSectors;
    ArrayList<MyPropertyGaragesForDB> propertyListGarages;
    ArrayList<MyPropertyBathroomsForDB> propertyListBathrooms;
    ArrayList<MyPropertyBedroomsForDB> propertyListBedrooms;
    ArrayList<MyPropertyRoomsForDB> propertyListRooms;
    ArrayList<MyPropertyDescriptionForDB> propertyListDescription;
    TextView city,area,sub_Area,sector,propertyId,propertyType,bathroom,bedroom;
    String pid;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        dBhelper = new DBhelper(this);
        pid = getIntent().getStringExtra("pid");
        city = findViewById(R.id.tv_city);
        area = findViewById(R.id.tv_area);
        sub_Area = findViewById(R.id.tv_sub_area);
        sector = findViewById(R.id.tv_sector);
        propertyId = findViewById(R.id.id_value);
        propertyType = findViewById(R.id.type_value);
        bathroom = findViewById(R.id.bed_value);
        bedroom = findViewById(R.id.bath_value);
        propertyList = dBhelper.getMyPropertyAreaSubAreaSector(pid);
        propertyListGarages = dBhelper.getMyPropertyGarages(pid);
        propertyListBathrooms = dBhelper.getMyPropertyBathrooms(pid);
        propertyListBedrooms = dBhelper.getMyPropertyBedrooms(pid);
        propertyListRooms = dBhelper.getMyPropertyRooms(pid);
        propertyListDescription = dBhelper.getMyPropertyDescription(pid);
        propertyListSectors = dBhelper.getMyPropertySectors(pid);

        setViews();
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabMode);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setViews() {

        city.setText(propertyList.get(0).getCity());
        area.setText(propertyList.get(0).getArea());
        sub_Area.setText(propertyList.get(0).getSub_area());
        sector.setText(propertyListSectors.get(0).getSectors());
        propertyId.setText(propertyList.get(0).getPid());
        bathroom.setText(propertyListBathrooms.get(0).getBathrooms());
        bedroom.setText(propertyListBedrooms.get(0).getBedrooms());
        propertyType.setText(propertyList.get(0).getPropertyType());

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putSerializable("propertyList", propertyList);
        bundle.putSerializable("propertyListSectors", propertyListSectors);
        bundle.putSerializable("propertyListGarages", propertyListGarages);
        bundle.putSerializable("propertyListBathrooms", propertyListBathrooms);
        bundle.putSerializable("propertyListBedrooms", propertyListBedrooms);
        bundle.putSerializable("propertyListRooms", propertyListRooms);
        bundle.putSerializable("propertyListDescription", propertyListDescription);
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
