package com.example.bansach.Admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.R;
import com.google.android.material.textfield.TextInputLayout;

public class AddBook extends AppCompatActivity {


    private EditText editTextBookName, editTextAuthorName, editTextYear, editTextQuantity, editTextDescription, editTextSample, editTextPrice;
    private Switch switchVisibility;


    private TextInputLayout editTextBookNameLayout, editTextAuthorNameLayout, editTextYearLayout, editTextQuantityLayout, editTextDescriptionLayout, editTextSampleLayout, editTextPriceLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_book);


        editTextBookNameLayout = findViewById(R.id.editTextBookNameLayout);
        editTextBookName = findViewById(R.id.editTextBookName);
        editTextAuthorNameLayout = findViewById(R.id.editTextAuthorNameLayout);
        editTextAuthorName = findViewById(R.id.editTextAuthorName);
        editTextYearLayout = findViewById(R.id.editTextYearLayout);
        editTextYear = findViewById(R.id.editTextYear);
        editTextQuantityLayout = findViewById(R.id.editTextQuantityLayout);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        editTextDescriptionLayout = findViewById(R.id.editTextDescriptionLayout);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextSampleLayout = findViewById(R.id.editTextSampleLayout);
        editTextSample = findViewById(R.id.editTextSample);
        editTextPriceLayout = findViewById(R.id.editTextPriceLayout);
        editTextPrice = findViewById(R.id.editTextPrice);
        switchVisibility = findViewById(R.id.switchVisibility);
        Button btnAdd = findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBook();
            }
        });
    }

    private void addBook() {
        // Get data from input fields
        String bookName = editTextBookName.getText().toString().trim();
        String authorName = editTextAuthorName.getText().toString().trim();
        String year = editTextYear.getText().toString().trim();
        String quantity = editTextQuantity.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String sampleContent = editTextSample.getText().toString().trim();
        String price = editTextPrice.getText().toString().trim();
        boolean isVisible = switchVisibility.isChecked();


        if (bookName.isEmpty() || authorName.isEmpty() || year.isEmpty() || quantity.isEmpty() || description.isEmpty() || sampleContent.isEmpty() || price.isEmpty()) {
            Toast.makeText(this, "Vui lòng điền tất cả các trường.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Perform the book addition logic (e.g., save to database)
        Toast.makeText(this, "Sách đã được thêm thành công!", Toast.LENGTH_SHORT).show();

        clearInputs();
    }

    private void clearInputs() {
        // Clear all input fields
        editTextBookName.setText("");
        editTextAuthorName.setText("");
        editTextYear.setText("");
        editTextQuantity.setText("");
        editTextDescription.setText("");
        editTextSample.setText("");
        editTextPrice.setText("");
        switchVisibility.setChecked(false);
    }
}
