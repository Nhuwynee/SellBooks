package com.example.bansach.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bansach.FogotPassPage;
import com.example.bansach.LoginMainPage;
import com.example.bansach.MainActivity;
import com.example.bansach.R;

public class AccountFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_account, container, false);

        Button change = view.findViewById(R.id.change_address);
        Button history = view.findViewById(R.id.btn_history);
        Button cart = view.findViewById(R.id.btn_cart);
        Button logout = view.findViewById(R.id.btn_logout);
        Button favourite = view.findViewById(R.id.btn_favourite);
    Button audiobook = view.findViewById(R.id.audioBook);
        // Xử lý sự kiện nhấn nút
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeAddressFragment newFragment = new ChangeAddressFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment) // Đảm bảo ID container đúng
                        .addToBackStack(null) // Nếu muốn thêm vào backstack
                        .commit();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListHistoryFragment newFragment = new ListHistoryFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment) // Đảm bảo ID container đúng
                        .addToBackStack(null) // Nếu muốn thêm vào backstack
                        .commit();
            }
        });
        audiobook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListBuyedAudioFragment newFragment = new ListBuyedAudioFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment) // Đảm bảo ID container đúng
                        .addToBackStack(null) // Nếu muốn thêm vào backstack
                        .commit();
            }
        });

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavouriteBookFragment newFragment = new FavouriteBookFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment) // Đảm bảo ID container đúng
                        .addToBackStack(null) // Nếu muốn thêm vào backstack
                        .commit();
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartFragment newFragment = new CartFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment) // Đảm bảo ID container đúng
                        .addToBackStack(null) // Nếu muốn thêm vào backstack
                        .commit();
            }
        });
        return view;
    }
}