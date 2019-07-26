package com.example.appcoffee.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.StringEvent;
import com.example.appcoffee.adapter.AdapterConfigMultiple;
import com.example.appcoffee.adapter.AdapterConfigSingle;
import com.example.appcoffee.base.BaseActivity;
import com.example.appcoffee.model.AddOn;
import com.example.appcoffee.model.Config;
import com.example.appcoffee.model.Product;
import com.example.appcoffee.presenter.FetchDataCallback;
import com.example.appcoffee.presenter.PresenterProduct2;

import java.util.ArrayList;
import java.util.List;

public class ActivityOrderDetail extends BaseActivity implements View.OnClickListener {
    public PresenterProduct2 presenterProduct;
    TextView tvNameConfig1, tvNameConfig2, tvNameConfig3, tvNameConfig4;
    RecyclerView recycler1, recycler2, recycler3, recycler4;

    LinearLayout layout;
    Button btnAdd;
    ImageButton iBtnAdd,iBtnSub;
    TextView tvQuantity;
    private int quantity = 1;

    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void init(Bundle savedInstanceState) {
//        setContentView(R.layout.activity_order_detail);
        setContentView(R.layout.activity_order_detail_tam);
        layout = findViewById(R.id.linear);
        btnAdd = findViewById(R.id.btn_add);
        iBtnAdd = findViewById(R.id.ibtn_add);
        iBtnSub = findViewById(R.id.ibtn_sub);
        tvQuantity = findViewById(R.id.tv_quantity);

        iBtnSub.setOnClickListener(this);
        iBtnAdd.setOnClickListener(this);


        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        final Product product = (Product) intent.getSerializableExtra(StringEvent.SEND_PRODUCT);
        Log.d("InRaProduct", product.getName());

        ShowAddOnOfProduct(product.getAddOn());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), product.toString(), Toast.LENGTH_SHORT).show();
                setResultProduct(product);

            }
        });


    }
    private void setTextForTextViewQuantity(int mQuantity){
        tvQuantity.setText(String.valueOf(mQuantity));
    }
    private void setResultProduct(Product product){
        Intent intent = new Intent();

        Bundle bundle = new Bundle();

        bundle.putInt(StringEvent.RESULT_QUANTITY, quantity);
        bundle.putSerializable(StringEvent.RESULT_PRODUCT, product);


        intent.putExtras(bundle);
//        intent.putExtra(StringEvent.RESULT_QUANTITY,quantity);
//        intent.putExtra(StringEvent.RESULT_PRODUCT,product);
        setResult(StringEvent.RESULT_OK,intent);
        finish();

    }
    public String toStringFromArray(List<AddOn> addOnList){
        String mString = "[";
        for(int i =0; i< addOnList.size(); i++){
            mString += addOnList.get(i).toString()+", ";
        }
        mString += "]";
        return mString;

    }

    @SuppressLint("WrongConstant")
    public void ShowAddOnOfProduct(List<AddOn> addOnList) {
        hideLoading();

        TextView tv;
        RecyclerView recycler;



        float d = this.getResources().getDisplayMetrics().density;

        RecyclerView.LayoutParams param = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, (int)(30*d));

        List<RecyclerView> recyclerList = new ArrayList<>();

        for (int i = 0; i < addOnList.size(); i++) {
            tv = new TextView(this);
            tv.setText(addOnList.get(i).getName());
            tv.setTextSize(15);
            Typeface face = ResourcesCompat.getFont(this, R.font.opensans_semibold);
            tv.setTypeface(face);
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setPadding((int)(12*d),0,(int)(12*d),0);
            tv.setBackgroundColor(ContextCompat.getColor(this, R.color.white88));
            tv.setLayoutParams(param);
            layout.addView(tv);


            recycler = new RecyclerView(this);;

            recycler.setHasFixedSize(false);
            layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recycler.setLayoutManager(layoutManager);
            List<Config> configs1 = addOnList.get(i).getConfigs();

            if( addOnList.get(i).getMultiple() == null || addOnList.get(i).getMultiple() == false) {
                AdapterConfigSingle adapter = new AdapterConfigSingle(this, configs1);
                recycler.setAdapter(adapter);
                layout.addView(recycler);
                recyclerList.add(recycler);
            }else {
                AdapterConfigMultiple adapter = new AdapterConfigMultiple(this, configs1);
                recycler.setAdapter(adapter);
                layout.addView(recycler);
                recyclerList.add(recycler);
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.ibtn_add):
                quantity ++;
                setTextForTextViewQuantity(quantity);
                return;

            case R.id.ibtn_sub:
                if(quantity >= 2) {
                    quantity--;
                    setTextForTextViewQuantity(quantity);
                }
                return;
        }
    }
}
