package com.example.bansach.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bansach.Fragment.CartFragment;
import com.example.bansach.Fragment.ChangeAddressFragment;
import com.example.bansach.Fragment.ListHistoryFragment;
import com.example.bansach.MainActivity;
import com.example.bansach.R;


    public class AccountActivityAdmin extends Fragment {
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_account_admin, container, false);
            Button add = view.findViewById(R.id.button_add_book);
            Button listbook = view.findViewById(R.id.button_book_list);
            Button listorder = view.findViewById(R.id.button_order_list);
            Button logout = view.findViewById(R.id.button_logout);

            // Xử lý sự kiện nhấn nút
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AddBookFragment newFragment = new AddBookFragment();
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.container_admin, newFragment) // Đảm bảo ID container đúng
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

            listbook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ListViewBookFragment newFragment = new ListViewBookFragment();
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.container_admin, newFragment) // Đảm bảo ID container đúng
                            .addToBackStack(null) // Nếu muốn thêm vào backstack
                            .commit();
                }
            });

            listorder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ListInvoiceFragment newFragment = new ListInvoiceFragment();
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.container_admin, newFragment) // Đảm bảo ID container đúng
                            .addToBackStack(null) // Nếu muốn thêm vào backstack
                            .commit();
                }
            });
            return view;
        }
    }
