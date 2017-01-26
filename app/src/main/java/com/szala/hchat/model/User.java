package com.szala.hchat.model;

import org.parceler.Parcel;

/**
 * Created by robert on 22/01/2017.
 */

@Parcel
public class User {
    private Image avatar;
    private String username;
    private String displayName;

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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
