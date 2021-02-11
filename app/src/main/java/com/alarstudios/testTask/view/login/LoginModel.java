package com.alarstudios.testTask.view.login;

import com.alarstudios.testTask.data.model.Login;
import com.alarstudios.testTask.network.Api;
import com.alarstudios.testTask.network.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginContractor.Model {

    private static final String TAG = "LoginModel";

    @Override
    public void login(String username, String password, onResponseListener onResponseListener) {
        Api service = ApiClient.getRetrofit().create(Api.class);

        Call<Login> call = service.login(username, password);

        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                if (response.body().getStatus().equals("ok")){
//                    onResponseListener.saveCredential(response.body().getCode());
                    onResponseListener.onFinished(response.body().getCode());
                }

                else {onResponseListener.onFailure();}

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                onResponseListener.onFailure();
            }
        });
    }
}
