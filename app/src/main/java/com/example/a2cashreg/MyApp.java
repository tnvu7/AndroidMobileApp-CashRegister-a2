package com.example.a2cashreg;

import android.app.Application;

public class MyApp extends Application {
    ProductManager productManager = new ProductManager();
    Product mainProduct = new Product();

    int quantityBought = 0;

    HistoryManager historyManager = new HistoryManager();
    PurchasedProduct boughtProduct = new PurchasedProduct();
}
