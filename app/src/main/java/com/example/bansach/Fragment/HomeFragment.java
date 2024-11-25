package com.example.bansach.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.Adapter.BookAdapter_search;
import com.example.bansach.Adapter.ParentAdapter;
import com.example.bansach.Adapter.TextAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book1;
import com.example.bansach.model.Section;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private ParentAdapter parentAdapter;
    private List<Section> sectionList;
    private BottomNavigationView bottomNavigationView;
    private ViewFlipper viewFlipper;
    private RecyclerView recyclerViewMain, recyclerView1, recyclerView2, recyclerView3, recyclerView4, recyclerView5, recyclerView6;
    private APIService apiService;
    private TextView textView1, textView2,textView3,textView4,textView5,textView6;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trang_chu, container, false);

        // Khởi tạo các view
        viewFlipper = view.findViewById(R.id.viewflipper);
        recyclerViewMain = view.findViewById(R.id.recyclerViewMain);
        recyclerView1 = view.findViewById(R.id.recyclerView1);
        recyclerView2 = view.findViewById(R.id.recyclerView2);
        recyclerView3 = view.findViewById(R.id.recyclerView3);
        recyclerView4 = view.findViewById(R.id.recyclerView4);
        recyclerView5 = view.findViewById(R.id.recyclerView5);
        recyclerView6 = view.findViewById(R.id.recyclerView6);
        textView1 = view.findViewById(R.id.categoryTitle1);
        textView2 = view.findViewById(R.id.categoryTitle2);
        textView3 = view.findViewById(R.id.categoryTitle3);
        textView4 = view.findViewById(R.id.categoryTitle4);
        textView5 = view.findViewById(R.id.categoryTitle5);
        textView6 = view.findViewById(R.id.categoryTitle6);

        // Khởi tạo APIService
        apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);

        // Gọi các hàm để thiết lập dữ liệu
        addImagesToFlipper();
        loadBooksByCategory("Tiểu thuyết", recyclerView1, textView1); // Ví dụ thể loại "fiction"
        loadBooksByCategory("Văn học", recyclerView2, textView2); // Ví dụ thể loại "non-fiction"
        loadBooksByCategory("Tâm lý học", recyclerView3, textView3);
        loadBooksByCategory("Self-help", recyclerView4, textView4);
        loadBooksByCategory("Kỹ năng sống", recyclerView5, textView5);
        loadBooksByCategory("Trinh thám", recyclerView6, textView6);// Giới thiệu thể loại chính
        category();

        TextView filter = view.findViewById(R.id.filter);
        // Spannable cho Forgot Password
        SpannableString spannableString_forgot = new SpannableString("Xem thêm");
        ClickableSpan clickableSpan_forgot = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Chuyển đến forgot_pass Activity
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CategoryFragment()) // Thay thế 'container' bằng ID thực tế của Layout chứa Fragment
                        .addToBackStack(null) // Thêm vào back stack nếu muốn quay lại
                        .commit();
                // Xóa màu nền khi nhấn vào
                filter.setBackgroundColor(Color.TRANSPARENT);
            }

            @Override
            public void updateDrawState(android.text.TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true); // Gạch chân chữ
                ds.setColor(filter.getCurrentTextColor()); // Giữ nguyên màu chữ hiện tại
                ds.bgColor = Color.TRANSPARENT; // Màu nền trong suốt
            }
        };
        spannableString_forgot.setSpan(clickableSpan_forgot, 0, spannableString_forgot.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        filter.setText(spannableString_forgot);
        filter.setMovementMethod(LinkMovementMethod.getInstance()); // Cho phép TextView có thể nhấn

        return view;
    }

    private void addImagesToFlipper() {
        try {
            int[] images = {R.drawable.promotion, R.drawable.read_book_3, R.drawable.yeuthich, R.drawable.audiobook};
            for (int image : images) {
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(image);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(5000);
            viewFlipper.setAutoStart(true);
            viewFlipper.startFlipping();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void category() {
        // Tạo danh sách sách cho mỗi RecyclerView
        List<String> bookList1 = new ArrayList<>();

        // Thêm dữ liệu vào các danh sách sách
        bookList1.add("Tiểu thuyết");
        bookList1.add("Văn học");
        bookList1.add("Tâm lý học");
        bookList1.add("Self-help");
        bookList1.add("Kỹ năng sống");
        bookList1.add("Trinh thám");

        TextAdapter textAdapter = new TextAdapter(bookList1);

        // Thiết lập LinearLayoutManager cho từng RecyclerView
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewMain.setLayoutManager(layoutManager1);
        recyclerViewMain.setAdapter(textAdapter);
    }

    private void loadBooksByCategory(String category, RecyclerView recyclerView, TextView categoryTitle) {
        // Cập nhật tên thể loại cho TextView
        categoryTitle.setText(category);

        // Tiến hành lấy sách từ API
        Call<List<Book1>> call = apiService.getBooksByCategory(category);
        call.enqueue(new Callback<List<Book1>>() {
            @Override
            public void onResponse(Call<List<Book1>> call, Response<List<Book1>> response) {
                if (response.isSuccessful()) {
                    List<Book1> books = response.body();
                    if (books != null && !books.isEmpty()) {
                        setUpRecyclerView(books, recyclerView);
                    } else {
                        showNoBooksMessage(recyclerView);
                    }
                } else {
                    showNoBooksMessage(recyclerView);
                }
            }

            @Override
            public void onFailure(Call<List<Book1>> call, Throwable t) {
                showNoBooksMessage(recyclerView);
            }
        });
    }


    private void setUpRecyclerView(List<Book1> books, RecyclerView recyclerView) {
        BookAdapter_search bookAdapter = new BookAdapter_search(books, getContext(), new BookAdapter_search.OnBookClickListener() {
            @Override
            public void onBookClick(Book1 book) {
                openBookDetailFragment(book);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(bookAdapter);
    }

    private void showNoBooksMessage(RecyclerView recyclerView) {
        recyclerView.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Không có sách nào trong thể loại này.", Toast.LENGTH_SHORT).show();
    }

    private void openBookDetailFragment(Book1 book) {
        Bundle bundle = new Bundle();
        bundle.putString("bookId", book.getId());
        ViewBookFragment viewBookFragment = new ViewBookFragment();
        viewBookFragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, viewBookFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

