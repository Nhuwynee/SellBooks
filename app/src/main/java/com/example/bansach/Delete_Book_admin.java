package com.example.bansach;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.ListViewBookAdapter;
import com.example.bansach.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Delete_Book_admin extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListViewBookAdapter bookAdapter;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_book);

        // Khởi tạo RecyclerView
        recyclerView = findViewById(R.id.recyclerView_addbook);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Khởi tạo danh sách Book mẫu
        bookList = new ArrayList<>();


        // Khởi tạo và gán Adapter cho RecyclerView
        bookAdapter = new ListViewBookAdapter(bookList);
        recyclerView.setAdapter(bookAdapter);

        // Thêm ItemTouchHelper để vuốt xóa item
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(this));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {
        private final Drawable deleteIcon;
        private final ColorDrawable background;
        private int iconWidth;

        public SwipeToDeleteCallback(Context context) {
            super(0, ItemTouchHelper.LEFT); // Chỉ cho phép vuốt trái
            deleteIcon = ContextCompat.getDrawable(context, R.drawable.ic_delete); // Icon thùng rác
            background = new ColorDrawable(Color.RED); // Nền khi vuốt
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false; // Không sử dụng di chuyển item
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            // Không xóa trực tiếp khi vuốt
        }

        @Override
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                float dX, float dY, int actionState, boolean isCurrentlyActive) {
            View itemView = viewHolder.itemView;
            int backgroundCornerOffset = 20; // Độ lệch nền khi vuốt

            // Giới hạn khoảng cách vuốt tới độ rộng của icon
            if (dX < -iconWidth) {
                dX = -iconWidth;
            }

            // Vẽ nền đỏ và icon thùng rác khi vuốt sang trái
            if (dX < 0) {
                background.setBounds(itemView.getRight() + (int) dX - backgroundCornerOffset,
                        itemView.getTop(), itemView.getRight(), itemView.getBottom());
                background.draw(c);

                int itemHeight = itemView.getHeight();
                int iconHeight = itemHeight - 20;
                iconWidth = iconHeight * deleteIcon.getIntrinsicWidth() / deleteIcon.getIntrinsicHeight();

                // Tính toán vị trí icon thùng rác
                int iconMargin = (itemHeight - iconHeight) / 2;
                int iconTop = itemView.getTop() + iconMargin;
                int iconBottom = iconTop + iconHeight;
                int iconLeft = itemView.getRight() - iconMargin - iconWidth;
                int iconRight = itemView.getRight() - iconMargin;
                deleteIcon.setBounds(iconLeft, iconTop, iconRight, iconBottom);
                deleteIcon.draw(c);

                // Di chuyển item với khoảng cách vuốt
                itemView.setTranslationX(dX);
            }

            // Xử lý khi vuốt hoàn thành hoặc người dùng dừng vuốt
            if (!isCurrentlyActive) {
                if (Math.abs(dX) == iconWidth) {
                    // Giữ vị trí item tại icon thùng rác
                    itemView.setTranslationX(-iconWidth);

                    // Lắng nghe sự kiện click để xóa item
                    itemView.setOnClickListener(v -> {
                        int position = viewHolder.getAdapterPosition();
                        bookAdapter.removeItem(position); // Xóa item
                        Toast.makeText(v.getContext(), "Item đã được xóa", Toast.LENGTH_SHORT).show();
                    });
                } else {
                    // Cho phép vuốt ngược lại để hủy bỏ
                    itemView.setTranslationX(0);
                    itemView.setOnClickListener(null); // Ngắt sự kiện xóa nếu không vuốt đủ
                    bookAdapter.notifyItemChanged(viewHolder.getAdapterPosition()); // Đặt lại vị trí item
                }
            }
        }
    }
}
