package com.example.a2cashreg;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HistoryDetail extends AppCompatActivity {
    TextView pd_type, pd_price, pd_quantity, pd_date;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_detail);

        pd_type = findViewById(R.id.pd_type);
        pd_price = findViewById(R.id.pd_price);
        pd_date = findViewById(R.id.pd_date);
        pd_quantity = findViewById(R.id.pd_quantity);

        pd_type.setText("Product: " + ((MyApp)getApplication()).boughtProduct.getType());
        pd_price.setText("Price: " + ((MyApp)getApplication()).boughtProduct.getPrice());
        pd_quantity.setText("Quantity: " + ((MyApp)getApplication()).boughtProduct.getQuantity());
        pd_date.setText("Purchase date: " + ((MyApp)getApplication()).boughtProduct.getPurchase_date());
    }
}
