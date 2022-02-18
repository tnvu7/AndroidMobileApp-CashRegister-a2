package com.example.a2cashreg;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{

    ArrayList<PurchasedProduct> purchasedProducts;
    Context context;
    private ItemClickListener clickListener;

    HistoryAdapter(ArrayList<PurchasedProduct> listOfProducts, Context context){
        this.purchasedProducts = listOfProducts;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryAdapter.HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(context).inflate(R.layout.base_adapter_row_layout, null);
        View view = LayoutInflater.from(context).inflate(R.layout.base_adapter_row_layout, parent,false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.HistoryViewHolder holder, int position) {
        holder.typeText.setText(purchasedProducts.get(position).getType());
        holder.qtyText.setText(String.valueOf(purchasedProducts.get(position).getQuantity()));
        holder.totalText.setText(String.valueOf(purchasedProducts.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return purchasedProducts.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView typeText, qtyText, totalText;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            typeText = itemView.findViewById(R.id.type);
            qtyText = itemView.findViewById(R.id.quantity);
            totalText = itemView.findViewById(R.id.price);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                Log.d("onClick", "ok");
                clickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
    public PurchasedProduct getItem(int i) {
        return purchasedProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

