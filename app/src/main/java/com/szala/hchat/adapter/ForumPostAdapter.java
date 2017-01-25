package com.szala.hchat.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.szala.hchat.R;
import com.szala.hchat.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert on 23/01/2017.
 */


public class ForumPostAdapter extends RecyclerView.Adapter<ForumPostAdapter.ViewHolder> {

    private final String TAG = ForumPostAdapter.class.getSimpleName();

    private List<Post> posts = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.forum_post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.text.setText(post.getText());
        holder.upVotes.setText(post.getStats().getUpVotesAsString());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void addPosts(List<Post> newPosts) {
        posts.clear();
        posts.addAll(newPosts);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        TextView upVotes;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.post_text);
            upVotes = (TextView) itemView.findViewById(R.id.post_upvotes);
        }
    }

}
