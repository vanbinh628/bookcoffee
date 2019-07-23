package com.example.appcoffee.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.base.BaseFragment;
import com.example.appcoffee.presenter.PresenterProduct;
import com.google.android.material.tabs.TabLayout;

public class FragmentHome extends BaseFragment {
    RecyclerView recyclerView;
    PresenterProduct presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);

        recyclerView = view.findViewById(R.id.recycler_home);

        presenter = new PresenterProduct(getContext(),recyclerView,this);
        presenter.fetchDataProductsCoffee();

        final TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tab_layout_home);
        tabLayout.addOnTabSelectedListener(mOnTabSelectedListener);

        return view;

    }
    private TabLayout.OnTabSelectedListener mOnTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getPosition()){
                case 0:
                    presenter.deleteData();
                    presenter.fetchDataProductsCoffee();
                    return;
                case 1:
                    presenter.deleteData();
                    presenter.fetchDataProductsBreakfast();
                    return;
                case 2:
                    presenter.deleteData();
                    presenter.fetchDataProductsDessert();
                    return;


            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
}
