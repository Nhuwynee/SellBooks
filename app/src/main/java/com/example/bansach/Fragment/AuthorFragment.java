package com.example.bansach.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.R;
import com.example.bansach.model.Book1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AuthorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AuthorFragment extends Fragment {
    private TextView tvAbout;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters


    public AuthorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment AuthorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AuthorFragment newInstance(String bookId) {
        AuthorFragment fragment = new AuthorFragment();
        Bundle args = new Bundle();
        args.putString("bookId", bookId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String bookId = getArguments().getString("bookId");
            Log.d("AboutFragment", "Received bookId: " + bookId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_author, container, false);
        tvAbout = view.findViewById(R.id.author);

        String bookId = getArguments().getString("bookId");

        if (bookId != null) {
            fetchAboutText(bookId);
        } else {
            Log.e("AboutFragment", "bookId is null");
            tvAbout.setText("No book ID provided.");
        }

        return view;
    }
    private void fetchAboutText(String bookId) {
        // Khởi tạo Retrofit
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        Call<Book1> call = apiService.getBookDetails(bookId);  // Truyền bookId vào đây

        call.enqueue(new Callback<Book1>() {
            @Override
            public void onResponse(Call<Book1> call, Response<Book1> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Set dữ liệu lên TextView
                    Book1 bookDetails = response.body();
                    tvAbout.setText(bookDetails.getDetailAuthor());
                } else {
                    tvAbout.setText("Failed to load data.");
                }
            }

            public void onFailure(Call<Book1> call, Throwable t) {
                Log.e("ViewBookFragment", "Lỗi API: " + t.getMessage());
            }

        });
    }
}