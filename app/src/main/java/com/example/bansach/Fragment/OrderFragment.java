package com.example.bansach.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bansach.R;

public class OrderFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_order, container, false);

        Button buy = view.findViewById(R.id.buy_button);

        // Xử lý sự kiện nhấn nút
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComfirmFragment newFragment = new ComfirmFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment) // Đảm bảo ID container đúng
                        .addToBackStack(null) // Nếu muốn thêm vào backstack
                        .commit();
                Log.d("TAG", "đã có sự kiện ");
            }
        });
        return view;
    }
}