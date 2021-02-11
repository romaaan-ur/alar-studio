package com.alarstudios.testTask.view.login;

import android.text.Editable;


public interface LoginContractor {

    interface Model {

        interface onResponseListener {
            void onFinished(String code);
            void onFailure();
        }

        void login(String username, String password, onResponseListener onResponseListener);
    }

    interface View {
        void showSuccess(String code);
        void showError();
        void noConnection();
    }

    interface Presenter {
        void clickLogin(Editable username, Editable password);
    }

}
