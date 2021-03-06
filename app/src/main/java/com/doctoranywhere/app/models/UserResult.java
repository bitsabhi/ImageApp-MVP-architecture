package com.doctoranywhere.app.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class UserResult implements Serializable{
    @SerializedName("name")
    private String user;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("items")
    private ArrayList<String> itemUrlList;

    public UserResult(String user, String imageUrl, ArrayList<String> itemUrlList) {
        this.user = user;
        this.imageUrl = imageUrl;
        this.itemUrlList = itemUrlList;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ArrayList<String> getItemUrlList() {
        return itemUrlList;
    }

    public void setItemUrlList(ArrayList<String> itemUrlList) {
        this.itemUrlList = itemUrlList;
    }


}
