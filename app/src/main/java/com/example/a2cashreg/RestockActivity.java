package com.example.a2cashreg;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RestockActivity extends AppCompatActivity implements View.OnClickListener {
    ListView restock_list;
    EditText editText;
    ProductBaseAdapter productBaseAdapter;
    Product pro;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restock);

        restock_list = findViewById(R.id.restock_list);
        editText = findViewById(R.id.editText);
        findViewById(R.id.buttonOK).setOnClickListener(this);
        findViewById(R.id.buttonCancel).setOnClickListener(this);

        ArrayList<Product> list = ((MyApp)getApplication()).productManager.products;
        productBaseAdapter = new ProductBaseAdapter(list, this);
        restock_list.setAdapter(productBaseAdapter);

        restock_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pro = (Product) productBaseAdapter.getItem(i);
                view.setBackgroundColor(R.color.teal_200);

            }
        });
    }
    private boolean validate() {
        return (editText.getText().toString() != null && pro != null);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.buttonOK:
                if (validate()){
                    ((MyApp)getApplication()).productManager.products.get(pro.getId()).updateQty(pro.getQuantity() + Integer.parseInt(editText.getText().toString()));
                    Toast.makeText(getApplicationContext(), "Successful added the quantity!", Toast.LENGTH_SHORT).show();
                    productBaseAdapter.notifyDataSetChanged();
                    pro=null;
                    editText.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter a quantity and select product", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonCancel:
                finish();
                break;
        }

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
