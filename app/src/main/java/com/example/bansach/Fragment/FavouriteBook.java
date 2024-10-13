package com.example.bansach.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.bansach.R;

public class FavouriteBook extends Fragment {

    private Button btnOK;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favourite_book, container, false);

        // Khởi tạo nút OK
        btnOK = view.findViewById(R.id.tvOk);
        btnOK.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container, new ViewBookFragment())
                    .addToBackStack(null)
                    .commit();
        });
        return view;
    }
}
