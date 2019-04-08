package com.diemthithu.doctruyen.Adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.diemthithu.doctruyen.Model.Truyen;
import com.diemthithu.doctruyen.Activity.DetailActivity;
import com.diemthithu.doctruyen.Fragment.DetailFragment;
import com.diemthithu.doctruyen.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TruyenAdapter extends RecyclerView.Adapter<TruyenAdapter.ViewHolder> {
    //b5:
    private Context context;
    private List<Truyen> truyenList;

    public TruyenAdapter(Context context, List<Truyen> truyenList) {
        this.context = context;
        this.truyenList = truyenList;
    }

    @NonNull
    @Override
    //b4:viet de phuong thuc
    //khoi tao viewholder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int typeView) {
        //b6
        View view=LayoutInflater.from(context).inflate(R.layout.item_truyen,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    //truyen dl
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        //b7
        Truyen truyen=truyenList.get(position);
        viewHolder.tv_tentruyen.setText(truyen.getTenTruyen());
        Picasso.with(context).load(truyen.getHinhAnh()).into(viewHolder.img_truyen);
    }

    public int getItemCount() {
        return truyenList.size();
    }
    //note...
    public void check(int i) {
    }

    //b1: viewholder :alt insert ->constructer
    public class ViewHolder extends RecyclerView.ViewHolder {
        //b3:khai bao
        TextView tv_tentruyen;
        ImageView img_truyen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //b4:anh xa
            tv_tentruyen = itemView.findViewById(R.id.tv_tentruyen);
            img_truyen=itemView.findViewById(R.id.img_truyen);
            //bat su kien
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    check(getAdapterPosition());
                }
            });
        }
        public void check(int position) {
            //chuyen dl sang man hinh ngang
            Truyen truyen = truyenList.get(position);
            boolean land = context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
            if (land) {
                FragmentTransaction ft = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.layoutfragdetail, DetailFragment.newInstance(truyen));
                ft.commit();
            }
            //  //chuyen dl sang man hinh doc,chuyen man hinh
            else{
                DetailActivity.showdetail(context,truyen);
            }


        }
    }
}
