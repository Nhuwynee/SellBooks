package com.example.bansach.Adapter;

import android.content.Context;
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
import com.example.bansach.model.Cart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.BookViewHolder> {
    private Context context;

    private final List<Cart> bookList; // Đã thêm final ở đây

    public CartAdapter(List<Cart> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
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

        holder.bookPrice.setText(String.valueOf(book.getPrice()));
        holder.bookAuthor.setText(String.valueOf(book.getAuthor()));
        holder.bookPoint.setText(String.valueOf(book.getPoint()));
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
    public void updateBooks(List<Cart> newBooks) {
        bookList.clear();
        bookList.addAll(newBooks);
        notifyDataSetChanged();
    }
}
