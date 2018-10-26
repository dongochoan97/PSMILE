package com.example.admin.smile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.admin.smile.Adapter.PagerAdaptertab;

public class MainActivity extends AppCompatActivity implements ItfOnClick {
    ViewPager viewPager;
    TabLayout tabLayout;
    PagerAdaptertab pagerAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager= findViewById(R.id.viewpage);
        tabLayout= findViewById(R.id.tab_layout);
        FragmentManager manager = getSupportFragmentManager();
        pagerAdapter = new PagerAdaptertab(manager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);//deprecated
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

        //getSupportActionBar().hide();
        //tabLayout.setVisibility(View.GONE);
    }

    @Override
    public void hideTablayout() {
        getSupportActionBar().hide();
        tabLayout.setVisibility(View.GONE);

    }

    @Override
    public void hienTabLayout() {
        getSupportActionBar().show();
        tabLayout.setVisibility(View.VISIBLE);
    }
}
