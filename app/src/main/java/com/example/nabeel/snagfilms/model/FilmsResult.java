package com.example.nabeel.snagfilms.model;

/**
 * Created by Nabeel on 1/26/2018.
 */



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilmsResult {

    @SerializedName("films")
    @Expose
    private Films films;

    public Films getFilms() {
        return films;
    }

    public void setFilms(Films films) {
        this.films = films;
    }

}
