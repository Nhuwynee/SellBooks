package com.example.bansach;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbarmhchinh;
    ViewFlipper viewFlipper;
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private List<Book> bookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addImagesToFlipper();
        book();

    }

    private void addImagesToFlipper() {
        viewFlipper = findViewById(R.id.viewflipper);

        try {
            // Mảng chứa các ảnh trong thư mục drawable
            int[] images = {R.drawable.boconcagai, R.drawable.bongdembatxichmon, R.drawable.chinhphuchanhphuc2, R.drawable.mbabanghinh};

            // Thêm từng ảnh vào ViewFlipper
            for (int image : images) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(image); // Đặt ảnh cho ImageView
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); // Thiết lập kiểu hiển thị
                viewFlipper.addView(imageView); // Thêm ImageView vào ViewFlipper
            }

            // Bắt đầu lật ảnh
            viewFlipper.setFlipInterval(2000); // Lật mỗi 2 giây
            viewFlipper.setAutoStart(true); // Tự động bắt đầu
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý lỗi hoặc thông báo lỗi nếu cần
        }
    }
private void book() {
    recyclerView = findViewById(R.id.recyclerView);

    // Khởi tạo dữ liệu sách
    bookList = new ArrayList<>();
    bookList.add(new Book("Book 1", R.drawable.vhvn1,129000));
    bookList.add(new Book("Book 2", R.drawable.vhvn2,150000));
    bookList.add(new Book("Book 3", R.drawable.vhvn3,185000));
    bookList.add(new Book("Book 4", R.drawable.vhvn4,74000));
    bookList.add(new Book("Book 5", R.drawable.vhvn5,55000));
    bookList.add(new Book("Book 6", R.drawable.vhvn6,186000));
    bookList.add(new Book("Book 7", R.drawable.vhvn7,117000));
    bookList.add(new Book("Book 8", R.drawable.vhvn8,99000));
    // Khởi tạo adapter
    bookAdapter = new BookAdapter(bookList);

    // Thiết lập LinearLayoutManager với hướng ngang
    LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(bookAdapter);
}

}
