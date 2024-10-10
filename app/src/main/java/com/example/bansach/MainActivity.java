package com.example.bansach;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.Listview_bookAdapter;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Listview_bookAdapter adapter;
    private List<Book> bookList;

    FrameLayout frameLayout;
    TabLayout tabLayout;
    private Button btnFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login1);
        Button signupButton = findViewById(R.id.signup_button);
        Button loginButton = findViewById(R.id.login_button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sử dụng Intent để chuyển sang SignupActivity
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);  // Bắt đầu SignupActivity
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sử dụng Intent để chuyển sang SignupActivity
                Intent intent = new Intent(MainActivity.this, login_main.class);
                startActivity(intent);  // Bắt đầu SignupActivity
            }
        });}}
//        addImagesToFlipper();
//
//        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
//        tabLayout = (TabLayout) findViewById(R.id.tablayout);
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new AboutFragment())
//                .addToBackStack(null)
//                .commit();
//
//
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//                Fragment fragment = null;
//                switch (tab.getPosition()) {
//                    case 0:
//                        fragment = new AboutFragment();
//                        break;
//                    case 1:
//                        fragment = new ReviewFragment();
//                        break;
//                    case 2:
//                        fragment = new AuthorFragment();
//                        break;
//
//                }
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment)
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        .commit();
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }
//
//    private void addImagesToFlipper() {
//        viewFlipper = findViewById(R.id.viewflipper);
//        try {
//            int[] images = {R.drawable.hong_luc, R.drawable.hong_luc_2};
//
//            for (int image : images) {
//                ImageView imageView = new ImageView(this);
//                imageView.setImageResource(image);
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                viewFlipper.addView(imageView);
//            }
//            viewFlipper.setFlipInterval(2000);
//            viewFlipper.setAutoStart(true); // Bắt đầu tự động
//            viewFlipper.startFlipping(); // Bắt đầu lật ảnh
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

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
//    }


//    book1();
// Hiếu HEAD


//        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
//        tabLayout = (TabLayout) findViewById(R.id.tablayout);
//

//     addImagesToFlipper();
//        category();
//        book();


//    private void addImagesToFlipper() {
//        viewFlipper = findViewById(R.id.viewflipper);
//        try {
//            int[] images = {R.drawable.hong_luc, R.drawable.tinh_yeu_cua_thoi_ha, R.drawable.nay_dung_co_an_co, R.drawable.toc_cua_toi};
//        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new AboutFragment())
//                .addToBackStack(null)
//                .commit();
//
//
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//                Fragment fragment = null;
//                switch (tab.getPosition()) {
//                    case 0:
//                        fragment = new AboutFragment();
//                        break;
//                    case 1:
//                        fragment = new ReviewFragment();
//                        break;
//                    case 2:
//                        fragment = new AuthorFragment();
//                        break;
//
//                }
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment)
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        .commit();
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//

// HEAD

//     addImagesToFlipper();
//        book();
// ae997279018cdba21c67a962e1d1c7265c2e0cfb
//    }


// ----------------- Như
//        btnFrag = (Button) findViewById(R.id.btn_review);
//        btnFrag.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                replaceFragmentContent(new Fragment2());
//                Log.e("Replaced fragment", "2");
//            }
//        });
//
//        // initFragment();
//        replaceFragmentContent(new Fragment1());

//        addImagesToFlipper();
//        book();
//  }
//



//    private void category() {
//
//        RecyclerView recyclerView1 = findViewById(R.id.recyclerView1);
//
//        // Tạo danh sách sách cho mỗi RecyclerView
//        List<String> bookList1 = new ArrayList<>();
//
//        // Thêm dữ liệu vào các danh sách sách
//        bookList1.add("Tiểu thuyết");
//        bookList1.add("Văn học Việt Nam");
//        bookList1.add("Trinh thám");
//        bookList1.add("Ngôn tình");
//
//        TextAdapter textAdapter = new TextAdapter(bookList1);
//
//        // Thiết lập LinearLayoutManager cho từng RecyclerView
//        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//
//
//        recyclerView1.setLayoutManager(layoutManager1);
//        recyclerView1.setAdapter(textAdapter);
//
//
//    }
//


// HEAD
// ?

//    private void book() {
//        recyclerView = findViewById(R.id.recyclerView);
//
//        // Khởi tạo dữ liệu sách
//        bookList = new ArrayList<>();
//        bookList.add(new Book("Book 1", R.drawable.toc_cua_toi,129000));
//        bookList.add(new Book("Book 2", R.drawable.hong_luc,150000));
//        bookList.add(new Book("Book 3", R.drawable.bong_bong_anh_dao,185000));
//        bookList.add(new Book("Book 4", R.drawable.nay_dung_co_an_co,74000));
//        bookList.add(new Book("Book 5", R.drawable.nay_cho_lam_loan,55000));
//        bookList.add(new Book("Book 6", R.drawable.nhat_kinh_tinh_yeu,186000));
//        bookList.add(new Book("Book 7", R.drawable.mot_qua_tao,117000));
//        bookList.add(new Book("Book 8", R.drawable.tinh_yeu_cua_thoi_ha,99000));
//        // Khởi tạo adapter
//        bookAdapter = new BookAdapter(bookList);
//
//        // Thiết lập LinearLayoutManager với hướng ngang
//        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(bookAdapter);
//
//}

//
//    private void addImagesToFlipper() {
//        viewFlipper = findViewById(R.id.viewflipper);
//
//        try {
//            // Mảng chứa các ảnh trong thư mục drawable
//            int[] images = { R.drawable.bongdembatxichmon, R.drawable.chinhphuchanhphuc2, R.drawable.mbabanghinh};
//
//            // Thêm từng ảnh vào ViewFlipper
//            for (int image : images) {
//                ImageView imageView = new ImageView(viewFlipper.getContext());
//                imageView.setImageResource(image); // Đặt ảnh cho ImageView
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); // Thiết lập kiểu hiển thị
//                viewFlipper.addView(imageView); // Thêm ImageView vào ViewFlipper
//            }
//
//            // Bắt đầu lật ảnh
//            viewFlipper.setFlipInterval(2000); // Lật mỗi 2 giây
//            viewFlipper.setAutoStart(true); // Tự động bắt đầu
//            viewFlipper.startFlipping(); // Bắt đầu lật ảnh
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Xử lý lỗi hoặc thông báo lỗi nếu cần
//        }
//    }
//
//    private void book() {
//        recyclerView = findViewById(R.id.recyclerView);
//
//        // Khởi tạo dữ liệu sách
//        bookList = new ArrayList<>();
//        bookList.add(new Book("Book 1", R.drawable.vhvn1,129000));
//        bookList.add(new Book("Book 2", R.drawable.vhvn2,150000));
//        bookList.add(new Book("Book 3", R.drawable.vhvn3,185000));
//        bookList.add(new Book("Book 4", R.drawable.vhvn4,74000));
//        bookList.add(new Book("Book 5", R.drawable.vhvn5,55000));
//        bookList.add(new Book("Book 6", R.drawable.vhvn6,186000));
//        bookList.add(new Book("Book 7", R.drawable.vhvn7,117000));
//        bookList.add(new Book("Book 8", R.drawable.vhvn8,99000));
//        // Khởi tạo adapter
//        bookAdapter = new BookAdapter(bookList);
//
//        // Thiết lập LinearLayoutManager với hướng ngang
//        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(bookAdapter);
//    }

// ---------------------- Như
//    private void addFragment(Fragment fragment) {
//        FragmentManager fmgr = getSupportFragmentManager();
//        FragmentTransaction ft = fmgr.beginTransaction();
//        ft.add(R.id.container_body, fragment);
//        ft.addToBackStack(fragment.getClass().getSimpleName());
//        ft.commit();
//    }
//    private void initFragment() {
//        Fragment1 firstFragment = new Fragment1();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction ft = fragmentManager.beginTransaction();
//        ft.replace(R.id.container_body, firstFragment);
//        ft.commit();
//    }
//
//    private void replaceFragmentContent(Fragment fragment) {
//        if (fragment != null) {
//            FragmentManager fmgr = getSupportFragmentManager();
//            FragmentTransaction ft = fmgr.beginTransaction();
//            ft.replace(R.id.container_body, fragment);
//            ft.commit();
//
//        }
//    }


// =====================================



//    private void book1() {
//        recyclerView = findViewById(R.id.recyclerView);
//
//        // Khởi tạo dữ liệu sách
//        bookList = new ArrayList<>();
//        bookList.add(new Book("Nhật ký tình yêu tuổi học trò của yến như", R.drawable.hong_luc, 129000, "Nguyễn Nhật Ánh"));
//        bookList.add(new Book("Book 2", R.drawable.vhvn2, 150000, "Nguyễn Nhật Ánh"));
//        bookList.add(new Book("Book 3", R.drawable.vhvn3, 185000, "Nguyễn Nhật Ánh"));
//        bookList.add(new Book("Book 4", R.drawable.vhvn4, 74000, "Nguyễn Nhật Ánh"));
//        bookList.add(new Book("Book 5", R.drawable.vhvn5, 55000, "Nguyễn Nhật Ánh"));
//        bookList.add(new Book("Book 6", R.drawable.vhvn6, 186000, "Nguyễn Nhật Ánh"));
//        bookList.add(new Book("Book 7", R.drawable.vhvn7, 117000, "Nguyễn Nhật Ánh"));
//        bookList.add(new Book("Book 8", R.drawable.vhvn8, 99000, "Nguyễn Nhật Ánh"));
//
//        // Khởi tạo adapter
//        cartAdapter = new CartAdapter(bookList);
//
//        // Thiết lập LinearLayoutManager với hướng ngang
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(cartAdapter);
//    }
//}