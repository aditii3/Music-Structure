package com.example.android.musicstructure.data;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.musicstructure.R;

import java.util.ArrayList;


public class SongsAdapter extends ArrayAdapter<Song> {

    public SongsAdapter(Activity context, ArrayList<Song> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }
        Song current = getItem(position);
        TextView song_name = listItemView.findViewById(R.id.tv_name_of_song);
        TextView artist_name = listItemView.findViewById(R.id.tv_artist_name);

        song_name.setText(current.getmSongName());
        artist_name.setText(current.getmArtistName());
        return listItemView;

    }
}
