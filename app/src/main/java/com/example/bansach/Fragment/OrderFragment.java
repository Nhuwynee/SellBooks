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
import android.widget.ImageButton;
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
import com.example.bansach.R;
import com.example.bansach.model.Cart;
import com.example.bansach.model.OrderRequest;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.content.SharedPreferences;


public class OrderFragment extends Fragment {
    private List<Cart> bookList;
    private TextView name, phone, address, date, number, total, subTotal,point;
    private ImageView avatar;
    private RecyclerView recyclerView;
    private BuyedBookAdapter buyedBookAdapter;
    private List<Cart> cartList = new ArrayList<>();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_order, container, false);

        Button buy = view.findViewById(R.id.buy_button);
        name = view.findViewById(R.id.customer_name);
        phone = view.findViewById(R.id.customer_phone);
        address = view.findViewById(R.id.customer_address);
        avatar = view.findViewById(R.id.customer_image);
        date = view.findViewById(R.id.date);
        number = view.findViewById(R.id.number);
        total = view.findViewById(R.id.total);
        subTotal = view.findViewById(R.id.subTotal);
        point = view.findViewById(R.id.point_star);
        // Xử lý sự kiện nhấn nút
        loadpage();

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadCartData();
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComfirmFragment newFragment = new ComfirmFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment) // Đảm bảo ID container đúng
                        .addToBackStack(null) // Nếu muốn thêm vào backstack
                        .commit();
                insertOrderDetails();
            }
        });
        return view;
    }
    private void loadCartData() {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1); // Giả sử bạn lưu userId trong SharedPreferences

        Call<List<Cart>> call = apiService.getBooksbyIdUser(userId);
        call.enqueue(new Callback<List<Cart>>() {
            @Override
            public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    cartList = response.body();
                    buyedBookAdapter = new BuyedBookAdapter(getActivity(), cartList);
                    if (recyclerView == null) {
                        Log.e("OrderFragment", "RecyclerView is null!");
                    } else {
                        recyclerView.setAdapter(buyedBookAdapter);
                    }
                } else {
                    Log.e("API", "Không có dữ liệu");
                }
            }

            @Override
            public void onFailure(Call<List<Cart>> call, Throwable t) {
                Log.e("API_ERROR", "Lỗi khi gọi API: " + t.getMessage());
            }
        });
    }
    private void loadpage () {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1);
        Log.d("UserId", "User ID: " + userId);
        Call<List<Cart>> call = apiService.getBooksbyIdUser(userId);
        call.enqueue(new Callback<List<Cart>>() {
            @Override
            public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                if (response.isSuccessful()) {
                    bookList = response.body();
                    float sum = 0;
                    int sl =0;
                    int point1 =0;
                    for (Cart book : bookList) {
                        sum += book.getNumber() * book.getPrice();
                        sl += book.getNumber();
                        point1 += book.getPoint();
                    }
                        String resourceName = bookList.get(0).getAvatarImage().substring(0, bookList.get(0).getAvatarImage().lastIndexOf('.'));
                            int resId = getResources().getIdentifier(resourceName, "drawable", requireContext().getPackageName());
                            Glide.with(requireContext())
                                    .load(resId)
                                    .into(avatar);
                        name.setText(bookList.get(0).getName());
                        phone.setText(bookList.get(0).getPhone());
                        address.setText(bookList.get(0).getAddress());
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                        String currentDate = dateFormat.format(calendar.getTime());
                        date.setText(currentDate);
                        total.setText(String.format("%,.0f đ", sum));
                        subTotal.setText(String.format("%,.0f đ", sum - bookList.get(0).getPointSum()));
                        point.setText(point1 + " ★" );
                        number.setText(String.valueOf(sl));

                } else {
                    Log.e("SearchFragment", "API error");
                }
            }

            @Override
            public void onFailure(Call<List<Cart>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });
    }
    private void insertOrderDetails() {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1);
        if (userId == -1) {
            Toast.makeText(getContext(), "Lỗi: Người dùng chưa đăng nhập", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.d("UserId", "User ID in insert: " + userId);
        Call<List<Cart>> call = apiService.getBooksbyIdUser(userId);
        call.enqueue(new Callback<List<Cart>>() {
            @Override
            public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    bookList = response.body();
                    if (bookList.isEmpty()) {
                        Toast.makeText(getContext(), "Giỏ hàng rỗng", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    List<OrderRequest.Orderitem> details = new ArrayList<>();
                    float sum = 0;
                    int point = 0;
                    for (Cart book : bookList) {
                        details.add(new OrderRequest.Orderitem(book.getId(), book.getNumber()));
                        sum += book.getNumber() * book.getPrice();
                        point += book.getPoint();
                    }
                    float total = sum - ( bookList.get(0).getPointSum() ); // Kiểm tra null
                    OrderRequest order = new OrderRequest(userId, total, details,point);
                    Gson gson = new Gson();
                    String jsonOrder = gson.toJson(order);
                    Log.d("OrderRequest", "Dữ liệu JSON gửi đi: " + jsonOrder);
                    Call<Void> call1 = apiService.createOrder(order);
                    call1.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(getContext(), "Đơn hàng đã được thêm thành công!", Toast.LENGTH_LONG).show();
                            } else {
                                Log.e("API","Lỗi: " + response.message());
                                Toast.makeText(getContext(), "Lỗi: " + response.message(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Log.e("API_ERROR call", t.getMessage());
                            Toast.makeText(getContext(), "Lỗi: " + t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    Log.e("SearchFragment", "API error");
                }
            }

            @Override
            public void onFailure(Call<List<Cart>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });
    }
}