package com.example.bansach;

import android.os.Bundle;
import android.widget.ImageView;

import android.widget.ViewFlipper;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.ParentAdapter;
import com.example.bansach.model.Book;
import com.example.bansach.model.Section;

import java.util.ArrayList;
import java.util.List;



public class Home extends AppCompatActivity {
    ViewFlipper viewFlipper;
    private RecyclerView recyclerViewParent;
    private ParentAdapter parentAdapter;
    private List<Section> sectionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trang_chu);
        addImagesToFlipper();
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
    private void book() {
        recyclerViewParent = findViewById(R.id.recyclerView2);

        // Tạo danh sách section
        sectionList = new ArrayList<>();

        // Tên sách
        String[] bookNames = {
                "Book 1", "Book 2", "Book 3", "Book 4",
                "Book 5", "Book 6", "Book 7", "Book 8",
                "Book 9", "Book 10", "Book 11", "Book 12",
                "Book 13", "Book 14", "Book 15", "Book 16",
                "Book 17", "Book 18", "Book 19", "Book 20",
                "Book 21", "Book 22", "Book 23", "Book 24"
        };

        // Hình ảnh tương ứng
        int[] bookImages = {
                R.drawable.nhat_kinh_tinh_yeu, R.drawable.hong_luc_2, R.drawable.nay_dung_co_an_co, R.drawable.toc_cua_toi,
                R.drawable.bong_bong_anh_dao, R.drawable.tinh_yeu_cua_thoi_ha, R.drawable.hong_luc_3, R.drawable.mot_qua_tao,
                R.drawable.vhvn1, R.drawable.vhvn2, R.drawable.vhvn3, R.drawable.vhvn4,
                R.drawable.vhvn5, R.drawable.vhvn6, R.drawable.vhvn7, R.drawable.vhvn8,
                R.drawable.tt1, R.drawable.tt2, R.drawable.tt3, R.drawable.tt4 ,
                R.drawable.tt5, R.drawable.tt6, R.drawable.tt7, R.drawable.toc_cua_toi
        };
        String[] sectionTitles = {
                "Tiểu thuyết",
                "Văn học Việt Nam",
                "Trinh thám"
        };


        for (int i = 0; i < sectionTitles.length; i++) {
            List<Book> bookList = new ArrayList<>();
            // Thêm 8 sách vào bookList
            for (int j = 0; j < 8; j++) {
                int bookIndex = i * 8 + j; // Tính chỉ số sách tương ứng
                bookList.add(new Book(bookNames[bookIndex], bookImages[bookIndex], 129000 + (j * 1000)));
            }
            sectionList.add(new Section(sectionTitles[i], bookList)); // Sử dụng tên section từ mảng sectionTitles
        }

        // Thiết lập adapter cho RecyclerView cha
        parentAdapter = new ParentAdapter(sectionList);
        recyclerViewParent.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewParent.setAdapter(parentAdapter);
    }

}
