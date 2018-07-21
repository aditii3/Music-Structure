package com.example.android.musicstructure.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.musicstructure.R;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent i = getIntent();
        if (i.hasExtra(MainActivity.ARTIST_NAME)) {
            TextView artistName = findViewById(R.id.tv_artist_name);
            artistName.setText(i.getStringExtra(MainActivity.ARTIST_NAME));
        }
        if (i.hasExtra(MainActivity.SONG_NAME)) {
            TextView songName = findViewById(R.id.tv_song_name);
            songName.setText(i.getStringExtra(MainActivity.SONG_NAME));
        }
    }
}
