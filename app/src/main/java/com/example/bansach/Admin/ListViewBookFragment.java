package com.example.bansach.Admin;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.ListViewBookAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;


public class ListViewBookFragment extends Fragment {
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview_book, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_addbook);
        list();
        return view;
    }

    public void list(){
        List<Book> bookList = new ArrayList<>();
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

        ListViewBookAdapter listViewBookAdapter = new ListViewBookAdapter(bookList, new ListViewBookAdapter.OnBookClickListener() {
            @Override
            public void onBookClick(Book book) {
                Log.d("ListViewBookFragment", "Clicked book: " + book.getTitle());
                Update_book_admin viewBookFragment = new Update_book_admin();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_admin, viewBookFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(listViewBookAdapter);

    }
}
