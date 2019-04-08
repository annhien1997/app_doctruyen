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

import com.diemthithu.doctruyen.Model.TimKiem;
import com.diemthithu.doctruyen.Model.Truyen;
import com.diemthithu.doctruyen.Activity.DetailActivity;
import com.diemthithu.doctruyen.Fragment.DetailFragment;
import com.diemthithu.doctruyen.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TimKiemAdapter extends RecyclerView.Adapter<TimKiemAdapter.ViewHolder> {
    //b5:
    private Context context;
    private List<TimKiem> timKiemList;

    public TimKiemAdapter(Context context, List<TimKiem> timKiemList) {
        this.context = context;
        this.timKiemList = timKiemList;
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
        TimKiem timKiem=timKiemList.get(position);
        viewHolder.tv_tentruyen.setText(timKiem.getTenTruyen());
        Picasso.with(context).load(timKiem.getHinhAnh()).into(viewHolder.img_truyen);
    }

    public int getItemCount() {
        return timKiemList.size();
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
        }
    }
}
