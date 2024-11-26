package com.example.bansach.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.Adapter.OrderHistoryAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Order;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListHistoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private OrderHistoryAdapter orderHistoryAdapter;
    private List<Order> orderList = new ArrayList<>();
    private List<Order> filteredOrderList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_history, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewHistory);

        // Khởi tạo Adapter
        orderHistoryAdapter = new OrderHistoryAdapter(filteredOrderList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(orderHistoryAdapter);

        loadOrderHistory();

        Spinner spinner = view.findViewById(R.id.spinner2);
        String[] options = {"All", "Đã giao", "Đang giao", "Đã huỷ"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.item_list_filter, options);
        adapter.setDropDownViewResource(R.layout.item_filter);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                filterHistoryByGenre(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return view;
    }

    private void loadOrderHistory() {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        int userId = 5;
        Call<List<Order>> call = apiService.getOrderHistoryByUser(userId);

        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    orderList = response.body();
                    filteredOrderList.addAll(orderList); // Hiển thị tất cả đơn hàng ban đầu
                    orderHistoryAdapter.notifyDataSetChanged();
                } else {
                    Log.e("OrderHistoryFragment", "API response unsuccessful or empty");
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });
    }

    private void filterHistoryByGenre(String genre) {
        filteredOrderList.clear();

        if (genre.equalsIgnoreCase("All")) {
            filteredOrderList.addAll(orderList);
        } else {
            for (Order order : orderList) {
                if (order.getOrderStatus().equalsIgnoreCase(genre)) {
                    filteredOrderList.add(order);
                }
            }
        }

        orderHistoryAdapter.notifyDataSetChanged();
    }
}
