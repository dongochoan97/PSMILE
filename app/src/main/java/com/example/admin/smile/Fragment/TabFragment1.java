package com.example.admin.smile.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.smile.Adapter.AdapterCategory;
import com.example.admin.smile.ItfOnClick;
import com.example.admin.smile.Model.Category;
import com.example.admin.smile.R;

import java.util.ArrayList;

public class TabFragment1 extends Fragment implements GestureDetector.OnGestureListener {

    // EDIT_20171110_NTQ#41751_TruongNDH_Fix_bug_scroll_timeline_Start
    private static final int SWIPE_THRESHOLD = 20;
    private static final int SWIPE_VELOCITY_THRESHOLD = 1000;
    // EDIT_20171110_NTQ#41751_TruongNDH_Fix_bug_scroll_timeline_End




    ListView lvCategory;
    AdapterCategory adapterCategory;
    ArrayList<Category> arrdata;
    GestureDetector gestureDetector;
    ItfOnClick onClick;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onClick = (ItfOnClick) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_layout1,container,false);
        arrdata = new ArrayList<>();
        arrdata.add(new Category("Tin tức trong ngày","Cục CSGT thông tin vụ ô tô biển xanh 80B hụ còi huyên náo đường phố Sài Gòn","Cục Cảnh sát giao thông cho biết, biển số 80B-3758 không được cấp cho chiếc xe ô tô hụ phát còi ưu tiên, bật đèn quay...","2:51 PM  -  10/24/2018"));
        arrdata.add(new Category("Tin bóng đá - thể thao","Rooney tròn 33 tuổi: Nhìn Ronaldo vẫn trên đỉnh, tiểu Pele có chạnh lòng?","Rooney đón tuổi 33 tại Mỹ trong khi sự nghiệp Ronaldo vẫn thăng như diều gặp gió.","2:51 PM  -  10/24/2018"));
        arrdata.add(new Category("Tài Chính bất động sản","Nhà hướng tây và sợ nóng? Học ngay thiết kế của căn nhà ở Bình Dương này nhé!","Thiết kế thông minh giúp căn nhà ở Bình Dương luôn mát mẻ, lộng gió dù nằm ở hướng tây.","11:20 AM  - 9/10/2018"));
        arrdata.add(new Category("Tin tức trong ngày","Cục CSGT thông tin vụ ô tô biển xanh 80B hụ còi huyên náo đường phố Sài Gòn","Cục Cảnh sát giao thông cho biết, biển số 80B-3758 không được cấp cho chiếc xe ô tô hụ phát còi ưu tiên, bật đèn quay...","2:51 PM  -  10/24/2018"));
        arrdata.add(new Category("Tin bóng đá - thể thao","Rooney tròn 33 tuổi: Nhìn Ronaldo vẫn trên đỉnh, tiểu Pele có chạnh lòng?","Rooney đón tuổi 33 tại Mỹ trong khi sự nghiệp Ronaldo vẫn thăng như diều gặp gió.","2:51 PM  -  10/24/2018"));
        arrdata.add(new Category("Tài Chính bất động sản","Nhà hướng tây và sợ nóng? Học ngay thiết kế của căn nhà ở Bình Dương này nhé!","Thiết kế thông minh giúp căn nhà ở Bình Dương luôn mát mẻ, lộng gió dù nằm ở hướng tây.","11:20 AM  - 9/10/2018"));
        arrdata.add(new Category("Tin tức trong ngày","Cục CSGT thông tin vụ ô tô biển xanh 80B hụ còi huyên náo đường phố Sài Gòn","Cục Cảnh sát giao thông cho biết, biển số 80B-3758 không được cấp cho chiếc xe ô tô hụ phát còi ưu tiên, bật đèn quay...","2:51 PM  -  10/24/2018"));
        arrdata.add(new Category("Tin bóng đá - thể thao","Rooney tròn 33 tuổi: Nhìn Ronaldo vẫn trên đỉnh, tiểu Pele có chạnh lòng?","Rooney đón tuổi 33 tại Mỹ trong khi sự nghiệp Ronaldo vẫn thăng như diều gặp gió.","2:51 PM  -  10/24/2018"));
        arrdata.add(new Category("Tài Chính bất động sản","Nhà hướng tây và sợ nóng? Học ngay thiết kế của căn nhà ở Bình Dương này nhé!","Thiết kế thông minh giúp căn nhà ở Bình Dương luôn mát mẻ, lộng gió dù nằm ở hướng tây.","11:20 AM  - 9/10/2018"));
        arrdata.add(new Category("Tin tức trong ngày","Cục CSGT thông tin vụ ô tô biển xanh 80B hụ còi huyên náo đường phố Sài Gòn","Cục Cảnh sát giao thông cho biết, biển số 80B-3758 không được cấp cho chiếc xe ô tô hụ phát còi ưu tiên, bật đèn quay...","2:51 PM  -  10/24/2018"));
        arrdata.add(new Category("Tin bóng đá - thể thao","Rooney tròn 33 tuổi: Nhìn Ronaldo vẫn trên đỉnh, tiểu Pele có chạnh lòng?","Rooney đón tuổi 33 tại Mỹ trong khi sự nghiệp Ronaldo vẫn thăng như diều gặp gió.","2:51 PM  -  10/24/2018"));
        arrdata.add(new Category("Tài Chính bất động sản","Nhà hướng tây và sợ nóng? Học ngay thiết kế của căn nhà ở Bình Dương này nhé!","Thiết kế thông minh giúp căn nhà ở Bình Dương luôn mát mẻ, lộng gió dù nằm ở hướng tây.","11:20 AM  - 9/10/2018"));


        lvCategory =  view.findViewById(R.id.lv_category);
        adapterCategory = new AdapterCategory(getContext(),arrdata);
        lvCategory.setAdapter(adapterCategory);
        adapterCategory.notifyDataSetChanged();
        gestureDetector = new GestureDetector(getContext(),this);
        lvCategory.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return gestureDetector.onTouchEvent(event);
            }
        });
        return view;

    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        //onSwipeRight();
                        Toast.makeText(getContext(),"Right",Toast.LENGTH_SHORT).show();
                        Log.e("Event","right");
                    } else {
                        Toast.makeText(getContext(),"left",Toast.LENGTH_SHORT).show();
                        Log.e("Event","left");
                    }
                }
            }
            else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
//                    onSwipeBottom();
                    onClick.hienTabLayout();



                } else {
                   // onSwipeTop();

                    onClick.hideTablayout();

                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }


}
