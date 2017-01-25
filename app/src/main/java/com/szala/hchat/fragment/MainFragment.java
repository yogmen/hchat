package com.szala.hchat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.szala.hchat.R;
import com.szala.hchat.adapter.ForumPostAdapter;
import com.szala.hchat.model.Post;
import com.szala.hchat.presenter.IMainPresenter;

import java.util.List;

/**
 * Created by robert on 25/01/2017.
 */

public class MainFragment extends Fragment implements IMainFragment<IMainPresenter> {
    private final String TAG = MainFragment.class.getSimpleName();

    private IMainPresenter presenter;
    private RecyclerView.LayoutManager layoutManager;
    private ForumPostAdapter forumPostAdapter;
    private RecyclerView postsView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutManager = new LinearLayoutManager(getActivity());
        forumPostAdapter = new ForumPostAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);
        postsView = (RecyclerView) view.findViewById(R.id.post_list);
        postsView.setLayoutManager(layoutManager);
        postsView.setItemAnimator(new DefaultItemAnimator());
        postsView.setAdapter(forumPostAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void setPresenter(IMainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addPosts(List<Post> posts) {
        forumPostAdapter.addPosts(posts);
        forumPostAdapter.notifyDataSetChanged();
    }

}
