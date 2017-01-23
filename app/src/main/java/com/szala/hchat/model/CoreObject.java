package com.szala.hchat.model;

import java.util.List;

/**
 * Created by robert on 22/01/2017.
 */

public class CoreObject {
    private String status;
    private Forum forum;
    private List<Post> posts;

    public CoreObject(){}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
