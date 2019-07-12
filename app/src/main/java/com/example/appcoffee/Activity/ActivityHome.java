package com.example.appcoffee.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.appcoffee.Fragment.FragmentOrder;
import com.example.appcoffee.Fragment.FragmentHome;
import com.example.appcoffee.Fragment.FragmentRecycleViewDrink;
import com.example.appcoffee.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class ActivityHome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        getSupportActionBar().hide();

        Fragment fragment;
        fragment = new FragmentRecycleViewDrink();
        loadFragment(fragment);


        BottomNavigationView navigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment;
                switch (tab.getPosition()){
                    case 0:
                        fragment = new FragmentRecycleViewDrink();
                        loadFragment(fragment);
                        return;
                    case 1:
                        fragment = new FragmentOrder();
                        loadFragment(fragment);
                        return;
                    case 2:
                        return;


                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

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
                    fragment = new FragmentHome();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}