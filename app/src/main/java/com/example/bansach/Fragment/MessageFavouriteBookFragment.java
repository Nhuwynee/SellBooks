package com.example.bansach.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.R;
import com.example.bansach.model.FavouriteBook;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageFavouriteBookFragment extends Fragment {

    private int userId;
    private int bookId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_favourite_book, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            userId = bundle.getInt("userId", -1);
            bookId = bundle.getInt("bookId", -1);
        }

        // Log to check values
        if (userId == -1 || bookId == -1) {
            Log.e("MessageFavouriteBook", "Invalid userId or bookId");
            return view;
        }
        Log.d("MessageFavouriteBook", "userId: " + userId + ", bookId: " + bookId);

        // Handle the "OK" button click
        Button okButton = view.findViewById(R.id.tvOk);
        okButton.setOnClickListener(v -> goToFavouriteBookFragment());

        return view;
    }
    private void goToFavouriteBookFragment() {
        FavouriteBookFragment favouriteBookFragment = new FavouriteBookFragment();
        getParentFragmentManager().beginTransaction()
                .replace(R.id.container, favouriteBookFragment)
                .addToBackStack(null)
                .commit();
    }
}
















