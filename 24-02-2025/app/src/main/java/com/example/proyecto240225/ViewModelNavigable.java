package com.example.proyecto240225;

import android.content.Context;
import android.content.Intent;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

import androidx.annotation.NonNull;


public abstract class ViewModelNavigable{

    //public NonBackActviviti nonBackDispatcher = new NonBackActviviti;
    public void navegar(Context context, Class actividad) {
        Intent i = new Intent(context, actividad);
        context.startActivity(i);
    }
}
