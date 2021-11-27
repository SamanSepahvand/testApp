package com.example.testapp.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.fragment.HomeFragment;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {


    private ArrayList<HomeFragment.HomeModel> datas=new ArrayList<>();
    private Context mContext;


    public HomeAdapter(ArrayList<HomeFragment.HomeModel> datas, Context mContext) {
        this.datas = datas;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=null;
        if (view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.item_home,parent,false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.imgDrawable.setImageResource(datas.get(position).getDrawable());


        holder.txtItemTitle.setText(datas.get(position).getTitle()+" ");


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{


        private TextView txtItemTitle;
        private ImageView imgDrawable;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            imgDrawable=itemView.findViewById(R.id.item_img_drawable);
            txtItemTitle=itemView.findViewById(R.id.item_txt_title);

        }
    }
}
