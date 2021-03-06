package com.jyh.androiddemo.activity;

import android.os.Bundle;

import com.jyh.androiddemo.R;
import com.jyh.androiddemo.presenters.IIndexPresenter;
import com.jyh.androiddemo.presenters.impl.IndexPresenter;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private IIndexPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new IndexPresenter(this, R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        presenter.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}