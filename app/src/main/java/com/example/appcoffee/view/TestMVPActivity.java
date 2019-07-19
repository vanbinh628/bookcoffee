package com.example.appcoffee.view;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.presenter.PresenterProduct;

public class TestMVPActivity extends BaseActivity {
    RecyclerView recyclerView;
    PresenterProduct productPresenter;
    @Override
    protected void init(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_home);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_home);

        productPresenter = new PresenterProduct(this,recyclerView,this);
        productPresenter.fetchDataProductsCoffee();
    }


}
