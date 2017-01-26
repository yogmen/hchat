package com.szala.hchat.model;


import org.parceler.Parcel;

/**
 * Created by robert on 22/01/2017.
 */

@Parcel
public class Crop {
    int height;
    int width;
    int x;
    int y;

    public Crop() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
