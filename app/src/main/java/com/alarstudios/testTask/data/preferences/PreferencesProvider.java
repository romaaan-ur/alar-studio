package com.alarstudios.testTask.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class PreferencesProvider {
    private static final String TAG = "PreferencesProvider";
    private static final String SHARED_PREFERENCES = "preferences";

    private static SharedPreferences sharedPreferences;

    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";

    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    public static String getPassword() {
        return sharedPreferences.getString(PASSWORD, null);
    }

    public static void setPassword(String password) {sharedPreferences.edit().putString(PASSWORD, password).apply();}

    public static String getUserName() {
        return sharedPreferences.getString(USER_NAME, null);
    }

    public static boolean isLogged() {
//        Log.d(TAG, "isLogged: "+getUserName());
        boolean isLogin = false;

        Log.d(TAG, "isLogged: "+getPassword());

        if (getPassword() != null ){
            isLogin = true;
        }

        Log.d(TAG, "isLogged: "+isLogin);

        return isLogin;
    }

    public static void clear(){
        sharedPreferences.edit().clear().apply();
    }
}
