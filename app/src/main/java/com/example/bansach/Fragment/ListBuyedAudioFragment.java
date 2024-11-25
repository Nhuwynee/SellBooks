package com.example.bansach.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.AudioAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListBuyedAudioFragment extends Fragment {
    private RecyclerView recyclerView;
    private AudioAdapter audioAdapter;
    private List<Book> bookList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_buyed_audiobook, container, false);

        // Khởi tạo RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView_audio1);
        list();
        return view;
    }

    // Phương thức thêm sách vào danh sách
    private void list() {
        bookList.add(new Book("Bơ đi mà sống", "Mèo Xù",  R.drawable.bong_bong_anh_dao));

//        audioAdapter = new AudioAdapter(bookList, new AudioAdapter.OnBookClickListener() {
//            @Override
//            public void onBookClick(Book book) {
//                // Chuyển đến ViewBookFragment khi click vào sách
//                AudioFragment viewBookFragment = new AudioFragment();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.container, viewBookFragment)
//                        .commit();
//            }
//        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(audioAdapter);
    }


}
