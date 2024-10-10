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

import com.example.bansach.Adapter.Listview_bookAdapter;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

public class listview_book extends Fragment {

    private RecyclerView recyclerView;
    private Listview_bookAdapter adapter;
    private List<Book> bookList;
    private CartAdapter cartAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listview_book, container, false); // Thay 'fragment_home' bằng tên layout thực tế

        // Khởi tạo các view
        recyclerView = view.findViewById(R.id.recyclerView_addbook);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        bookList = new ArrayList<>();
        bookList.add(new Book("Bong bóng anh đào", "Tê Kiến", 200000, "Hoạt động", R.drawable.bong_bong_anh_dao));
        bookList.add(new Book("Hồng lục", "Kiểm Diệp Tử", 170000, "Hoạt động", R.drawable.hong_luc));

        return view; // Trả về view đã được khởi tạo

    }
}