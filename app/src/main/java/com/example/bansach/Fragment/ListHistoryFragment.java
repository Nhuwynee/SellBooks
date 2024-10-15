package com.example.bansach.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.HistoryAdapter;
import com.example.bansach.R;
import com.example.bansach.model.History;
import com.example.bansach.model.Invoice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListHistoryFragment extends Fragment {
    List<History> filteredBookList = new ArrayList<>();
    List<History> historyList = new ArrayList<>();
    private HistoryAdapter historyAdapter;  // Khai báo toàn cục đúng cách

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_history, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewHistory);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            historyList.add(new History("2411001", dateFormat.parse("10/10/2024"), 425000, "Đang giao", "hong_luc", "xemay"));
            historyList.add(new History("2411002", dateFormat.parse("11/10/2024"), 500000, "Đã huỷ", "nhat_kinh_tinh_yeu", "dahuy"));
            historyList.add(new History("2411003", dateFormat.parse("12/10/2024"), 600000, "Đang giao", "mot_qua_tao", "xemay"));
            historyList.add(new History("2411004", dateFormat.parse("13/10/2024"), 150000, "Đang giao", "nay_cho_lam_loan", "xemay"));
            historyList.add(new History("2411005", dateFormat.parse("14/10/2024"), 680000, "Đã huỷ", "nay_dung_co_an_co", "dahuy"));
            historyList.add(new History("2411006", dateFormat.parse("15/10/2024"), 250000, "Đã giao", "nhunggiacmoohieusach", "dagiao"));
            historyList.add(new History("2411007", dateFormat.parse("16/10/2024"), 405000, "Đã giao", "ngaymaingaymaivangaymainua", "dagiao"));
            historyList.add(new History("2411008", dateFormat.parse("17/10/2024"), 550000, "Đã huỷ", "bong_bong_anh_dao", "dahuy"));
            historyList.add(new History("2411009", dateFormat.parse("18/10/2024"), 675000, "Đang giao", "boconcagai", "xemay"));
            historyList.add(new History("2411010", dateFormat.parse("19/10/2024"), 275000, "Đang giao", "bongtoigiuachungta", "xemay"));
            historyList.add(new History("2411011", dateFormat.parse("20/10/2024"), 320000, "Đã giao", "chinhphuchanhphuc", "dagiao"));
            historyList.add(new History("2411012", dateFormat.parse("21/10/2024"), 320000, "Đã giao", "tinh_yeu_cua_thoi_ha", "dagiao"));
            historyList.add(new History("2411013", dateFormat.parse("22/10/2024"), 475000, "Đã huỷ", "toc_cua_toi", "dahuy"));
            filteredBookList.addAll(historyList);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // Khởi tạo historyAdapter toàn cục
        historyAdapter = new HistoryAdapter(filteredBookList, new HistoryAdapter.OnHistoryClickListener() {
            @Override
            public void onHistoryClick(History history) {
                // Chuyển đến OrderConfirmFragment khi click vào sách
                OrderConfirmFragment viewBookFragment = new OrderConfirmFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, viewBookFragment)
                        .addToBackStack(null)  // Thêm vào back stack
                        .commit();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(historyAdapter);

        Spinner spinner = view.findViewById(R.id.spinner2);
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

    private void filterHistoryByGenre(String genre) {
        filteredBookList.clear(); // Xóa danh sách đã lọc

        if (genre.equalsIgnoreCase("All")) {
            filteredBookList.addAll(historyList); // Hiển thị tất cả sách
        } else {
            for (History b : historyList) {
                String category = b.getOrderStatus();
                if (category.trim().equalsIgnoreCase(genre.trim())) {
                    filteredBookList.add(b);
                }
            }
        }

        ; // Cập nhật dữ liệu trong adapter
        historyAdapter.notifyDataSetChanged();
    }
}
