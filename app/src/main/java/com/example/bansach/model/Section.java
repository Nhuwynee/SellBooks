package com.example.bansach.model;
import java.util.List;

public class Section {
    private String title;
    private static List<Book> itemList;

    public Section(String title, List<Book> itemList) {
        this.title = title;
        this.itemList = itemList;
    }

    public String getTitle() {
        return title;
    }

    public static List<Book> getItemList() {
        return itemList;
    }
}

