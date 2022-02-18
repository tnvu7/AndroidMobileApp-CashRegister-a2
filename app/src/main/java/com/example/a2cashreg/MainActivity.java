package com.example.a2cashreg;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //UI elements
    TextView typeText, quantityText, totalText;
    NumberPicker numberPicker;
    ListView productList;

    //classes
    ProductManager productManager;
    Product product;
    ProductBaseAdapter productBaseAdapter;

    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new AlertDialog.Builder(this);

        typeText = findViewById(R.id.productType);
        quantityText = findViewById(R.id.quantityText);
        totalText = findViewById(R.id.totalText);
        findViewById(R.id.buttonBuy).setOnClickListener(this);
        findViewById(R.id.buttonManager).setOnClickListener(this);
        numberPicker = findViewById(R.id.numberPicker);
        productList = findViewById(R.id.productList);

        //initial
        typeText.setText("Select a type");
        quantityText.setText("Quantity");
        totalText.setText("Total");
        numberPicker.setMinValue(0);

        //product object
        productManager = ((MyApp) getApplication()).productManager;
        product = ((MyApp)getApplication()).mainProduct;

        //orientation changes
        if (product.getId() != -1){
            typeText.setText(product.getType());
            numberPicker.setMaxValue(product.getQuantity());
            numberPicker.setValue(((MyApp)getApplication()).quantityBought);
            totalText.setText(String.valueOf(((MyApp)getApplication()).quantityBought * product.getPrice()));
        }

        ArrayList<Product> list = ((MyApp)getApplication()).productManager.products;
        productBaseAdapter = new ProductBaseAdapter(list, this);
        productList.setAdapter(productBaseAdapter);

        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((MyApp)getApplication()).mainProduct = (Product) productBaseAdapter.getItem(i);
                product = ((MyApp)getApplication()).mainProduct;
                typeText.setText(product.getType());
                numberPicker.setMaxValue(product.getQuantity());
                numberPicker.setValue(((MyApp)getApplication()).quantityBought);
                quantityText.setText(String.valueOf(numberPicker.getValue()));
                totalText.setText(String.valueOf(numberPicker.getValue() * product.getPrice()));
            }
        });

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                quantityText.setText(String.valueOf(newVal));
                totalText.setText(String.valueOf(product.getPrice() * newVal));
                ((MyApp)getApplication()).quantityBought = newVal;
            }
        });
    }
    private boolean validate(){
        if (product.getId() == -1){
            Toast.makeText(getApplicationContext(), "Please select a product", Toast.LENGTH_SHORT).show();
            return false;
        } else if (numberPicker.getValue() == 0){
            Toast.makeText(getApplicationContext(), "Please select a quantity", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        int qtyBought = numberPicker.getValue();
        double total = numberPicker.getValue()*product.getPrice();

        switch(id){
            case R.id.buttonManager:
                startActivity(new Intent(this, ManagerPanel.class));
                break;
            case R.id.buttonBuy:
                if (validate()){
                    ((MyApp)getApplication()).historyManager.purchasedProducts.add(new PurchasedProduct(product.getId(), product.getType(), qtyBought, total, String.valueOf(new Date())));
                    builder.setTitle("Thank you for your purchase")
                            .setMessage("Your purchase is " + qtyBought + " " + product.getType() + " for " + total + ".")
                            .setCancelable(true)
                            .setPositiveButton("OK", null)
                            .show();
                    typeText.setText("Select a type");
                    quantityText.setText("Quantity");
                    totalText.setText("Total");
                    numberPicker.setMaxValue(0);
                    ((MyApp)getApplication()).productManager.products.get(product.getId()).updateQty(product.getQuantity() - qtyBought);
                    //refresh listview
                    productBaseAdapter.notifyDataSetChanged();

                    ((MyApp)getApplication()).mainProduct = new Product();
                    product = ((MyApp)getApplication()).mainProduct;
                }
                break;
        }
    }
}