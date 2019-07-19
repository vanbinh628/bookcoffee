package com.example.appcoffee.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appcoffee.R;
import com.example.appcoffee.model.Store;
import com.example.appcoffee.presenter.FetchDataListStore;
import com.example.appcoffee.presenter.PresenterStore;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ActivityOrderConfirm extends BaseActivity implements FetchDataListStore {
    TextView tvName,tvAddress;
    PresenterStore presenter;
    ImageView imageStore;
    @Override
    protected void init(Bundle savedInstanceState) {
        setContentView(R.layout.activity_order_confirm);

        View view = findViewById(R.id.toolbar_order_confirm);
        TextView textView = view.findViewById(R.id.title_toolbar);
        textView.setText("OrderConfirm");

        tvName = findViewById(R.id.tv_name_order_confirm1);
        tvAddress = findViewById(R.id.tv_address_order_confirm1);
        imageStore = findViewById(R.id.image_store_order_confirm);

        presenter = new PresenterStore(this,this);
        presenter.FetchData();
        showLoading();

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
                .error(R.drawable.ic_launcher_foreground)
                .into(imageStore);
        hideLoading();
    }

    @Override
    public void OnFetchFailure(Exception e) {
        hideLoading();
    }
}
