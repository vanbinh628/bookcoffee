package com.example.appcoffee.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.appcoffee.Fragment.FragmentOrder;
import com.example.appcoffee.Fragment.FragmentHome;
import com.example.appcoffee.Fragment.FragmentProfile;
import com.example.appcoffee.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityBottomMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_menu);
        getSupportActionBar().hide();

        BottomNavigationView navigationView = (BottomNavigationView)findViewById(R.id.tab_bottom_navigation_menu);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigationView.setSelectedItemId(R.id.navigation_home);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new FragmentHome();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_history:
                    fragment = new FragmentOrder();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_user:
                    fragment = new FragmentProfile();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fm_bottom_menu,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}