package com.example.appcoffee.view;

public interface HandleOrderItems {
    public void showDialogUpdate(int position);
    public void updateQuantity(int position, int quantity);
    public void updateTotal(long total);
    public void deleteAllItems();
}
