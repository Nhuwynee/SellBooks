package com.example.bansach.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.R;
import com.example.bansach.model.Book;
import com.example.bansach.model.History;

import java.util.List;

public class ListViewBookAdapter extends RecyclerView.Adapter<ListViewBookAdapter.BookViewHolder> {

    private final List<Book> bookList;
    private OnBookClickListener listener;
    private OnBookDeleteListener deleteListener;
    public interface OnBookClickListener {
        void onBookClick(Book book);
    }
    public interface OnBookDeleteListener {
        void onBookDelete(Book book, int position);  // Dùng cho việc xóa sách
    }

    public ListViewBookAdapter(List<Book> bookList, OnBookClickListener listener, OnBookDeleteListener deleteListener) {
        this.bookList = bookList;
        this.listener = listener;
        this.deleteListener = deleteListener;
    }

    public ListViewBookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.bookTitle.setText(book.getTitle());
        holder.bookAuthor.setText(book.getAuthor());

        holder.bookPrice.setText(String.format("%.0f VND", book.getPrice()));

        holder.bookStatus.setText(book.getIsActive());

        // Thiết lập ảnh cho sách
        holder.bookImage.setImageResource(book.getImgResource());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onBookClick(book);
            }
        });
        holder.buttonDelete.setOnClickListener(v -> {
            if (deleteListener != null) {
                deleteListener.onBookDelete(book, position);  // Gọi đến phương thức delete
            }        });

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView bookTitle, bookAuthor, bookPrice, bookStatus;
        ImageView bookImage;
    public Button buttonDelete;
        public BookViewHolder(View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookAuthor = itemView.findViewById(R.id.book_author);
            bookPrice = itemView.findViewById(R.id.book_price);
            bookStatus = itemView.findViewById(R.id.book_status);
            bookImage = itemView.findViewById(R.id.image_book);
            buttonDelete = itemView.findViewById(R.id.buttonDelete); // Thay đổi id theo layout của bạn

        }
    }
    public void removeItem(int position) {
        bookList.remove(position);
        notifyItemRemoved(position);
    }
}
