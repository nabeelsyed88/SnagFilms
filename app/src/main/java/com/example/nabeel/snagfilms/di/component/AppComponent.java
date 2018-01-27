package com.example.nabeel.snagfilms.di.component;

import com.example.nabeel.snagfilms.di.module.AppModule;
import com.example.nabeel.snagfilms.di.module.FilmModule;

import dagger.Component;

/**
 * Created by Nabeel on 1/26/2018.
 */

@Component(modules = AppModule.class)
public interface AppComponent {
    FilmComponent add(FilmModule filmModule);
}
