package com.example.bansach.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.Adapter.FavouriteAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book1;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavouriteBookFragment extends Fragment {
    private RecyclerView recyclerView;
    private FavouriteAdapter favouriteAdapter;
    private List<Book1> bookList;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_favourite_book, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_favourite);
        loadBooks();

        return view;
    }
    private void loadBooks() {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1);
        // Gọi API với userId mặc định
        Call<List<Book1>> call = apiService.getFavouriteBooks(userId);
        call.enqueue(new Callback<List<Book1>>() {
            @Override
            public void onResponse(Call<List<Book1>> call, Response<List<Book1>> response) {
                if (response.isSuccessful()) {
                    bookList = response.body();
                    Log.d("API_RESPONSE", "Dữ liệu trả về: " + bookList.toString());
                    setUpRecyclerView(bookList);
                } else {
                    Log.e("FavouriteBookFragment", "API error");
                }
            }

            @Override
            public void onFailure(Call<List<Book1>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });
    }

    private void setUpRecyclerView(List<Book1> books) {
        if (favouriteAdapter == null) {
            favouriteAdapter = new FavouriteAdapter(books, new FavouriteAdapter.OnFavouriteClickListener() {
                @Override
                public void onFavouriteList(Book1 book) {
                    openFavouriteBookFragment(book);
                }
            });
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(favouriteAdapter);
        }
    }

    private void openFavouriteBookFragment(Book1 book) {
        String bookId = book.getId();
        Bundle bundle = new Bundle();
        bundle.putString("bookId", bookId);
        ViewBookFragment viewBookFragment = new ViewBookFragment();
        viewBookFragment.setArguments(bundle);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, viewBookFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
