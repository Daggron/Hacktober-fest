package com.example.dell.introscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.renderscript.ScriptIntrinsicResize;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class activity_intro extends AppCompatActivity {

    private ViewPager screenPager;
    introViewPagerAdapter introViewPagerAdapter;
    TabLayout tabindicator;
    int position =0;
    Button btnGetStarted,btnNext;
    Animation  btnAnims;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        if(restorefData()){
            Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainactivity);
        }

        btnNext = (Button)findViewById(R.id.btn_next);
        btnGetStarted = (Button)findViewById(R.id.btn_getStarted);

        btnAnims = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);

        tabindicator = findViewById(R.id.tab_indicator);

        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Anytime Location","it has the ability to to show the path of any building and it is very useful.it has the ability to to show the path of any building and it is very useful.",R.drawable.driver));
        mList.add(new ScreenItem("Fast Delivery","it has the ability to to show the path of any building and it is very useful.it has the ability to to show the path of any building and it is very useful.",R.drawable.meal));
        mList.add(new ScreenItem("Easy","it has the ability to to show the path of any building and it is very useful.it has the ability to to show the path of any building and it is very useful.",R.drawable.payment));



        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new introViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);


        tabindicator.setupWithViewPager(screenPager);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if(position < mList.size()){
                    position++;
                    screenPager.setCurrentItem(position);

                }
                if(position == mList.size()-1){
                    //TODO :

                    loadlastscreen();
                }
            }
        });

        tabindicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == mList.size()-1){
                    loadlastscreen();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivity);

                savepreference();
                finish();
            }
        });
    }

    public boolean restorefData() {

    SharedPreferences Pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
    Boolean isIntroActivityOpened = Pref.getBoolean("isIntroOpened",false);
    return isIntroActivityOpened;

    }

    public void savepreference() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();
    }

    private void loadlastscreen() {
      btnNext.setVisibility(View.INVISIBLE);
      btnGetStarted.setVisibility(View.VISIBLE);
      tabindicator.setVisibility(View.INVISIBLE);

      btnGetStarted.setAnimation(btnAnims);
    }

}
