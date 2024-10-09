package com.example.bansach;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.BookAdapter;
import com.example.bansach.Adapter.ParentAdapter;
import com.example.bansach.Adapter.TextAdapter;
import com.example.bansach.model.Book;
import com.example.bansach.model.Section;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbarmhchinh;
    ViewFlipper viewFlipper;
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private CartAdapter cartAdapter;
    private List<Book> bookList;
    private RecyclerView recyclerViewParent;
    private ParentAdapter parentAdapter;
    private List<Section> sectionList;

    FrameLayout frameLayout;
    TabLayout tabLayout;

    private Button btnFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        // book1();
    }
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

//        setContentView(R.layout.add_book);
//        setContentView(R.layout.trang_chu);
// d677e22dbbe1284639ba4f618d46ac9a273a5627

//        setContentView(R.layout.activity_main);
//        addImagesToFlipper();
//        book();
// Như HEAD
//        setContentView(R.layout.viewbooks_main);

// HEAD

//        setContentView(R.layout.cart_main);
//        book1();
        //addImagesToFlipper();

//        setContentView(R.layout.viewbooks_main);
//        addImagesToFlipper();
//ba7ecc200d9943a06fa363036581c6b37029ef29
//
// ae997279018cdba21c67a962e1d1c7265c2e0cfb
// d677e22dbbe1284639ba4f618d46ac9a273a5627


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
//    private void addImagesToFlipper() {
//        viewFlipper = findViewById(R.id.viewflipper);
//
//        try {
//            // Mảng chứa các ảnh trong thư mục drawable
// HEAD
//            int[] images = { R.drawable.hong_luc, R.drawable.hong_luc_3};

//            int[] images = { R.drawable.hong_luc, R.drawable.hong_luc_2};
// ba7ecc200d9943a06fa363036581c6b37029ef29
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
//    private void addImagesToFlipper() {
//        viewFlipper = findViewById(R.id.viewflipper);
//        try {
//            int[] images = {R.drawable.hong_luc, R.drawable.tinh_yeu_cua_thoi_ha, R.drawable.nay_dung_co_an_co, R.drawable.toc_cua_toi};
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
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

// d677e22dbbe1284639ba4f618d46ac9a273a5627

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
//    private void book() {
//        recyclerViewParent = findViewById(R.id.recyclerView2);
//
//        // Tạo danh sách section
//        sectionList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            List<Book> bookList = new ArrayList<>();
//            // Thêm sách vào bookList
//            for (int j = 0; j < 8; j++) {
//                bookList.add(new Book("Book " + (j + 1), R.drawable.nhat_kinh_tinh_yeu, 129000 + (j * 1000)));
//            }
//            sectionList.add(new Section("Section " + (i + 1), bookList));
//        }
//
//        // Thiết lập adapter cho RecyclerView cha
//        parentAdapter = new ParentAdapter(sectionList);
//        recyclerViewParent.setLayoutManager(new LinearLayoutManager(this));
//        recyclerViewParent.setAdapter(parentAdapter);
//    }

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


    private void book1() {
        recyclerView = findViewById(R.id.recyclerView);

        // Khởi tạo dữ liệu sách
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cartAdapter);
    }
}



// d677e22dbbe1284639ba4f618d46ac9a273a5627
// ba7ecc200d9943a06fa363036581c6b37029ef29
