package com.alarstudios.testTask;

import android.app.Application;

import com.alarstudios.testTask.data.preferences.PreferencesProvider;

public class App extends Application {

    PreferencesProvider preferencesProvider;

    @Override
    public void onCreate() {
        super.onCreate();
        preferencesProvider.init(this);
    }
}
