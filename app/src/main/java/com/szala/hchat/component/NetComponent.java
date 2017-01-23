package com.szala.hchat.component;

import com.szala.hchat.activity.MainActivity;
import com.szala.hchat.module.AppModule;
import com.szala.hchat.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by robert on 23/01/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
}
