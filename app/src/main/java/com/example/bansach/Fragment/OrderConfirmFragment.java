package com.example.bansach.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.Adapter.BuyedBookAdapter;
import com.example.bansach.Adapter.HistoryAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Cart;
import com.example.bansach.model.Order;
import com.example.bansach.model.OrderDetail;
import com.example.bansach.model.OrderRequest;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderConfirmFragment extends Fragment {
    private List<OrderDetail> bookList;
    private TextView name, phone, address, date, number, total, subTotal, datedetail;
    private ImageView avatar;
    private RecyclerView recyclerView;
    private HistoryAdapter buyedBookAdapter;
    private List<OrderDetail> cartList = new ArrayList<>();
    private int idOrder;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_order_confirm, container, false);

        name = view.findViewById(R.id.customer_name);
        phone = view.findViewById(R.id.customer_phone);
        address = view.findViewById(R.id.customer_address);
        avatar = view.findViewById(R.id.customer_image);
        date = view.findViewById(R.id.date);
        number = view.findViewById(R.id.number);
        total = view.findViewById(R.id.total);
        subTotal = view.findViewById(R.id.subTotal);
        datedetail = view.findViewById(R.id.date_detail);
        if (getArguments() != null) {
            idOrder = getArguments().getInt("userId");
            Log.d("ViewBookFragment", "Received bookId: " + idOrder);
            if (idOrder != 0) {
                loadpage(idOrder);
            } else {
                Toast.makeText(getContext(), "Không tìm thấy ID đơn hàng.", Toast.LENGTH_SHORT).show();
                Log.e("OrderConfirmFragment", "idOrder là null hoặc không hợp lệ");
            }

        } else {
            Log.e("ViewBookFragment", "getArguments() là null");
        }

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadCartData(idOrder);

        return view;
    }

    private void loadCartData(int idOrder) {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);

        Call<List<OrderDetail>> call = apiService.getOrderbyId(idOrder);
        call.enqueue(new Callback<List<OrderDetail>>() {
            @Override
            public void onResponse(Call<List<OrderDetail>> call, Response<List<OrderDetail>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    cartList = response.body();
                    buyedBookAdapter = new HistoryAdapter(getContext(), cartList);
                    recyclerView.setAdapter(buyedBookAdapter);
                } else {
                    Log.e("API", "Không có dữ liệu");
                }
            }

            @Override
            public void onFailure(Call<List<OrderDetail>> call, Throwable t) {
                Log.e("API_ERROR", "Lỗi khi gọi API: " + t.getMessage());
            }
        });
    }

    private void loadpage(int idOrder) {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        Call<List<OrderDetail>> call = apiService.getOrderbyId(idOrder);
        Log.d("idOrder","idOrder= " + idOrder);
        call.enqueue(new Callback<List<OrderDetail>>() {
            @Override
            public void onResponse(Call<List<OrderDetail>> call, Response<List<OrderDetail>> response) {
                if (response.isSuccessful()) {
                    bookList = response.body();
                    float sum = 0;
                    int sl =0;
                    for (OrderDetail book : bookList) {
                        sum += book.getNumber() * book.getPrice();
                        sl += book.getNumber();
                    }
                    String resourceName = bookList.get(0).getAvatarImage().substring(0, bookList.get(0).getAvatarImage().lastIndexOf('.'));
                    int resId = getResources().getIdentifier(resourceName, "drawable", requireContext().getPackageName());
                    Glide.with(requireContext())
                            .load(resId)
                            .into(avatar);
                    name.setText(bookList.get(0).getName());
                    phone.setText(bookList.get(0).getPhone());
                    address.setText(bookList.get(0).getAddress());
                    date.setText(bookList.get(0).getOrderTime());
                    total.setText(String.format("%,.0f đ", sum));
                    subTotal.setText(String.format("%,.0f đ", sum - bookList.get(0).getPoint()));
                    number.setText(String.valueOf(sl));

                    try {
                        // Lấy ngày từ TextView
                        String dateText = date.getText().toString();

                        // Định dạng ngày ban đầu
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDate localDate = LocalDate.parse(dateText, formatter);

                        // Cộng thêm 10 ngày
                        LocalDate updatedDate = localDate.plusDays(10);

                        // Hiển thị ngày mới
                        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        datedetail.setText(updatedDate.format(outputFormatter));
                    } catch (Exception e) {
                        e.printStackTrace();
                        datedetail.setText("Lỗi định dạng ngày!");
                    }

                } else {
                    Log.e("SearchFragment", "API error");
                }
            }

            @Override
            public void onFailure(Call<List<OrderDetail>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });
    }


}