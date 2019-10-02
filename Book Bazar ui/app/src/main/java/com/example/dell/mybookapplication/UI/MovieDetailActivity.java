package com.example.dell.mybookapplication.UI;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dell.mybookapplication.R;
import com.example.dell.mybookapplication.adapters.MovieAdapter;
import com.example.dell.mybookapplication.adapters.MovieItemClickListener;
import com.example.dell.mybookapplication.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Movie> lstCast;
    private ImageView MovieThumbnailImg,MovieCoverImg;
    private TextView tv_title,tv_description;
    private RecyclerView RvCast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        // iniViews
        iniViews();

        lstCast = new ArrayList<>();
        initCast();

        MovieAdapter adapter = new MovieAdapter(this,lstCast,this);
        RvCast.setAdapter(adapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false));

    }

    private void initCast() {
        lstCast.add(new Movie("Moana",R.drawable.e,R.drawable.e));
        lstCast.add(new Movie("Robert downey junior",R.drawable.a,R.drawable.a));
        lstCast.add(new Movie("Robert downey junior",R.drawable.b,R.drawable.b));
        lstCast.add(new Movie("Robert downey junior",R.drawable.c,R.drawable.c));
        lstCast.add(new Movie("Robert downey junior",R.drawable.d,R.drawable.d));
        lstCast.add(new Movie("Robert downey junior",R.drawable.e,R.drawable.e));
        lstCast.add(new Movie("Robert downey junior",R.drawable.f,R.drawable.f));
        lstCast.add(new Movie("Robert downey junior",R.drawable.g,R.drawable.g));
        lstCast.add(new Movie("Robert downey junior",R.drawable.a,R.drawable.a));


    }


    void iniViews(){
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourcesId = getIntent().getExtras().getInt("imgURL");
        int imageCover = getIntent().getExtras().getInt("imgCover");
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourcesId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourcesId);

        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imageCover).into(MovieCoverImg);
        MovieCoverImg.setImageResource(imageCover);
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        tv_title = findViewById(R.id.detail_movie_title);
        tv_description = findViewById(R.id.detail_movie_desc);

        // recyler view

        RvCast = findViewById(R.id.rv_cast);


    }
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        // here we send moview information to detail actiivty
        //also we will create the transition bew the two activty

        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MovieDetailActivity.this,
                movieImageView,"sharedName");

        startActivity(intent,options.toBundle());
        Toast.makeText(this,"the item " + movie.getTitle() + " is Clicked",Toast.LENGTH_LONG).show();
    }
}
