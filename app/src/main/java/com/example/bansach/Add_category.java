package com.example.bansach;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.CategoryAdapter;
import com.example.bansach.model.Book;


import java.util.ArrayList;
import java.util.List;

public class Add_category extends AppCompatActivity {

    private RecyclerView recyclerViewCategories;
    private CategoryAdapter categoryAdapter;
    private List<Book> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        // Khởi tạo RecyclerView
        recyclerViewCategories = findViewById(R.id.recyclerViewCategories);

        // Khởi tạo dữ liệu danh mục
        categoryList = new ArrayList<>();
        categoryList.add(new Book("Văn Học"));
        categoryList.add(new Book("Lập trình"));
        categoryList.add(new Book("Giáo dục "));
        categoryList.add(new Book("Tâm lý "));
        categoryList.add(new Book("Thiếu nhi "));
        categoryList.add(new Book("Khoa học "));

        // Khởi tạo Adapter
        categoryAdapter = new CategoryAdapter(categoryList);

        // Thiết lập LayoutManager cho RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewCategories.setLayoutManager(layoutManager);

        // Gán adapter cho RecyclerView
        recyclerViewCategories.setAdapter(categoryAdapter);
    }
}
