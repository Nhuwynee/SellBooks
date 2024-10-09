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
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.book_list_item, parent, false);
            holder = new ViewHolder();
            holder.tvTitle = convertView.findViewById(R.id.book_title);
            holder.tvAuthor = convertView.findViewById(R.id.book_author);
            holder.tvPrice = convertView.findViewById(R.id.book_price);
            holder.tvStatus = convertView.findViewById(R.id.book_status);
            holder.imgCover = convertView.findViewById(R.id.image_book);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Contact_listbook book = bookList.get(position);
        holder.tvTitle.setText(book.getTitle());
        holder.tvAuthor.setText(book.getAuthor());
        holder.tvPrice.setText(book.getPrice());
        holder.tvStatus.setText(book.getStatus());
        holder.imgCover.setImageResource(book.getCoverImageResource());

        return convertView;
    }

    static class ViewHolder {
        TextView tvTitle;
        TextView tvAuthor;
        TextView tvPrice;
        TextView tvStatus;
        ImageView imgCover;
    }
}
