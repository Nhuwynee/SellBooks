
package com.example.bansach.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.Adapter.FavouriteAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book1;
import com.example.bansach.model.FavouriteBook;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavouriteBookFragment extends Fragment {
    private RecyclerView recyclerView;
    private FavouriteAdapter favouriteAdapter;
    private List<Book1> bookList;
    private APIService apiService;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_favourite_book, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_favourite);
        bookList = new ArrayList<>();
        apiService = RetrofitClient.getRetrofitInstance().create(APIService.class); // Khởi tạo API service

        favouriteAdapter = new FavouriteAdapter(bookList, getContext(),
                new FavouriteAdapter.OnBookClickListener() {
                    @Override
                    public void onBookClick(Book1 book) {
                        Log.d("FavouriteBookFragment", "Sách được chọn: " + book.getTitle());
                    }
                },
                new FavouriteAdapter.OnBookDeleteListener() {
                    @Override
                    public void onBookDelete(Book1 book, int position) {
                        deleteBookFromFavourite(book, position);
                    }
                }
        );
        recyclerView.setAdapter(favouriteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadBooks();
        setupSwipeToShowDeleteButton();
        return view;
    }

    private void loadBooks() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1);

        Call<List<Book1>> call = apiService.getFavouriteBooks(userId);
        call.enqueue(new Callback<List<Book1>>() {
            @Override
            public void onResponse(Call<List<Book1>> call, Response<List<Book1>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    bookList = response.body();
                    favouriteAdapter.updateBooks(bookList);
                } else {
                    Log.e("FavouriteBookFragment", "API error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Book1>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });
    }

    private void deleteBookFromFavourite(Book1 book, int position) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1);

        Call<Void> call = apiService.deleteFavouriteBook(userId, book.getId());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.d("FavouriteBookFragment", "Sách đã xóa khỏi danh sách yêu thích");

                    // Xóa item khỏi danh sách và cập nhật giao diện
                    favouriteAdapter.removeItem(position);
                } else {
                    Log.e("FavouriteBookFragment", "Lỗi khi xóa sách khỏi danh sách yêu thích: " + response.message());
                    favouriteAdapter.notifyItemChanged(position);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("FavouriteBookFragment", "API xóa sách thất bại: " + t.getMessage());
                favouriteAdapter.notifyItemChanged(position);
            }
        });
    }

    private void setupSwipeToShowDeleteButton() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                favouriteAdapter.onItemSwiped(position);
                favouriteAdapter.notifyItemChanged(position);
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

}





