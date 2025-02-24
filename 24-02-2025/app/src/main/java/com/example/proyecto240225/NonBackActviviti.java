package com.example.proyecto240225;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
public class NonBackActviviti implements OnBackInvokedDispatcher {

    @Override
    public void registerOnBackInvokedCallback(int priority, @NonNull OnBackInvokedCallback callback) {
        
    }

    @Override
    public void unregisterOnBackInvokedCallback(@NonNull OnBackInvokedCallback callback) {

    }
}
