package com.szala.hchat.model;

import org.parceler.Parcel;

/**
 * Created by robert on 22/01/2017.
 */

@Parcel
public class Image {
    String url;
    Crop crop;

    public Image() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }
}
