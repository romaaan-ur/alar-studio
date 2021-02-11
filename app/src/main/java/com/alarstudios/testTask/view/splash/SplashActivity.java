package com.alarstudios.testTask.view.splash;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.alarstudios.testTask.R;
import com.alarstudios.testTask.data.preferences.PreferencesProvider;
import com.alarstudios.testTask.view.login.LoginActivity;
import com.alarstudios.testTask.view.main.MainActivity;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    SplashContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        presenter = new SplashPresenter(this);
        if (presenter.checkUserIsLogin()){
            presenter.showMainActivity();
        } else {
            presenter.showLoginActivity();
        }

    }

    @Override
    public boolean checkUserIsLogin() {
        return PreferencesProvider.isLogged();
    }

    @Override
    public void showMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void showLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}