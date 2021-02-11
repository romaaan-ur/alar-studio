package com.alarstudios.testTask.view.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.alarstudios.testTask.R;
import com.alarstudios.testTask.data.preferences.PreferencesProvider;
import com.alarstudios.testTask.view.item.ItemActivity;
import com.alarstudios.testTask.view.login.LoginActivity;
import com.alarstudios.testTask.view.main.adapter.ItemsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, ItemClickListener {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    List items;
    private MainPresenter presenter;
    private ItemsAdapter itemsAdapter;
    private ProgressBar progressBar;

    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        setListeners();

        presenter = new MainPresenter(this);
        presenter.requestDataFromServer();
    }

    private void initUi() {
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        
        items = new ArrayList();
        itemsAdapter = new ItemsAdapter(this,items);
        recyclerView.setAdapter(itemsAdapter);

       itemsAdapter.setOnBottom(new OnBottomListener() {
           @Override
           public void onBottomListener() {
               presenter.getMoreDate(page);
           }
       });
    }

    private void setListeners() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });

    }

    @Override
    public void setDatToRecyclerView(List items) {
        Log.d(TAG, "setDatToRecyclerView: "+items.size());
        this.items.addAll(items);
        itemsAdapter.notifyDataSetChanged();
        page++;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void exitApp() {
        PreferencesProvider.clear();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void onItemClick(int position) {
        Log.d(TAG, "onMovieItemClick: "+position);
        Intent itemIntent = new Intent(this, ItemActivity.class);
        itemIntent.putExtra("ITEM", items.get(position).toString());
        startActivity(itemIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.exit_app: presenter.exitApp(); break;
            default: break;
        }
        return true;
    }
}