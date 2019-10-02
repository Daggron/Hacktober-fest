package com.example.dell.recyclerbeautifulview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView NewsRecyclerView;
    NewsAdapter newsAdapter;
    List<NewsItem> mData;
    AutoCompleteTextView searchinput;
    List<CountryItem> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //adding up animations

        searchinput = findViewById(R.id.editText);


        NewsRecyclerView = findViewById(R.id.news_rv);
        mData = new ArrayList<>();
        filter();

        newsAdapter = new NewsAdapter(this,mData);
        NewsRecyclerView.setAdapter(newsAdapter);
        NewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //adding custom suggestions
        fillCountryList();

        //ONclick method


        // Autosuggestion
        AutoCompleteCountryAdapter autosuggestion = new AutoCompleteCountryAdapter(this,countryList);

        searchinput.setAdapter(autosuggestion);

        searchinput.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
             newsAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void filter(){
        mData.add(new NewsItem("one plus 6t","art app is very useful made by developers to rome around chitkara.\nthey can use thier own location as well,art app is very useful made by \ndevelopers to rome around chitkara.they can use thier own location as well,\nart app is very useful made by developers to rome around chitkara.they can use thi\ner own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("one plus 7pro","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("samsung note 7","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("oppo Realme 1","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Vivo F11","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Redmi Note 3","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Redmi note 5 pro","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Oppo find x","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("samsung note 9","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Nokia 1120","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("facebook","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("instagram","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Watsapp","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));

    }
    private void fillCountryList(){
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("one plus 6t",R.drawable.driver));
        countryList.add(new CountryItem("one plus 7pro",R.drawable.flower));
        countryList.add(new CountryItem("oppo Realme 1",R.drawable.sg));
        countryList.add(new CountryItem("samsung note 7",R.drawable.meal));
        countryList.add(new CountryItem("Vivo F11",R.drawable.payment));
        countryList.add(new CountryItem("Redmi Note 3",R.drawable.payment));
        countryList.add(new CountryItem("Redmi note 5 pro",R.drawable.payment));
        countryList.add(new CountryItem("samsung note 9",R.drawable.payment));
        countryList.add(new CountryItem("Nokia 1120",R.drawable.payment));
        countryList.add(new CountryItem("facebook",R.drawable.payment));
        countryList.add(new CountryItem("instagram",R.drawable.payment));
        countryList.add(new CountryItem("Watsapp",R.drawable.payment));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if(id == R.id.action_search){
//           searchinput.setVisibility(View.VISIBLE);
//           toolbar.setVisibility(View.INVISIBLE);
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
