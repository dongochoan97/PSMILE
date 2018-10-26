package com.example.admin.smile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.smile.Model.Category;
import com.example.admin.smile.R;

import java.util.ArrayList;

public class AdapterCategory extends BaseAdapter {
    Context context;
    ArrayList<Category> arrData;

    public AdapterCategory(Context context, ArrayList<Category> arrData) {
        this.context = context;
        this.arrData = arrData;
    }

    @Override
    public int getCount() {
        return arrData.size();
    }

    @Override
    public Object getItem(int position) {
        return arrData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_category,parent,false);
            viewHolder.txtTitle = convertView.findViewById(R.id.txttitle);
            viewHolder.txtThreadnew = convertView.findViewById(R.id.txtThreadnew);
            viewHolder.txtContent = convertView.findViewById(R.id.txtContent);
            viewHolder.txtDate = convertView.findViewById(R.id.txtDate);
            convertView.setTag(viewHolder);


        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // ánh xạ
        Category item = arrData.get(position);
        viewHolder.txtTitle.setText(item.getTitle());
        viewHolder.txtThreadnew.setText(item.getThreadnew());
        viewHolder.txtContent.setText(item.getContent());
        viewHolder.txtDate.setText(item.getDate());


        return convertView;
    }
    class  ViewHolder{
        TextView txtTitle,txtContent,txtThreadnew,txtDate;
    }
}
