package com.example.a2cashreg;

public class PurchasedProduct extends Product {
    private String purchase_date;

    public PurchasedProduct(){
        super();
        this.purchase_date = null;
    }
    public PurchasedProduct(int id, String type, int quantity, double price, String date) {
        super(id, type, quantity, price);
        this.purchase_date = date;
    }
    public String getPurchase_date() {
        return this.purchase_date;
    }

}
