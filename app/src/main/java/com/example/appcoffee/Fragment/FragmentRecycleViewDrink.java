package com.example.appcoffee.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.Adapter.AdapterDrinkDetail;
import com.example.appcoffee.Model.DrinkDetail;
import com.example.appcoffee.R;
import com.example.appcoffee.RecyclerViewMargin;

import java.util.ArrayList;

public class FragmentRecycleViewDrink extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_container, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id._recycleview);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(inflater.getContext(), 1);

        recyclerView.setLayoutManager(mGridLayoutManager);

        RecyclerViewMargin decoration = new RecyclerViewMargin(20, 2);
        recyclerView.addItemDecoration(decoration);

        ArrayList<DrinkDetail> arrayList = new ArrayList<>();
        arrayList.add(new DrinkDetail(R.drawable.coffee1,"Choco Frappe","Locally Roasted","10.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee2,"Choco Frappe","Locally Roasted","11.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee3,"Caramel Frappe","Decaf Colombia","12.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee3,"Kick Frappe","Decaf Colombia","13.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee3,"Caramel Frappe","Decaf Colombia","12.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee3,"Kick Frappe","Decaf Colombia","13.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee3,"Caramel Frappe","Decaf Colombia","12.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee3,"Kick Frappe","Decaf Colombia","13.00"));

        AdapterDrinkDetail adapter = new AdapterDrinkDetail(inflater.getContext(),arrayList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
