package com.szala.hchat;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.szala.hchat.component.DaggerNetComponent;
import com.szala.hchat.component.NetComponent;
import com.szala.hchat.module.AppModule;
import com.szala.hchat.module.NetModule;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by robert on 23/01/2017.
 */

public class HChatApplication extends Application {
    private static final String BASE_URL = "https://api.hubchat.com/v1/";
    private static final HttpLoggingInterceptor.Level LOGGING_LEVEL = HttpLoggingInterceptor.Level.BASIC;

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(BASE_URL, LOGGING_LEVEL))
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
