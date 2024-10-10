package com.example.bansach;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

    public class CartPage extends Fragment {
        private RecyclerView recyclerView;
        private CartAdapter cartAdapter;
        private List<Book> bookList;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.cart_main, container, false);
            recyclerView = view.findViewById(R.id.recyclerView);
            book(); // Khởi tạo dữ liệu
            return view; // Trả về view đã tạo
        }

        private void book() {
            // Khởi tạo dữ liệu sách
            bookList = new ArrayList<>();
            bookList.add(new Book("Book 1", R.drawable.hong_luc, 129000, "Nguyễn Nhật Ánh"));
            bookList.add(new Book("Book 2", R.drawable.vhvn2, 150000, "Nguyễn Nhật Ánh"));
            bookList.add(new Book("Book 3", R.drawable.vhvn3, 185000, "Nguyễn Nhật Ánh"));
            bookList.add(new Book("Book 4", R.drawable.vhvn4, 74000, "Nguyễn Nhật Ánh"));
            bookList.add(new Book("Book 5", R.drawable.vhvn5, 55000, "Nguyễn Nhật Ánh"));
            bookList.add(new Book("Book 6", R.drawable.vhvn6, 186000, "Nguyễn Nhật Ánh"));
            bookList.add(new Book("Book 7", R.drawable.vhvn7, 117000, "Nguyễn Nhật Ánh"));
            bookList.add(new Book("Book 8", R.drawable.vhvn8, 99000, "Nguyễn Nhật Ánh"));
            Log.d("CartPage", "Số lượng sách: " + bookList.size()); // Kiểm tra kích thước

            cartAdapter = new CartAdapter(bookList);
            LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(cartAdapter);

        }
    }