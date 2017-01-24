package com.szala.hchat.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.szala.hchat.HChatApplication;
import com.szala.hchat.R;
import com.szala.hchat.endpoints.ForumService;

import javax.inject.Inject;

import butterknife.OnClick;
import retrofit2.Retrofit;

/**
 * Created by robert on 22/01/2017.
 */

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_acitivity_layout);

        ((HChatApplication) getApplication()).getNetComponent().inject(this);

        ForumService forumService = retrofit.create(ForumService.class);
    }

    @OnClick(R.id.menu_reload)
    void reloadView() {
        Log.i(TAG, "reloadView: that will call manual action");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
