package com.example.ady.amazontest;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Ady on 11/29/2017.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "http://de-coding-test.s3.amazonaws.com";


    //    build the retrofit object to be used
    public static Retrofit create() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }
    public static Call<BookList> getbooks(){
        Retrofit retrofit = create();
        RetrofitService service = retrofit.create(RetrofitService.class);
        return service.getbooks();
    }


    //    create an interface for http verbs
    interface RetrofitService  {

       @GET("/books.json")
        Call<BookList> getbooks();
    }
}