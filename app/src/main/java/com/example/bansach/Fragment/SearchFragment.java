package com.example.bansach.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.Adapter.BookAdapter_search;
import com.example.bansach.R;
import com.example.bansach.model.Book1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    private BookAdapter_search bookAdapter;
    private SearchView search;
    private TextView tvNoResults;
    private List<Book1> bookList1 = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_search, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewBooks);
        search = view.findViewById(R.id.etSearch);
        tvNoResults = view.findViewById(R.id.tvNoResults);

        // Khởi tạo danh sách sách
        loadBooks();

        // Đặt listener cho SearchView
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d("SearchFragment", "Query submitted: " + s);
                searchInBookList(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("SearchFragment", "Query changed: " + s);
                searchInBookList(s);
                return true;
            }
        });

        return view;
    }
    private void searchInBookList(String query) {
        Log.d("SearchFragment", "Searching for: " + query);
        List<Book1> resultBooks = new ArrayList<>();
        if (query == null || query.isEmpty()) {
            setUpRecyclerView(bookList1);
            return;
        }

        for (Book1 b : bookList1) {
            String title = b.getTitle();
            String author = b.getAuthor();

            if ((title != null && title.toLowerCase().contains(query.toLowerCase())) ||
                    (author != null && author.toLowerCase().contains(query.toLowerCase()))) {
                resultBooks.add(b);
            }
        }

        setUpRecyclerView(resultBooks);
        Log.d("SearchFragment", "Found results: " + resultBooks.size());

        if (resultBooks.isEmpty()) {
            tvNoResults.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            tvNoResults.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }
    private void loadBooks() {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        Call<List<Book1>> call = apiService.getBooks();
        call.enqueue(new Callback<List<Book1>>() {
            @Override
            public void onResponse(Call<List<Book1>> call, Response<List<Book1>> response) {
                if (response.isSuccessful()) {
                    bookList1 = response.body();
                    if (bookList1 != null && !bookList1.isEmpty()) {
                        setUpRecyclerView(bookList1);
                    } else {
                        Log.e("SearchFragment", "No books found");
                    }
                } else {
                    Log.e("SearchFragment", "API error");
                }
            }

            @Override
            public void onFailure(Call<List<Book1>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });
    }


    private void setUpRecyclerView(List<Book1> books) {
        if (bookAdapter == null) {
            bookAdapter = new BookAdapter_search(getContext(), books);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3)); // Bố cục 3 cột
            recyclerView.setAdapter(bookAdapter);
        } else {
            bookAdapter.updateBooks(books); // Cập nhật danh sách nếu adapter đã tồn tại
        }
    }


}
