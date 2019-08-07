package com.example.appcoffee.view.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appcoffee.R;
import com.example.appcoffee.StringEvent;
import com.example.appcoffee.base.BaseActivity;
import com.example.appcoffee.model.ProductOrder;
import com.example.appcoffee.model.Store;
import com.example.appcoffee.presenter.FetchDataListStore;
import com.example.appcoffee.presenter.PresenterOrderItems;
import com.example.appcoffee.presenter.PresenterStore;
import com.example.appcoffee.presenter.PresenterStoreItem;
import com.example.appcoffee.view.HandleOrderItems;
import com.example.appcoffee.view.HandleStore;
import com.example.appcoffee.view.HandleUserCart;
import com.example.appcoffee.view.RecyclerViewClickListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ActivityOrderConfirm extends BaseActivity implements HandleOrderItems, HandleStore, View.OnClickListener {
    TextView tvName,tvAddress, tvTotal, tvDelete, tvTime, tvEditTime, tvSeeMore;
    PresenterStoreItem presenter;
    ImageView imageStore;
    TextView tvQuantityDialog, tvProductDialog, btnCancelDialog, btnUpdateDialog;
    ImageButton iBtnSubDialog, iBtnAddDialog;
    BottomSheetDialog bottomSheetDialog;
    int quantityDialog;

    RecyclerView recyclerDialogChangeStore;
    List<Store> mListStore;

    PresenterOrderItems mPresenterOrderItems;

    RecyclerView recyclerView;
    Dialog dialogUpdate;
    @Override
    protected void init(Bundle savedInstanceState) {
        setContentView(R.layout.activity_order_confirm);

        initOrderConfim();
        initDialogUpdate();

        imageStore.getLayoutParams().height = (int)(getResources().getDisplayMetrics().widthPixels*0.3);
        presenter = new PresenterStoreItem(this,this, this);
        presenter.FetchData();
        showLoading();

        initBottomSheetDialog();


        Intent intent = getIntent();
        List<ProductOrder> listProduct = (List<ProductOrder>)intent.getSerializableExtra(StringEvent.SEND_LIST_ORDER_ITEMS);

        mPresenterOrderItems = new PresenterOrderItems(this, listProduct, this);
        recyclerView.setHasFixedSize(true);
        @SuppressLint("WrongConstant") LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration decoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(decoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mPresenterOrderItems.getAdapterUserCart());

        mPresenterOrderItems.calculatorTotal();

//        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,700,getResources().getDisplayMetrics());

        tvDelete.setOnClickListener(this);
        tvEditTime.setOnClickListener(this);
        backNavigation.setOnClickListener(this);
        tvSeeMore.setOnClickListener(this);
    }

    public void initOrderConfim(){
        View view = findViewById(R.id.toolbar_order_confirm);
        TextView textView = view.findViewById(R.id.title_toolbar);
        textView.setText("OrderConfirm");
        recyclerView = findViewById(R.id.recycler_order_confirm);
        tvTotal = findViewById(R.id.tv_total_order_confirm);
        tvName = findViewById(R.id.tv_name_order_confirm1);
        tvAddress = findViewById(R.id.tv_address_order_confirm1);
        imageStore = findViewById(R.id.image_store_order_confirm);
        tvDelete = findViewById(R.id.tv_delete_order_confirm);
        tvTime = findViewById(R.id.tv_time_order_confirm);
        tvEditTime = findViewById(R.id.tv_edit_time_order_confirm);
        tvSeeMore = findViewById(R.id.tv_see_more);
        backNavigation = view.findViewById(R.id.navigation_toolbar);

    }

    public void initBottomSheetDialog(){
        bottomSheetDialog = new BottomSheetDialog(ActivityOrderConfirm.this);
        View sheetView = getLayoutInflater().inflate(R.layout.dialog_change_store, null, false);
        bottomSheetDialog.setContentView(sheetView);
        recyclerDialogChangeStore = sheetView.findViewById(R.id.recycler_list_store);
        recyclerDialogChangeStore.setHasFixedSize(true);

        @SuppressLint("WrongConstant") LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration decoration1 = new DividerItemDecoration(this, layoutManager1.getOrientation());
        recyclerDialogChangeStore.addItemDecoration(decoration1);
        recyclerDialogChangeStore.setLayoutManager(layoutManager1);
        recyclerDialogChangeStore.setAdapter(presenter.getAdapter());
    }

    @Override
    public void updateQuantity(int position, int quantity) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(StringEvent.RESULT_ORDER_CONFIRM_POSITION, position);
        bundle.putInt(StringEvent.RESULT_ORDER_CONFIRM_QUANTITY, quantity);
        intent.putExtras(bundle);
        setResult(StringEvent.RESULT_ORDER_CONFIRM, intent);
        Log.d("InRa","Daguidata");
    }

    @Override
    public void updateTotal(long total) {
        tvTotal.setText(String.valueOf(total));
    }

    @Override
    public void deleteAllItems() {
        Toast.makeText(getApplicationContext(),R.string.mess_clear, Toast.LENGTH_SHORT).show();
        setResult(StringEvent.RESULT_ORDER_CONFIRM_DELETE);
    }
    public void initDialogUpdate(){
        dialogUpdate = new Dialog(ActivityOrderConfirm.this);
        dialogUpdate.setContentView(R.layout.dialog_update_item);
        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
        dialogUpdate.getWindow().setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT);

        tvQuantityDialog = dialogUpdate.findViewById(R.id.tv_quantity_dialog_update);
        tvProductDialog = dialogUpdate.findViewById(R.id.tv_product_dialog_update);
        iBtnSubDialog = dialogUpdate.findViewById(R.id.ibtn_sub_dialog_update);
        iBtnAddDialog = dialogUpdate.findViewById(R.id.ibtn_add_dialog_update);
        btnCancelDialog = dialogUpdate.findViewById(R.id.btn_cancel_dialog_update);
        btnUpdateDialog = dialogUpdate.findViewById(R.id.btn_update_dialog_update);
    }
    @Override
    public void showDialogUpdate(final int position){
        ProductOrder product = mPresenterOrderItems.getProductOrder(position);
        tvProductDialog.setText(product.getName());
        quantityDialog = product.getQuantity();
        tvQuantityDialog.setText(String.valueOf(quantityDialog));
        dialogUpdate.show();


        iBtnSubDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantityDialog > 1){
                    quantityDialog --;
                    tvQuantityDialog.setText(String.valueOf(quantityDialog));
                }
            }
        });
        iBtnAddDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityDialog ++;
                tvQuantityDialog.setText(String.valueOf(quantityDialog));
            }
        });
        btnCancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogUpdate.dismiss();
            }
        });
        btnUpdateDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenterOrderItems.updateQuantity(position, quantityDialog);
                dialogUpdate.dismiss();
            }
        });
    }
    public void showAlertDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Do you sure delete all products in your cart");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        mPresenterOrderItems.deleteAllProduct();
                    }
                });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void showTimePicker() {
        // TODO Auto-generated method stub
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(ActivityOrderConfirm.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                tvTime.setText( "Takeaway" + " - " + selectedHour + ":" + selectedMinute );
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }


    @Override
    public void chooseStore(Store store) {
        tvAddress.setText(store.getAddress());
        tvName.setText(store.getName());

        Glide.with(getApplicationContext()).load("http://www.bsc.com.my/clients/Bangsar_Shopping_Centre_102297F7-46FB-4E0D-8BF8-CC61C6C88554/contentms/img/stores_banner_Kitchen_Shop_1.jpg")
                .error(R.drawable.no_image)
                .into(imageStore);
        bottomSheetDialog.dismiss();
        hideLoading();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.navigation_toolbar):
                onSupportNavigateUp();
                return;
            case (R.id.tv_delete_order_confirm):
                showAlertDialog();
                return;
            case (R.id.tv_edit_time_order_confirm):
                showTimePicker();
                return;
            case (R.id.tv_see_more):
                bottomSheetDialog.show();
                return;
        }
    }
}
