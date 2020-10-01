package com.example.dell.mybookapplication.UI;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dell.mybookapplication.adapters.MovieAdapter;
import com.example.dell.mybookapplication.adapters.MovieItemClickListener;
import com.example.dell.mybookapplication.R;
import com.example.dell.mybookapplication.adapters.SliderPagerAdapter;
import com.example.dell.mybookapplication.models.Movie;
import com.example.dell.mybookapplication.models.Slide;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
//
//    private List<Slide> lstSlides;
//    private List<Movie> lstMovies;
//    private ViewPager slidePager;
//    private TabLayout indicator;
//    private RecyclerView MoviesRV,MoviesLiked,MoviesFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button =(Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

//
//        slidePager = findViewById(R.id.slider_pager);
//        indicator = findViewById(R.id.indicator);
//        MoviesRV = findViewById(R.id.Rv_movies);
//        MoviesLiked = findViewById(R.id.Rv_likes);
//        MoviesFav = findViewById(R.id.Rv_Fav);
//
//        lstSlides = new ArrayList<>();
//        ListSlidesnames();
//
//
//        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
//        slidePager.setAdapter(adapter);
//        // dots indicator
//        indicator.setupWithViewPager(slidePager,true);
//
//        // timer for dots indicator
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(),4000,6000);
//
//        //recycler View set up
//        //init data
//
//        lstMovies = new ArrayList<>();
//        ListRecycleMovies();
//        MovieAdapter movieAdapter = new MovieAdapter(this,lstMovies,this);
//        MoviesRV.setAdapter(movieAdapter);
//        MoviesRV.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false));
//
//        // liked movies
//
//        MoviesLiked.setAdapter(movieAdapter);
//        MoviesLiked.setLayoutManager(new LinearLayoutManager(this,LinearLayout.HORIZONTAL,false));
//
//        MoviesFav.setAdapter(movieAdapter);
//        MoviesFav.setLayoutManager(new LinearLayoutManager(this,LinearLayout.HORIZONTAL,false));
//

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void onMovieClick(Movie movie, ImageView movieImageView) {
//
//       // here we send moview information to detail actiivty
//       //also we will create the transition bew the two activty
//
//        Intent intent = new Intent(this, MovieDetailActivity.class);
//        intent.putExtra("title",movie.getTitle());
//        intent.putExtra("imgURL",movie.getThumbnail());
//        intent.putExtra("imgCover",movie.getCoverPhoto());
//
//        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
//                                                   movieImageView,"sharedName");
//
//        startActivity(intent,options.toBundle());
//        Toast.makeText(this,"the item " + movie.getTitle() + " is Clicked",Toast.LENGTH_LONG).show();
//    }
//
//    class SliderTimer extends TimerTask{
//
//        @Override
//        public void run() {
//            MainActivity.this.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    if(slidePager.getCurrentItem() < lstSlides.size()-1){
//                        slidePager.setCurrentItem(slidePager.getCurrentItem() +1);
//                    }
//                    else{
//                        slidePager.setCurrentItem(0);
//                    }
//                }
//            });
//        }
//    }
//    private void ListRecycleMovies() {
//        lstMovies.add(new Movie("Civil War",R.drawable.a,R.drawable.a));
//        lstMovies.add(new Movie("Moana",R.drawable.b,R.drawable.b));
//        lstMovies.add(new Movie("X Men",R.drawable.c,R.drawable.c));
//        lstMovies.add(new Movie("Toy Story",R.drawable.d,R.drawable.d));
//        lstMovies.add(new Movie("Ant Man",R.drawable.e,R.drawable.e));
//        lstMovies.add(new Movie("Body Guard",R.drawable.f,R.drawable.f));
//        lstMovies.add(new Movie("Time Story",R.drawable.g,R.drawable.g));
//        lstMovies.add(new Movie("Spider Man Far from Home",R.drawable.b,R.drawable.b));
//    }
//
//    private void ListSlidesnames() {
//        lstSlides.add(new Slide(R.drawable.a,"Slide Title \nmore text here"));
//        lstSlides.add(new Slide(R.drawable.b,"Slide Title \nmore text here"));
//        lstSlides.add(new Slide(R.drawable.c,"Slide Title \nmore text here"));
//        lstSlides.add(new Slide(R.drawable.d,"Slide Title \nmore text here"));
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
