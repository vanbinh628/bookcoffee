package com.example.appcoffee.view;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcoffee.R;
import com.example.appcoffee.base.BaseActivity;
import com.example.appcoffee.model.User;
import com.example.appcoffee.presenter.FetchDataUserCallback;
import com.example.appcoffee.presenter.PresenterUserProfile;

public class ActivityUserProfile extends BaseActivity implements FetchDataUserCallback {
    TextView tvName;
    PresenterUserProfile userProfilePresenter;


    @Override
    protected void init(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_profile);
        tvName = findViewById(R.id.tv_name_profile);

        userProfilePresenter = new PresenterUserProfile(this,this);
            userProfilePresenter.FetchData();
            showLoading();


    }


    @Override
    public void OnFetchSuccess(User user) {
        tvName.setText(user.getPhoneNumber());
        hideLoading();
    }

    @Override
    public void OnFetchFault(Exception e) {
        Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        hideLoading();
    }

}
