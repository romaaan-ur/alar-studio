package com.alarstudios.testTask.view.item;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.alarstudios.testTask.R;
import com.alarstudios.testTask.data.model.Item;
import com.alarstudios.testTask.view.main.MainActivity;
import com.google.gson.Gson;

public class ItemActivity extends AppCompatActivity implements ItemContract.View {

    private static final String TAG = "ItemActivity";

    private ItemPresenter presenter;
    private TextView id, name, country, lat, lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        initUI();

//        Toolbar toolbar = findViewById(R.id.toolbar);
//
//        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//
//        setSupportActionBar(toolbar);


        Intent intent = getIntent();
        String test = intent.getStringExtra("ITEM");
        presenter = new ItemPresenter(this,new Gson().fromJson(test, Item.class));
        presenter.setToolbarTitle();
        presenter.setCardContent();
//        Log.d(TAG, "onCreate: "+new Gson().fromJson(test, Item.class));
    }

    private void initUI(){
        id = findViewById(R.id.card_id);
        name = findViewById(R.id.card_name);
        country = findViewById(R.id.card_country);
        lat = findViewById(R.id.card_lat);
        lon = findViewById(R.id.card_lon);
    }

    @Override
    public void setToolbarTitle(String title) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d(TAG, "setToolbarTitle: "+title);
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void initToolbar(String title) {
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setCardContent(Item item) {
        id.setText(item.getId());
        name.setText(item.getName());
        country.setText(item.getCountry());
        lat.setText(Float.toString(item.getLat()));
        lon.setText(Float.toString(item.getLon()));
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: "+item.getItemId());
        switch (item.getItemId()){
            case 16908332:
            case R.id.home:
                this.finish();return true;
        }
        return super.onOptionsItemSelected(item);
    }
}