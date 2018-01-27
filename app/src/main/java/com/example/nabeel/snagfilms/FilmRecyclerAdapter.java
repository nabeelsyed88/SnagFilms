package com.example.nabeel.snagfilms;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nabeel.snagfilms.model.Film;

import java.util.List;

/**
 * Created by Nabeel on 1/26/2018.
 */

public class FilmRecyclerAdapter extends RecyclerView.Adapter<FilmRecyclerAdapter.ViewHolder> {

    List<Film> films;

    public FilmRecyclerAdapter(List<Film> films) {
        this.films = films;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_recycler_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Film film = films.get(position);
        if(film!=null) {
            holder.tvTitle.setText(film.getTitle());
            Glide.with(holder.itemView.getContext()).load(film.getImages().getImage().get(0).getSrc()).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            tvTitle = itemView.findViewById(R.id.title);
        }
    }

}
