package com.example.user.myrecyclerview;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    ArrayList<HashMap<String, Object>> arrayList = null;
    private SQLiteDatabase mdb;
    //    public RecyclerAdapter(ArrayList<HashMap<String, Object>> arrayList) {
//        this.arrayList = new ArrayList<HashMap<String, Object>>();
//        this.arrayList = arrayList;
//    }

    public RecyclerAdapter(SQLiteDatabase db){
        this.mdb = db;
        String query = new StringBuilder().append("select*from shop").toString();
        Cursor cursor = mdb.rawQuery(query,null);
        ArrayList<HashMap<String,Object>> arrayListTemp = new ArrayList<>();
        HashMap<String,Object> hashMap = null;
        while(cursor.moveToNext()){
            int[] image = {R.drawable.android_image_1,R.drawable.android_image_2,R.drawable.android_image_3,R.drawable.android_image_4,
                    R.drawable.android_image_5,R.drawable.android_image_6,R.drawable.android_image_7,R.drawable.android_image_8,};
            for(int i=0;i<8;i++){
                hashMap = new HashMap<String,Object>();
                hashMap.put("itemtitle",cursor.getString(0));
                hashMap.put("itemdetail",cursor.getString(0));
                hashMap.put("itemimage",image[i]);
                arrayListTemp.add(hashMap);
        }}
        this.arrayList = arrayListTemp;
    }
    public  void addItem(int position,HashMap<String,Object> hashMap){
        this.arrayList.add(hashMap);
        notifyItemInserted(position);
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


            }
        });


        holder.itemdetail.setText((String) hashMap.get("detail"));

        holder.itemdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //             Toast.makeText(v.getContext(),holder.itemdetail.getText().toString(),Toast.LENGTH_SHORT).show();
                Integer count = Integer.parseInt(((TextView)holder.itemtitle).getText().toString())+1;
                ((TextView)holder.itemtitle).setText(count.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemImage;
        public TextView itemtitle, itemdetail;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            itemtitle = (TextView) itemView.findViewById(R.id.item_title);
            itemdetail = (TextView) itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    removeItem(position);
                    Log.e("ViewHolder Click",position+","+getItemId());
                }
            });
              }
    }
    public void removeItem(int position){
        this.arrayList.remove(position);
        notifyDataSetChanged();
    }

}


