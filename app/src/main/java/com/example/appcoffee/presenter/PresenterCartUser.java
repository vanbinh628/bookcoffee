package com.example.appcoffee.presenter;

import android.content.Context;

import com.example.appcoffee.model.Product;
import com.example.appcoffee.model.ProductOrder;
import com.example.appcoffee.view.HandleUserCart;

import java.util.ArrayList;
import java.util.List;

public class PresenterCartUser{
    private Context mContext;
    private List<ProductOrder> mListProductOrder;
    private HandleUserCart mHandleUserCart;

    public List<ProductOrder> getListProductOrder() {
        return mListProductOrder;
    }

    public PresenterCartUser(Context context, HandleUserCart handleCartUser) {
        this.mContext = context;
        this.mListProductOrder = new ArrayList<>();
        this.mHandleUserCart = handleCartUser;
    }
    public boolean isEmptyUserCard(){
        if(mListProductOrder.size() > 0){
            mHandleUserCart.ShowUserCart();
            return false;
        }
        mHandleUserCart.HideUserCart();
        return true;

    }
    public void deleteAllProduct(){
        mListProductOrder.clear();
        totalUserCart();
        isEmptyUserCard();
    }
    public void updateProduct(int position, int quantity){
        mListProductOrder.get(position).setQuantity(quantity);
        mListProductOrder.get(position).handleCalculateTotal();
        totalUserCart();
    }
    public void addProductToUserCart(Product product, int quantity){
        ProductOrder productOrder = new ProductOrder(product, quantity);
        productOrder.handleCalculateTotal();
        mListProductOrder.add(productOrder);
        mHandleUserCart.ShowUserCart();
    }
    public Long totalUserCart(){
        long total = 0;
        for(int i = 0;i < mListProductOrder.size(); i++){
            if(mListProductOrder.get(i).getTotal() != null) {
                total += mListProductOrder.get(i).getTotal();
            }
        }
        mHandleUserCart.TotalUserCard(total);
        return total;
    }
}
