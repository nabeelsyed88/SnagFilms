package com.example.nabeel.snagfilms.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nabeel.snagfilms.FilmApplication;
import com.example.nabeel.snagfilms.FilmRecyclerAdapter;
import com.example.nabeel.snagfilms.R;
import com.example.nabeel.snagfilms.model.Film;
import com.example.nabeel.snagfilms.model.FilmsResult;
import com.example.nabeel.snagfilms.view.FilmContract;
import com.example.nabeel.snagfilms.view.FilmPresenter;

import java.util.List;

import javax.inject.Inject;

public class FilmActivity extends AppCompatActivity implements FilmContract.View{

    @Inject
    FilmPresenter filmPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        FilmApplication.get(this).getFilmComponent().inject(this);

        filmPresenter.attachView(this);
        filmPresenter.getFilms(10);

        TextView textView = findViewById(R.id.tvTop);
        textView.setText("Nabeel Syed - ViewLift App");
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayFilms(FilmsResult filmsResult) {
        List<Film> filmList = filmsResult.getFilms().getFilm();

        FilmRecyclerAdapter filmRecyclerAdapter = new FilmRecyclerAdapter(filmList);
        RecyclerView recyclerView = findViewById(R.id.rvMain);

        int columns = getResources().getInteger(R.integer.noColumns);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,columns);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);
        recyclerView.setAdapter(filmRecyclerAdapter);
    }

    @Override
    public void showProgress(String progress) {
        Toast.makeText(this, progress, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        filmPresenter.detachView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        FilmApplication.get(this).clearFilmComponent();
    }
}
