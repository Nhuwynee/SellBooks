package com.example.bansach;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.AudioAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListAudioBook extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AudioAdapter audioAdapter;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_audio_book); // Đảm bảo layout này tồn tại

        // Khởi tạo RecyclerView
        recyclerView = findViewById(R.id.recyclerView_audio);

        // Khởi tạo danh sách sách mẫu
        bookList = new ArrayList<>();
        list(); // Gọi phương thức để thêm sách vào danh sách

        // Thiết lập LayoutManager cho RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Khởi tạo AudioAdapter và gán cho RecyclerView
        audioAdapter = new AudioAdapter(bookList, book -> {
            // Xử lý khi người dùng click vào sách để nghe âm thanh
            // Ví dụ: Phát âm thanh sách
        }, (book, position) -> {
            // Xử lý sự kiện xóa sách
            audioAdapter.removeItem(position);
            Log.d("MainActivity", "Sách đã bị xóa: " + book.getTitle());
        });

        recyclerView.setAdapter(audioAdapter);

        // Gọi phương thức để thiết lập ItemTouchHelper
        setupItemTouchHelper();
    }

    // Phương thức thêm sách vào danh sách
    private void list() {
        bookList.add(new Book("Bong bóng anh đào", "Tê Kiến", 200000f, "Hoạt động", R.drawable.bong_bong_anh_dao));
        bookList.add(new Book("Hồng lục", "Kiêm Diệp Tử", 170000f, "Hoạt động", R.drawable.hong_luc));
        bookList.add(new Book("Này đừng có ăn cỏ!", "Lục Lục", 150000f, "Hoạt động", R.drawable.nay_dung_co_an_co));
        bookList.add(new Book("Nhật kính tình yêu", "Tống Cửu Cẩn", 250000f, "Hoạt động", R.drawable.nhat_kinh_tinh_yeu));
        bookList.add(new Book("Này chớ làm loạn", "Minh Nguyệt", 150000f, "Hoạt động", R.drawable.nay_cho_lam_loan));
        bookList.add(new Book("Án mạng mười một chữ", "Higashino Keigo", 200000f, "Hoạt động", R.drawable.tt6));
        bookList.add(new Book("Chí Phèo", "Nam Cao", 120000f, "Hoạt động", R.drawable.chipheo));
        bookList.add(new Book("Tắt đèn", "Ngô Tất Tố", 130000f, "Hoạt động", R.drawable.tatden));
        bookList.add(new Book("Thao túng tâm lý", "Shannon Thomas", 250000f, "Hoạt động", R.drawable.thaotungtamly));
        bookList.add(new Book("Vợ Nhặt", "Kim Lân", 90000f, "Hoạt động", R.drawable.vonhat));
    }

    // Thiết lập ItemTouchHelper để xóa sách bằng cách vuốt
    private void setupItemTouchHelper() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false; // Không sử dụng di chuyển
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Book removedBook = bookList.get(position);

                // Xóa sách khỏi danh sách
                audioAdapter.removeItem(position);
                Log.d("MainActivity", "Sách đã bị xóa: " + removedBook.getTitle());
            }
        });

        // Gán ItemTouchHelper vào RecyclerView
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
