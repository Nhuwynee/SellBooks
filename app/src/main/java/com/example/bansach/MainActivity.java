package com.example.bansach;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;
import android.widget.ViewFlipper;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.BookAdapter;
import com.example.bansach.Adapter.ParentAdapter;
import com.example.bansach.Adapter.TextAdapter;
import com.example.bansach.model.Book;
import com.example.bansach.model.Section;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbarmhchinh;
    ViewFlipper viewFlipper;
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private List<Book> bookList;
    private RecyclerView recyclerViewParent;
    private ParentAdapter parentAdapter;
    private List<Section> sectionList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.trang_chu);

//        setContentView(R.layout.activity_main);
//        addImagesToFlipper();
//        book();
//        Button signupButton = findViewById(R.id.signup_button);
//        Button loginButton = findViewById(R.id.login_button);
//        signupButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Sử dụng Intent để chuyển sang SignupActivity
//                Intent intent = new Intent(MainActivity.this, signup.class);
//                startActivity(intent);  // Bắt đầu SignupActivity
//            }
//        });
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Sử dụng Intent để chuyển sang SignupActivity
//                Intent intent = new Intent(MainActivity.this, login_main.class);
//                startActivity(intent);  // Bắt đầu SignupActivity
//            }
//        });


     addImagesToFlipper();
     category();
        book();
    }
    private void addImagesToFlipper() {
        viewFlipper = findViewById(R.id.viewflipper);
        try {
            int[] images = {R.drawable.hong_luc, R.drawable.tinh_yeu_cua_thoi_ha, R.drawable.nay_dung_co_an_co, R.drawable.toc_cua_toi};

            for (int image : images) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(image);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(2000);
            viewFlipper.setAutoStart(true); // Bắt đầu tự động
            viewFlipper.startFlipping(); // Bắt đầu lật ảnh

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//        book();
//        setContentView(R.layout.login1);
//        Button signupButton = findViewById(R.id.signup_button);
//        Button loginButton = findViewById(R.id.login_button);
//        signupButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Sử dụng Intent để chuyển sang SignupActivity
//                Intent intent = new Intent(MainActivity.this, signup.class);
//                startActivity(intent);  // Bắt đầu SignupActivity
//            }
//        });
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Sử dụng Intent để chuyển sang SignupActivity
//                Intent intent = new Intent(MainActivity.this, login_main.class);
//                startActivity(intent);  // Bắt đầu SignupActivity
//            }
//        });

    private void category() {

        RecyclerView recyclerView1 = findViewById(R.id.recyclerView1);

        // Tạo danh sách sách cho mỗi RecyclerView
        List<String> bookList1 = new ArrayList<>();

        // Thêm dữ liệu vào các danh sách sách
        bookList1.add("Tiểu thuyết");
        bookList1.add("Văn học Việt Nam");
        bookList1.add("Trinh thám");
        bookList1.add("Ngôn tình");

        TextAdapter textAdapter = new TextAdapter(bookList1);

        // Thiết lập LinearLayoutManager cho từng RecyclerView
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);


        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setAdapter(textAdapter);


    }
    private void book() {
        recyclerViewParent = findViewById(R.id.recyclerView2);

        // Tạo danh sách section
        sectionList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Book> bookList = new ArrayList<>();
            // Thêm sách vào bookList
            for (int j = 0; j < 8; j++) {
                bookList.add(new Book("Book " + (j + 1), R.drawable.nhat_kinh_tinh_yeu, 129000 + (j * 1000)));
            }
            sectionList.add(new Section("Section " + (i + 1), bookList));
        }

        // Thiết lập adapter cho RecyclerView cha
        parentAdapter = new ParentAdapter(sectionList);
        recyclerViewParent.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewParent.setAdapter(parentAdapter);
    }

}
