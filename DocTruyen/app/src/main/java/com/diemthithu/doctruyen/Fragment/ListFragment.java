package com.diemthithu.doctruyen.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.diemthithu.doctruyen.Model.Response_truyen;
import com.diemthithu.doctruyen.Model.Truyen;
import com.diemthithu.doctruyen.Adapter.TruyenAdapter;
import com.diemthithu.doctruyen.Server.Api;
import com.diemthithu.doctruyen.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment {
//truyen dl theo id TT
    public static ListFragment newInstance(int id) {
        ListFragment listFragment = new ListFragment();
        Bundle bundle = new Bundle();
        //
        bundle.putInt("id", id);
        listFragment.setArguments(bundle);
        return listFragment;
    }

    //tao adapter và list:activity viet dau
    private TruyenAdapter truyenAdapter;
    private List<Truyen> truyenList = new ArrayList<>();
    private int idTT ;

    @Override
    //lay dl
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        idTT = getArguments().getInt("id");
    }

    //dua dl len/hien textview
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_fragment, container, false);
        //Recycler-neu lm recycler k thi viet trong oncreate mainacti
        RecyclerView rc_truyen = view.findViewById(R.id.recyclerview_truyen);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3,GridLayoutManager.VERTICAL,false);
        // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        truyenAdapter = new TruyenAdapter(getContext(), truyenList);
        rc_truyen.setLayoutManager(gridLayoutManager);
        rc_truyen.setAdapter(truyenAdapter);
        //
        loadData();
//kiem tra xem man hinh la ngang k
        boolean land = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (land) {
            truyenAdapter.check(0);
        }
        return view;
    }
    //load dl từ csdl về
    private void loadData() {
        Api.getRetrofit().create(Api.API.class).getList("nty",idTT)
                .enqueue(new Callback<Response_truyen>() {
                    @Override
                    public void onResponse(Call<Response_truyen> call, Response<Response_truyen> response) {
                        if (response.isSuccessful()) {
                            truyenList.clear();
                            truyenList.addAll(response.body().getTruyenList());
                            truyenAdapter.notifyDataSetChanged();

                        } else {
                            Log.e("Error 1", response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<Response_truyen> call, Throwable t) {
                        Log.e("Error 2", t.getMessage());
                        t.printStackTrace();
                    }
                });
    }
}
