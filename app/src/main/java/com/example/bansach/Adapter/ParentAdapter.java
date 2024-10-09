package com.example.bansach.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.R;
import com.example.bansach.model.Section;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> {
    private List<Section> sectionList;

    public ParentAdapter(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parent, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        Section section = sectionList.get(position);
        holder.sectionTitle.setText(section.getTitle());

        // Thiết lập RecyclerView con
        BookAdapter childAdapter = new BookAdapter(Section.getItemList());
        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.recyclerViewChild.getContext(), LinearLayoutManager.HORIZONTAL, false);
        holder.recyclerViewChild.setLayoutManager(layoutManager);
        holder.recyclerViewChild.setAdapter(childAdapter);
    }

    @Override
    public int getItemCount() {
        return sectionList.size();
    }

    public static class ParentViewHolder extends RecyclerView.ViewHolder {
        public TextView sectionTitle;
        public RecyclerView recyclerViewChild;

        public ParentViewHolder(View itemView) {
            super(itemView);
            sectionTitle = itemView.findViewById(R.id.sectionTitle);
            recyclerViewChild = itemView.findViewById(R.id.recyclerViewChild);
        }
    }
}
