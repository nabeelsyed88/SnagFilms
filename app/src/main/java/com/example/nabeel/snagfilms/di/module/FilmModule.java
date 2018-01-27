package com.example.nabeel.snagfilms.di.module;

import com.example.nabeel.snagfilms.view.FilmPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Nabeel on 1/26/2018.
 */
@Module
public class FilmModule {
    @Provides
    FilmPresenter providesFilmPresenter() {
        return new FilmPresenter();
    }
}
