package com.szala.hchat.model;

import java.util.List;

/**
 * Created by robert on 22/01/2017.
 */

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
