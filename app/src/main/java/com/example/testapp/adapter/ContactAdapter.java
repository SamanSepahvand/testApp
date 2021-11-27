package com.example.testapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.fragment.ContactFragment;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {


    private ArrayList<ContactFragment.ContactModel> datas=new ArrayList<>();
    private Context mContext;

    Random r = new Random();
    int[] picList = new int[]{
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3,
            R.drawable.f4,

    };

    public ContactAdapter(ArrayList<ContactFragment.ContactModel> datas, Context mContext) {
        this.datas = datas;
        this.mContext = mContext;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=null;
        if (view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.item_contact,parent,false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    //    holder.txtItemTitle.setText(datas.get(position)+" ");


        holder.txtItemTitle.setText(datas.get(position).getTitle());

        holder.img1.setImageResource(datas.get(position).getRandImageResources());
        holder.img2.setImageResource(picList[r.nextInt(picList.length)]);
        holder.img4.setImageResource(picList[r.nextInt(picList.length)]);

        if (position%5==0){

            holder.moreImg.setVisibility(View.VISIBLE);
            holder.img4.setVisibility(View.GONE);

        }

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{


        private CircleImageView img1,img2,img3,img4;

        private  TextView moreImg;


        private TextView txtItemTitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            img1=itemView.findViewById(R.id.img1);
            img2=itemView.findViewById(R.id.img2);
            img4=itemView.findViewById(R.id.img4);



            moreImg=itemView.findViewById(R.id.txt_img_more);


            txtItemTitle=itemView.findViewById(R.id.title);


           // txtItemTitle=itemView.findViewById(R.id.item_txt_title);

        }
    }
}
