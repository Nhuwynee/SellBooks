package com.example.bansach.Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.InvoiceAdapter;
import com.example.bansach.R;
import com.example.bansach.model.History;
import com.example.bansach.model.Invoice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListInvoiceFragment extends Fragment {
    List<Invoice> filteredBookList = new ArrayList<>();
    private RecyclerView recyclerViewInvoices;
    private InvoiceAdapter invoiceAdapter;
    List<Invoice> invoiceList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_invoice, container, false);

        recyclerViewInvoices = view.findViewById(R.id.recycler);
        list();
        Spinner spinner = view.findViewById(R.id.spinner3);
        // Danh sách các tùy chọn cho Spinner
        String[] options = {"All", "Đã giao", "Đang giao", "Đã huỷ"};

        // Tạo ArrayAdapter để liên kết dữ liệu với Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.item_list_filter, options);
        adapter.setDropDownViewResource(R.layout.item_filter);

        // Gắn Adapter vào Spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                filterHistoryByGenre(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không làm gì nếu không có mục nào được chọn
            }
        });
        return view;
    }
    public void list(){
        invoiceList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {

            try {
                invoiceList.add(new Invoice("2411001", dateFormat.parse("10/10/2024"), 425000, "Đang giao", "ava_admin_1", "xemay"));
                invoiceList.add(new Invoice("2411002", dateFormat.parse("11/10/2024"), 500000, "Đã huỷ", "ava_admin_2", "dahuy"));
                invoiceList.add(new Invoice("2411003", dateFormat.parse("12/10/2024"), 600000, "Đang giao", "ava_admin_3", "xemay"));
                invoiceList.add(new Invoice("2411004", dateFormat.parse("13/10/2024"), 600000, "Đang giao", "ava_admin_4", "xemay"));
                invoiceList.add(new Invoice("2411005", dateFormat.parse("14/10/2024"), 600000, "Đã huỷ", "ava_admin_5", "dahuy"));
                invoiceList.add(new Invoice("2411006", dateFormat.parse("15/10/2024"), 600000, "Đã giao", "ava_admin_6", "dagiao"));
                invoiceList.add(new Invoice("2411007", dateFormat.parse("16/10/2024"), 600000, "Đã giao", "ava_admin_7", "dagiao"));
                invoiceList.add(new Invoice("2411008", dateFormat.parse("17/10/2024"), 600000, "Đã huỷ", "ava_admin_1", "dahuy"));
                invoiceList.add(new Invoice("2411009", dateFormat.parse("18/10/2024"), 600000, "Đang giao", "ava_admin_2", "xemay"));
                invoiceList.add(new Invoice("2411010", dateFormat.parse("19/10/2024"), 600000, "Đang giao", "ava_admin_3", "xemay"));
                invoiceList.add(new Invoice("2411011", dateFormat.parse("20/10/2024"), 600000, "Đã giao", "ava_admin_4", "dagiao"));
                invoiceList.add(new Invoice("2411012", dateFormat.parse("21/10/2024"), 600000, "Đã giao", "ava_admin_5", "dagiao"));
                invoiceList.add(new Invoice("2411013", dateFormat.parse("22/10/2024"), 600000, "Đã huỷ", "ava_admin_6", "dahuy"));
                filteredBookList.addAll(invoiceList);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
             invoiceAdapter = new InvoiceAdapter(filteredBookList, new InvoiceAdapter.OnInvoiceClickListener() {
                @Override
                public void oninvoiceClick(Invoice invoice) {
                    DetailInvoiceFragment viewBookFragment = new DetailInvoiceFragment();
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_admin, viewBookFragment)
                            .commit();
                }
            });

            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerViewInvoices.setLayoutManager(layoutManager);

            // Gán adapter cho RecyclerView
            recyclerViewInvoices.setAdapter(invoiceAdapter);
        } finally {

        }
    }
    private void filterHistoryByGenre(String genre) {
        filteredBookList.clear(); // Xóa danh sách đã lọc

        if (genre.equalsIgnoreCase("All")) {
            filteredBookList.addAll(invoiceList); // Hiển thị tất cả sách
        } else {
            for (Invoice b : invoiceList) {
                String category = b.getOrderStatus();
                if (category.trim().equalsIgnoreCase(genre.trim())) {
                    filteredBookList.add(b);
                }
            }
        }

        ; // Cập nhật dữ liệu trong adapter
        invoiceAdapter.notifyDataSetChanged();
    }
}
