package com.alarstudios.testTask.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Items {

    @SerializedName("data") private List<Item> items;
    @SerializedName("page") private int page;
    @SerializedName("status") private String status;

    public int getPage() {
        return page;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }
}
