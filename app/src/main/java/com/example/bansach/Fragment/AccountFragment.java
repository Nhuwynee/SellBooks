package com.example.bansach.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
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

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.Login;
import com.example.bansach.R;
import com.example.bansach.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountFragment extends Fragment {

    private static final String TAG = "AccountFragment";
    private TextView tvName, tvName2, phone, address, star;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_account, container, false);

        // Ánh xạ các TextView
        tvName = view.findViewById(R.id.name);
        tvName2 = view.findViewById(R.id.name2);
        phone = view.findViewById(R.id.phone);
        address = view.findViewById(R.id.address);
        star = view.findViewById(R.id.star);

        // Ánh xạ các Button
        Button change = view.findViewById(R.id.change_address);
        Button history = view.findViewById(R.id.btn_history);
        Button cart = view.findViewById(R.id.btn_cart);
        Button logout = view.findViewById(R.id.btn_logout);
        Button favourite = view.findViewById(R.id.btn_favourite);
        Button audiobook = view.findViewById(R.id.audioBook);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1);

        // Lấy dữ liệu từ API
        loadUserData(userId);

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
                Intent intent = new Intent(getContext(), Login.class);
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

    private void loadUserData(int idUser) {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        apiService.getUserById(idUser).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    User user = response.body();
                    // Cập nhật giao diện với dữ liệu của User
                    tvName.setText(user.getName());
                    tvName2.setText(user.getName());
                    phone.setText(user.getPhone());
                    address.setText(user.getAddress());
                    star.setText(user.getPoint() + "★");
                } else {
                    Log.e("API_ERROR", "Response failed: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("API_ERROR", "API call failed: " + t.getMessage());
            }
        });
    }


    // Cập nhật UI với dữ liệu User
    private void updateUserUI(User user) {
        tvName.setText(user.getName());
        tvName2.setText(user.getName());
        phone.setText(user.getPhone());
        address.setText(user.getAddress());
        star.setText(user.getPoint() + "★");
    }

    // Phương thức thay thế fragment
    private void replaceFragment(Fragment fragment) {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
