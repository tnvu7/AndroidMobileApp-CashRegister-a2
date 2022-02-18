package com.example.a2cashreg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProductBaseAdapter extends BaseAdapter {
    ArrayList<Product> productList;
    Context context;

    public ProductBaseAdapter(ArrayList<Product> listOfProducts, Context context) {
        this.productList = listOfProducts;
        this.context = context;
    }
    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.base_adapter_row_layout,null);

        TextView typeText = view.findViewById(R.id.type);
        TextView quantityText = view.findViewById(R.id.quantity);
        TextView priceText = view.findViewById(R.id.price);

        typeText.setText(String.valueOf(productList.get(i).getType()));
        quantityText.setText(String.valueOf(productList.get(i).getQuantity()));
        priceText.setText(String.valueOf(productList.get(i).getPrice()));

        return view;
    }
}
