package com.example.bansach.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.R;
import com.example.bansach.model.Book;
import com.example.bansach.model.Cart;

import java.util.List;
public class BuyedBookAdapter extends RecyclerView.Adapter<BuyedBookAdapter.ProductViewHolder> {
    private Context context;
    private List<Cart> productList;

    public BuyedBookAdapter(Context context, List<Cart> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order_ng, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Cart product = productList.get(position);

        // Lấy giá và số lượng từ đối tượng Cart
        float price = product.getPrice();  // Giả sử price là kiểu String, nếu là số bạn có thể trực tiếp sử dụng
        int quantity = product.getNumber();

        // Tính tổng: price * quantity
        double total = price * quantity;

        // Cập nhật các TextView
        holder.productName.setText(product.getTitle());
        holder.productPrice.setText(String.format("%,.0f đ",price)); // Giữ giá nguyên bản
        holder.productQuantity.setText(String.valueOf(quantity)); // Hiển thị số lượng
        holder.productTotal.setText(String.format("%,.0f đ", total)); // Hiển thị tổng (có thể format lại theo yêu cầu)
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productPrice, productQuantity, productTotal;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_1);
            productPrice = itemView.findViewById(R.id.price_1);
            productQuantity = itemView.findViewById(R.id.quantity_1);
            productTotal = itemView.findViewById(R.id.total_1);
        }
    }
}
