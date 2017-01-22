package com.szala.hchat.model;

/**
 * Created by robert on 22/01/2017.
 */

public class User {
    private Image avatar;
    private String username;

    public User(){}

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
