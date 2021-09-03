package com.example.appcoffee.activity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;

import com.example.appcoffee.presenter.PresenterProduct;

import java.util.ArrayList;


public class Fragment_Home extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_home);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(getContext(),layoutManager.getOrientation());
        recyclerView.addItemDecoration(divider);

        final ArrayList<orderBasic> arrayList = new ArrayList<>();
        arrayList.add(new orderBasic(1,"Cappuchino [75% sugar, 50% ice]","$3.5"));
        arrayList.add(new orderBasic(5,"Frappuchino [25% sugar, 40% ice]","$13.5"));
        arrayList.add(new orderBasic(1,"Cappuchino [75% sugar, 50% ice]","$3.5"));
        arrayList.add(new orderBasic(5,"Frappuchino [25% sugar, 40% ice]","$13.5"));

        AdapterUser_Cart adapterUser_cart = new AdapterUser_Cart(getContext(),arrayList);

        recyclerView.setAdapter(adapterUser_cart);




//        RecyclerView recyclerView =(RecyclerView)view.findViewById(R.id.recycler_home);
//        recyclerView.setHasFixedSize(true);// giúp recycle view có kích thước cố định
//
//        @SuppressLint("WrongConstant") LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
//        //LinearLayoutManager hỗ trợ item scroll view theo chiều ngang or chiều dọc
//        recyclerView.setLayoutManager(layoutManager);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),layoutManager.getOrientation());
//        //tạo ra ngăn cách giữa các item
//        recyclerView.addItemDecoration(dividerItemDecoration);
//
//        //tạo data cho arraylist
//        final ArrayList<orderBasic> arrayList = new ArrayList<>();
//        arrayList.add(new orderBasic(1,"Cappuchino [75% sugar, 50% ice]","$3.5"));
//        arrayList.add(new orderBasic(5,"Frappuchino [75% sugar, 50% ice]","$13.5"));
//        arrayList.add(new orderBasic(1,"Cappuchino [75% sugar, 50% ice]","$3.5"));
//        arrayList.add(new orderBasic(1,"Cappuchino [75% sugar, 50% ice]","$3.5"));
//        arrayList.add(new orderBasic(5,"Frappuchino [75% sugar, 50% ice]","$13.5"));
//        arrayList.add(new orderBasic(1,"Cappuchino [75% sugar, 50% ice]","$3.5"));

        // khởi tạo adpter có data và set cho nó Context hiện tại
//        final AdapterUser_Cart orderAdapter = new AdapterUser_Cart(getContext(),arrayList);
//        recyclerView.setAdapter(orderAdapter);

        return view;
    }
}
