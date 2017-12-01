package com.example.ady.amazontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
   TextView trying ;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trying =findViewById(R.id.trying);
        list = new ArrayList<>();

        RetrofitHelper.getbooks()
                .enqueue(new Callback<BookList>() {
                    @Override
                    public void onResponse(Call<BookList> call, retrofit2.Response<BookList> response) {

                           //list.set(0,(response.body().getBooks().get(0)));
                            trying.append(response.body().getBooks().get(0).getAuthor());

                    }

                    @Override
                    public void onFailure(Call<BookList> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"ups" + t.getMessage(),Toast.LENGTH_LONG).show();
                        trying.append(t.getMessage());

                    }
                });


    }
}
