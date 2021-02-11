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
    }



    interface Presenter {
        void requestDataFromServer();
    }
}
