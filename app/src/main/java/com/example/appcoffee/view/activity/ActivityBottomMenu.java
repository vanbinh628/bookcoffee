package com.example.appcoffee.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.appcoffee.R;
import com.example.appcoffee.StringEvent;
import com.example.appcoffee.model.Product;
import com.example.appcoffee.presenter.PresenterCartUser;
import com.example.appcoffee.view.HandleUserCart;
import com.example.appcoffee.view.fragment.FragmentHome;
import com.example.appcoffee.view.fragment.FragmentOrderHistory;
import com.example.appcoffee.view.fragment.FragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.List;

public class ActivityBottomMenu extends AppCompatActivity implements HandleUserCart {
    private LinearLayout linearUserCart;
    private TextView tvPriceTotal, tvViewCart;
    private PresenterCartUser mPresenterCartUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_menu);
        getSupportActionBar().hide();

        linearUserCart = findViewById(R.id.liner_user_cart);
        tvPriceTotal = findViewById(R.id.tv_price_total);
        tvViewCart = findViewById(R.id.tv_view_card);

        mPresenterCartUser = new PresenterCartUser(this, this);
        mPresenterCartUser.isEmptyUserCard();
        BottomNavigationView navigationView = (BottomNavigationView)findViewById(R.id.tab_bottom_navigation_menu);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigationView.setSelectedItemId(R.id.navigation_home);

        tvViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityBottomMenu.this, ActivityOrderConfirm.class);
                intent.putExtra(StringEvent.SEND_LIST_ORDER_ITEMS, (Serializable)mPresenterCartUser.getListProductOrder());
                startActivity(intent);
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
                    mPresenterCartUser.isEmptyUserCard();
                    return true;
                case R.id.navigation_history:
                    fragment = new FragmentOrderHistory();
                    loadFragment(fragment);
                    HideUserCart();
                    return true;
                case R.id.navigation_user:
                    fragment = new FragmentProfile();
                    loadFragment(fragment);
                    HideUserCart();
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
    public void SendProduct(Product product){
        Log.d("InRa",product.getName());
        Intent intent = new Intent(ActivityBottomMenu.this, ActivityOrderDetail.class);
        intent.putExtra(StringEvent.SEND_PRODUCT, product);
        startActivityForResult(intent,StringEvent.REQUEST_CODE );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == StringEvent.REQUEST_CODE){
            if(resultCode == StringEvent.RESULT_OK){
                Bundle bundle = data.getExtras();
                Product product = (Product)bundle.getSerializable(StringEvent.RESULT_PRODUCT);
                int quantity = bundle.getInt(StringEvent.RESULT_QUANTITY);
                Log.d("InRaNhan", String.valueOf(quantity));
                Log.d("InRaNhan", product.getName());
                if(quantity >= 0 && product != null){
                    mPresenterCartUser.addProductToUserCart(product, quantity);
                    mPresenterCartUser.totalUserCart();
                }
                else {
                    Log.d("Error","Error Add product");
                }
//                Product product = (Product)data.getSerializableExtra(StringEvent.RESULT_PRODUCT);
//                int quantity = (int)data.getIntExtra(StringEvent.RESULT_QUANTITY,0);
            }
        }
    }

    @Override
    public void HideUserCart() {
        linearUserCart.setVisibility(View.GONE);
    }

    @Override
    public void ShowUserCart() {
        linearUserCart.setVisibility(View.VISIBLE);
    }

    @Override
    public void TotalUserCard(Long total) {
        ShowUserCart();
        tvPriceTotal.setText(String.valueOf(total));
    }
}