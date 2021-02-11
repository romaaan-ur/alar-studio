package com.alarstudios.testTask.view.splash;

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View view;

    public SplashPresenter(SplashContract.View view){
        this.view = view;
    }

    @Override
    public boolean checkUserIsLogin() {
        return view.checkUserIsLogin();
    }

    @Override
    public void showLoginActivity() {
        view.showLoginActivity();
    }

    @Override
    public void showMainActivity() {
        view.showMainActivity();
    }
}
