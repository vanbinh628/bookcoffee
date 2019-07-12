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

public class FragmentHome extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_home);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

        RecyclerViewMargin viewMargin = new RecyclerViewMargin(40,2);
        recyclerView.addItemDecoration(viewMargin);

        ArrayList<DrinkDetail> arrayList = new ArrayList<>();
        arrayList.add(new DrinkDetail(R.drawable.coffee1,"Choco Frappe","Locally Roasted","10.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee2,"Choco Frappe","Locally Roasted","11.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee3,"Caramel Frappe","Decaf Colombia","12.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee3,"Kick Frappe","Decaf Colombia","13.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee1,"Choco Frappe","Locally Roasted","10.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee2,"Choco Frappe","Locally Roasted","11.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee3,"Caramel Frappe","Decaf Colombia","12.00"));
        arrayList.add(new DrinkDetail(R.drawable.coffee3,"Kick Frappe","Decaf Colombia","13.00"));

        AdapterDrinkDetail adapter = new AdapterDrinkDetail(getContext(),arrayList);
        recyclerView.setAdapter(adapter);
        return  view;
    }
}
