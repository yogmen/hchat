package com.szala.hchat.model;

import org.parceler.Parcel;

/**
 * Created by robert on 22/01/2017.
 */

@Parcel
public class PostImage {
    private String type;
    private String cdnUrl;
    private int weight;
    private int height;

    public PostImage(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCdnUrl() {
        return cdnUrl;
    }

    public void setCdnUrl(String cdnUrl) {
        this.cdnUrl = cdnUrl;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
