package com.example.bansach.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bansach.R;
import com.example.bansach.model.Contact_listbook;
import com.example.bansach.model.Contact_listbook;

import java.util.List;

public class Listview_bookAdapter extends BaseAdapter {
    private Context context;
    private List<Contact_listbook> bookList;

    public Listview_bookAdapter(Context context, List<Contact_listbook> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_book, parent, false);
        }

        // Get the current Contact object
        Contact_listbook book = bookList.get(position);

        // Bind the data to the views
        TextView tvTitle = convertView.findViewById(R.id.book_title);
        TextView tvAuthor = convertView.findViewById(R.id.book_author);
        TextView tvPrice = convertView.findViewById(R.id.book_price);
        TextView tvStatus = convertView.findViewById(R.id.book_status);
        ImageView imgCover = convertView.findViewById(R.id.book_image);

        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());
        tvPrice.setText(book.getPrice());
        tvStatus.setText(book.getStatus());
        imgCover.setImageResource(book.getCoverImageResource());

        return convertView;
    }
}
