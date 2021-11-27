package com.example.testapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;

import java.util.ArrayList;

public class FileAdapter  extends RecyclerView.Adapter<FileAdapter.ViewHolder> {


    private ArrayList<String> datas=new ArrayList<>();
    private Context mContext;


    public FileAdapter(ArrayList<String> datas, Context mContext) {
        this.datas = datas;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=null;
        if (view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.item_file,parent,false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtItemTitle.setText(datas.get(position)+" ");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{


        private TextView txtItemTitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtItemTitle=itemView.findViewById(R.id.item_txt_title);

        }
    }
}
