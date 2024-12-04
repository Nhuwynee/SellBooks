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

import com.example.bansach.Adapter.InvoiceAdapter;
import com.example.bansach.Adapter.ListViewBookAdapter;
import com.example.bansach.R;
import com.example.bansach.Update_book_admin;
import com.example.bansach.model.Book;
import com.example.bansach.model.Invoice;

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
        adapter = new ListViewBookAdapter(bookList, new ListViewBookAdapter.OnBookClickListener() {
            @Override
            public void onBookClick(Book book) {
                // Xử lý khi người dùng click vào sách để xem thông tin
                UpdateBookAdminFragment viewBookFragment = new UpdateBookAdminFragment();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_admin, viewBookFragment)
                        .commit();
            }
        }, new ListViewBookAdapter.OnBookDeleteListener() {
            @Override
            public void onBookDelete(Book book, int position) {
                // Xử lý việc xóa sách
                adapter.removeItem(position);
                Log.d("ListViewBookFragment", "Sách đã bị xóa: " + book.getTitle());
            }
        });
        recyclerView.setAdapter(adapter);


        return view;
    }




}


