package com.example.a2cashreg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ManagerPanel extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_panel);

        findViewById(R.id.buttonHistory).setOnClickListener(this);
        findViewById(R.id.buttonRestock).setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.buttonHistory:
                startActivity(new Intent(this, HistoryActivity.class));
                break;
            case R.id.buttonRestock:
                startActivity(new Intent(this, RestockActivity.class));
                break;
        }
    }
}
