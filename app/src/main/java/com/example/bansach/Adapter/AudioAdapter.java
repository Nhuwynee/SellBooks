package com.example.bansach.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.R;
import com.example.bansach.model.Book;

import java.util.List;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.BookViewHolder> {

    private final List<Book> bookList;
    private final OnBookClickListener listener;

    public interface OnBookClickListener {
        void onBookClick(Book book);
    }

    public interface OnBookDeleteListener {
        void onBookDelete(Book book, int position);
    }

    public AudioAdapter(List<Book> bookList, OnBookClickListener listener) {
        this.bookList = bookList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_audio, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = bookList.get(position);

        holder.bookTitle.setText(book.getTitle());
        holder.bookAuthor.setText(book.getAuthor());
        holder.bookPrice.setText(String.format("%.0f VND", book.getPrice()));
        holder.bookStatus.setText(book.getIsActive());

        holder.bookImage.setImageResource(book.getImgResource());

        // Set the play button click listener
        holder.audioPlayButton.setOnClickListener(v -> {
            if (book.getIsActive().equals("Hoạt động")) {
                // Logic to play audio goes here
            } else {
                // Optionally inform the user that the book is not active
            }
        });

        // Set item click listener
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onBookClick(book);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView bookTitle, bookAuthor, bookPrice, bookStatus;
        ImageView bookImage;
        public Button buttonDeleteAudio;
        ImageButton audioPlayButton;


        public BookViewHolder(View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookAuthor = itemView.findViewById(R.id.book_author);
            bookPrice = itemView.findViewById(R.id.book_price);
            bookStatus = itemView.findViewById(R.id.book_status);
            bookImage = itemView.findViewById(R.id.image_book);
            audioPlayButton = itemView.findViewById(R.id.audio_play_button);
            buttonDeleteAudio = itemView.findViewById(R.id.buttonDelete_audio);
        }
    }

    public void removeItem(int position) {
        bookList.remove(position);
        notifyItemRemoved(position);
    }
}
