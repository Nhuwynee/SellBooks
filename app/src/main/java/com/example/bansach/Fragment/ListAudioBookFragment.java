package com.example.bansach.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.Adapter.AudioAdapter;
import com.example.bansach.Adapter.BookAdapter_search;
import com.example.bansach.R;
import com.example.bansach.model.Book;
import com.example.bansach.model.Book1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListAudioBookFragment extends Fragment {
    private RecyclerView recyclerView;
    private AudioAdapter audioAdapter;
    private List<Book> bookList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_audio_book, container, false);

        // Khởi tạo RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView_audio);
        list();
        return view;
    }

    // Phương thức thêm sách vào danh sách
    private void list() {
        bookList.add(new Book("Bơ đi mà sống", "Mèo Xù", 200000f, "Hoạt động", R.drawable.bo_di_ma_song));
        bookList.add(new Book("Hồng lục", "Kiêm Diệp Tử", 170000f, "Hoạt động", R.drawable.hong_luc));
        bookList.add(new Book("Này đừng có ăn cỏ!", "Lục Lục", 150000f, "Hoạt động", R.drawable.nay_dung_co_an_co));
        bookList.add(new Book("Nhật kính tình yêu", "Tống Cửu Cẩn", 250000f, "Hoạt động", R.drawable.nhat_kinh_tinh_yeu));
        bookList.add(new Book("Này chớ làm loạn", "Minh Nguyệt", 150000f, "Hoạt động", R.drawable.nay_cho_lam_loan));
        bookList.add(new Book("Án mạng mười một chữ", "Higashino Keigo", 200000f, "Hoạt động", R.drawable.tt6));
        bookList.add(new Book("Chí Phèo", "Nam Cao", 120000f, "Hoạt động", R.drawable.chipheo));
        bookList.add(new Book("Tắt đèn", "Ngô Tất Tố", 130000f, "Hoạt động", R.drawable.tatden));
        bookList.add(new Book("Thao túng tâm lý", "Shannon Thomas", 250000f, "Hoạt động", R.drawable.thaotungtamly));
        bookList.add(new Book("Vợ Nhặt", "Kim Lân", 90000f, "Hoạt động", R.drawable.vonhat));
        audioAdapter = new AudioAdapter(bookList, new AudioAdapter.OnBookClickListener() {
            @Override
            public void onBookClick(Book book) {
                // Chuyển đến ViewBookFragment khi click vào sách
                ViewBookAudioFragment viewBookFragment = new ViewBookAudioFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, viewBookFragment)
                        .commit();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(audioAdapter);
    }


}
