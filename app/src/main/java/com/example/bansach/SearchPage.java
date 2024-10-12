package com.example.bansach;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.ParentAdapter;
import com.example.bansach.Fragment.ViewBookFragment;
import com.example.bansach.model.Book;
import com.example.bansach.model.Section;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends Fragment {
    private RecyclerView recyclerViewParent;
    private ParentAdapter parentAdapter;
    private List<Section> sectionList;
    private BottomNavigationView bottomNavigationView;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_search, container, false); // Thay 'fragment_home' bằng tên layout thực tế

        // Khởi tạo các view
        recyclerViewParent = view.findViewById(R.id.recyclerViewBooks);
        // Gọi các hàm để thiết lập dữ liệu


        return view; // Trả về view đã được khởi tạo
    }
//
}
