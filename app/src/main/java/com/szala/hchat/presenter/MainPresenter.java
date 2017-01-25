package com.szala.hchat.presenter;

import android.util.Log;

import com.szala.hchat.endpoints.ForumService;
import com.szala.hchat.fragment.IMainFragment;
import com.szala.hchat.model.CoreObject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by robert on 25/01/2017.
 */

public class MainPresenter implements IMainPresenter{

    private final String TAG = MainPresenter.class.getSimpleName();
    private final IMainFragment mainFragment;
    private final ForumService forumService;

    private CompositeDisposable disposable = new CompositeDisposable();

    public MainPresenter(IMainFragment mainFragment, ForumService forumService) {
        this.mainFragment = mainFragment;
        this.forumService = forumService;

        loadPosts(forumService.getForumPosts("photography"));
    }


    @Override
    public void subscribe() {
        //TODO implement
    }

    @Override
    public void unsubscribe() {
        disposable.clear();
    }

    public void loadPosts(Observable<CoreObject> observable){
        disposable.add(observable
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<CoreObject>() {
            @Override
            public void accept(CoreObject coreObject) throws Exception {
                mainFragment.addPosts(coreObject.getPosts());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(TAG, "accept: " + throwable.getMessage(), throwable);
            }
        }));
    }
}
