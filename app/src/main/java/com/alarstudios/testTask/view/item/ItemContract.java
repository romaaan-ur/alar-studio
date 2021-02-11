package com.alarstudios.testTask.view.item;

import com.alarstudios.testTask.data.model.Item;

public interface ItemContract {
    interface View{
        void setToolbarTitle(String title);
        void initToolbar(String title);
        void setCardContent(Item item);
    }
    interface Presenter{
        void setToolbarTitle();
        void setCardContent();
    }
}
