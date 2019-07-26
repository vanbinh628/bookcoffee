package com.example.appcoffee.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.StringEvent;
import com.example.appcoffee.adapter.AdapterUserCart;
import com.example.appcoffee.base.BaseActivity;
import com.example.appcoffee.model.ProductOrder;
import com.example.appcoffee.model.Store;
import com.example.appcoffee.presenter.FetchDataListStore;
import com.example.appcoffee.presenter.PresenterOrderItems;
import com.example.appcoffee.presenter.PresenterStore;
import com.example.appcoffee.view.HandleOrderItems;
import com.example.appcoffee.view.HandleUserCart;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ActivityOrderConfirm extends BaseActivity implements FetchDataListStore, HandleOrderItems {
    TextView tvName,tvAddress, tvTotal;
    PresenterStore presenter;
    ImageView imageStore;

    PresenterOrderItems mPresenterOrderItems;

    RecyclerView recyclerView;
    @Override
    protected void init(Bundle savedInstanceState) {
        setContentView(R.layout.activity_order_confirm);

        View view = findViewById(R.id.toolbar_order_confirm);
        TextView textView = view.findViewById(R.id.title_toolbar);
        textView.setText("OrderConfirm");
        recyclerView = findViewById(R.id.recycler_order_confirm);
        tvTotal = findViewById(R.id.tv_total_order_confirm);
        tvName = findViewById(R.id.tv_name_order_confirm1);
        tvAddress = findViewById(R.id.tv_address_order_confirm1);
        imageStore = findViewById(R.id.image_store_order_confirm);

        presenter = new PresenterStore(this,this);
        presenter.FetchData();
        showLoading();

        Intent intent = getIntent();
        List<ProductOrder> listProduct = (List<ProductOrder>)intent.getSerializableExtra(StringEvent.SEND_LIST_ORDER_ITEMS);

        mPresenterOrderItems = new PresenterOrderItems(this, listProduct, this);
        recyclerView.setHasFixedSize(true);
        @SuppressLint("WrongConstant") LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration decoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(decoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mPresenterOrderItems.getAdapterUserCart());

        mPresenterOrderItems.calculatorTotal();



//        recyclerView.setHasFixedSize(true);
//        @SuppressLint("WrongConstant") LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//
//        AdapterUserCart mAdapterUserCart = new AdapterUserCart(this,listProduct);
//        recyclerView.setAdapter(mAdapterUserCart);


        backNavigation = view.findViewById(R.id.navigation_toolbar);
        backNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSupportNavigateUp();
            }
        });
    }

    @Override
    public void OnFetchSuccess(List<Store> storeList) {
            getStore(storeList.get(0));



            hideLoading();
    }

    @Override
    public void getStore(Store store) {
        tvAddress.setText(store.getAddress());
        tvName.setText(store.getName());

        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this));
        builder.build().load(store.getImg_url())
                .error(R.drawable.no_image)
                .into(imageStore);
        hideLoading();
    }

    @Override
    public void OnFetchFailure(Exception e) {
        hideLoading();
    }


    @Override
    public void updateQuantity() {

    }

    @Override
    public void updateTotal(long total) {
        tvTotal.setText(String.valueOf(total));
    }

    @Override
    public void deleteAllItems() {

    }
}
