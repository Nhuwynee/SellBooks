package com.example.bansach;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.BookAdapter;
import com.example.bansach.Adapter.BookAdapter_search;
import com.example.bansach.Adapter.ParentAdapter;
import com.example.bansach.Fragment.ViewBookFragment;
import com.example.bansach.model.Book;
import com.example.bansach.model.Section;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends Fragment {
    private RecyclerView recyclerView;
    private BookAdapter_search bookAdapter;
    private BottomNavigationView bottomNavigationView;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_search, container, false); // Thay 'fragment_home' bằng tên layout thực tế

        // Khởi tạo các view
        recyclerView = view.findViewById(R.id.recyclerViewBooks);
        // Gọi các hàm để thiết lập dữ liệu

    book();
        return view; // Trả về view đã được khởi tạo
    }
    private void book() {

        // Section 1 - Tiểu thuyết
        List<Book> bookList1 = new ArrayList<>();
        bookList1.add(new Book("Hồng Lục", R.drawable.hong_luc, 129000));
        bookList1.add(new Book("Bong bóng anh đào", R.drawable.bong_bong_anh_dao, 130000));
        bookList1.add(new Book("Văn học Việt Nam", R.drawable.vhvn1, 131000));
        bookList1.add(new Book("Một quả táo", R.drawable.mot_qua_tao, 129000));
        bookList1.add(new Book("Phía sau nghi can X", R.drawable.tt4, 130000));
        bookList1.add(new Book("Truyện Kiều", R.drawable.vhvn5, 131000));
        bookList1.add(new Book("Nhất kính tinh yêu", R.drawable.nhat_kinh_tinh_yeu, 130000));
        bookList1.add(new Book("Này đừng có ăn cỏ", R.drawable.nay_dung_co_an_co, 131000));
        // Thêm các sách khác tương tự...


        bookAdapter = new BookAdapter_search(bookList1, new BookAdapter_search.OnBookClickListener() {
            @Override
            public void onBookClick(Book book) {
                // Chuyển đến ViewBookFragment khi click vào sách
                ViewBookFragment viewBookFragment = new ViewBookFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, viewBookFragment)
                        .commit();
            }
        });


        // Thiết lập adapter cho RecyclerView cha
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3); // 3 cột
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(bookAdapter);
    }
//
}
