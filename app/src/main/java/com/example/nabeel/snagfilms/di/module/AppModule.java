package com.example.nabeel.snagfilms.di.module;

import com.example.nabeel.snagfilms.data.RemoteDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Nabeel on 1/26/2018.
 */
@Module
public class AppModule {

    public AppModule() {

    }

    @Provides
    RemoteDataSource providesRemoteDataSource() {return new RemoteDataSource();}
}
