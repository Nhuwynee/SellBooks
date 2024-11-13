package com.example.bansach.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.model.Book;
import com.example.bansach.model.History;
import com.example.bansach.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<History> historyList;

    public HistoryAdapter(List<History> historyList) {
        this.historyList = historyList;
    }
    private OnHistoryClickListener listener;

    public interface OnHistoryClickListener {
        void onHistoryClick(History history);
    }
    public HistoryAdapter(List<History> historyList, OnHistoryClickListener listener) {
        this.historyList = historyList;
        this.listener = listener;
    }
    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        History history = historyList.get(position);
        holder.orderNumber.setText(history.getOrderNumber());

        // Định dạng ngày tháng
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(history.getOrderDate());
        holder.orderDate.setText(formattedDate);

        // Chuyển đổi giá tiền từ int sang String với định dạng
        holder.orderPrice.setText(String.format(Locale.getDefault(), "%,dđ", history.getOrderPrice()));

        holder.orderStatus.setText(history.getOrderStatus());

        int avatarResId = holder.itemView.getContext().getResources().getIdentifier(history.getAvatarImage(), "drawable", holder.itemView.getContext().getPackageName());
        holder.avatarImage.setImageResource(avatarResId);

        // Cập nhật icon trạng thái
        int statusIconResId = holder.itemView.getContext().getResources().getIdentifier(history.getStatusIcon(), "drawable", holder.itemView.getContext().getPackageName());
        holder.statusIcon.setImageResource(statusIconResId);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onHistoryClick(history);
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView orderNumber, orderDate, orderPrice, orderStatus;
        ImageView avatarImage, statusIcon;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            orderNumber = itemView.findViewById(R.id.orderNumber);
            orderDate = itemView.findViewById(R.id.orderDate);
            orderPrice = itemView.findViewById(R.id.orderPrice);
            orderStatus = itemView.findViewById(R.id.orderStatus);
            avatarImage = itemView.findViewById(R.id.avatarImage);
            statusIcon = itemView.findViewById(R.id.statusIcon);
        }
    }
}