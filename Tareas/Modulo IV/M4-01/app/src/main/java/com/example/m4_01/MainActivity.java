package com.example.m4_01;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CicloVida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtils.showToast(this, "onCreate invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        ToastUtils.showToast(this, "onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ToastUtils.showToast(this, "onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ToastUtils.showToast(this, "onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ToastUtils.showToast(this, "onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ToastUtils.showToast(this, "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy invoked");
    }
}