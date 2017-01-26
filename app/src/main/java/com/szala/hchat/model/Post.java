package com.szala.hchat.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by robert on 22/01/2017.
 */

@Parcel
public class Post {

    @SerializedName("rawContent")
    private String text;

    @SerializedName("createdBy")
    private User createdBy;

    @SerializedName("entities")
    private Entities entities;

    @SerializedName("stats")
    private Stats stats;

    public Post() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
