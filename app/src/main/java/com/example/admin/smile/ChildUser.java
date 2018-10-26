package com.example.admin.smile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.smile.Adapter.ExpandableListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChildUser extends AppCompatActivity implements View.OnClickListener {
    ExpandableListView expandableListView;

    List<String> listHeader;

    private HashMap<String, List<String>> mData;
    ExpandableListViewAdapter expandableListViewAdapter;

    ImageView btnbackChild;
    Button btnluudata;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerchild);
        addControl();
        expandableListViewAdapter = new ExpandableListViewAdapter(this, listHeader, mData);
        expandableListView.setAdapter(expandableListViewAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {


                return false;
            }
        });

    }

    private void addControl() {

        btnluudata = findViewById(R.id.btnLuuRegis);
        btnluudata.setOnClickListener(this);
        expandableListView = findViewById(R.id.expanded_menu);
        btnbackChild = findViewById(R.id.imvbackRigis);
        btnbackChild.setOnClickListener(this);
        ///////////
        listHeader = new ArrayList<>();
        mData = new HashMap<>();
        List<String> listStudentXs = new ArrayList<>();
        listStudentXs.add("child1.1");
        for (int i = 0; i < getSizeChild(); i++) {
            listHeader.add("Child " + i);
            mData.put(listHeader.get(i), listStudentXs);
        }


    }

    int getSizeChild() {
        SharedPreferences preferences = getSharedPreferences("DataRegister", Context.MODE_PRIVATE);
        String sl = preferences.getString("soluong", "");
        int slu = Integer.parseInt(sl);
        return slu;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.imvbackRigis:
                finish();
                break;
            case R.id.btnLuuRegis:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

}
