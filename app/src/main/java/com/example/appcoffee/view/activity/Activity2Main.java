package com.example.appcoffee.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.appcoffee.R;
import com.example.appcoffee.view.fragment.FragmentHome;

public class Activity2Main extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bottom_menu);
        getSupportActionBar().hide();

        FragmentHome fmHome = new FragmentHome();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fm_bottom_menu,fmHome);
        transaction.addToBackStack(null);
        transaction.commit();



    }
}
