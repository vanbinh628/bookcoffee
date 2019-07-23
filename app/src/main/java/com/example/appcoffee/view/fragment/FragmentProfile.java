package com.example.appcoffee.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appcoffee.R;
import com.example.appcoffee.base.BaseFragment;
import com.example.appcoffee.model.User;
import com.example.appcoffee.presenter.FetchDataUserCallback;
import com.example.appcoffee.presenter.PresenterUserProfile;

public class FragmentProfile extends BaseFragment implements FetchDataUserCallback {
    TextView tvPhone;
    PresenterUserProfile presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tvPhone = view.findViewById(R.id.tv_phone_profile);
        presenter = new PresenterUserProfile(getContext(),this);
        presenter.FetchData();

        return view;
    }

    @Override
    public void OnFetchSuccess(User user) {
        tvPhone.setText(user.getPhoneNumber());
    }

    @Override
    public void OnFetchFault(Exception e) {

    }
}
