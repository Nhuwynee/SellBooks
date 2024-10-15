package com.example.bansach.Admin;

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

import com.example.bansach.Adapter.AudioAdapter;
import com.example.bansach.Adapter.ListViewBookAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListAudioBookAdminFragment extends Fragment {
    private RecyclerView recyclerView;
    private AudioAdapter audioAdapter;
    private List<Book> bookList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_audio_book, container, false);

        // Khởi tạo RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView_audio);

        audioAdapter = new AudioAdapter(bookList, new AudioAdapter.OnBookClickListener() {
            @Override
            public void onBookClick(Book book) {
                // Xử lý khi người dùng click vào sách để xem thông tin
                if (container != null) {
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_admin, new UpdateBookAdminFragment())
                            .addToBackStack(null) // Có thể thêm để quay lại fragment trước đó
                            .commit();
                } else {
                    Log.e("FragmentTransaction", "Container not found!");
                }
            }
        }, new AudioAdapter.OnBookDeleteListener() {
            @Override
            public void onBookDelete(Book book, int position) {
                // Xử lý việc xóa sách
                audioAdapter.removeItem(position);
                Log.d("ListViewBookFragment", "Sách đã bị xóa: " + book.getTitle());
            }
        });

        list();
        Delete();
        return view;
    }

    // Phương thức thêm sách vào danh sách
    private void list() {
        bookList.add(new Book("Bơ đi mà sống", "Mèo Xù", 200000f, "Hoạt động", R.drawable.bo_di_ma_song));
        bookList.add(new Book("Hồng lục", "Kiêm Diệp Tử", 170000f, "Hoạt động", R.drawable.hong_luc));
        bookList.add(new Book("Này đừng có ăn cỏ!", "Lục Lục", 150000f, "Hoạt động", R.drawable.nay_dung_co_an_co));
        bookList.add(new Book("Nhật kính tình yêu", "Tống Cửu Cẩn", 250000f, "Hoạt động", R.drawable.nhat_kinh_tinh_yeu));
        bookList.add(new Book("Này chớ làm loạn", "Minh Nguyệt", 150000f, "Hoạt động", R.drawable.nay_cho_lam_loan));
        bookList.add(new Book("Án mạng mười một chữ", "Higashino Keigo", 200000f, "Hoạt động", R.drawable.tt6));
        bookList.add(new Book("Chí Phèo", "Nam Cao", 120000f, "Hoạt động", R.drawable.chipheo));
        bookList.add(new Book("Tắt đèn", "Ngô Tất Tố", 130000f, "Hoạt động", R.drawable.tatden));
        bookList.add(new Book("Thao túng tâm lý", "Shannon Thomas", 250000f, "Hoạt động", R.drawable.thaotungtamly));
        bookList.add(new Book("Vợ Nhặt", "Kim Lân", 90000f, "Hoạt động", R.drawable.vonhat));


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(audioAdapter);

    }
    public void Delete() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false; // Không sử dụng di chuyển
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                // Lấy ViewHolder của item đã vuốt
                AudioAdapter.BookViewHolder bookViewHolder = (AudioAdapter.BookViewHolder) viewHolder;

                // Hiển thị buttonDelete sau khi vuốt
                bookViewHolder.bookImage.setVisibility(View.GONE);
                bookViewHolder.buttonDeleteAudio.setVisibility(View.VISIBLE);

                // Hoàn tác thao tác vuốt để item không bị xóa
                audioAdapter.notifyItemChanged(position);



            }
        });

        // Gán ItemTouchHelper vào RecyclerView
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

}
