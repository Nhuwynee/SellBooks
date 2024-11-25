package com.example.bansach.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bansach.R;
import com.example.bansach.model.Book;
import com.example.bansach.model.Book1;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.BookViewHolder> {

    private final List<Book1> bookList; // Đã thêm final ở đây
    private FavouriteAdapter.OnFavouriteClickListener listener;

    public interface OnFavouriteClickListener {
        void onFavouriteList(Book1 book);

//        void onBookClick(Book1 book);
    }
    public FavouriteAdapter(List<Book1> bookList, OnFavouriteClickListener listener) {
        this.bookList = bookList;
        this.listener = listener;
    }
    public FavouriteAdapter(List<Book1> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favourite_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book1 book = bookList.get(position);

        // Đặt tiêu đề
        holder.bookTitle.setText(book.getTitle());

        // Xử lý hình ảnh
        String imageName = book.getImgResource();
        if (imageName != null) {
            if (imageName.endsWith(".jpg")) {
                imageName = imageName.substring(0, imageName.length() - 4);
            } else if (imageName.endsWith(".png")) {
                imageName = imageName.substring(0, imageName.length() - 4);
            }

            // Lấy ID của ảnh từ drawable
            int resId = holder.itemView.getContext().getResources().getIdentifier(
                    imageName, "drawable", holder.itemView.getContext().getPackageName()
            );

            // Sử dụng Glide để load ảnh
            Glide.with(holder.itemView.getContext())
                    .load(resId)
                    .into(holder.bookImage);
        }

        // Đặt giá sách
        holder.bookPrice.setText(String.valueOf(book.getPrice()));

        // Đặt tác giả
        holder.bookAuthor.setText(String.valueOf(book.getAuthor()));

        // Đặt điểm sách
        holder.bookPoint.setText(String.valueOf(book.getPoint()));

        // Xử lý sự kiện click vào item
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onFavouriteList(book);
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

        public BookViewHolder(View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookImage = itemView.findViewById(R.id.book_img);
            bookPrice = itemView.findViewById(R.id.book_price);
            bookAuthor = itemView.findViewById(R.id.book_author);
            bookPoint = itemView.findViewById(R.id.textPoint);
        }
    }


}
