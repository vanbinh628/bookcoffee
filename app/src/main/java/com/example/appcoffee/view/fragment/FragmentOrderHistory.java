package com.example.appcoffee.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.presenter.PresenterStoreItem;
import com.example.appcoffee.view.BaseFragment;
import com.google.android.material.tabs.TabLayout;

public class FragmentOrderHistory extends BaseFragment {
    RecyclerView recyclerView;
    TabLayout tabLayout;
    PresenterStoreItem presenterStoreItem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        recyclerView = view.findViewById(R.id.recycler_order);
        presenterStoreItem = new PresenterStoreItem(getContext(), recyclerView, this);


        tabLayout = (TabLayout)view.findViewById(R.id.tab_layout_order);
        tabLayout.addOnTabSelectedListener(mOnTabSelectedListener);

        return view;
    }
    private TabLayout.OnTabSelectedListener mOnTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getPosition()){
                case 0:
                    presenterStoreItem.DeleteData();
                    return;
                case 1:
                    presenterStoreItem.DeleteData();
                    presenterStoreItem.FetchData();
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
