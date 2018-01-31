package com.example.myandroidlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

//Simple Android library that displays a Joke

public class DisplayJokeActivity extends AppCompatActivity {
    public final static String GET_JOKE = "getJoke";
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.display_joke);
        textView = findViewById(R.id.joke_textview);
        setJoke();

    }
    private void setJoke(){
        String joke = getIntent().getStringExtra(GET_JOKE);
        textView.setText(joke);
    }
}
