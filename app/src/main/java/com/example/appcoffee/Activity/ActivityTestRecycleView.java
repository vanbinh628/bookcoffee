package com.example.appcoffee.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appcoffee.Adapter.AdapterDrinkDetail;
import com.example.appcoffee.Model.DrinkDetail;
import com.example.appcoffee.R;
import com.example.appcoffee.RecyclerViewMargin;

import java.util.ArrayList;

public class ActivityTestRecycleView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);
        getSupportActionBar().hide();

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

//        setSupportActionBar(toolbar);
//        toolbar.setSubtitle("ToolBar");
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_forward_black_24dp);
//        toolbar.setTitle("Hello");

//        assert getSupportActionBar() != null;   //null check
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.custom_toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        TextView tvTotal = (TextView)findViewById(R.id.total);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id._recycleview);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(ActivityTestRecycleView.this, 2);

        recyclerView.setLayoutManager(mGridLayoutManager);

        RecyclerViewMargin decoration = new RecyclerViewMargin(20, 2);
        recyclerView.addItemDecoration(decoration);

        ArrayList<DrinkDetail> arrayList = new ArrayList<>();
        arrayList.add(new DrinkDetail(R.drawable.coffee1,"Choco Frappe","Locally Roasted","10.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee2,"Choco Frappe","Locally Roasted","11.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee3,"Caramel Frappe","Decaf Colombia","12.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee3,"Kick Frappe","Decaf Colombia","13.00"));

        AdapterDrinkDetail adapter = new AdapterDrinkDetail(getApplicationContext(),arrayList);
        recyclerView.setAdapter(adapter);




    }
}
