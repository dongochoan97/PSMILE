package com.example.admin.smile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {
    EditText edttten,edtngaysinh,edtsoluong,edtdiachi,edtthongtin;
    ImageButton imvBack;
    Button btnLuudata;
    ImageView imvAvatar;
    public static int REQUEST_CODE_MOHINH=123;

    Uri UriAvatar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeruser);
        anhxa();
    }

    private void anhxa() {
        imvBack = findViewById(R.id.imvbackRigis);
        imvBack.setOnClickListener(this);
        imvAvatar= findViewById(R.id.imvAvatar);
        imvAvatar.setOnClickListener(this);
        btnLuudata= findViewById(R.id.btnLuuRegis);
        btnLuudata.setOnClickListener(this);
        edttten= findViewById(R.id.edtNhaptenRegis);
        edtngaysinh= findViewById(R.id.edtNhapngaysinhRegis);
        edtsoluong= findViewById(R.id.edtsoluongRegis);
        edtthongtin= findViewById(R.id.edtThongtinchungRegis);
        edtdiachi = findViewById(R.id.edtDiachiRegis);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.imvbackRigis:
                Intent intent= new Intent(this,Welcome.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnLuuRegis:

                saveData();
                break;

            case R.id.imvAvatar:
                Intent intent1 = new Intent();
                intent1.setType("image/*");
                intent1.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent1,"Chọn hình ảnh"),REQUEST_CODE_MOHINH);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(REQUEST_CODE_MOHINH == requestCode){
            if(resultCode == Activity.RESULT_OK){
                if(data.getData()!=null){
                    imvAvatar.setImageURI(data.getData());
                    UriAvatar=data.getData();
                }else {
                    Toast.makeText(getApplicationContext(),"Vui lòng chọn hình ảnh",Toast.LENGTH_SHORT).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void saveData(){
        SharedPreferences preferences = getSharedPreferences("DataRegister", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("ten",edttten.getText().toString());
        editor.putString("ngaysinh",edtngaysinh.getText().toString());
        editor.putString("soluong",edtsoluong.getText().toString());
        editor.putString("diachi",edtdiachi.getText().toString());
        editor.putString("thongtin",edtthongtin.getText().toString());
        if(UriAvatar==null){
            editor.putString("hinhanh","");
        }else {
            editor.putString("hinhanh", UriAvatar.toString());
        }
       boolean kq = editor.commit();
        if(kq==false){
            Toast.makeText(getApplicationContext(),"Lỗi",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"Lưu Thành công",Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(this,ChildUser.class);
            int sl= Integer.parseInt(edtsoluong.getText().toString());
            intent.putExtra("soluongcon",sl);
            startActivity(intent);
        }

    }
}
