package com.app.omandiscount.model;

/**
 * Created by Rj on 3/3/2018.
 */

public class ImageModel {
    String imageHtPath;
    String imageText;
    String offer;
    String time;

    public ImageModel(String imageHtPath, String imageText) {
        this.imageHtPath = imageHtPath;
        this.imageText = imageText;
    }

    public ImageModel(String imagePath) {
        this.imageHtPath = imagePath;
    }

    public ImageModel(String imageHtPath, String imageText, String offer, String time) {
        this.imageHtPath = imageHtPath;
        this.imageText = imageText;
        this.offer = offer;
        this.time = time;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImageHtPath() {
        return imageHtPath;
    }

    public void setImageHtPath(String imageHtPath) {
        this.imageHtPath = imageHtPath;
    }

    public String getImageText() {
        return imageText;
    }
}
