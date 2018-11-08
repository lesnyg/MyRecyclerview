package com.example.user.myrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    ArrayList<HashMap<String,Object>> arrayList = null;
    public RecyclerAdapter(ArrayList<HashMap<String,Object>> arrayList){
        this.arrayList = new ArrayList<HashMap<String,Object>>();
        this.arrayList = arrayList;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView itemImage;
        public TextView itemtitle,itemdetail;
        public MyViewHolder(View itemView){
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemtitle = (TextView)itemView.findViewById(R.id.item_title);
            itemdetail= (TextView)itemView.findViewById(R.id.item_detail);
        }}


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflate = LayoutInflater.from(viewGroup.getContext());
        View view = inflate.inflate(R.layout.item_cardlayout, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HashMap<String,Object> hashMap = arrayList.get(position);
        holder.itemtitle.setText((String)hashMap.get("title"));
        holder.itemImage.setImageResource((Integer) hashMap.get("image"));
        holder.itemdetail.setText((String)hashMap.get("detail"));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<HashMap<String,Object>> arrayList = new ArrayList<HashMap<String,Object>>();

        HashMap<String,Object> hashMap = null;
        hashMap = new HashMap<String,Object>();
        hashMap.put("title", "Chapter Two");
        hashMap.put("detail", "Item two details");
        hashMap.put("image", R.drawable.android_image_2);
        arrayList.add(hashMap);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
}











