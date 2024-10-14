package com.example.bansach.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.FavouriteAdapter;
import com.example.bansach.FogotPassPage;
import com.example.bansach.LoginMainPage;
import com.example.bansach.R;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

public class FavouriteBookFragment extends Fragment {
    private RecyclerView recyclerView;
    private FavouriteAdapter favouriteAdapter;
    private List<Book> bookList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_favourite_book, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_favourite);
        book(); // Khởi tạo dữ liệu

        return view; // Trả về view đã tạo
    }

    private void book() {
        // Khởi tạo dữ liệu sách
        bookList = new ArrayList<>();
        bookList.add(new Book("Hồng Lục", R.drawable.hong_luc, 225000f, "Kim Diệp Tử", "2000 ★"));
        bookList.add(new Book("Nhật ký tình yêu", R.drawable.nhat_kinh_tinh_yeu, 175000f, "Mark Twain", "2500 ★"));
        bookList.add(new Book("Bong bóng anh đào", R.drawable.bong_bong_anh_dao, 250000f, "Tê Kiến", "1000 ★"));
        bookList.add(new Book("Này đừng có ăn cỏ", R.drawable.nay_dung_co_an_co, 174000f, "Nguyễn Nhật Ánh","2000 ★"));
        bookList.add(new Book("Này chớ làm loạn", R.drawable.nay_cho_lam_loan, 100000f, "Phạm Nhật An", "4000 ★"));
        bookList.add(new Book("Tình yêu của thời hạ", R.drawable.tinh_yeu_cua_thoi_ha, 186000f, "Lê Minh Đạt", "3500 ★"));
        bookList.add(new Book("Tóc của tôi", R.drawable.toc_cua_toi, 117000f, "Lưu Thị Lan", "2200 ★"));
        bookList.add(new Book("Vợ nhặt", R.drawable.vhvn1, 99000f, "Nguyễn Nhật Ánh", "1500 ★"));

        favouriteAdapter = new FavouriteAdapter(bookList, new FavouriteAdapter.OnFavouriteClickListener() {
            @Override
            public void onFavouriteList(Book book) {
                ViewBookFragment viewBookFragment = new ViewBookFragment();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, viewBookFragment)
                        .addToBackStack(null) // Thêm vào back stack nếu cần
                        .commit();
            }
        });        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(favouriteAdapter);

    }
}