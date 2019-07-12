package com.example.appcoffee.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.Adapter.AdapterOrderInfo;
import com.example.appcoffee.Model.OrderInfor;
import com.example.appcoffee.R;
import com.example.appcoffee.RecyclerViewMargin;

import java.util.ArrayList;

public class FragmentOrder extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_order);
        recyclerView.setHasFixedSize(true);
        @SuppressLint("WrongConstant") LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewMargin viewMargin = new RecyclerViewMargin(40,1);
        recyclerView.addItemDecoration(viewMargin);

        ArrayList<OrderInfor> inforArrayList = new ArrayList<>();
        inforArrayList.add(new OrderInfor("Name of branch","Street 87/96 Ung Van Khiem - Ward 1","20/05/2019, 12:00","123.00"));
        inforArrayList.add(new OrderInfor("Name of branch","Street 87/96 Ung Van Khiem - Ward 1","20/05/2019, 12:00","123.00"));
        inforArrayList.add(new OrderInfor("Name of branch","Street 87/96 Ung Van Khiem - Ward 1","20/05/2019, 12:00","123.00"));
        inforArrayList.add(new OrderInfor("Name of branch","Street 87/96 Ung Van Khiem - Ward 1","20/05/2019, 12:00","123.00"));
        AdapterOrderInfo adapterOrderInfo = new AdapterOrderInfo(getContext(),inforArrayList);

        recyclerView.setAdapter(adapterOrderInfo);

        return  view;
    }
}
