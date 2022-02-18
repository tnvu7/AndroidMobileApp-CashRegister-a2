package com.example.a2cashreg;

import java.util.ArrayList;

public class HistoryManager {
    ArrayList<PurchasedProduct> purchasedProducts = new ArrayList<>();

    public void addProduct(int id, String type, int quantity, double price, String date){
        purchasedProducts.add(new PurchasedProduct(id, type, quantity, price, date));
    }
/*
    public ArrayList<PurchasedProduct> getPurchased() {
        return purchasedProducts;
    }
*/

}
