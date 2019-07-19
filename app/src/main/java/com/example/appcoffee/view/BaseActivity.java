package com.example.appcoffee.view;

import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appcoffee.utils.NetworkUtils;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {
    protected ProgressBar mProgressBar;
    protected ImageView backNavigation;

    private ProgressDialog progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        init(savedInstanceState);
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("Loading ...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
    }

    protected abstract void init(Bundle savedInstanceState);

    @Override
    public void showLoading() {
        if(progressBar != null) {
            progressBar.show();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void hideLoading() {
        if(progressBar != null) {
            progressBar.dismiss();
        }

    }



}
