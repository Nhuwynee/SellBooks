package com.example.bansach.Fragment;

import static com.example.bansach.R.*;

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
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.ViewFlipper;

//import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.ParentAdapter;
import com.example.bansach.Adapter.TextAdapter;
import com.example.bansach.FogotPassPage;
import com.example.bansach.LoginMainPage;
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

        TextView filter = view.findViewById(id.filter);
        // Spannable cho Forgot Password
        SpannableString spannableString_forgot = new SpannableString("Xem thêm");
        ClickableSpan clickableSpan_forgot = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Chuyển đến forgot_pass Activity
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CategoryFragment()) // Thay thế 'container' bằng ID thực tế của Layout chứa Fragment
                        .addToBackStack(null) // Thêm vào back stack nếu muốn quay lại
                        .commit();
                // Xóa màu nền khi nhấn vào
                filter.setBackgroundColor(Color.TRANSPARENT);
            }

            @Override
            public void updateDrawState(android.text.TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true); // Gạch chân chữ
                ds.setColor(filter.getCurrentTextColor()); // Giữ nguyên màu chữ hiện tại
                ds.bgColor = Color.TRANSPARENT; // Màu nền trong suốt
            }
        };
        spannableString_forgot.setSpan(clickableSpan_forgot, 0, spannableString_forgot.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        filter.setText(spannableString_forgot);
        filter.setMovementMethod(LinkMovementMethod.getInstance()); // Cho phép TextView có thể nhấn
        return view; // Trả về view đã được khởi tạo
    }


    private void addImagesToFlipper() {
        try {
            int[] images = {drawable.promotion, drawable.read_book_3, drawable.yeuthich, drawable.audiobook};

            for (int image : images) {
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(image);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(5000);
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
            bookList2.add(new Book("Vợ nhặt", R.drawable.vhvn1, 129000));
            bookList2.add(new Book("Đôi mắt", R.drawable.vhvn2, 130000));
            bookList2.add(new Book("Chí Phèo", R.drawable.vhvn3, 131000));
            bookList2.add(new Book("Làng nghề", R.drawable.vhvn4, 129000));
            bookList2.add(new Book("Truyện Kiều", R.drawable.vhvn5, 130000));
            bookList2.add(new Book("Tắt đèn", R.drawable.vhvn6, 131000));
            bookList2.add(new Book("Truyện kiều", R.drawable.vhvn7, 129000));
            bookList2.add(new Book("Sống mòn", R.drawable.vhvn8, 130000));
            // Thêm các sách khác tương tự...

            // Section 3 - Trinh thám
            List<Book> bookList3 = new ArrayList<>();
            bookList3.add(new Book("Ghi chép pháp y", R.drawable.tt1, 129000));
            bookList3.add(new Book("Thao túng tâm lý", R.drawable.tt2, 130000));
            bookList3.add(new Book("Sổ tay nhà thôi miên", R.drawable.tt3, 129000));
            bookList3.add(new Book("Phía sau nghi can X", R.drawable.tt4, 130000));
            bookList3.add(new Book("Vụ án mạng nhà khách núi Hakuba", R.drawable.tt5, 131000));
            bookList3.add(new Book("Án mạng 11 chữ", R.drawable.tt6, 129000));
            bookList3.add(new Book("Thợ săn ở Auschwitz", R.drawable.tt7, 130000));


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

