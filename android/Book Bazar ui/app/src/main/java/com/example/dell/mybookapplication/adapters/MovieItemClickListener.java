package com.example.dell.mybookapplication.adapters;

import android.widget.ImageView;

import com.example.dell.mybookapplication.models.Movie;

public interface MovieItemClickListener {
    // we will need the image to make the shared bew activites
    void onMovieClick(Movie movie, ImageView movieImageView);
}
