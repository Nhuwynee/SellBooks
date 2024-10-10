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

import java.util.List;

public class Listview_bookAdapter extends RecyclerView.Adapter<Listview_bookAdapter.BookViewHolder> {

    private List<Book> bookList;

    // Constructor
    public Listview_bookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.bookTitle.setText(book.getTitle());
        holder.bookAuthor.setText(book.getAuthor());
        holder.bookPrice.setText(String.valueOf(book.getPrice()));
        holder.bookStatus.setText(book.getIsActive());
        holder.imageBook.setImageResource(book.getImgResource());
    }
    @Override
    public int getItemCount() {
        return (bookList != null && !bookList.isEmpty()) ? bookList.size() : 0;
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView bookTitle, bookAuthor, bookPrice, bookStatus;
        ImageView imageBook;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookAuthor = itemView.findViewById(R.id.book_author);
            bookPrice = itemView.findViewById(R.id.book_price);
            bookStatus = itemView.findViewById(R.id.book_status);
            imageBook = itemView.findViewById(R.id.image_book);
        }
    }
}
