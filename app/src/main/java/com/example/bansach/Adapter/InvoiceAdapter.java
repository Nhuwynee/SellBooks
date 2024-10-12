package com.example.bansach.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.model.Book;
import com.example.bansach.model.Invoice; // Đảm bảo bạn có model Invoice trong package Model
import com.example.bansach.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.InvoiceViewHolder> {

    private List<Invoice> invoiceList;
    private InvoiceAdapter.OnInvoiceClickListener listener;

    public interface OnInvoiceClickListener {
        void oninvoiceClick(Invoice invoice);
    }
    public InvoiceAdapter(List<Invoice> invoiceList, InvoiceAdapter.OnInvoiceClickListener listener) {
        this.invoiceList = invoiceList;
        this.listener = listener;
    }
    public InvoiceAdapter(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @NonNull
    @Override
    public InvoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_orders_admin, parent, false);
        return new InvoiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InvoiceViewHolder holder, int position) {
        Invoice invoice = invoiceList.get(position);
        holder.orderNumber.setText(invoice.getOrderNumber());

        // Định dạng ngày tháng
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(invoice.getOrderDate());
        holder.orderDate.setText(formattedDate);

        // Chuyển đổi giá tiền từ int sang String với định dạng
        holder.orderPrice.setText(String.format(Locale.getDefault(), "%,d VNĐ", (int) invoice.getOrderPrice()));

        holder.orderStatus.setText(invoice.getOrderStatus());

        // Cập nhật hình ảnh avatar
        int avatarResId = holder.itemView.getContext().getResources().getIdentifier(invoice.getAvatarImage(), "drawable", holder.itemView.getContext().getPackageName());
        holder.avatarImage.setImageResource(avatarResId);

        // Cập nhật icon trạng thái
        int statusIconResId = holder.itemView.getContext().getResources().getIdentifier(invoice.getStatusIcon(), "drawable", holder.itemView.getContext().getPackageName());
        holder.statusIcon.setImageResource(statusIconResId);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.oninvoiceClick(invoice);
            }
        });
    }

    @Override
    public int getItemCount() {
        return invoiceList.size();
    }

    public static class InvoiceViewHolder extends RecyclerView.ViewHolder {
        TextView orderNumber, orderDate, orderPrice, orderStatus;
        ImageView avatarImage, statusIcon;

        public InvoiceViewHolder(View itemView) {
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
