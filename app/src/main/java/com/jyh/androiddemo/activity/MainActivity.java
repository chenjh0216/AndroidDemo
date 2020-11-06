package com.jyh.androiddemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jyh.androiddemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}