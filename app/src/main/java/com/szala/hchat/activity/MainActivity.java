package com.szala.hchat.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.szala.hchat.HChatApplication;
import com.szala.hchat.R;
import com.szala.hchat.endpoints.ForumService;
import com.szala.hchat.model.CoreObject;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by robert on 22/01/2017.
 */

public class MainActivity extends Activity {
    private final String TAG = MainActivity.class.getSimpleName();

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_acitivity_layout);


        ((HChatApplication) getApplication()).getNetComponent().inject(this);

        Call<CoreObject> photography = retrofit.create(ForumService.class).getForum("photography");
        photography.enqueue(new Callback<CoreObject>() {
            @Override
            public void onResponse(Call<CoreObject> call, Response<CoreObject> response) {
                Log.i(TAG, "onResponse: " + response.body().getForum().getDescription());
            }

            @Override
            public void onFailure(Call<CoreObject> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage(), t);
            }
        });
    }
}
