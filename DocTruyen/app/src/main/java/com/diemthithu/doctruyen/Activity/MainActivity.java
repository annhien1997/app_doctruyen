package com.diemthithu.doctruyen.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.diemthithu.doctruyen.Adapter.PageAdapter;
import com.diemthithu.doctruyen.Adapter.TimKiemAdapter;
import com.diemthithu.doctruyen.Fragment.ListFragment;
import com.diemthithu.doctruyen.Model.TimKiem;
import com.diemthithu.doctruyen.R;
import com.diemthithu.doctruyen.Server.Api;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Animation in, out;
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewTK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        //ẩn name app
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
        bindView();

        addEEventViewFlipper();
    }
//chay slide
    private void addEEventViewFlipper() {
        ArrayList<String> arrQuangCao = new ArrayList<>();
        arrQuangCao.add("http://192.168.56.1:8080/doctruyen/anh/slide_1.jpg");
        arrQuangCao.add("http://192.168.56.1:8080/doctruyen/anh/slide_2.jpg");
        arrQuangCao.add("http://192.168.56.1:8080/doctruyen/anh/slide_4.jpg");
        arrQuangCao.add("http://192.168.56.1:8080/doctruyen/anh/bia1.jpg");
        arrQuangCao.add("http://192.168.56.1:8080/doctruyen/anh/bia8.jpg");

        for (int i = 0; i < arrQuangCao.size(); i++) {
            ImageView imageView = new ImageView(MainActivity.this);
            Picasso.with(MainActivity.this).load(arrQuangCao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000); //thoi gian chay
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
        viewFlipper.setAutoStart(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.timkiem,menu);
        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            //nhap xong enter
            public boolean onQueryTextSubmit(String s) {
                getDaTaTimKiem(s);
                return true;
            }

            @Override
            //nhan xong tu ra
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });
        return true;
    }

    private  void bindView() {
         recyclerViewTK=findViewById(R.id.recyclerview_tk);
        ViewPager viewPager = findViewById(R.id.view_paper);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager());
        pageAdapter.add(ListFragment.newInstance(1),"Mới");
        pageAdapter.add(ListFragment.newInstance(2),"Phổ biến");
        pageAdapter.add(ListFragment.newInstance(3),"Ưa thích");
        viewPager.setAdapter(pageAdapter);
        //tablayout
        TabLayout tabLayout=findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        //slie quang cáo
        in = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
        out = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewfliper);
    }
    public void getDaTaTimKiem(String s){
        Api.getRetrofit().create(Api.API.class).getTimKiem(s).enqueue(new Callback<List<TimKiem>>() {
            @Override
            public void onResponse(Call<List<TimKiem>> call, Response<List<TimKiem>> response) {
                ArrayList<TimKiem> timKiemArrayList=(ArrayList<TimKiem>)response.body();
                if (timKiemArrayList.size()>0){
                    TimKiemAdapter timkiemAdapter=new TimKiemAdapter(MainActivity.this,timKiemArrayList);
                    GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,3,GridLayoutManager.VERTICAL,false);

                    recyclerViewTK.setLayoutManager(gridLayoutManager);
                    recyclerViewTK.setAdapter(timkiemAdapter);
                    //Nếu có dữ liệu recycleview sẽ hiển thị lên;
                    Toast.makeText(MainActivity.this, "Tìm thấy dữ liệu", Toast.LENGTH_SHORT).show();
                    recyclerViewTK.setVisibility(View.VISIBLE);
                }else{
                    recyclerViewTK.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<TimKiem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
