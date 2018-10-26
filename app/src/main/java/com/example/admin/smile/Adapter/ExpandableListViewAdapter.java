package com.example.admin.smile.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.smile.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.admin.smile.R.drawable.buttonfacebook;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter  {
    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
    int gioiTinh=0;
    boolean benh1=true;
    boolean benh2=false;
    boolean benh3=false;
    boolean benh4=false;
    boolean benh5=false;
    boolean benh6=false;


    public ExpandableListViewAdapter(Context _context, List<String> _listDataHeader, HashMap<String, List<String>> _listDataChild) {
        this._context = _context;
        this._listDataHeader = _listDataHeader;
        this._listDataChild = _listDataChild;
    }


    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return _listDataChild.get(_listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return _listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return _listDataChild.get(_listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        String data = (String) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater li = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.item_view, null);
        }

        TextView tvHeader = (TextView) view.findViewById(R.id.tvHeader);
        tvHeader.setTypeface(null, Typeface.BOLD);
        tvHeader.setText(data);

        return view;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View view, ViewGroup parent) {


        final ViewHolder viewHolder;


        final String data = (String) getChild(groupPosition, childPosition);

        if (view == null) {
            viewHolder= new ViewHolder();
            LayoutInflater li = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.additemcon, null);
            viewHolder.edtten= view.findViewById(R.id.edtNhaptenChild);
            viewHolder.edtnamsinh= view.findViewById(R.id.edtnamsinhChild);
            viewHolder.edtdiachi = view.findViewById(R.id.edtthongtinconChild);

            viewHolder.btnbenh1= view.findViewById(R.id.btnbenh1);
            viewHolder.btnbenh2= view.findViewById(R.id.btnbenh2);
            viewHolder.btnbenh3= view.findViewById(R.id.btnbenh3);
            viewHolder.btnbenh4= view.findViewById(R.id.btnbenh4);
            viewHolder.btnbenh5= view.findViewById(R.id.btnbenh5);
            viewHolder.btnbenh6= view.findViewById(R.id.btnbenh6);
            viewHolder.btnNam= view.findViewById(R.id.btnGtNam);
            viewHolder.btnNu= view.findViewById(R.id.btnGtNu);
            viewHolder.btnKhac = view.findViewById(R.id.btnGtKhac);
            viewHolder.btnSave = view.findViewById(R.id.btnSavechild);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        ///
        viewHolder.btnNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gioiTinh=0;
                viewHolder.btnNu.setBackgroundResource(R.drawable.buttonfacebook);
                viewHolder.btnNam.setBackgroundResource(R.drawable.buttonregister);
                viewHolder.btnKhac.setBackgroundResource(R.drawable.buttonfacebook);
                Log.e("gt","Nam "+gioiTinh);
            }
        });
        viewHolder.btnNu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gioiTinh=1;
                viewHolder.btnNu.setBackgroundResource(R.drawable.buttonregister);
                viewHolder.btnNam.setBackgroundResource(R.drawable.buttonfacebook);
                viewHolder.btnKhac.setBackgroundResource(R.drawable.buttonfacebook);
                Log.e("gt","Nu "+gioiTinh);
            }
        });

        viewHolder.btnKhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gioiTinh=2;
                viewHolder.btnNu.setBackgroundResource(R.drawable.buttonfacebook);
                viewHolder.btnNam.setBackgroundResource(R.drawable.buttonfacebook);
                viewHolder.btnKhac.setBackgroundResource(R.drawable.buttonregister);
                Log.e("gt","khac "+gioiTinh);
            }
        });

        viewHolder.btnbenh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (benh1==true){
                    benh1=false;
                    viewHolder.btnbenh1.setBackgroundResource(R.drawable.buttonfacebook);
                }else {
                    benh1=true;
                    viewHolder.btnbenh1.setBackgroundResource(R.drawable.buttonregister);
                }
            }
        });
        viewHolder.btnbenh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (benh2==true){
                    benh2=false;
                    viewHolder.btnbenh2.setBackgroundResource(R.drawable.buttonfacebook);
                }else {
                    benh2=true;
                    viewHolder.btnbenh2.setBackgroundResource(R.drawable.buttonregister);
                }
            }
        });
        viewHolder.btnbenh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (benh3==true){
                    benh3=false;
                    viewHolder.btnbenh3.setBackgroundResource(R.drawable.buttonfacebook);
                }else {
                    benh3=true;
                    viewHolder.btnbenh3.setBackgroundResource(R.drawable.buttonregister);
                }
            }
        });
        viewHolder.btnbenh4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (benh4==true){
                    benh4=false;
                    viewHolder.btnbenh4.setBackgroundResource(R.drawable.buttonfacebook);
                }else {
                    benh4=true;
                    viewHolder.btnbenh4.setBackgroundResource(R.drawable.buttonregister);
                }
            }
        });
        viewHolder.btnbenh5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (benh5==true){
                    benh5=false;
                    viewHolder.btnbenh5.setBackgroundResource(R.drawable.buttonfacebook);
                }else {
                    benh5=true;
                    viewHolder.btnbenh5.setBackgroundResource(R.drawable.buttonregister);
                }
            }
        });
        viewHolder.btnbenh6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (benh6==true){
                    benh6=false;
                    viewHolder.btnbenh6.setBackgroundResource(R.drawable.buttonfacebook);
                }else {
                    benh6=true;
                    viewHolder.btnbenh6.setBackgroundResource(R.drawable.buttonregister);
                }
            }
        });
        viewHolder.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean kq = luudulieucon("child"+groupPosition,viewHolder.edtten.getText().toString(),viewHolder.edtnamsinh.getText().toString(),viewHolder.edtdiachi.getText().toString());
                if(kq==true){
                    Toast.makeText(_context,"Thành công",Toast.LENGTH_SHORT).show();
                }
                Log.e("tencon","child"+groupPosition);

            }
        });




        return view;
    }


    class ViewHolder{
        Button btnbenh1,btnbenh2,btnbenh3,btnbenh4,btnbenh5,btnbenh6,btnNam,btnNu,btnKhac,btnSave;
        EditText edtten, edtnamsinh,edtdiachi;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    boolean luudulieucon(String tendata,String tencon,String namsinh,String thongtin ){
        SharedPreferences preferences = _context.getSharedPreferences(tendata, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("tencon",tencon);
        editor.putString("namsinh",namsinh);
        editor.putString("thongtin",thongtin);
        editor.putInt("gioitinh",gioiTinh);
        editor.putBoolean("benh1",benh1);
        editor.putBoolean("benh2",benh2);
        editor.putBoolean("benh3",benh3);
        editor.putBoolean("benh4",benh4);
        editor.putBoolean("benh5",benh5);
        editor.putBoolean("benh6",benh6);
        boolean kq = editor.commit();
        return kq;
    }



}
