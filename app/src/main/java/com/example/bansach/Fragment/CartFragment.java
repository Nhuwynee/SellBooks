package com.example.bansach.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.CartAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

    public class CartFragment extends Fragment {
        private RecyclerView recyclerView;
        private CartAdapter cartAdapter;
        private List<Book> bookList;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_cart, container, false);
            recyclerView = view.findViewById(R.id.recyclerView);
            book(); // Khởi tạo dữ liệu
            ImageButton cart = view.findViewById(R.id.btn_cart);

            // Xử lý sự kiện nhấn nút
            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Chuyển sang Fragment khác
                    OrderFragment newFragment = new OrderFragment();
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.container, newFragment) // Đảm bảo ID container đúng
                            .addToBackStack(null) // Nếu muốn thêm vào backstack
                            .commit();
                }
            });
            return view; // Trả về view đã tạo
        }

        private void book() {
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

            cartAdapter = new CartAdapter(bookList);
            LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(cartAdapter);

        }
    }