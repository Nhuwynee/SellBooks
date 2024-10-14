package com.example.bansach.Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bansach.Fragment.ComfirmFragment;
import com.example.bansach.R;
import com.google.android.material.textfield.TextInputLayout;

public class AddBookFragment extends Fragment {
    private EditText editTextBookName, editTextAuthorName, editTextYear, editTextQuantity, editTextDescription, editTextSample, editTextPrice;
    private Switch switchVisibility;
    private TextInputLayout editTextBookNameLayout, editTextAuthorNameLayout, editTextYearLayout, editTextQuantityLayout, editTextDescriptionLayout, editTextSampleLayout, editTextPriceLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_book, container, false);
        Button add = view.findViewById(R.id.btnAdd);

        // Xử lý sự kiện nhấn nút
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListViewBookFragment newFragment = new ListViewBookFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container_admin, newFragment) // Đảm bảo ID container đúng
                        .addToBackStack(null) // Nếu muốn thêm vào backstack
                        .commit();
            }
        });

        editTextBookNameLayout = view.findViewById(R.id.editTextBookNameLayout);
        editTextBookName = view.findViewById(R.id.editTextBookName);
        editTextAuthorNameLayout = view.findViewById(R.id.editTextAuthorNameLayout);
        editTextAuthorName = view.findViewById(R.id.editTextAuthorName);
        editTextYearLayout = view.findViewById(R.id.editTextYearLayout);
        editTextYear = view.findViewById(R.id.editTextYear);
        editTextQuantityLayout = view.findViewById(R.id.editTextQuantityLayout);
        editTextQuantity = view.findViewById(R.id.editTextQuantity);
        editTextDescriptionLayout = view.findViewById(R.id.editTextDescriptionLayout);
        editTextDescription = view.findViewById(R.id.editTextDescription);
        editTextSampleLayout = view.findViewById(R.id.editTextSampleLayout);
        editTextSample = view.findViewById(R.id.editTextSample);
        editTextPriceLayout = view.findViewById(R.id.editTextPriceLayout);
        editTextPrice = view.findViewById(R.id.editTextPrice);
        switchVisibility = view.findViewById(R.id.switchVisibility);
        Button btnAdd = view.findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBook();
            }
        });
        return view;

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
            Toast.makeText(getContext(), "Vui lòng điền tất cả các trường.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Perform the book addition logic (e.g., save to database)
        Toast.makeText(getContext(), "Sách đã được thêm thành công!", Toast.LENGTH_SHORT).show();

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
