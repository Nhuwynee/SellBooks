package com.example.bansach.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.R;
import com.example.bansach.model.OrderDetail;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private Context context;
    private List<OrderDetail> productList;

    public HistoryAdapter(Context context, List<OrderDetail> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order_ng, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        OrderDetail product = productList.get(position);

        if (product != null) {
            // Lấy giá và số lượng từ đối tượng OrderDetail
            float price = product.getPrice();
            int quantity = product.getNumber();

            // Tính tổng giá
            float total = price * quantity;

            // Cập nhật các TextView
            holder.productName.setText(product.getTitle());
            holder.productPrice.setText(String.format("%,.0f đ", price)); // Hiển thị giá
            holder.productQuantity.setText(String.valueOf(quantity)); // Hiển thị số lượng
            holder.productTotal.setText(String.format("%,.0f đ", total)); // Hiển thị tổng giá
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productPrice, productQuantity, productTotal;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_1);
            productPrice = itemView.findViewById(R.id.price_1);
            productQuantity = itemView.findViewById(R.id.quantity_1);
            productTotal = itemView.findViewById(R.id.total_1);
        }
    }
}
