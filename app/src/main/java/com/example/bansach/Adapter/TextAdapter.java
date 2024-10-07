package com.example.bansach.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bansach.R;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.TextViewHolder> {
    private List<String> textList;

    public TextAdapter(List<String> textList) {
        this.textList = textList;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        String text = textList.get(position);
        holder.textViewItem.setText(text);
    }

    @Override
    public int getItemCount() {
        return textList.size();
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewItem;

        public TextViewHolder(View itemView) {
            super(itemView);
            textViewItem = itemView.findViewById(R.id.text_category);
        }
    }
}

