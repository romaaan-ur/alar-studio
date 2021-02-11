package com.alarstudios.testTask.view.main;

import java.util.List;

public class MainPresenter implements MainContract.Presenter, MainContract.Model.onResponseListener {

    private MainContract.View view;
    private MainContract.Model model;

    public MainPresenter(MainContract.View view){
        this.view = view;
        model = new MainModel();
    }

    @Override
    public void getMoreDate(int page) {
        if (view !=null){
            view.showProgress();
        }
        model.getItemList(this, page);
    }

    @Override
    public void requestDataFromServer() {
        if (view!=null){
            view.showProgress();
        }
        model.getItemList(this,1);
    }

    @Override
    public void exitApp() {
        view.exitApp();
    }

    @Override
    public void onFinished(List movies) {
        view.setDatToRecyclerView(movies);
        if (view != null){
            view.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
