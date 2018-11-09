package com.example.user.myrecyclerview;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    class MyViewHolder extends ViewHolder {
        public ImageView itemImage;
        public TextView itemtitle, itemdetail;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            itemtitle = (TextView) itemView.findViewById(R.id.item_title);
            itemdetail = (TextView) itemView.findViewById(R.id.item_detail);
        }
    }


    ArrayList<HashMap<String, Object>> arrayList = null;
    public RecyclerAdapter(ArrayList<HashMap<String, Object>> arrayList) {
        this.arrayList = new ArrayList<HashMap<String, Object>>();
        this.arrayList = arrayList;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.item_cardlayout, parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        HashMap<String, Object> hashMap = arrayList.get(position);

        holder.itemImage.setImageResource((Integer) hashMap.get("image"));
        holder.itemtitle.setText("0");
        holder.itemImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Integer count = Integer.parseInt(((TextView)holder.itemtitle).getText().toString())+1;
                ((TextView)holder.itemtitle).setText(count.toString());
            }
        });


        holder.itemdetail.setText((String) hashMap.get("detail"));

        holder.itemdetail.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              Toast.makeText(v.getContext(),holder.itemdetail.getText().toString(),Toast.LENGTH_SHORT).show();

            }
       });


    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}


