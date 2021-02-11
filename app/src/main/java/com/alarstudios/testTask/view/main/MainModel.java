package com.alarstudios.testTask.view.main;

import android.util.Log;

import com.alarstudios.testTask.data.model.Item;
import com.alarstudios.testTask.data.model.Items;
import com.alarstudios.testTask.data.model.Login;
import com.alarstudios.testTask.data.preferences.PreferencesProvider;
import com.alarstudios.testTask.network.Api;
import com.alarstudios.testTask.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModel implements MainContract.Model {
    private static final String TAG = "MainModel";

    @Override
    public void getItemList(onResponseListener onResponseListener, int page) {
        Api service = ApiClient.getRetrofit().create(Api.class);

        Call<Items> call = service.getData(PreferencesProvider.getPassword(), page);
        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                List<Item> items = response.body().getItems();
                onResponseListener.onFinished(items);
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Log.d(TAG, t.toString());
                onResponseListener.onFailure(t);
            }
        });
    }
}
