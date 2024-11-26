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
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewBookFragment extends Fragment {

    FrameLayout frameLayout;
    TabLayout tabLayout;
    String bookId;
    TextView title, author, price, point, sl, slcart;
    ImageView img;
    Button btnIncrease, btnDecrease;
 int numbersl =1;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_viewbooks, container, false);
        ImageButton cart = view.findViewById(R.id.btn_cart);
        Button read = view.findViewById(R.id.doc_thu);
        ImageButton like =view.findViewById(R.id.btn_favourite_book);
        title = view.findViewById(R.id.title);
        author = view.findViewById(R.id.author);
        price = view.findViewById(R.id.price);
        point = view.findViewById(R.id.point);
        img = view.findViewById(R.id.img);
        sl = view.findViewById(R.id.book_sl);
        btnIncrease = view.findViewById(R.id.btngiamsoluong);
        btnDecrease = view.findViewById(R.id.btntangsoluong);
        slcart = view.findViewById(R.id.book_soluong);
        btnDecrease.setOnClickListener(v -> {
            int quantity = numbersl++ ;
            slcart.setText(String.valueOf(quantity));
        });

        btnIncrease.setOnClickListener(v -> {
            int quantity = numbersl--;
            slcart.setText(String.valueOf(quantity));
        });

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

        // Khởi tạo fragment mặc định
        Fragment fragment =  AboutFragment.newInstance( bookId);
        getParentFragmentManager().beginTransaction().replace(R.id.framelayout,fragment)
                .addToBackStack(null)
                .commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment =  AboutFragment.newInstance( bookId);
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
            public void onTabUnselected(TabLayout.Tab tab) {
                // Có thể để trống hoặc thực hiện một số hành động khi tab không được chọn nữa
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Có thể để trống hoặc thực hiện một số hành động khi tab đã được chọn lại
            }
        });

        // Sự kiện nút Đọc thử sách
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang Fragment khác
                ReadBookFragment newFragment = ReadBookFragment.newInstance(bookId);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment) // Đảm bảo ID container đúng
                        .addToBackStack(null) // Nếu muốn thêm vào backstack
                        .commit();
            }
        });

        // Sự kiện nút yêu thích sách
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang Fragment khác
                MessageFavouriteBookFragment newFragment = new MessageFavouriteBookFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang Fragment khác

                addToCart(Integer.parseInt(bookId), numbersl);
            }
        });

        return view; // Trả về view
    }


    private void loadBookDetails(String bookId) {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        Call<Book1> call = apiService.getBookDetails(bookId);  // Truyền bookId vào đây

        call.enqueue(new Callback<Book1>() {
            @Override
            public void onResponse(Call<Book1> call, Response<Book1> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Book1 bookDetails = response.body();
                    title.setText(bookDetails.getTitle());
                    author.setText(bookDetails.getAuthor());
                    price.setText(String.valueOf(bookDetails.getPrice()));
                    point.setText(bookDetails.getPoint() + " ★" );
                    sl.setText("| "+ String.valueOf(bookDetails.getInStock()) +" books");
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
    private void addToCart(int bookId, int sl) {
        // Lấy userId từ SharedPreferences
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("UserPrefs", MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1); // Lấy userId từ SharedPreferences

        if (userId != -1) {
            // Tạo đối tượng Book hoặc Cart tùy vào cách bạn gửi dữ liệu
            // Tạo đối tượng Cart với các thông tin cần thiết
            Cart1 cartItem = new Cart1(userId, bookId, sl); // chỉ gửi idUser, idBook và number

// Chuyển đối tượng Cart thành JSON
            Gson gson = new Gson();
            String json = gson.toJson(cartItem);

// In ra JSON trước khi gửi
            Log.d("AddToCart", "Sending JSON: " + json);


            // Gọi API để thêm cuốn sách vào giỏ hàng
            APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
            Call<Void> call = apiService.addToCart(cartItem);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Log.d("ViewBookFragment", "Sách đã được thêm vào giỏ hàng");
                        // Cập nhật UI hoặc hiển thị thông báo
                        // Bạn có thể chuyển sang giỏ hàng sau khi thêm thành công:
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
