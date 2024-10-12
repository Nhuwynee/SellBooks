package com.example.bansach.Fragment;

import static com.example.bansach.R.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.ViewFlipper;

//import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.ParentAdapter;
import com.example.bansach.Adapter.TextAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book;
import com.example.bansach.model.Section;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    ViewFlipper viewFlipper;
    private RecyclerView recyclerViewParent, recyclerView1;
    private ParentAdapter parentAdapter;
    private List<Section> sectionList;
    private BottomNavigationView bottomNavigationView;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(layout.trang_chu, container, false); // Thay 'fragment_home' bằng tên layout thực tế

        // Khởi tạo các view
        viewFlipper = view.findViewById(R.id.viewflipper);
        recyclerViewParent = view.findViewById(R.id.recyclerView2);
        recyclerView1 = view.findViewById(R.id.recyclerView1);
        // Gọi các hàm để thiết lập dữ liệu
        addImagesToFlipper();
        category();
        book();
        return view; // Trả về view đã được khởi tạo
    }


    private void addImagesToFlipper() {
        try {
            int[] images = {drawable.promotion, drawable.read_book_3, drawable.favourite3};

            for (int image : images) {
                ImageView imageView = new ImageView(getContext());
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
        private void category() {

       ;

        // Tạo danh sách sách cho mỗi RecyclerView
        List<String> bookList1 = new ArrayList<>();

        // Thêm dữ liệu vào các danh sách sách
        bookList1.add("Tiểu thuyết");
        bookList1.add("Văn học Việt Nam");
        bookList1.add("Trinh thám");
        bookList1.add("Ngôn tình");

        TextAdapter textAdapter = new TextAdapter(bookList1);

        // Thiết lập LinearLayoutManager cho từng RecyclerView
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);


        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setAdapter(textAdapter);


    }
    private void book() {

        sectionList = new ArrayList<>();

            // Section 1 - Tiểu thuyết
            List<Book> bookList1 = new ArrayList<>();
            bookList1.add(new Book("Hồng Lục", R.drawable.hong_luc, 129000));
            bookList1.add(new Book("Bong bóng anh đào", R.drawable.bong_bong_anh_dao, 130000));
            bookList1.add(new Book("Này! Chớ làm loạn", R.drawable.nay_cho_lam_loan, 131000));
            bookList1.add(new Book("Một quả táo", R.drawable.mot_qua_tao, 129000));
            bookList1.add(new Book("Tóc của tôi", R.drawable.toc_cua_toi, 130000));
            bookList1.add(new Book("Tình yêu của Thời Hạ", R.drawable.tinh_yeu_cua_thoi_ha, 131000));
            bookList1.add(new Book("Nhất kính tinh yêu", R.drawable.nhat_kinh_tinh_yeu, 130000));
            bookList1.add(new Book("Này đừng có ăn cỏ", R.drawable.nay_dung_co_an_co, 131000));
            // Thêm các sách khác tương tự...

            // Section 2 - Văn học Việt Nam
            List<Book> bookList2 = new ArrayList<>();
            bookList2.add(new Book("Văn học VN 1", R.drawable.vhvn1, 129000));
            bookList2.add(new Book("Văn học VN 2", R.drawable.vhvn2, 130000));
            bookList2.add(new Book("Văn học VN 3", R.drawable.vhvn3, 131000));
            bookList2.add(new Book("Văn học VN 4", R.drawable.vhvn4, 129000));
            bookList2.add(new Book("Văn học VN 5", R.drawable.vhvn5, 130000));
            bookList2.add(new Book("Văn học VN 6", R.drawable.vhvn6, 131000));
            bookList2.add(new Book("Văn học VN 7", R.drawable.vhvn7, 129000));
            bookList2.add(new Book("Văn học VN 8", R.drawable.vhvn8, 130000));
            // Thêm các sách khác tương tự...

            // Section 3 - Trinh thám
            List<Book> bookList3 = new ArrayList<>();
            bookList3.add(new Book("Trinh thám 1", R.drawable.tt1, 129000));
            bookList3.add(new Book("Trinh thám 2", R.drawable.tt2, 130000));
            bookList3.add(new Book("Trinh thám 3", R.drawable.tt3, 129000));
            bookList3.add(new Book("Trinh thám 4", R.drawable.tt4, 130000));
            bookList3.add(new Book("Trinh thám 5", R.drawable.tt5, 131000));
            bookList3.add(new Book("Trinh thám 6", R.drawable.tt6, 129000));
            bookList3.add(new Book("Trinh thám 7", R.drawable.tt7, 130000));


        sectionList.add(new Section("Tiểu thuyết", bookList1));
        sectionList.add(new Section("Văn học Việt Nam", bookList2));
        sectionList.add(new Section("Trinh thám", bookList3));

        parentAdapter = new ParentAdapter(sectionList, new ParentAdapter.OnBookClickListener() {
            @Override
            public void onBookClick(Book book) {
                // Tạo fragment mới để chuyển đến
                ViewBookFragment viewBookFragment = new ViewBookFragment();

                // Thực hiện chuyển fragment mà không cần truyền dữ liệu
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, viewBookFragment).commit();
            }
        });


        // Thiết lập adapter cho RecyclerView cha
            recyclerViewParent.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerViewParent.setAdapter(parentAdapter);
        }
    }


