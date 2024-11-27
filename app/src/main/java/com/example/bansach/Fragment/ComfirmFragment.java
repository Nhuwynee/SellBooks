package com.example.bansach.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.Adapter.OrderHistoryAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book1;
import com.example.bansach.model.Order;
import com.example.bansach.model.Order_User;
import com.example.bansach.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComfirmFragment extends Fragment {
    TextView name, phone, address, id_dh, date;
    private OrderHistoryAdapter orderHistoryAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(R.layout.activity_confirm, container, false);
        Button ok = view.findViewById(R.id.ok_button);
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone);
        address = view.findViewById(R.id.address);
        id_dh = view.findViewById(R.id.id_dh);
        date = view.findViewById(R.id.date);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1);
        loadOrderHistory(userId);
        Log.d("user","user id = " + userId);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListHistoryFragment newFragment = new ListHistoryFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
    private void loadOrderHistory(int orderId) {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        Log.d("user","user id = " + orderId);
        Call<Order_User> call = apiService.getOrder(orderId);

        call.enqueue(new Callback<Order_User>() {
            @Override
            public void onResponse(Call<Order_User> call, Response<Order_User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Nhận dữ liệu từ API
                    Order_User orderDetails = response.body();

                    // Hiển thị dữ liệu lên TextView
                    name.setText(orderDetails.getName());
                    phone.setText(orderDetails.getPhone());
                    address.setText(orderDetails.getAddress());
                    id_dh.setText(String.valueOf(orderDetails.getIdOrder()));
                    date.setText(orderDetails.getOrderTime());
                } else {
                    try {
                        Log.e("API Error", "Error body: " + response.errorBody().string());
                    } catch (Exception e) {
                        Log.e("API Error", "Cannot read error body", e);
                    }
                }
            }

            @Override
            public void onFailure(Call<Order_User> call, Throwable t) {
                Log.e("ConfirmFragment", "API Error: " + t.getMessage());
                if (t instanceof IOException) {
                    Log.e("ConfirmFragment", "Network Error: " + t.getMessage());
                } else {
                    Log.e("ConfirmFragment", "Conversion Error: " + t.getMessage());
                }
            }
        });
    }




}