package com.example.nabeel.snagfilms.util;

/**
 * Created by Nabeel on 1/26/2018.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}
