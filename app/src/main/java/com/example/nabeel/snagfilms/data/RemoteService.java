package com.example.nabeel.snagfilms.data;

import com.example.nabeel.snagfilms.model.FilmsResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nabeel on 1/26/2018.
 */

public interface RemoteService {

    @GET("films.json")
    Observable<FilmsResult> getFilms(@Query("limit") int noFilms);
}
