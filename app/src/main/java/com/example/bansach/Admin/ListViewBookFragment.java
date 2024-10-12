package com.example.bansach.Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.CartAdapter;
import com.example.bansach.Adapter.ListViewBookAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListViewBookFragment extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListViewBookAdapter adapter;
    private List<Book> bookList;
    private CartAdapter cartAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_book);}

//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.listview_book, container, false); // Thay 'fragment_home' bằng tên layout thực tế
//
////        // Khởi tạo các view
////        recyclerView = view.findViewById(R.id.recyclerView_addbook);
////        bookList = new ArrayList<>();
////        bookList.add(new Book("Bong bóng anh đào", "Tê Kiến", 200000, "Hoạt động", R.drawable.bong_bong_anh_dao));
////        bookList.add(new Book("Hồng lục", "Kiểm Diệp Tử", 170000, "Hoạt động", R.drawable.hong_luc));
//
//        return view;
//
//    }
}