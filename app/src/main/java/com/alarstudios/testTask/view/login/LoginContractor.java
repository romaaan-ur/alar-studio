package com.alarstudios.testTask.view.login;

import android.text.Editable;


public interface LoginContractor {

    interface Model {

        interface onResponseListener {
            void onFinished(String code);
            void onFailure();
            void onConnection();
        }

        void login(String username, String password, onResponseListener onResponseListener);
    }

    interface View {
        void showSuccess(String code);
        void showError();
        void noConnection();
        boolean checkField();
        void emptyField();
        void showProgress();
        void hideProgress();
    }

    interface Presenter {
        void clickLogin(Editable username, Editable password);
    }

}
