package com.example.bansach.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.Adapter.BookAdapter_search;
import com.example.bansach.Adapter.HistoryAdapter;
import com.example.bansach.OrderConfirmFragment;
import com.example.bansach.R;
import com.example.bansach.model.Book;
import com.example.bansach.model.History;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListHistoryFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_history, container, false);
        RecyclerView recyclerViewHistory = view.findViewById(R.id.recyclerViewHistory);

        List<History> historyList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            try {
                historyList.add(new History("2411001", dateFormat.parse("10/10/2024"), 425000, "Đang giao", "hong_luc", "xemay"));
                historyList.add(new History("2411002", dateFormat.parse("11/10/2024"), 500000, "Đã huỷ", "nhat_kinh_tinh_yeu", "dahuy"));
                historyList.add(new History("2411003", dateFormat.parse("12/10/2024"), 600000, "Đang giao", "mot_qua_tao", "xemay"));
                historyList.add(new History("2411004", dateFormat.parse("13/10/2024"), 600000, "Đang giao", "nay_cho_lam_loan", "xemay"));
                historyList.add(new History("2411005", dateFormat.parse("14/10/2024"), 600000, "Đã huỷ", "nay_dung_co_an_co", "dahuy"));
                historyList.add(new History("2411006", dateFormat.parse("15/10/2024"), 600000, "Đã giao", "nhunggiacmoohieusach", "dagiao"));
                historyList.add(new History("2411007", dateFormat.parse("16/10/2024"), 600000, "Đã giao", "ngaymaingaymaivangaymainua", "dagiao"));
                historyList.add(new History("2411008", dateFormat.parse("17/10/2024"), 600000, "Đã huỷ", "bong_bong_anh_dao", "dahuy"));
                historyList.add(new History("2411009", dateFormat.parse("18/10/2024"), 600000, "Đang giao", "boconcagai", "xemay"));
                historyList.add(new History("2411010", dateFormat.parse("19/10/2024"), 600000, "Đang giao", "bongtoigiuachungta", "xemay"));
                historyList.add(new History("2411011", dateFormat.parse("20/10/2024"), 600000, "Đã giao", "chinhphuchanhphuc", "dagiao"));
                historyList.add(new History("2411012", dateFormat.parse("21/10/2024"), 600000, "Đã giao", "tinh_yeu_cua_thoi_ha", "dagiao"));
                historyList.add(new History("2411013", dateFormat.parse("22/10/2024"), 600000, "Đã huỷ", "toc_cua_toi", "dahuy"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            HistoryAdapter historyAdapter = new HistoryAdapter(historyList, new HistoryAdapter.OnHistoryClickListener() {
                @Override
                public void onHistoryClick(History history) {
                    // Chuyển đến ViewBookFragment khi click vào sách
                    OrderConfirmFragment viewBookFragment = new OrderConfirmFragment();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, viewBookFragment)
                            .commit();
                }
            });
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerViewHistory.setLayoutManager(layoutManager);

            recyclerViewHistory.setAdapter(historyAdapter);
        } finally {

        }
        return view;
    }
}