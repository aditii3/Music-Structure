package com.example.android.musicstructure.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.musicstructure.R;
import com.example.android.musicstructure.data.Song;
import com.example.android.musicstructure.data.SongsAdapter;

import java.util.ArrayList;

import static com.example.android.musicstructure.activities.MainActivity.ARTIST_NAME;
import static com.example.android.musicstructure.activities.MainActivity.SONG_NAME;

public class TrendingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);

        ArrayList<Song> list = new ArrayList<>();
        list.add(new Song("Till I Collapse", "Eminem"));
        list.add(new Song("Thunder", "Imagine Dragons"));
        list.add(new Song("Call Out My Name", "The Weeknd"));
        list.add(new Song("Let Me", "ZAYN"));
        list.add(new Song("Shape Of You", "Ed Sheeran"));
        list.add(new Song("Phenomenal", "Eminem"));

        final ListView listView = findViewById(R.id.songs_list);
        SongsAdapter adapter = new SongsAdapter(this, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(TrendingActivity.this, NowPlayingActivity.class);
                Song s = (Song) listView.getItemAtPosition(position);
                i.putExtra(ARTIST_NAME, s.getmArtistName());
                i.putExtra(SONG_NAME, s.getmSongName());
                startActivity(i);
            }
        });
    }
}
