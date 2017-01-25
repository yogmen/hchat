package com.szala.hchat.fragment;


import com.szala.hchat.model.Post;

import java.util.List;

/**
 * Created by robert on 25/01/2017.
 */

public interface IMainFragment<T> {
    void setPresenter(T presenter);

    void addPosts(List<Post> posts);
}
