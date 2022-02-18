package com.example.a2cashreg;

import java.util.ArrayList;

public class ProductManager {
    ArrayList<Product> products = new ArrayList<Product>();

    public ProductManager() {
        products.add(new Product(0, "Pants", 10, 20.40));
        products.add(new Product(1, "Shoes", 100, 10.60));
        products.add(new Product(2, "Hats", 30, 15.99));
        products.add(new Product(3, "Sweater", 50, 55.99));
        products.add(new Product(4, "Gloves", 40, 35.19));
    }

}
