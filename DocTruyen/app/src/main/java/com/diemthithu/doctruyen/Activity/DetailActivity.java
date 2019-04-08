package com.diemthithu.doctruyen.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.diemthithu.doctruyen.Model.Truyen;
import com.diemthithu.doctruyen.Fragment.DetailFragment;
import com.diemthithu.doctruyen.R;
import com.google.gson.Gson;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
        //Hiển thị nút back ở tool bar;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String json=getIntent().getStringExtra(DetailFragment.KEY_DETAIL);
        //chuyen json ve object
        Truyen truyen=new Gson().fromJson(json,Truyen.class);
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.layoutfrag,DetailFragment.newInstance(truyen));
        ft.commit();

    }
    //chuyen dl sang man hinh doc,chuyen man hinh
    public  static  void showdetail(Context context, Truyen truyen){
        Intent intent=new Intent(context,DetailActivity.class);
        intent.putExtra(DetailFragment.KEY_DETAIL,new Gson().toJson(truyen));
        context.startActivity(intent);
}

}

