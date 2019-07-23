package com.example.appcoffee.view.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.adapter.AdapterConfigSingle;
import com.example.appcoffee.base.BaseActivity;
import com.example.appcoffee.model.AddOn;
import com.example.appcoffee.model.Config;
import com.example.appcoffee.model.Product;
import com.example.appcoffee.presenter.FetchDataCallback;
import com.example.appcoffee.presenter.PresenterProduct2;

import java.util.ArrayList;
import java.util.List;

public class ActivityOrderDetail extends BaseActivity implements FetchDataCallback {
    public PresenterProduct2 presenterProduct;
    TextView tvNameConfig1, tvNameConfig2, tvNameConfig3, tvNameConfig4;
    RecyclerView recycler1, recycler2, recycler3, recycler4;

    LinearLayout layout;
    Button btnAdd;

    List<AddOn> addOnList;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void init(Bundle savedInstanceState) {
//        setContentView(R.layout.activity_order_detail);
        setContentView(R.layout.activity_order_detail_tam);
        layout = findViewById(R.id.linear);
        btnAdd = findViewById(R.id.btn_add);
//        tvNameConfig1 = findViewById(R.id.tv_name_config_1);
//        tvNameConfig2 = findViewById(R.id.tv_name_config_2);
//        tvNameConfig3 = findViewById(R.id.tv_name_config_3);
//        tvNameConfig4 = findViewById(R.id.tv_name_config_4);
//
//        recycler1 = findViewById(R.id.recycler_config_1);
//        recycler2 = findViewById(R.id.recycler_config_2);
//        recycler3 = findViewById(R.id.recycler_config_3);
//        recycler4 = findViewById(R.id.recycler_config_4);

        presenterProduct = new PresenterProduct2(this, this);
        presenterProduct.FetchData();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),toStringFromAraay(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    public String toStringFromAraay(){
        String mString = "[";
        for(int i =0; i< addOnList.size(); i++){
            mString += addOnList.get(i).toString()+", ";
        }
        mString += "]";
        return mString;

    }

    @SuppressLint("WrongConstant")
    @Override
    public void OnFetchSuccess(List<Product> productList) {
        addOnList = productList.get(0).getAddOn();
        hideLoading();

        TextView tv;
        RecyclerView recycler;

        RecyclerView.LayoutParams param = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);

        List<RecyclerView> recyclerList = new ArrayList<>();
        List<AdapterConfigSingle> adapterList = new ArrayList<>();

        for (int i = 0; i < addOnList.size(); i++) {
            tv = new TextView(this);
            tv.setText(addOnList.get(i).getName());
            tv.setTextSize(15);
            tv.setPadding(30,0,30,0);
            tv.setBackgroundColor(ContextCompat.getColor(this, R.color.white88));
            layout.addView(tv);

            recycler = new RecyclerView(this);
            recycler.setLayoutParams(param);

            recycler.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recycler.setLayoutManager(layoutManager);
            List<Config> configs1 = addOnList.get(i).getConfigs();
            AdapterConfigSingle adapter = new AdapterConfigSingle(this, configs1);
            recycler.setAdapter(adapter);

            layout.addView(recycler);
            recyclerList.add(recycler);
            adapterList.add(adapter);

        }



    }

    @Override
    public void OnFetchFault(Exception e) {
        hideLoading();
    }

}
