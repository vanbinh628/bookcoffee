package com.example.appcoffee.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.appcoffee.Model.orderBasic;
import com.example.appcoffee.R;
import com.example.appcoffee.Adapter.orderBasicAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_progress);

        TextView tvTotal = (TextView)findViewById(R.id.total);
        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recycler_view_order);
        recyclerView.setHasFixedSize(true);// giúp recycle view có kích thước cố định

        @SuppressLint("WrongConstant") LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        //LinearLayoutManager hỗ trợ item scroll view theo chiều ngang or chiều dọc
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        //tạo ra ngăn cách giữa các item
        recyclerView.addItemDecoration(dividerItemDecoration);

        //tạo data cho arraylist
        final ArrayList<orderBasic> arrayList = new ArrayList<>();
        arrayList.add(new orderBasic(1,"Cappuchino [75% sugar, 50% ice]","$3.5"));
        arrayList.add(new orderBasic(5,"Frappuchino [75% sugar, 50% ice]","$13.5"));
        arrayList.add(new orderBasic(1,"Cappuchino [75% sugar, 50% ice]","$3.5"));
        arrayList.add(new orderBasic(1,"Cappuchino [75% sugar, 50% ice]","$3.5"));
        arrayList.add(new orderBasic(5,"Frappuchino [75% sugar, 50% ice]","$13.5"));
        arrayList.add(new orderBasic(1,"Cappuchino [75% sugar, 50% ice]","$3.5"));

        // khởi tạo adpter có data và set cho nó Context hiện tại

        final orderBasicAdapter orderAdapter = new orderBasicAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(orderAdapter);

        tvTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(new orderBasic(10,"ABC [75% sugar, 50% ice]","$0"));
                orderAdapter.notifyDataSetChanged();
                //khi thêm vào thì phải báo có dự liệu mới show lại
            }
        });


    }
    public  void initView(){

    }
}
