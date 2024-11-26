package com.example.bansach.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.R;
import com.example.bansach.model.Book1;
import com.example.bansach.model.Cart;
import com.example.bansach.model.Cart1;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.BookViewHolder> {
    private Context context;
    private boolean isUpdating = false; // Flag kiểm tra trạng thái đang cập nhật
    public interface OnItemChangeListener {
        void onItemChanged();
    }

    private OnItemChangeListener listener;
    private final List<Cart> bookList; // Đã thêm final ở đây

    public CartAdapter(List<Cart> bookList, Context context, OnItemChangeListener listener) {
        this.bookList = bookList;
        this.context = context;
        this.listener= listener;
    }


    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Cart book = bookList.get(position);
        holder.bookTitle.setText(book.getTitle());
        String imageName = book.getImgResource();
        if (imageName.endsWith(".jpg")) {
            imageName = imageName.substring(0, imageName.length() - 4);
        } else if (imageName.endsWith(".png")) {
            imageName = imageName.substring(0, imageName.length() - 4);
        }
        int resId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        Glide.with(context).load(resId).into(holder.bookImage);

        holder.bookPrice.setText(String.valueOf(book.getPrice()*book.getNumber()));
        holder.bookAuthor.setText(String.valueOf(book.getAuthor()));
        holder.bookPoint.setText(book.getPoint() + " ★" );
        holder.sl.setText(String.valueOf(book.getNumber()));
        // Số lượng sách

        // Nút tăng
        holder.tangsl.setOnClickListener(v -> {

            int quantity = book.getNumber();
            quantity++;
            book.setNumber(quantity);
            holder.sl.setText(String.valueOf(book.getNumber()));
            notifyItemChanged(position); // Cập nhật UI tại vị trí này
            isUpdating = true; // Đánh dấu đang cập nhật
            listener.onItemChanged();
            updateQuantity(book.getId(), book.getNumber());
            holder.bookPrice.setText(String.valueOf(book.getPrice() * book.getNumber()));
        });

        // Nút giảm
        // Nút giảm
        holder.giamsl.setOnClickListener(v -> {
            int quantity = book.getNumber() - 1;
            if (quantity <= 0) {
                // Nếu số lượng <= 0, xóa sách khỏi giỏ hàng
                removeFromCart(book.getId(), position);
            } else {
                book.setNumber(quantity);
                notifyItemChanged(position); // Cập nhật UI tại vị trí này
                updateQuantity(book.getId(), quantity); // Gọi API cập nhật số lượng
                listener.onItemChanged();
                holder.bookPrice.setText(String.valueOf(book.getPrice() * book.getNumber()));
            }
        });

    }

    private void updateQuantity( int bookId, int quantity) {
        // Tạo một instance của Retrofit
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);

        // Tạo request object
        Cart1 request = new Cart1(3, bookId, quantity);

        // Gọi API
        Call<Void> call = apiService.addToCart(request);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.d("CartAdapter", "Quantity updated successfully");
                } else {
                    Log.e("CartAdapter", "Error updating quantity: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("CartAdapter", "Error: " + t.getMessage());
            }
        });
    }
    private void removeFromCart(int bookId, int position) {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);

        Call<Void> call = apiService.deleteBookFromCart(bookId,3); // API để xóa sách
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.d("CartAdapter", "Book removed successfully");
                    // Xóa sách khỏi danh sách hiển thị và cập nhật UI
                    bookList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, bookList.size());
                } else {
                    Log.e("CartAdapter", "Error removing book: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("CartAdapter", "Error: " + t.getMessage());
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView bookTitle;
        public ImageView bookImage;
        public TextView bookPrice;
        public TextView bookAuthor;
        public TextView bookPoint;
        public TextView sl;
        public Button giamsl, tangsl;

        public BookViewHolder(View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookImage = itemView.findViewById(R.id.book_img);
            bookPrice = itemView.findViewById(R.id.book_price);
            bookAuthor = itemView.findViewById(R.id.book_author);
            bookPoint = itemView.findViewById(R.id.textPoint);
            giamsl = itemView.findViewById(R.id.btngiamsoluong);
            tangsl = itemView.findViewById(R.id.btntangsoluong);
            sl = itemView.findViewById(R.id.book_sl);
        }
    }
    public void updateBooks(List<Cart> newBooks) {
        bookList.clear();
        bookList.addAll(newBooks);
        notifyDataSetChanged();
    }
}
