package com.alarstudios.testTask.view.item;

import com.alarstudios.testTask.data.model.Item;
import com.google.gson.Gson;

public class ItemPresenter implements ItemContract.Presenter {

    private Item item;
    private ItemContract.View view;

    public ItemPresenter(ItemContract.View view, Item item){
        this.view = view;
        this.item = item;
    }

    @Override
    public void setToolbarTitle() {
        view.setToolbarTitle(item.getName());
    }

    @Override
    public void setCardContent() {
        view.setCardContent(item);
    }
}
