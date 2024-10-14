package com.example.bansach.Admin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.ListViewBookAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;


public class ListViewBookFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Book> bookList = new ArrayList<>();
    private ListViewBookAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview_book, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_addbook);

        // Khởi tạo adapter
        adapter = new ListViewBookAdapter(bookList);
        recyclerView.setAdapter(adapter);

        // Gọi phương thức list để thêm sách
        list();
        // Gọi phương thức Delete để thiết lập ItemTouchHelper
        Delete();

        return view;
    }

    public void list() {
        bookList.add(new Book("Bong bóng anh đào", "Tê Kiến", 200000f, "Hoạt động", R.drawable.bong_bong_anh_dao));
        bookList.add(new Book("Hồng lục", "Kiêm Diệp Tử", 170000f, "Hoạt động", R.drawable.hong_luc));
        bookList.add(new Book("Này đừng có ăn cỏ!", "Lục Lục", 150000f, "Hoạt động", R.drawable.nay_dung_co_an_co));
        bookList.add(new Book("Nhật kính tình yêu", "Tống Cửu Cẩn", 250000f, "Hoạt động", R.drawable.nhat_kinh_tinh_yeu));
        bookList.add(new Book("Này chớ làm loạn", "Minh Nguyệt", 150000f, "Hoạt động", R.drawable.nay_cho_lam_loan));
        bookList.add(new Book("Án mạng mười một chữ", "Higashino Keigo", 200000f, "Hoạt động", R.drawable.tt6));
        bookList.add(new Book("Chí Phèo", "Nam Cao", 120000f, "Hoạt động", R.drawable.chipheo));
        bookList.add(new Book("Tắt đèn", "Ngô Tất Tố", 130000f, "Hoạt động", R.drawable.tatden));
        bookList.add(new Book("Thao túng tâm lý", "Shannon Thomas", 250000f, "Hoạt động", R.drawable.thaotungtamly));
        bookList.add(new Book("Vợ Nhặt", "Kim Lân", 90000f, "Hoạt động", R.drawable.vonhat));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void Delete() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false; // Không sử dụng di chuyển
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                // Xóa item khỏi danh sách
                bookList.remove(position); // Xóa khỏi danh sách
                adapter.notifyItemRemoved(position); // Cập nhật adapter
                adapter.notifyItemRangeChanged(position, bookList.size()); // Cập nhật các item khác
            }
        });

        // Gán ItemTouchHelper vào RecyclerView
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}


