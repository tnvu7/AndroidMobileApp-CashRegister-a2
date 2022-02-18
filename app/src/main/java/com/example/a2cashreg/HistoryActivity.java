package com.example.a2cashreg;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryActivity extends AppCompatActivity implements HistoryAdapter.ItemClickListener {

    HistoryAdapter adapter;
    HistoryManager history_manager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_list);

        history_manager = ((MyApp)getApplication()).historyManager;

        recyclerView = findViewById(R.id.history_list);
        adapter = new HistoryAdapter(history_manager.purchasedProducts, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d("OnItemClick", "ok");
        ((MyApp)getApplication()).boughtProduct = (PurchasedProduct) adapter.getProduct(position);
        startActivity(new Intent(view.getContext(), HistoryDetail.class));
    }
}

