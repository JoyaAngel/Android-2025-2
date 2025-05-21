package com.example.contactosapp;
import android.os.StrictMode;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ContactService {

    @GET("/")
    Call<List<Contact>> listContacts(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ccardoso.multics.org/fca")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactService service = retrofit.create(ContactService.class);
        Call<List<Contact>> contactCall = service.listContacts();
        try {
            Response<List<Contact>> response = contactCall.execute();
            List<Contact> contacts = response.body();
            assert contacts != null;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
