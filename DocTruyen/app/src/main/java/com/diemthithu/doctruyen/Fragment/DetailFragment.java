package com.diemthithu.doctruyen.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.diemthithu.doctruyen.Model.Truyen;
import com.diemthithu.doctruyen.R;
import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {
    //truyen dl
    //doc
    public static final String KEY_DETAIL="detail";
    //
    private static  final String KEY_ID="id_truyen";
    private static final String KEY_TENTRUYEN="tentruyen";
    private static final String KEY_TACGIA="tacgia";
    private static final String KEY_THELOAI="theloai";
    private static final String KEY_NOIDUNG="noidung";
    private static final String KEY_HINHANH="hinhanh";
    private static final String KEY_ANHBIA="anhbia";
    private static final String KEY_IDTT="trangthai";

    public  static DetailFragment newInstance(Truyen truyen){
        DetailFragment listFragment=new DetailFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(KEY_ID,truyen.getId_truyen());
        bundle.putString(KEY_TENTRUYEN,truyen.getTenTruyen());
        bundle.putString(KEY_TACGIA,truyen.getTacGia());
        bundle.putString(KEY_THELOAI, truyen.getTheLoai());
        bundle.putString(KEY_NOIDUNG, truyen.getNoiDung());
        bundle.putString(KEY_HINHANH,truyen.getHinhAnh());
        bundle.putString(KEY_ANHBIA,truyen.getAnhBia());
        bundle.putInt(KEY_IDTT,truyen.getId_trangthai());
        listFragment.setArguments(bundle);
        return  listFragment;
    }
    private Truyen truyen;
    @Override
    //lay dl
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int id_truyen=getArguments().getInt(KEY_ID);
        String tentruyen=getArguments().getString(KEY_TENTRUYEN);
        String tacgia=getArguments().getString(KEY_TACGIA);
        String theloai=getArguments().getString(KEY_THELOAI);
        String noidung=getArguments().getString(KEY_NOIDUNG);
        String hinhanh=getArguments().getString(KEY_HINHANH);
        String anhbia=getArguments().getString(KEY_ANHBIA);
        int trangthai=getArguments().getInt(KEY_IDTT);
       truyen=new Truyen(id_truyen,tentruyen,tacgia,theloai,noidung,hinhanh,anhbia,trangthai);
    }
    //dua dl len/hien textview
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= LayoutInflater.from(getContext()).inflate(R.layout.detail_fragment,container,false);
       TextView tv_tentruyen= view.findViewById(R.id.tv_tentruyen);
       TextView tv_tacgia= view.findViewById(R.id.tv_tacgia);
       TextView tv_theloai= view.findViewById(R.id.tv_theloai);
       TextView tv_noidung= view.findViewById(R.id.tv_noidung);
        ImageView img_truyen=view.findViewById(R.id.img_truyen);
        ImageView img_bia=view.findViewById(R.id.img_bia);
        //truyen anh
        Picasso.with(getContext()).load(truyen.getHinhAnh()).into(img_truyen);
        Picasso.with(getContext()).load(truyen.getAnhBia()).into(img_bia);
        //click nút share
        ImageView share=view.findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        tv_tentruyen.setText(truyen.getTenTruyen());
        tv_tacgia.setText(truyen.getTacGia());
        tv_theloai.setText(truyen.getTheLoai());
        tv_noidung.setText(truyen.getNoiDung());
        return view;
    }
}