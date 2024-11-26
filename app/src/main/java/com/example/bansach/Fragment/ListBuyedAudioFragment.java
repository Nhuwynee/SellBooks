package com.example.bansach.Fragment;

import android.annotation.SuppressLint;
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
import com.example.bansach.Adapter.AudioAdapter;
import com.example.bansach.Adapter.FavouriteAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book;
import com.example.bansach.model.Book1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBuyedAudioFragment extends Fragment {
    private RecyclerView recyclerView;
    private AudioAdapter audioAdapter;
    private List<Book1> bookList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_buyed_audiobook, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_audio1);
        loadBooks();
        return view;
    }


    private void loadBooks() {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);

        Call<List<Book1>> call = apiService.getBuyedAudio(3);
        call.enqueue(new Callback<List<Book1>>() {
            @Override
            public void onResponse(Call<List<Book1>> call, Response<List<Book1>> response) {
                if (response.isSuccessful()) {
                    List<Book1> allBooks = response.body();

                    List<Book1> validBooks = new ArrayList<>();
                    for (Book1 book : allBooks) {
                        if (book.getIsActive() != null) {
                            if (book.getIsActive().equals("1")) {
                                book.setIsActive("Hoạt động");
                            } else if (book.getIsActive().equals("0")) {
                                book.setIsActive("Không hoạt động");
                            }
                        }
                        if (book.getURLaudioBook() != null && !book.getURLaudioBook().isEmpty()) {
                            validBooks.add(book);
                        }
                    }
                    bookList = validBooks;
                    setUpRecyclerView(bookList);
                } else {
                    Log.e("ListBuyedAudioFragment", "API error");
                }
            }

            @Override
            public void onFailure(Call<List<Book1>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });
    }


    private void setUpRecyclerView(List<Book1> books) {
        if (audioAdapter == null) {
            audioAdapter = new AudioAdapter(books, new AudioAdapter.OnBookClickListener() {
                @Override
                public void onBookClick(Book1 book) {
                    openListBuyedAudioFragment(book);
                }

            });
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(audioAdapter);
        }
    }

    private void openListBuyedAudioFragment(Book1 book) {
        String bookId = book.getId();
        Bundle bundle = new Bundle();
        bundle.putString("bookId", bookId);
        AudioFragment viewBookFragment = new AudioFragment();
        viewBookFragment.setArguments(bundle);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, viewBookFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
