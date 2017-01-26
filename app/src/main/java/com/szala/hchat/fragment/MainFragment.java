package com.szala.hchat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.szala.hchat.R;
import com.szala.hchat.adapter.ForumPostAdapter;
import com.szala.hchat.model.Post;
import com.szala.hchat.presenter.IMainPresenter;
import com.szala.hchat.ui.ForumPostDivider;

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
    private ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutManager = new LinearLayoutManager(getActivity());
        forumPostAdapter = new ForumPostAdapter();

        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        postsView = (RecyclerView) view.findViewById(R.id.post_list);
        postsView.setLayoutManager(layoutManager);
        postsView.setItemAnimator(new DefaultItemAnimator());
        postsView.addItemDecoration(new ForumPostDivider(getActivity(), LinearLayoutManager.VERTICAL));
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

    @Override
    public void showErrorMessage() {
        Snackbar.make(getView(), R.string.something_went_wrong, BaseTransientBottomBar.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_forum_info:

                return true;
            case R.id.menu_reload:
                presenter.loadPosts();
                return true;
        }
        return false;
    }
}
