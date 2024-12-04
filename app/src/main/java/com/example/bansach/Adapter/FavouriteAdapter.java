
package com.example.bansach.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bansach.R;
import com.example.bansach.model.Cart;

import java.util.List;
public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.BookViewHolder> {

    private Context context;
    private OnBookClickListener listener;
    private OnBookDeleteListener deleteListener;
    private final List<Cart> bookList;

    public interface OnBookClickListener {
        void onBookClick(Cart book);
    }
    public interface OnBookDeleteListener {
        void onBookDelete(Cart book, int position);

    }
    public FavouriteAdapter(List<Cart> bookList, Context context, OnBookClickListener favouriteBookFragment, OnBookDeleteListener deleteListener) {
        this.bookList = bookList;
        this.context = context;
        this.deleteListener = deleteListener;
    }
    public FavouriteAdapter(List<Cart> bookList) {
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
        Cart book = bookList.get(position);

        holder.bookTitle.setText(book.getTitle());

        String imageName = book.getImgResource();
        if (imageName != null && !imageName.isEmpty()) {
            if (imageName.endsWith(".jpg") || imageName.endsWith(".png")) {
                imageName = imageName.substring(0, imageName.length() - 4);
            }

            int resId = holder.itemView.getContext().getResources().getIdentifier(
                    imageName, "drawable", holder.itemView.getContext().getPackageName()
            );
            Glide.with(holder.itemView.getContext())
                    .load(resId)
                    .into(holder.bookImage);
        }

        holder.bookPrice.setText(String.valueOf(book.getPrice()));
        holder.bookAuthor.setText(String.valueOf(book.getAuthor()));
        holder.bookPoint.setText(String.valueOf(book.getPoint()));

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
        public TextView bookTitle;
        public ImageView bookImage;
        public TextView bookPrice;
        public TextView bookAuthor;
        public TextView bookPoint;
        public Button buttonDelete;

        public BookViewHolder(View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookImage = itemView.findViewById(R.id.book_img);
            bookPrice = itemView.findViewById(R.id.book_price);
            bookAuthor = itemView.findViewById(R.id.book_author);
            bookPoint = itemView.findViewById(R.id.textPoint);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
    public void updateBooks(List<Cart> newBooks) {
        bookList.clear();
        bookList.addAll(newBooks);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        bookList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, bookList.size());
    }
}







