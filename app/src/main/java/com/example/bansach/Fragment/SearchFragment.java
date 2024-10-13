package com.example.bansach.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.BookAdapter_search;
import com.example.bansach.R;
import com.example.bansach.model.Book;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    private BookAdapter_search bookAdapter;
    private SearchView search;
    private TextView tvNoResults;
    List<Book> bookList1 = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_search, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewBooks);
        search = view.findViewById(R.id.etSearch);
        tvNoResults = view.findViewById(R.id.tvNoResults);

        // Khởi tạo danh sách sách
        book();

        // Đặt listener cho SearchView
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d("SearchFragment", "onQueryTextSubmit: " + s); // Kiểm tra giá trị của s
                searchInBookList(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("SearchFragment", "onQueryTextChange: " + s); // Kiểm tra giá trị của s
                searchInBookList(s);
                return true;
            }
        });

        return view; // Trả về view đã được khởi tạo
    }

    private void book() {
        // Khởi tạo danh sách sách (Dữ liệu cứng)
        bookList1.add(new Book("Hồng Lục", R.drawable.hong_luc, 129000));
        bookList1.add(new Book("Bong bóng anh đào", R.drawable.bong_bong_anh_dao, 130000));
        bookList1.add(new Book("Văn học Việt Nam", R.drawable.vhvn1, 131000));
        bookList1.add(new Book("Một quả táo", R.drawable.mot_qua_tao, 129000));
        bookList1.add(new Book("Phía sau nghi can X", R.drawable.tt4, 130000));
        bookList1.add(new Book("Truyện Kiều", R.drawable.vhvn5, 131000));
        bookList1.add(new Book("Nhất kính tinh yêu", R.drawable.nhat_kinh_tinh_yeu, 130000));
        bookList1.add(new Book("Này đừng có ăn cỏ", R.drawable.nay_dung_co_an_co, 131000));

        // Thiết lập adapter cho RecyclerView
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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3); // 3 cột
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(bookAdapter);
    }

    private void searchInBookList(String search) {
        List<Book> resultBooks = new ArrayList<>(); // Tạo danh sách kết quả
        if (search == null || search.isEmpty()) { // Kiểm tra nếu search là null hoặc rỗng
            return; // Không làm gì nếu không có từ khóa tìm kiếm
        }

        // Duyệt qua danh sách dữ liệu cứng bookList
        for (Book b : bookList1) { // Duyệt qua bookList1
            String title = b.getTitle();
            String author = b.getAuthor();

            // Kiểm tra xem title và author có null không trước khi gọi toLowerCase()
            if ((title != null && title.toLowerCase().contains(search.toLowerCase())) ||
                    (author != null && author.toLowerCase().contains(search.toLowerCase()))) {
                resultBooks.add(b); // Thêm vào danh sách kết quả
            }
        }

        // Cập nhật bookAdapter với danh sách tìm kiếm mới
        bookAdapter = new BookAdapter_search(resultBooks, new BookAdapter_search.OnBookClickListener() {
            @Override
            public void onBookClick(Book book) {
                // Chuyển đến ViewBookFragment khi click vào sách
                ViewBookFragment viewBookFragment = new ViewBookFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, viewBookFragment)
                        .commit();
            }
        });

        // Thiết lập RecyclerView
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3); // 3 cột
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(bookAdapter);

        // Kiểm tra danh sách kết quả và hiển thị thông báo nếu cần
        if (resultBooks.isEmpty()) {
            tvNoResults.setVisibility(View.VISIBLE); // Hiện thông báo
            recyclerView.setVisibility(View.GONE); // Ẩn RecyclerView
        } else {
            tvNoResults.setVisibility(View.GONE); // Ẩn thông báo
            recyclerView.setVisibility(View.VISIBLE); // Hiện RecyclerView
        }
    }

}

