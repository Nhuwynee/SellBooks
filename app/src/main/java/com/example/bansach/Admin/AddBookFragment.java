package com.example.bansach.Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bansach.Fragment.ComfirmFragment;
import com.example.bansach.R;

public class AddBookFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_book, container, false);
        Button add = view.findViewById(R.id.btnAdd);

        // Xử lý sự kiện nhấn nút
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListViewBookFragment newFragment = new ListViewBookFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container_admin, newFragment) // Đảm bảo ID container đúng
                        .addToBackStack(null) // Nếu muốn thêm vào backstack
                        .commit();
            }
        });
        return view;
    }
}