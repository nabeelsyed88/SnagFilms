package com.example.nabeel.snagfilms.view;

import android.util.Log;

import com.example.nabeel.snagfilms.data.RemoteDataSource;
import com.example.nabeel.snagfilms.model.FilmsResult;
import com.example.nabeel.snagfilms.view.FilmContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Nabeel on 1/26/2018.
 */

public class FilmPresenter implements FilmContract.Presenter {

    FilmContract.View view;

    @Override
    public void attachView(FilmContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getFilms(int noFilms) {
        RemoteDataSource.getFilms(noFilms)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FilmsResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(FilmsResult filmsResult) {
                        view.displayFilms(filmsResult);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        view.showProgress("Download Complete");
                    }
                });
    }
}
