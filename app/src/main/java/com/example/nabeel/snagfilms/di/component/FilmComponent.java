package com.example.nabeel.snagfilms.di.component;

import com.example.nabeel.snagfilms.view.FilmActivity;
import com.example.nabeel.snagfilms.di.module.FilmModule;

import dagger.Subcomponent;

/**
 * Created by Nabeel on 1/26/2018.
 */
@Subcomponent(modules = FilmModule.class)
public interface FilmComponent {
    void inject(FilmActivity filmActivity);
}
