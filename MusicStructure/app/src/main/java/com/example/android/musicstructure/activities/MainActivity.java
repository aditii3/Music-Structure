package com.example.android.musicstructure.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.musicstructure.R;
import com.example.android.musicstructure.data.Song;
import com.example.android.musicstructure.data.SongsAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    static final String ARTIST_NAME = "artist_name";
    static final String SONG_NAME = "song_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ArrayList<Song> list = new ArrayList<>();
        list.add(new Song("Till I Collapse", "Eminem"));
        list.add(new Song("Thunder", "Imagine Dragons"));
        list.add(new Song("Call Out My Name", "The Weeknd"));
        list.add(new Song("Lose Yourself", "Eminem"));
        list.add(new Song("Let Me", "ZAYN"));
        list.add(new Song("Shape Of You", "Ed Sheeran"));
        list.add(new Song("Not Afraid", "Eminem"));
        list.add(new Song("Believer", "Imaagine Dragons"));
        list.add(new Song("Attention", "Charlie Puth"));
        list.add(new Song("Phenomenal", "Eminem"));


        final ListView listView = findViewById(R.id.songs_list);
        SongsAdapter adapter = new SongsAdapter(this, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, NowPlayingActivity.class);
                Song s = (Song) listView.getItemAtPosition(position);
                i.putExtra(ARTIST_NAME, s.getmArtistName());
                i.putExtra(SONG_NAME, s.getmSongName());
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_album) {
            startActivity(new Intent(MainActivity.this, AlbumActivity.class));

        } else if (id == R.id.nav_trending) {
            startActivity(new Intent(MainActivity.this, TrendingActivity.class));

        } else if (id == R.id.nav_recent) {
            startActivity(new Intent(MainActivity.this, RecentActivity.class));

        } else if (id == R.id.nav_now_playing) {
            startActivity(new Intent(MainActivity.this, NowPlayingActivity.class));

        }
        return true;
    }
}
