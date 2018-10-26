package com.example.admin.smile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.smile.Adapter.AdapterViewPage;

public class Welcome extends AppCompatActivity implements View.OnClickListener {
    ViewPager viewPager;
    int []layout;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private AdapterViewPage myViewPagerAdapter;
    Button btnregiter,btnfacebook;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        viewPager= findViewById(R.id.viewpage);
        dotsLayout= findViewById(R.id.layoutDots);
        btnlogin= findViewById(R.id.btnlogin);
        btnregiter= findViewById(R.id.btnrigister);
        btnfacebook = findViewById(R.id.btnfacebook);
        btnlogin.setOnClickListener(this);
        btnfacebook.setOnClickListener(this);
        btnregiter.setOnClickListener(this);


        layout = new int[]{
                R.layout.welcome_slide1,R.layout.welcome_slide2,R.layout.welcome_slide3,R.layout.welcome_slide4
        };


        myViewPagerAdapter= new AdapterViewPage(layout,getApplicationContext());
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        addBottomDots(0);
    }


    private void addBottomDots(int currentPage) {
        dots = new TextView[layout.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnlogin:
                Intent intent = new Intent(this,LoginUser.class);
                startActivity(intent);
                break;
            case R.id.btnfacebook:
                Intent intent3 = new Intent(this,ChildUser.class);
                startActivity(intent3);
                break;
            case R.id.btnrigister:
                boolean check= ckeckDataRigisterUser();
                if(check==false){
                    Intent intent1 = new Intent(this,RegisterUser.class);
                    startActivity(intent1);
                }else {
                    Intent intent2 = new Intent(this,ChildUser.class);
                    startActivity(intent2);
                }

                break;
        }
    }

   public boolean  ckeckDataRigisterUser(){
        SharedPreferences preferences = getSharedPreferences("DataRegister", Context.MODE_PRIVATE);
        String user= preferences.getString("ten","");
        if(user==""){
            return false;
        }else {
            return true;
        }
    }
}
