package com.example.nabeel.snagfilms.model;

/**
 * Created by Nabeel on 1/26/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images_ {

    @SerializedName("image")
    @Expose
    private List<Image_> image = null;

    public List<Image_> getImage() {
        return image;
    }

    public void setImage(List<Image_> image) {
        this.image = image;
    }

}
