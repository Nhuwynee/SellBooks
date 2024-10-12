package com.example.bansach.Admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.R;

public class AddBook extends AppCompatActivity {

    private EditText editTextBookName, editTextAuthorName, editTextYear, editTextQuantity, editTextDescription, editTextPrice;
    private Switch switchVisibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_book);
        // Ánh xạ các view
        editTextBookName = findViewById(R.id.editTextBookName);
        editTextAuthorName = findViewById(R.id.editTextAuthorName);
        editTextYear = findViewById(R.id.editTextYear);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextPrice = findViewById(R.id.editTextPrice);
        switchVisibility = findViewById(R.id.switchVisibility);
        Button btnAdd = findViewById(R.id.btnAdd);

        // Thiết lập sự kiện cho nút ADD
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBook();
            }
        });
    }

    private void addBook() {
        // Lấy dữ liệu từ các trường nhập liệu
        String bookName = editTextBookName.getText().toString().trim();
        String authorName = editTextAuthorName.getText().toString().trim();
        String year = editTextYear.getText().toString().trim();
        String quantity = editTextQuantity.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String price = editTextPrice.getText().toString().trim();
        boolean isVisible = switchVisibility.isChecked();

        if (bookName.isEmpty() || authorName.isEmpty() || year.isEmpty() || quantity.isEmpty() || description.isEmpty() || price.isEmpty()) {
            Toast.makeText(this, "Vui lòng điền tất cả các trường.", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Sách đã được thêm thành công!", Toast.LENGTH_SHORT).show();

    }

    private void clearInputs() {
        editTextBookName.setText("");
        editTextAuthorName.setText("");
        editTextYear.setText("");
        editTextQuantity.setText("");
        editTextDescription.setText("");
        editTextPrice.setText("");
        switchVisibility.setChecked(false);
    }
}
