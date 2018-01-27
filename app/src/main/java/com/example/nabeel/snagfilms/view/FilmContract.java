package com.example.nabeel.snagfilms.view;

import com.example.nabeel.snagfilms.model.FilmsResult;
import com.example.nabeel.snagfilms.util.BasePresenter;
import com.example.nabeel.snagfilms.util.BaseView;

/**
 * Created by Nabeel on 1/26/2018.
 */

public interface FilmContract {

    interface View extends BaseView {
        void displayFilms(FilmsResult filmsResult);
        void showProgress(String progress);
    }

    interface Presenter extends BasePresenter<View> {
        void getFilms(int noFilms);
    }

}
