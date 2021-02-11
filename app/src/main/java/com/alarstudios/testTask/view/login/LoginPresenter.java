package com.alarstudios.testTask.view.login;

import android.text.Editable;
import android.util.Log;

public class LoginPresenter implements LoginContractor.Presenter, LoginContractor.Model.onResponseListener {

    private static final String TAG = "LoginPresenter";
    
    private LoginContractor.View view;
    private  LoginContractor.Model model;

    public LoginPresenter(LoginContractor.View view, LoginContractor.Model model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void clickLogin(Editable username, Editable password) {
        model.login(username.toString(), password.toString(), this);
    }

    @Override
    public void onFinished(String code) {
        view.showSuccess(code);
    }

    @Override
    public void onFailure() {
        view.showError();
    }
}
