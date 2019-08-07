package com.example.appcoffee.presenter;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.adapter.AdapterProductDetail;
import com.example.appcoffee.adapter.AdapterUserCart;
import com.example.appcoffee.base.BasePresenter;
import com.example.appcoffee.model.ProductOrder;
import com.example.appcoffee.other.RecyclerViewMargin;
import com.example.appcoffee.view.HandleOrderItems;
import com.example.appcoffee.view.HandleUserCart;

import java.util.ArrayList;
import java.util.List;

public class PresenterOrderItems extends BasePresenter {
    private List<ProductOrder> mListProductOrder;
    private HandleOrderItems mHandleOrderItems;

    private RecyclerView.LayoutManager layoutManager;
    private AdapterUserCart mAdapterUserCart;

    public AdapterUserCart getAdapterUserCart() {
        return mAdapterUserCart;
    }

    @SuppressLint("WrongConstant")
    public PresenterOrderItems(Context context, List<ProductOrder> listProductOrder, HandleOrderItems mHandleUserCart) {
        super(context);
        this.mListProductOrder = listProductOrder;
        this.mHandleOrderItems = mHandleUserCart;

        mAdapterUserCart = new AdapterUserCart(context, mListProductOrder, mHandleUserCart);
    }
    public long calculatorTotal(){
        long total = 0;
        for(int i =0;i < mListProductOrder.size(); i++){
            total += mListProductOrder.get(i).getTotal();
        }
        mHandleOrderItems.updateTotal(total);
        return total;
    }

    public void updateRecycleView(){
        mAdapterUserCart.notifyDataSetChanged();
    }
    public void updateQuantity(int position, int quantity){
        mListProductOrder.get(position).setQuantity(quantity);
        mListProductOrder.get(position).handleCalculateTotal();
        mHandleOrderItems.updateQuantity(position, quantity);
        updateRecycleView();
        calculatorTotal();
    }
    public ProductOrder getProductOrder(int position){
        return mListProductOrder.get(position);
    }
    public void deleteAllProduct(){
        mHandleOrderItems.updateTotal(0);
        mListProductOrder.clear();
        updateRecycleView();
        mHandleOrderItems.deleteAllItems();
    }



}
