package com.project1.listimagesfirebase;

public class Model {
    private String ImageUrl;

    public Model(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public Model(){

    }
}
