package com.example.android.musicstructure.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.android.musicstructure.R;
import com.example.android.musicstructure.data.AlbumAdapter;
import com.example.android.musicstructure.data.Song;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        GridView gridView = findViewById(R.id.album_grid);
        ArrayList<Song> list = new ArrayList<>();
        list.add(new Song("Mind Of Mine", 3));
        list.add(new Song("Reputation", 15));
        list.add(new Song("Revival", 19));
        list.add(new Song("Eminem Show", 18));
        list.add(new Song("Like I Would", 7));
        list.add(new Song("Perfect", 4));
        list.add(new Song("Up All Night", 13));
        list.add(new Song("Evolve", 8));

        AlbumAdapter adapter = new AlbumAdapter(this, list);
        gridView.setAdapter(adapter);
    }
}
