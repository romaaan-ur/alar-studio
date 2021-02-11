package com.alarstudios.testTask.view.splash;

public interface SplashContract {

    interface View {

        boolean checkUserIsLogin();

        void showMainActivity();
        void showLoginActivity();
    }

    interface Presenter {
        boolean checkUserIsLogin();
        void showLoginActivity();
        void showMainActivity();
    }
}
