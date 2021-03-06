package com.alarstudios.testTask.view.main;

import java.util.List;

public interface MainContract {

    interface Model {
        interface onResponseListener{
            void onFinished(List movies);
            void onFailure(Throwable t);
        }
        void getItemList(onResponseListener onResponseListener, int page);
    }

    interface View {
        void setDatToRecyclerView(List items);
        void showProgress();
        void hideProgress();
        void exitApp();
    }



    interface Presenter {
        void getMoreDate(int page);
        void requestDataFromServer();
        void exitApp();
    }
}
