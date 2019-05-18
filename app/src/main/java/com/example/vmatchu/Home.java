package com.example.vmatchu;

import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;
import android.widget.VideoView;

public class Home extends Fragment {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file

        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.activity_home2, container, false);


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        final VideoView videoView;
       //videoView = (VideoView)getView().findViewById(R.id.videoView1);
       // videoView.setVideoPath("https://vmatchu.com/#lg=1&slide=0.mp4");
       // videoView.start();

//        TabLayout tabLayout = (TabLayout) getView().findViewById(R.id.tabs);
//        // Add five tabs.  Three have icons and two have text titles
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.submit));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.match));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.contactus));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.dealdone));


        getActivity().setTitle("Home");
    }
}
