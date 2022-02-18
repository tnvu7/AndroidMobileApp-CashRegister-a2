package com.example.a2cashreg;

public class Product{
    private int p_id;
    private String p_type;
    private int p_quantity;
    private double p_price;

    public Product(){
        this.p_id = -1;
        this.p_price = -1;
        this.p_quantity = -1;
        this.p_type = null;
    }
    public Product(int id, String type, int quantity, double price) {
        this.p_id = id;
        this.p_price = price;
        this.p_quantity = quantity;
        this.p_type = type;
    }
    public int getId() {
        return this.p_id;
    }
    public String getType() {
        return this.p_type;
    }
    public int getQuantity() {
        return this.p_quantity;
    }
    public double getPrice() {
        return this.p_price;
    }
    public void updateQty(int qty) {
        this.p_quantity = qty;
    }
}
