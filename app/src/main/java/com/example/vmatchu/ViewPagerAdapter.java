package com.example.vmatchu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {



    private final List<Fragment> fragmentlist = new ArrayList<>();
    private final List<String> fragmentlisttitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int i) {
        return fragmentlist.get(i);
    }

    @Override
    public int getCount() {
        return fragmentlisttitle.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentlisttitle.get(position);
    }
    public void AddFragment(Fragment fragment,String Titles){

        fragmentlist.add(fragment);
        fragmentlisttitle.add(Titles);
    }
}
