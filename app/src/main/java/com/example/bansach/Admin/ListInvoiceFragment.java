package com.example.bansach.Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.InvoiceAdapter;
import com.example.bansach.R;
import com.example.bansach.model.Invoice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListInvoiceFragment extends Fragment {

    private RecyclerView recyclerViewInvoices;
    private InvoiceAdapter invoiceAdapter;
    private List<Invoice> invoiceList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_invoice, container, false);

        recyclerViewInvoices = view.findViewById(R.id.recycler);
        list();
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
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            InvoiceAdapter invoiceAdapter = new InvoiceAdapter(invoiceList, new InvoiceAdapter.OnInvoiceClickListener() {
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
}
