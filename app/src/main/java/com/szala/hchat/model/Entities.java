package com.szala.hchat.model;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by robert on 22/01/2017.
 */

@Parcel
public class Entities {
    private List<PostImage> images;

    public Entities(){}

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }
}
