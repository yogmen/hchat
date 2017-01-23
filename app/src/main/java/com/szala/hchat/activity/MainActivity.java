package com.szala.hchat.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.szala.hchat.R;
import com.szala.hchat.endpoints.ForumEndpoint;
import com.szala.hchat.model.CoreObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by robert on 22/01/2017.
 */

public class MainActivity extends Activity {
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_acitivity_layout);

        final String BASE_URL = "https://api.hubchat.com/v1/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ForumEndpoint forumEndpoint = retrofit.create(ForumEndpoint.class);
        Call<CoreObject> photography = forumEndpoint.getForum("photography");
        photography.enqueue(new Callback<CoreObject>() {
            @Override
            public void onResponse(Call<CoreObject> call, Response<CoreObject> response) {
                Log.i(TAG, "onResponse: " + response.code());
                Log.i(TAG, "onResponse: " + response.body().getForum().toString());

            }

            @Override
            public void onFailure(Call<CoreObject> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage(), t);
            }
        });
    }
}
