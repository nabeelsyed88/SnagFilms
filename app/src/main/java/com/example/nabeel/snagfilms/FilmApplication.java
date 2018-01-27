package com.example.nabeel.snagfilms;

import android.app.Application;
import android.content.Context;

import com.example.nabeel.snagfilms.di.component.AppComponent;
import com.example.nabeel.snagfilms.di.component.DaggerAppComponent;
import com.example.nabeel.snagfilms.di.component.FilmComponent;
import com.example.nabeel.snagfilms.di.module.AppModule;
import com.example.nabeel.snagfilms.di.module.FilmModule;

/**
 * Created by Nabeel on 1/26/2018.
 */

public class FilmApplication extends Application {

    private AppComponent appComponent;
    private FilmComponent filmComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule();

        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();
    }

    public static FilmApplication get(Context context) {
        return (FilmApplication) context.getApplicationContext();
    }

    public FilmComponent getFilmComponent() {
        filmComponent = appComponent.add(new FilmModule());
        return filmComponent;
    }

    public void clearFilmComponent() {
        filmComponent = null;
    }
}
