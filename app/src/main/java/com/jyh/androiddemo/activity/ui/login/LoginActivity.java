package com.jyh.androiddemo.activity.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jakewharton.rxbinding4.view.RxView;
import com.jyh.androiddemo.R;
import com.jyh.androiddemo.activity.data.Result;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;

public class LoginActivity extends BaseAppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = new ViewModelProvider(this, new ModelFactory())
                .get(LoginViewModel.class);

        final EditText appidEditText = findViewById(R.id.appid);
        final EditText secretEditText = findViewById(R.id.secret);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginViewModel.getLoginResponseMutableLiveData().observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result result) {
                if (result instanceof Result.Success) {
                    debug(((Result.Success) result).getData().toString());
                } else if (result instanceof Result.Error) {
                    error(((Result.Error) result).getError().toString());
                }
                loadingProgressBar.setVisibility(View.GONE);
            }
        });

        RxView.clicks(loginButton)
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribe(new Consumer<Unit>() {
                    @Override
                    public void accept(Unit unit) throws Throwable {
                        loadingProgressBar.setVisibility(View.VISIBLE);
                        loginViewModel.login(appidEditText.getText().toString()
                                , secretEditText.getText().toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {

                    }
                }, new Action() {
                    @Override
                    public void run() throws Throwable {

                    }
                });
    }

    @Override
    public String getTag() {
        return getClass().getSimpleName();
    }
}