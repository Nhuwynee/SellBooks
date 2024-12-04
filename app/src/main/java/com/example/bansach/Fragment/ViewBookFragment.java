package com.example.bansach.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.R;
import com.example.bansach.model.Book;
import com.example.bansach.model.Book1;
import com.example.bansach.model.Cart;
import com.example.bansach.model.Cart1;
import com.example.bansach.model.FavouriteBook;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewBookFragment extends Fragment {

    FrameLayout frameLayout;
    TabLayout tabLayout;
    String bookId;
    TextView title, author, price, point, sl;
    ImageView img;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_viewbooks, container, false);
        ImageButton cart = view.findViewById(R.id.btn_cart);
        Button read = view.findViewById(R.id.doc_thu);
        ImageButton like = view.findViewById(R.id.btn_favourite_book);
        title = view.findViewById(R.id.title);
        author = view.findViewById(R.id.author);
        price = view.findViewById(R.id.price);
        point = view.findViewById(R.id.point);
        img = view.findViewById(R.id.img);
        sl = view.findViewById(R.id.book_sl);

        if (getArguments() != null) {
            bookId = getArguments().getString("bookId");
            Log.d("ViewBookFragment", "Received bookId: " + bookId);
            if (bookId != null) {
                loadBookDetails(bookId);
            } else {
                Log.e("ViewBookFragment", "bookId là null");
            }
        } else {
            Log.e("ViewBookFragment", "getArguments() là null");
        }
        frameLayout = view.findViewById(R.id.framelayout);
        tabLayout = view.findViewById(R.id.tablayout);

        Fragment fragment = AboutFragment.newInstance(bookId);
        getParentFragmentManager().beginTransaction().replace(R.id.framelayout, fragment)
                .addToBackStack(null)
                .commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = AboutFragment.newInstance(bookId);
                        break;
                    case 1:
                        fragment = ReviewFragment.newInstance(bookId);
                        break;
                    case 2:
                        fragment = AuthorFragment.newInstance(bookId);
                        break;
                }

                if (fragment != null) {
                    getParentFragmentManager().beginTransaction().replace(R.id.framelayout, fragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        read.setOnClickListener(v -> {
            ReadBookFragment newFragment = ReadBookFragment.newInstance(bookId);
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container, newFragment)
                    .addToBackStack(null)
                    .commit();
        });

        like.setOnClickListener(v -> {

            addToFavourite(Integer.parseInt(bookId), v);
        });
        cart.setOnClickListener(v -> addToCart(Integer.parseInt(bookId)));

        return view;
    }
    private void loadBookDetails(String bookId) {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        Call<Book1> call = apiService.getBookDetails(bookId);

        call.enqueue(new Callback<Book1>() {
            @Override
            public void onResponse(Call<Book1> call, Response<Book1> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Book1 bookDetails = response.body();
                    title.setText(bookDetails.getTitle());
                    author.setText(bookDetails.getAuthor());
                    price.setText(String.valueOf(bookDetails.getPrice()));
                    point.setText(bookDetails.getPoint() + " ★");
                    sl.setText("| " + String.valueOf(bookDetails.getInStock()) + " books");

                    String imageName = bookDetails.getImgResource();
                    if (imageName.endsWith(".jpg") || imageName.endsWith(".png")) {
                        imageName = imageName.substring(0, imageName.lastIndexOf('.'));
                    }

                    if (getContext() != null) {
                        int resId = getContext().getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());

                        if (resId != 0) {
                            Glide.with(getContext()).load(resId).into(img);
                        } else {
                            Log.e("ViewBookFragment", "Không tìm thấy resource ảnh cho: " + imageName);
                            img.setVisibility(View.GONE);
                        }
                    } else {
                        Log.e("ViewBookFragment", "Context là null");
                    }
                } else {
                    Log.e("ViewBookFragment", "Không thể tải chi tiết sách, response body là null hoặc không thành công");
                }
            }

            @Override
            public void onFailure(Call<Book1> call, Throwable t) {
                Log.e("ViewBookFragment", "Lỗi API: " + t.getMessage());
            }
        });
    }

    private void addToFavourite(int bookId, View v) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1); // Lấy userId từ SharedPreferences

        if (userId != -1) {
            FavouriteBook favouriteBook = new FavouriteBook(userId, bookId); // Tạo đối tượng yêu thích

            Gson gson = new Gson();
            String json = gson.toJson(favouriteBook);

            Log.d("AddToFavourite", "Sending JSON: " + json);

            APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
            Call<Void> call = apiService.addBookToFavourite(favouriteBook );
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Log.d("ViewBookFragment", "Sách đã được thêm vào danh sách yêu thích");

                        MessageFavouriteBookFragment newFragment = new MessageFavouriteBookFragment();

                        Bundle bundle = new Bundle();
                        bundle.putInt("userId", userId);
                        bundle.putInt("bookId", bookId);
                        newFragment.setArguments(bundle);

                        getParentFragmentManager().beginTransaction()
                                .replace(R.id.container, newFragment)
                                .addToBackStack(null)
                                .commit();
                    } else {
                        Log.e("ViewBookFragment", "Không thể thêm sách vào danh sách yêu thích");
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.e("ViewBookFragment", "Lỗi API: " + t.getMessage());
                }
            });
        } else {
            Log.e("ViewBookFragment", "userId không hợp lệ");
        }
    }
    // Phương thức thêm sách vào giỏ hàng
    private void addToCart(int bookId) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1);

        if (userId != -1) {
            Cart1 cartItem = new Cart1(userId, bookId, 1);
            Gson gson = new Gson();
            String json = gson.toJson(cartItem);

            Log.d("AddToCart", "Sending JSON: " + json);

            APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
            Call<Void> call = apiService.addToCart(cartItem);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Log.d("ViewBookFragment", "Sách đã được thêm vào giỏ hàng");
                        CartFragment newFragment = new CartFragment();
                        getParentFragmentManager().beginTransaction()
                                .replace(R.id.container, newFragment)
                                .addToBackStack(null)
                                .commit();
                    } else {
                        Log.e("ViewBookFragment", "Không thể thêm sách vào giỏ hàng");
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.e("ViewBookFragment", "Lỗi API: " + t.getMessage());
                }
            });
        } else {
            Log.e("ViewBookFragment", "userId không hợp lệ");
        }
    }
}

