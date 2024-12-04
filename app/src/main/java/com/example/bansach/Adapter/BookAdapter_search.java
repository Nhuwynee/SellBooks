package com.example.bansach.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bansach.R;
import com.example.bansach.model.Book1;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter_search extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{
    private List<Book1> bookList;
    private OnBookClickListener listener;
    private List<Book1> filteredBookList;  // Danh sách đã lọc
    private Context context;

    public BookAdapter_search(List<Book1> bookList, Context context,OnBookClickListener listener) {
        this.bookList = bookList;
        this.filteredBookList = new ArrayList<>(bookList); // Khởi tạo với dữ liệu gốc
        this.context = context;
        this.listener = listener;
    }

    public BookAdapter_search(Context context, List<Book1> bookList) {
        this.context = context;
        this.bookList = new ArrayList<>(bookList);
    }


    public interface OnBookClickListener {
        void onBookClick(Book1 book);
    }
    public BookAdapter_search(List<Book1> bookList, OnBookClickListener listener) {
        this.bookList = bookList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookAdapter.BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.BookViewHolder holder, int position) {
        Book1 book = bookList.get(position);
        holder.bookTitle.setText(book.getTitle());
        holder.bookPrice.setText(String.valueOf(book.getPrice()));

        String imageName = book.getImgResource();
        Log.d("ImageLoader", "Original Image Name: " + imageName); // Log tên gốc của ảnh

        if (imageName != null) {
            if (imageName.endsWith(".jpg")) {
                imageName = imageName.substring(0, imageName.length() - 4);
            } else if (imageName.endsWith(".png")) {
                imageName = imageName.substring(0, imageName.length() - 4);
            }

            Log.d("ImageLoader", "Processed Image Name: " + imageName); // Log tên ảnh sau khi xử lý

            int resId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
            Log.d("ImageLoader", "Resource ID: " + resId); // Log ID của tài nguyên ảnh

            if (resId != 0) {
                Glide.with(context)
                        .load(resId)
                        .error(R.drawable.hello) // Ảnh dự phòng nếu không tìm thấy
                        .into(holder.bookImage);
            } else {
                Log.e("ImageLoader", "Resource not found for: " + imageName);
                holder.bookImage.setImageResource(R.drawable.hello); // Ảnh dự phòng nếu không tìm thấy
            }
        } else {
            Log.e("ImageLoader", "Image name is null");
            holder.bookImage.setImageResource(R.drawable.hello); // Nếu `imgResource` null
        }


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
        public TextView bookTitle;
        public ImageView bookImage;
        public TextView bookPrice;

        public BookViewHolder(View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.bookTitle1);
            bookImage = itemView.findViewById(R.id.bookImage1);
            bookPrice = itemView.findViewById(R.id.book_price);
        }
    }
    public void updateBooks(List<Book1> newBooks) {
        bookList.clear();
        bookList.addAll(newBooks);
        notifyDataSetChanged();
    }



}
