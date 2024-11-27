    package com.example.bansach.Fragment;

    import static android.content.Context.MODE_PRIVATE;

    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageButton;
    import android.widget.TextView;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.fragment.app.Fragment;
    import androidx.recyclerview.widget.GridLayoutManager;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.example.bansach.API.APIService;
    import com.example.bansach.API.RetrofitClient;
    import com.example.bansach.Adapter.BookAdapter_search;
    import com.example.bansach.Adapter.CartAdapter;
    import com.example.bansach.R;
    import com.example.bansach.model.Book;
    import com.example.bansach.model.Book1;
    import com.example.bansach.model.Cart;

    import java.util.ArrayList;
    import java.util.List;

    import retrofit2.Call;
    import retrofit2.Callback;
    import retrofit2.Response;

    public class CartFragment extends Fragment {
        private RecyclerView recyclerView;
        private CartAdapter cartAdapter;
        private List<Cart> bookList;
        private TextView point, sum;
        private float sum1 = 0;  // Tổng tiền, mặc định là 0

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_cart, container, false);
            recyclerView = view.findViewById(R.id.recyclerView_cart);
            ImageButton cart = view.findViewById(R.id.btn_cart);
            point = view.findViewById(R.id.point);
            sum = view.findViewById(R.id.summoney);

            loadBooks();

            // Xử lý sự kiện nhấn nút
            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Chuyển sang Fragment khác
                    OrderFragment newFragment = new OrderFragment();
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.container, newFragment) // Đảm bảo ID container đúng
                            .addToBackStack(null) // Nếu muốn thêm vào backstack
                            .commit();
                }
            });
            return view; // Trả về view đã tạo
        }

        private void loadBooks() {
            APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPrefs", MODE_PRIVATE);
            int userId = sharedPreferences.getInt("userId", -1);
            Log.d("UserId", "User ID: " + userId);
            Call<List<Cart>> call = apiService.getBooksbyIdUser(userId);
            call.enqueue(new Callback<List<Cart>>() {
                @Override
                public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                    if (response.isSuccessful()) {
                        bookList = response.body();
                        setUpRecyclerView(bookList);
                        updateTotalPrice();  // Cập nhật tổng tiền và điểm sau khi nhận được dữ liệu
                    } else {
                        Log.e("SearchFragment", "API error");
                    }
                }

                @Override
                public void onFailure(Call<List<Cart>> call, Throwable t) {
                    Log.e("API_ERROR", "Error: " + t.getMessage());
                }
            });
        }

        private void setUpRecyclerView(List<Cart> books) {
            if (cartAdapter == null) {
                cartAdapter = new CartAdapter(books, getContext(), new CartAdapter.OnItemChangeListener() {
                    @Override
                    public void onItemChanged() {
                        // Khi có sự thay đổi trong item (ví dụ: thay đổi số lượng hoặc chọn sách)
                        updateTotalPrice();
                    }
                });
                LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(cartAdapter);
            } else {
                cartAdapter.updateBooks(books);
            }
        }

        private void updateTotalPrice() {
            sum1 = 0;  // Đặt lại tổng tiền về 0 mỗi khi tính toán lại
            int totalPoints = 0;  // Khởi tạo biến tổng điểm

            if (bookList != null && !bookList.isEmpty()) {
                for (Cart book : bookList) {
                    totalPoints= book.getPointSum();  // Cộng dồn điểm sách
                    float money = book.getNumber() * book.getPrice();  // Tính tiền cho sách
                    sum1 += money;  // Cộng tiền vào tổng
                }

                // Cập nhật điểm và tổng tiền
                point.setText(String.format("%d ★", totalPoints));
                sum.setText(String.format("%.2f", sum1));
            } else {
                point.setText("0 ★");
                sum.setText("0.00");
            }
        }
    }
