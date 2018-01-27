package com.example.nabeel.snagfilms.model;

/**
 * Created by Nabeel on 1/26/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("image")
    @Expose
    private List<Image> image = null;

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

}
