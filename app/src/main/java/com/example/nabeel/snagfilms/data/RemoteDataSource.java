package com.example.nabeel.snagfilms.data;

import com.example.nabeel.snagfilms.model.FilmsResult;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nabeel on 1/26/2018.
 */

public class RemoteDataSource {
    private static final String BASE_URL = "http://www.snagfilms.com/apis/";

    public static Retrofit create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public static Observable<FilmsResult> getFilms(int noFilms) {
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getFilms(noFilms);
    }
}
