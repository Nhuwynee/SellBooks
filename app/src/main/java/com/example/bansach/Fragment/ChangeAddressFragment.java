package com.example.bansach.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.R;
import com.example.bansach.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangeAddressFragment extends Fragment
{
    private EditText editTextName, editTextPhone, editTextAddress;
    private Button buttonUpdate;
    private int userId = 3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_change_address, container, false);

        editTextName = view.findViewById(R.id.edittext_username);
        editTextPhone = view.findViewById(R.id.edittext_phone);
        editTextAddress = view.findViewById(R.id.edittext_address);
        buttonUpdate = view.findViewById(R.id.change);

        loadUserInfo();

        buttonUpdate.setOnClickListener(v -> updateUser());

        return view;
    }

    private void loadUserInfo() {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        Call<User> call = apiService.getUserById(userId);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user != null) {
                        editTextName.setText(user.getName());
                        editTextPhone.setText(user.getPhone());
                        editTextAddress.setText(user.getAddress());
                    }
                } else {
                    Log.e("UserProfileFragment", "Error loading user info");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("UserProfileFragment", "API Error: " + t.getMessage());
            }
        });
    }

    private void updateUser() {
        String newName = editTextName.getText().toString().trim();
        String newPhone = editTextPhone.getText().toString().trim();
        String newAddress = editTextAddress.getText().toString().trim();

        if (newName.isEmpty() || newPhone.isEmpty() || newAddress.isEmpty()) {
            Toast.makeText(getContext(), "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        User updatedUser = new User();
        updatedUser.setIdUser(userId);
        updatedUser.setName(newName);
        updatedUser.setPhone(newPhone);
        updatedUser.setAddress(newAddress);

        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        Call<Void> call = apiService.updateUser(updatedUser);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Cập nhật thất bại!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getContext(), "Lỗi: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
