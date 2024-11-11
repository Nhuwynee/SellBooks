package com.example.bansach.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.BookAdapter_search;
import com.example.bansach.FogotPassPage;
import com.example.bansach.LoginMainPage;
import com.example.bansach.R;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
    List<Book> bookList1 = new ArrayList<>();
    List<Book> filteredBookList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BookAdapter_search bookAdapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_category, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewBooks);
        book();
        Spinner spinner = view.findViewById(R.id.spinner1);
        // Danh sách các tùy chọn cho Spinner
        String[] options = {"All", "Ngôn tình", "Trinh thám", "Văn học Việt Nam"};

        // Tạo ArrayAdapter để liên kết dữ liệu với Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.item_list_filter, options);
        adapter.setDropDownViewResource(R.layout.item_filter);

        // Gắn Adapter vào Spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Button category = getView().findViewById(R.id.text_category1);
                String selectedItem = parent.getItemAtPosition(position).toString();
                category.setText(selectedItem);
                filterBooksByGenre(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không làm gì nếu không có mục nào được chọn
            }
        });
        return view;
    }
    private void book() {
        // Khởi tạo danh sách sách (Dữ liệu cứng)
        bookList1.add(new Book("Hồng Lục", R.drawable.hong_luc, 129000, "Ngôn tình"));
        bookList1.add(new Book("Bong bóng anh đào", R.drawable.bong_bong_anh_dao, 130000, "Ngôn tình"));
        bookList1.add(new Book("Vợ nhặt", R.drawable.vhvn1, 131000, "Văn học Việt Nam"));
        bookList1.add(new Book("Một quả táo", R.drawable.mot_qua_tao, 129000, "Trinh thám"));
        bookList1.add(new Book("Phía sau nghi can X", R.drawable.tt4, 130000, "Trinh thám"));
        bookList1.add(new Book("Truyện Kiều", R.drawable.vhvn5, 131000, "Văn học Việt Nam"));
        bookList1.add(new Book("Nhất kính tinh yêu", R.drawable.nhat_kinh_tinh_yeu, 130000, "Ngôn tình"));
        bookList1.add(new Book("Này đừng có ăn cỏ", R.drawable.nay_dung_co_an_co, 131000, "Ngôn tình"));
        filteredBookList.addAll(bookList1);

        // Thiết lập adapter cho RecyclerView
        bookAdapter = new BookAdapter_search(filteredBookList, new BookAdapter_search.OnBookClickListener() {
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
    private void filterBooksByGenre(String genre) {
        filteredBookList.clear(); // Xóa danh sách đã lọc

        // Kiểm tra thể loại "All" để hiển thị tất cả sách
        if (genre.equalsIgnoreCase("All")) {
            filteredBookList.addAll(bookList1); // Hiển thị tất cả sách
        } else {
            for (Book b : bookList1) {
                String category = b.getCategory();
                // Chỉ thêm sách nếu thể loại khớp
                if (category.equalsIgnoreCase(genre)) {
                    filteredBookList.add(b);
                }
            }
        }

        // Cập nhật adapter với danh sách kết quả
        bookAdapter.notifyDataSetChanged(); // Cập nhật dữ liệu trong adapter
    }


}
