package com.example.bansach.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.R;
import com.example.bansach.model.Book1;
import com.example.bansach.model.History;
import com.example.bansach.model.Order;
import com.example.bansach.model.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public abstract class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderViewHolder> {
    private final List<Order> orders;
    private OrderHistoryAdapter.OnHistoryClickListener listener;
    private Context context;



    public abstract void onBookClick(Order book);

    public interface OnHistoryClickListener {
        void onHistoryClick(Order history);
    }
    private final List<Order> allOrders = new ArrayList<>();
    public OrderHistoryAdapter(List<Order> orders,Context context, OrderHistoryAdapter.OnHistoryClickListener listener) {
        this.orders = new ArrayList<>(orders); // Danh sách hiện tại
        this.allOrders.addAll(orders);
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orders.get(position);

        holder.idOrder.setText("Mã đơn: " + order.getIdOrder());
        holder.orderTime.setText("Thời gian: " + order.getOrderTime());
        holder.orderCost.setText(String.format("%.2f", order.getOrderCost()) + " VND");
        holder.orderStatus.setText(order.getOrderStatus());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onHistoryClick(order);
            }
        });
        switch (order.getOrderStatus()) {
            case "Đã huỷ":
                holder.statusIcon.setImageResource(R.drawable.dahuy);
                break;
            case "Đang giao":
                holder.statusIcon.setImageResource(R.drawable.xemay);
                break;
            case "Đã giao":
                holder.statusIcon.setImageResource(R.drawable.dagiao);
                break;
            default:
                holder.statusIcon.setImageResource(R.drawable.xemay);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public void updateOrders(List<Order> newOrders) {
        orders.clear();
        orders.addAll(newOrders);
        notifyDataSetChanged();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView idOrder, orderTime, orderCost, orderStatus;
        ImageView statusIcon;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            idOrder = itemView.findViewById(R.id.tvIdOrder);
            orderTime = itemView.findViewById(R.id.tvOrderTime);
            orderCost = itemView.findViewById(R.id.tvOrderCost);
            orderStatus = itemView.findViewById(R.id.tvOrderStatus);
            statusIcon = itemView.findViewById(R.id.statusIcon);

        }
    }

}
