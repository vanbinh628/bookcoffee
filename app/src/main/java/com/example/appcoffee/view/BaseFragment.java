package com.example.appcoffee.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appcoffee.utils.DialogUtils;

public class BaseFragment extends Fragment implements MvpView {
    protected Dialog progressDialog;
    private ProgressDialog progressBar;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showLoading() {
        progressBar = new ProgressDialog(getContext());
        progressBar.setCancelable(true);
        progressBar.setMessage("Loading ...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
    }

    @Override
    public void hideLoading() {
        if (progressBar != null && progressBar.isShowing())
            progressBar.dismiss();
    }
}
