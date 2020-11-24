package com.jyh.androiddemo.activity.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.jyh.androiddemo.R;
import com.jyh.androiddemo.activity.data.Result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = new ViewModelProvider(this, new ModelFactory())
                .get(LoginViewModel.class);

        final EditText appidEditText = findViewById(R.id.appid);
        final EditText secretEditText = findViewById(R.id.secret);
        final EditText envEditText = findViewById(R.id.env);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginViewModel.getLoginResponseMutableLiveData().observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result result) {
                if (result instanceof Result.Success){

                } else if (result instanceof Result.Error){

                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(appidEditText.getText().toString()
                        ,secretEditText.getText().toString()
                        ,envEditText.getText().toString());
            }
        });
    }

}