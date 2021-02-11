package com.alarstudios.testTask.network;

import com.alarstudios.testTask.data.model.Items;
import com.alarstudios.testTask.data.model.Login;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("test/auth.cgi")
    public Call<Login> login(@Query("username") String username, @Query("password") String password);

    @GET("test/data.cgi")
    public Call<Items> getData(@Query("code") String code, @Query("p") int page);
}
