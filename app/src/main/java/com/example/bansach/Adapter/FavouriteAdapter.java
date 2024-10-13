package com.example.bansach.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.R;
import com.example.bansach.model.Book;
import com.example.bansach.model.History;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.BookViewHolder> {

    private final List<Book> bookList; // Đã thêm final ở đây
    private FavouriteAdapter.OnFavouriteClickListener listener;

    public interface OnFavouriteClickListener {
        void onFavouriteList(Book book);
    }
    public FavouriteAdapter(List<Book> bookList, FavouriteAdapter.OnFavouriteClickListener listener) {
        this.bookList = bookList;
        this.listener = listener;
    }
    public FavouriteAdapter(List<Book> bookList) {
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
        Book book = bookList.get(position);
        holder.bookTitle.setText(book.getTitle());
        holder.bookImage.setImageResource(book.getImgResource());
        holder.bookPrice.setText(String.valueOf(book.getPrice()));
        holder.bookAuthor.setText(String.valueOf(book.getAuthor()));
        holder.bookPoint.setText(String.valueOf(book.getPoint()));
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
