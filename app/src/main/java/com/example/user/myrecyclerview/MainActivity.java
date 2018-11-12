package com.example.user.myrecyclerview;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    MyDBOpenHelper dbHelper;
    SQLiteDatabase mdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDBOpenHelper(this);
        mdb = dbHelper.getWritableDatabase();
        adapter = new RecyclerAdapter(mdb);

        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "Chapter One");
        hashMap.put("detail", "Item One details");
        hashMap.put("image", R.drawable.android_image_1);
        arrayList.add(hashMap);

        hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "Chapter Two");
        hashMap.put("detail", "Item two details");
        hashMap.put("image", R.drawable.android_image_2);
        arrayList.add(hashMap);

        hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "Chapter Three");
        hashMap.put("detail", "Item Three details");
        hashMap.put("image", R.drawable.android_image_3);
        arrayList.add(hashMap);

        hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "Chapter Four");
        hashMap.put("detail", "Item Four details");
        hashMap.put("image", R.drawable.android_image_4);
        arrayList.add(hashMap);

        hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "Chapter Five");
        hashMap.put("detail", "Item Five details");
        hashMap.put("image", R.drawable.android_image_5);
        arrayList.add(hashMap);

        hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "Chapter Six");
        hashMap.put("detail", "Item Six details");
        hashMap.put("image", R.drawable.android_image_6);
        arrayList.add(hashMap);

        hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "Chapter Seven");
        hashMap.put("detail", "Item Seven details");
        hashMap.put("image", R.drawable.android_image_7);
        arrayList.add(hashMap);

        hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "Chapter Eight");
        hashMap.put("detail", "Item Eight details");
        hashMap.put("image", R.drawable.android_image_8);
        arrayList.add(hashMap);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        }
}

