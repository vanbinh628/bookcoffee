package com.example.appcoffee.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appcoffee.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityVBottomMenu extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_menu);
        getSupportActionBar().hide();

        BottomNavigationView navigationView = (BottomNavigationView)findViewById(R.id.tab_bottom_navigation_menu);
    }

}
