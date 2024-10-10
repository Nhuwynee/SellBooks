package com.example.bansach;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.Listview_bookAdapter;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Listview_bookAdapter adapter;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_book);

        recyclerView = findViewById(R.id.recyclerView_addbook);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bookList = new ArrayList<>();
        bookList.add(new Book("Bong bóng anh đào", "Tê Kiến", 200000, "Hoạt động", R.drawable.bong_bong_anh_dao));
        bookList.add(new Book("Hồng lục", "Kiểm Diệp Tử", 170000, "Hoạt động", R.drawable.hong_luc));


        adapter = new Listview_bookAdapter(bookList);
        recyclerView.setAdapter(adapter);
    }
}
