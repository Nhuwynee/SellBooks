package com.example.bansach.Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bansach.R;
import com.google.android.material.textfield.TextInputLayout;

public class UpdateBookAdminFragment extends Fragment {

    // Khai báo các view trong giao diện
    private TextInputLayout bookNameLayout, authorNameLayout, categoryLayout, yearLayout, quantityLayout, descriptionLayout, additionalNotesLayout, priceLayout;
    private EditText editTextBookName, editTextAuthorName, editTextYear, editTextQuantity, editTextDescription, editTextAdditionalNotes, editTextPrice;
    private ImageView priceImage1, priceImage2;
    private Switch switchVisibility;
    private Button btnAdd;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.update_admin, container, false);

        // Liên kết các view với mã
        bookNameLayout = view.findViewById(R.id.editTextBookNameLayout);
        authorNameLayout = view.findViewById(R.id.editTextAuthorNameLayout);
        categoryLayout = view.findViewById(R.id.editTextCategoryLayout);
        yearLayout =view.findViewById(R.id.editTextYearLayout);
        quantityLayout = view.findViewById(R.id.editTextQuantityLayout);
        descriptionLayout = view.findViewById(R.id.editTextDescriptionLayout);
        additionalNotesLayout = view.findViewById(R.id.editTextAdditionalNotesLayout);
        priceLayout = view.findViewById(R.id.editTextPriceLayout);

        editTextBookName = view.findViewById(R.id.editTextBookName);
        editTextAuthorName = view.findViewById(R.id.editTextAuthorName);
        editTextYear = view.findViewById(R.id.editTextYear);
        editTextQuantity = view.findViewById(R.id.editTextQuantity);
        editTextDescription = view.findViewById(R.id.editTextDescription);
        editTextAdditionalNotes = view.findViewById(R.id.editTextAdditionalNotes);
        editTextPrice = view.findViewById(R.id.editTextPrice);

        priceImage1 = view.findViewById(R.id.priceImage1);
        priceImage2 = view.findViewById(R.id.priceImage2);

        switchVisibility = view.findViewById(R.id.switchVisibility);
        btnAdd = view.findViewById(R.id.btnAdd);

        // Xử lý sự kiện khi nhấn nút "UPDATE"
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookName = editTextBookName.getText().toString().trim();
                String authorName = editTextAuthorName.getText().toString().trim();
                String year = editTextYear.getText().toString().trim();
                String quantity = editTextQuantity.getText().toString().trim();
                String description = editTextDescription.getText().toString().trim();
                String additionalNotes = editTextAdditionalNotes.getText().toString().trim();
                String price = editTextPrice.getText().toString().trim();
                boolean isVisible = switchVisibility.isChecked();

                // Kiểm tra các trường không rỗng
                if (!bookName.isEmpty() && !authorName.isEmpty() && !price.isEmpty()) {
                    Toast.makeText(getContext(), "Đã cập nhật sách:\n" +
                            "Tên: " + bookName + "\n" +
                            "Tác giả: " + authorName + "\n" +
                            "Năm: " + year + "\n" +
                            "Số lượng: " + quantity + "\n" +
                            "Mô tả: " + description + "\n" +
                            "Ghi chú: " + additionalNotes + "\n" +
                            "Giá: " + price + "\n" +
                            "Hiển thị: " + (isVisible ? "Có" : "Không"), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Vui lòng điền hết tất cả các trường.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return  view;
    }
}
