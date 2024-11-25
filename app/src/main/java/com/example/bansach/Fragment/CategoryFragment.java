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
import androidx.fragment.app.FragmentTransaction;
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
    private Spinner spinner;
    private Button categoryButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_category, container, false);

        // Ánh xạ các view
        recyclerView = view.findViewById(R.id.recyclerViewBooks);
        spinner = view.findViewById(R.id.spinner1);
        categoryButton = view.findViewById(R.id.text_category1);



        fetchBooksFromApi(); // Gọi API để lấy dữ liệu sách
        setupSpinner();
        return view;
    }

    private void setupSpinner() {
        String[] options = {"All", "Tiểu thuyết", "Trinh thám", "Văn học", "Self-help", "Tâm lý học", "Kỹ năng sống"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.item_list_filter, options);
        adapter.setDropDownViewResource(R.layout.item_filter);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                categoryButton.setText(selectedItem);
                filterBooksByGenre(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không thực hiện gì khi không có mục nào được chọn
            }
        });
    }

    private void fetchBooksFromApi() {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        Call<List<Book1>> call = apiService.getBooks();
        call.enqueue(new Callback<List<Book1>>() {
            @Override
            public void onResponse(Call<List<Book1>> call, Response<List<Book1>> response) {
                if (response.isSuccessful()) {
                    bookList = response.body();
                    setupRecyclerView(bookList);
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
    private void setupRecyclerView(List<Book1> books) {

        if (bookAdapter == null) {
            bookAdapter = new BookAdapter_search(books,getContext(), new BookAdapter_search.OnBookClickListener() {
                @Override
                public void onBookClick(Book1 book) {
                    openBookDetailFragment(book);
                }
            });
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3)); // Bố cục 3 cột
            recyclerView.setAdapter(bookAdapter);
        } else {
            bookAdapter.updateBooks(books);
        }
    }
    private void filterBooksByGenre(String genre) {
        updateFilteredList(genre);
    }

    private void updateFilteredList(String genre) {
        filteredBookList.clear();
        setupRecyclerView(bookList);
        if ("All".equalsIgnoreCase(genre)) {

            filteredBookList.addAll(bookList);
        } else {
            for (Book1 book : bookList) {
                if (book.getCategory().equalsIgnoreCase(genre)) {

                    filteredBookList.add(book);
                }
            }
        }
        bookAdapter.updateBooks(filteredBookList);
        bookAdapter.notifyDataSetChanged();
    }
    private void openBookDetailFragment(Book1 book) {

        String bookId = book.getId();
        Bundle bundle = new Bundle();
        bundle.putString("bookId", bookId);
        ViewBookFragment viewBookFragment = new ViewBookFragment()                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ;
        viewBookFragment.setArguments(bundle);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, viewBookFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
