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

import com.bumptech.glide.Glide;
import com.example.bansach.R;
import com.example.bansach.model.Book;
import com.example.bansach.model.Book1;

import java.util.List;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.BookViewHolder> {

    private final List<Book1> bookList;
    private OnBookClickListener listener;
    private OnBookClickListener deleteListener;


    public interface OnBookClickListener {
//        void onBookClick(Book book);

        void onBookClick(Book1 book);

//        void onBookDelete(Book1 book, int position);
    }
    public interface OnBookDeleteListener {
        void onBookDelete(Book book, int position);  // Dùng cho việc xóa sách
    }


//    public AudioAdapter(List<Book1> bookList, OnBookClickListener listener, OnBookClickListener deleteListener) {
//        this.bookList = bookList;
//        this.listener = listener;
//        this.deleteListener = deleteListener;
//    }
    public AudioAdapter(List<Book1> bookList, OnBookClickListener listener) {
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
        Book1 book = bookList.get(position);

        // Set các thông tin sách
        holder.bookTitle.setText(book.getTitle());
        holder.bookAuthor.setText(book.getAuthor());
        holder.bookPrice.setText(String.format("%.0f VND", book.getPrice()));
        holder.bookStatus.setText(book.getIsActive());

        // Lấy tên tài nguyên ảnh và xử lý phần mở rộng nếu có
        String imageName = book.getImgResource();
        if (imageName != null && (imageName.endsWith(".jpg") || imageName.endsWith(".png"))) {
            imageName = imageName.substring(0, imageName.lastIndexOf('.'));  // Loại bỏ phần mở rộng
        }

        // Lấy ID tài nguyên từ tên
        int resId = holder.itemView.getContext().getResources().getIdentifier(imageName, "drawable", holder.itemView.getContext().getPackageName());

        // Kiểm tra xem ID tài nguyên có hợp lệ không
        if (resId != 0) {
            // Sử dụng Glide để tải ảnh
            Glide.with(holder.itemView.getContext())
                    .load(resId)
                   // Hình ảnh khi tải không thành công
                    .into(holder.bookImage);
        }

        // Set listener cho nút play
        holder.audioPlayButton.setOnClickListener(v -> {
            if (book.getIsActive().equals("Hoạt động")) {
                // Logic để phát audio
            } else {
                // Thông báo cho người dùng nếu sách không hoạt động
            }
        });

        // Set listener cho item click
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
        public ImageView bookImage;
        public Button buttonDeleteAudio;
        ImageButton audioPlayButton;


        public BookViewHolder(View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.book_title1);
            bookAuthor = itemView.findViewById(R.id.book_author1);
            bookPrice = itemView.findViewById(R.id.book_price1);
            bookStatus = itemView.findViewById(R.id.book_status1);
            bookImage = itemView.findViewById(R.id.image_book1);
            audioPlayButton = itemView.findViewById(R.id.audio_play_button1);
            buttonDeleteAudio = itemView.findViewById(R.id.buttonDelete_audio1);
        }
    }

    public void removeItem(int position) {
        bookList.remove(position);
        notifyItemRemoved(position);
    }
}
