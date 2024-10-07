package com.example.bansach;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

public class CartPage
{
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private List<Book> bookList;

    private void book() {
        recyclerView = recyclerView.findViewById(R.id.recyclerView);

        // Khởi tạo dữ liệu sách
        bookList = new ArrayList<>();
        bookList.add(new Book("Book 1", R.drawable.hong_luc,129000, "Nguyễn Nhật Ánh"));
        bookList.add(new Book("Book 2", R.drawable.vhvn2,150000, "Nguyễn Nhật Ánh"));
        bookList.add(new Book("Book 3", R.drawable.vhvn3,185000, "Nguyễn Nhật Ánh"));
        bookList.add(new Book("Book 4", R.drawable.vhvn4,74000, "Nguyễn Nhật Ánh"));
        bookList.add(new Book("Book 5", R.drawable.vhvn5,55000, "Nguyễn Nhật Ánh"));
        bookList.add(new Book("Book 6", R.drawable.vhvn6,186000, "Nguyễn Nhật Ánh"));
        bookList.add(new Book("Book 7", R.drawable.vhvn7,117000, "Nguyễn Nhật Ánh"));
        bookList.add(new Book("Book 8", R.drawable.vhvn8,99000, "Nguyễn Nhật Ánh"));

        cartAdapter = new CartAdapter(bookList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cartAdapter);
    }
}
