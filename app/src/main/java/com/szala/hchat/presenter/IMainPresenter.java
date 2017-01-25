package com.szala.hchat.presenter;

import com.szala.hchat.model.CoreObject;

import io.reactivex.Observable;

/**
 * Created by robert on 25/01/2017.
 */

public interface IMainPresenter {
    void subscribe();

    void unsubscribe();

    void loadPosts();
}
