package com.example.bansach.Admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.R;
import com.google.android.material.textfield.TextInputLayout;

public class Update_book_admin extends AppCompatActivity {

    // Khai báo các view trong giao diện
    private TextInputLayout bookNameLayout, authorNameLayout, categoryLayout, yearLayout, quantityLayout, descriptionLayout, additionalNotesLayout, priceLayout;
    private EditText editTextBookName, editTextAuthorName, editTextYear, editTextQuantity, editTextDescription, editTextAdditionalNotes, editTextPrice;
    private ImageView priceImage1, priceImage2;
    private Switch switchVisibility;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_admin); // Đảm bảo tên tệp XML là đúng

        // Liên kết các view với mã
        bookNameLayout = findViewById(R.id.editTextBookNameLayout);
        authorNameLayout = findViewById(R.id.editTextAuthorNameLayout);
        categoryLayout = findViewById(R.id.editTextCategoryLayout);
        yearLayout = findViewById(R.id.editTextYearLayout);
        quantityLayout = findViewById(R.id.editTextQuantityLayout);
        descriptionLayout = findViewById(R.id.editTextDescriptionLayout);
        additionalNotesLayout = findViewById(R.id.editTextAdditionalNotesLayout);
        priceLayout = findViewById(R.id.editTextPriceLayout);

        editTextBookName = findViewById(R.id.editTextBookName);
        editTextAuthorName = findViewById(R.id.editTextAuthorName);
        editTextYear = findViewById(R.id.editTextYear);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextAdditionalNotes = findViewById(R.id.editTextAdditionalNotes);
        editTextPrice = findViewById(R.id.editTextPrice);

        priceImage1 = findViewById(R.id.priceImage1);
        priceImage2 = findViewById(R.id.priceImage2);

        switchVisibility = findViewById(R.id.switchVisibility);
        btnAdd = findViewById(R.id.btnAdd);

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
                    Toast.makeText(Update_book_admin.this, "Đã cập nhật sách:\n" +
                            "Tên: " + bookName + "\n" +
                            "Tác giả: " + authorName + "\n" +
                            "Năm: " + year + "\n" +
                            "Số lượng: " + quantity + "\n" +
                            "Mô tả: " + description + "\n" +
                            "Ghi chú: " + additionalNotes + "\n" +
                            "Giá: " + price + "\n" +
                            "Hiển thị: " + (isVisible ? "Có" : "Không"), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Update_book_admin.this, "Vui lòng điền hết tất cả các trường.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
