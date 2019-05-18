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
import com.example.vmatchu.Pojo.MyPropertyForDB;

import java.util.ArrayList;
import java.util.List;

public class PropertyDetailsActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    DBhelper dBhelper;
    ArrayList<MyPropertyForDB> propertyList;
    TextView city,area,sub_Area,sector;
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
        propertyList = dBhelper.getMyPropertyAreaSubAreaSector(pid);

        setViews();
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabMode);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setViews() {

        city.setText(propertyList.get(0).getCity());
        area.setText(propertyList.get(0).getArea());
        sub_Area.setText(propertyList.get(0).getSub_area());
        sector.setText(propertyList.get(0).getSector());
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DetailsFragments(), "Details");
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
