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
        if (!view.checkField()){
            Log.d(TAG, "clickLogin: ");
            view.showProgress();
            model.login(username.toString(), password.toString(), this);
        } else {
            view.emptyField();
        }
    }


    @Override
    public void onFinished(String code) {
        view.hideProgress();
        view.showSuccess(code);
    }

    @Override
    public void onFailure() {
        view.hideProgress();
        view.showError();
    }

    @Override
    public void onConnection() {
        view.hideProgress();
        view.noConnection();
    }
}
