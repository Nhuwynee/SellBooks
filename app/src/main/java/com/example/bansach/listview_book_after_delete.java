package com.example.bansach;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.Adapter.Listview_bookAdapter;
import com.example.bansach.model.Contact_listbook;

import java.util.ArrayList;
import java.util.List;

public class listview_book_after_delete extends AppCompatActivity {

    private ListView listViewBooks;
    private Listview_bookAdapter adapter;
    private List<Contact_listbook> contactListBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_book);

        initializeViews();
        loadBookData();
        setupAdapter();
    }

    private void initializeViews() {
        listViewBooks = findViewById(R.id.lvContact);
    }

    private void loadBookData() {
        contactListBooks = new ArrayList<>();
        addBooksToList();
    }

    private void addBooksToList() {
        contactListBooks.add(new Contact_listbook("Hồng lục", "Kiểm Diệp Tử", "170.000 VND", "Hoạt động", R.drawable.hong_luc));
        contactListBooks.add(new Contact_listbook("Này đừng có ăn cỏ!", "Lục Lục", "150.000 VND", "Hoạt động", R.drawable.nay_dung_co_an_co));
        contactListBooks.add(new Contact_listbook("Nhật kính tình yêu", "Tống Cầu Cẩn", "250.000 VND", "Hoạt động", R.drawable.nhat_kinh_tinh_yeu));
        contactListBooks.add(new Contact_listbook("Này chờ làm loạn", "Minh Nguyệt", "150.000 VND", "Hoạt động", R.drawable.nay_cho_lam_loan));
        contactListBooks.add(new Contact_listbook("Án mộng mười một chữ", "Hagashino Keigo", "200.000 VND", "Hoạt động", R.drawable.chinhphuchanhphuc));
        contactListBooks.add(new Contact_listbook("Chí Phèo", "Nam Cao", "120.000 VND", "Hoạt động", R.drawable.chipheo));
        contactListBooks.add(new Contact_listbook("Tắt đèn", "Ngô Tất Tố", "130.000 VND", "Hoạt động", R.drawable.tatden));
        contactListBooks.add(new Contact_listbook("Thao túng tâm lý", "Shannon Thomas", "250.000 VND", "Hoạt động", R.drawable.thaotungtamly));
        contactListBooks.add(new Contact_listbook("Vợ Nhặt", "Kim Lân", "90.000 VND", "Hoạt động", R.drawable.vonhat));
    }

    private void setupAdapter() {
        adapter = new Listview_bookAdapter(this, contactListBooks);
        listViewBooks.setAdapter(adapter);
    }
}
