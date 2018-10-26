package com.example.admin.smile.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin.smile.Fragment.TabFragment1;
import com.example.admin.smile.Fragment.TabFragment2;
import com.example.admin.smile.Fragment.TabFragment3;

public class PagerAdaptertab extends FragmentStatePagerAdapter {

    public PagerAdaptertab(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new TabFragment1();
                break;
            case 1:
                frag = new TabFragment2();
                break;
            case 2:
                frag = new TabFragment3();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "TOP";
                break;
            case 1:
                title = "ADHD";
                break;
            case 2:
                title = "LD";
                break;
        }
        return title;
    }
}
