package com.example.admin.smile.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.smile.R;

public class AdapterViewPage extends PagerAdapter {
    private LayoutInflater layoutInflater;
    int []Layout;
    Context context;

    public AdapterViewPage(int[] layout, Context context) {
        Layout = layout;
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      View view = layoutInflater.inflate(Layout[position],container,false);
      container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return Layout.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view= (View) object;
        container.removeView(view);

    }
}
