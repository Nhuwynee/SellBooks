package com.example.bansach.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bansach.R;

public class ChangeAddressFragment extends Fragment
{
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_change_address, container, false);
        Button change = view.findViewById(R.id.change);

        // Xử lý sự kiện nhấn nút
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountFragment newFragment = new AccountFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment) // Đảm bảo ID container đúng
                        .addToBackStack(null) // Nếu muốn thêm vào backstack
                        .commit();
            }
        });
        return view;
    }
}
