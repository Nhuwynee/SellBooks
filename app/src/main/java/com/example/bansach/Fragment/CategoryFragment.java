package com.example.bansach.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

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

public class CategoryFragment extends Fragment {

    private List<Book1> bookList = new ArrayList<>();
    private List<Book1> filteredBookList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BookAdapter_search bookAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_category, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewBooks);
        setupRecyclerView();

        // Set up the Spinner
        Spinner spinner = view.findViewById(R.id.spinner1);
        String[] options = {"All", "Ngôn tình", "Trinh thám", "Văn học Việt Nam"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.item_list_filter, options);
        adapter.setDropDownViewResource(R.layout.item_filter);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Button category = getView().findViewById(R.id.text_category1);
                String selectedItem = parent.getItemAtPosition(position).toString();
                category.setText(selectedItem);
                filterBooksByGenre(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // Fetch books from API
        fetchBooksFromApi();

        return view;
    }

    private void setupRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        bookAdapter = new BookAdapter_search(getContext(), filteredBookList);
        recyclerView.setAdapter(bookAdapter);
    }

    private void fetchBooksFromApi() {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        Call<List<Book1>> call = apiService.getBooks();

        call.enqueue(new Callback<List<Book1>>() {
            @Override
            public void onResponse(Call<List<Book1>> call, Response<List<Book1>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    bookList.clear();
                    bookList.addAll(response.body());
                    filteredBookList.clear();
                    filteredBookList.addAll(bookList);
                    bookAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "No books found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Book1>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
                Toast.makeText(getContext(), "Failed to load books", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void filterBooksByGenre(String genre) {
        filteredBookList.clear();

        if (genre.equalsIgnoreCase("All")) {
            filteredBookList.addAll(bookList);
        } else {
            for (Book1 book : bookList) {
                if (book.getCategory().equalsIgnoreCase(genre)) {
                    filteredBookList.add(book);
                }
            }
        }
        bookAdapter.notifyDataSetChanged();
    }
}
