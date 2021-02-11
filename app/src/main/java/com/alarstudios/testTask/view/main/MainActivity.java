package com.alarstudios.testTask.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.alarstudios.testTask.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, ItemClickListener{

    RecyclerView recyclerView;
    List items;


    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        setListeners();
    }

    private void initUi() {
        recyclerView = findViewById(R.id.recyclerView);
        items = new ArrayList();

    }

    private void setListeners() {

    }

    @Override
    public void setDatToRecyclerView(List items) {
        this.items.addAll(items);
    }

    @Override
    public void onMovieItemClick(int position) {

    }
}