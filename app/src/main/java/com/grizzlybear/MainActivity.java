package com.grizzlybear;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Routes routes;
    List<Guide> guides;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.guide_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        getGuideData();
    }

    void getGuideData() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new TypeToken<List<Guide>>(){}.getType(), new GuideSerializer());
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .baseUrl("https://guidebook.com/")
                .build();
        routes = retrofit.create(Routes.class);
        final Context context = this;
        routes.parseAndDisplay().enqueue(new Callback<List<Guide>>() {
            @Override
            public void onResponse(Call<List<Guide>> call, Response<List<Guide>> response) {
                if (response.isSuccessful()) {
                    guides = response.body();
                    for (Guide guide : guides) {
                        Log.d("output", guide.toString());
                    }
                    recyclerView.setAdapter(new GuideAdapter(guides, context));
                } else {
                    Log.d("Failure", "No response");
                }
            }

            @Override
            public void onFailure(Call<List<Guide>> call, Throwable t) {
                Log.d("Failure",  t.toString());
            }
        });
    }
}
