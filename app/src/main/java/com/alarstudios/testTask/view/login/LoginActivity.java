package com.alarstudios.testTask.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alarstudios.testTask.R;
import com.alarstudios.testTask.data.preferences.PreferencesProvider;
import com.alarstudios.testTask.view.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginContractor.View {

    private static final String TAG = "LoginActivity";

    EditText editTextUsername, editTextPassword;
    Button buttonLogin;
    ProgressBar progressBar;

    private LoginContractor.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniUI();
        presenter = new LoginPresenter(this, new LoginModel());
    }


    private void iniUI(){
        progressBar = findViewById(R.id.progress);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(v -> { presenter.clickLogin(editTextUsername.getText(), editTextPassword.getText());});
    }

    @Override
    public void showSuccess(String code) {
        PreferencesProvider.setPassword(code);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.incorrect_password, Toast.LENGTH_LONG).show();
    }

    @Override
    public void noConnection() {
        Toast.makeText(this, R.string.failed_connection, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean checkField() {
        return editTextUsername.getText().toString().isEmpty() || editTextPassword.toString().isEmpty();
    }

    @Override
    public void emptyField() {
        if (editTextUsername.getText().toString().isEmpty() ||editTextUsername.getText().toString().isEmpty()){
            Toast.makeText(this, R.string.empty_field, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void showProgress() {
        Log.d(TAG, "showProgress: ");
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }


}