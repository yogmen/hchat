package com.szala.hchat.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import com.szala.hchat.HChatApplication;
import com.szala.hchat.R;
import com.szala.hchat.endpoints.ForumService;
import com.szala.hchat.fragment.MainFragment;
import com.szala.hchat.presenter.MainPresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by robert on 22/01/2017.
 */

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_acitivity_layout);

        ((HChatApplication) getApplication()).getNetComponent().inject(this);

        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        if(null == mainFragment) mainFragment = new MainFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, mainFragment, MainFragment.class.getSimpleName())
                .commit();

        new MainPresenter(mainFragment, retrofit.create(ForumService.class));
    }
}
