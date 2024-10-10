package com.example.bansach;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.CartAdapter;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);
    }

    private void book() {
        // recyclerView = findViewById(R.id.recyclerView); Nếu ở MainActivity
        recyclerView = recyclerView.findViewById(R.id.recyclerView);

        bookList = new ArrayList<>();
        bookList.add(new Book("Hồng Lục", R.drawable.hong_luc, 225000, "Kim Diệp Tử"));
        bookList.add(new Book("Nhật ký tình yêu", R.drawable.nhat_kinh_tinh_yeu, 175000, "Mark Twain"));
        bookList.add(new Book("Bong bóng anh đào", R.drawable.bong_bong_anh_dao, 250000, "Tê Kiến"));
        bookList.add(new Book("Này đừng có ăn cỏ", R.drawable.nay_dung_co_an_co, 174000, "Nguyễn Nhật Ánh"));
        bookList.add(new Book("Này chớ làm loạn", R.drawable.nay_cho_lam_loan, 100000, "Phạm Nhật An"));
        bookList.add(new Book("Tình yêu của thời hạ", R.drawable.tinh_yeu_cua_thoi_ha, 186000, "Lê Minh Đạt"));
        bookList.add(new Book("Tóc của tôi", R.drawable.toc_cua_toi, 117000, "Lưu Thị Lan"));
        bookList.add(new Book("Vợ nhặt", R.drawable.vhvn1, 99000, "Nguyễn Nhật Ánh"));

        // Khởi tạo adapter
        cartAdapter = new CartAdapter(bookList);

        // Thiết lập LinearLayoutManager với hướng ngang
       // LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false); Nếu ở MainActivity
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cartAdapter);
    }
}
