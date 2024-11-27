package com.example.bansach.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
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
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.Adapter.OrderHistoryAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book1;
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
    private int idOrder;
    private Spinner spinner;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_history, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewHistory);
        loadOrderHistory();

        spinner = view.findViewById(R.id.spinner2);
        String[] options = {"All", "Đã giao", "Đang giao", "Đã huỷ"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.item_list_filter, options);
        adapter.setDropDownViewResource(R.layout.item_filter);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                filterBooksByGenre(selectedItem);            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return view;
    }

    private void loadOrderHistory() {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1);
        Call<List<Order>> call = apiService.getOrderHistoryByUser(userId);

        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    orderList = response.body();
                    // Khởi tạo RecyclerView và Adapter
                    setUpRecyclerView(orderList);
//                    orderHistoryAdapter.notifyDataSetChanged();
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

    private void setUpRecyclerView(List<Order> books) {
        orderHistoryAdapter = new OrderHistoryAdapter(books, getContext(), new OrderHistoryAdapter.OnHistoryClickListener() {
            @Override
            public void onHistoryClick(Order book) {
                openBookDetailFragment(book);
            }
        }) {
            @Override
            public void onBookClick(Order book) {

            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(orderHistoryAdapter);
    }

    private void openBookDetailFragment(Order book) {

        int bookId = book.getIdOrder();
        Bundle bundle = new Bundle();
        bundle.putInt("userId", bookId);
        OrderConfirmFragment viewBookFragment = new OrderConfirmFragment();
        viewBookFragment.setArguments(bundle);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, viewBookFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void filterBooksByGenre(String genre) {
        updateFilteredList(genre);
    }

    private void updateFilteredList(String genre) {
        filteredOrderList.clear();
        setUpRecyclerView(orderList);
        if ("All".equalsIgnoreCase(genre)) {
            filteredOrderList.addAll(orderList);
        } else {
            for (Order book : orderList) {
                if (book.getOrderStatus().equalsIgnoreCase(genre)) {
                    filteredOrderList.add(book);
                }
            }
        }
        orderHistoryAdapter.updateOrders(filteredOrderList);
        orderHistoryAdapter.notifyDataSetChanged();
    }
}
