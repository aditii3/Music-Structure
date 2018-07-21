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


public class AlbumAdapter extends ArrayAdapter<Song> {
    public AlbumAdapter(Activity context, ArrayList<Song> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
        }
        Song current = getItem(position);
        TextView albumName = v.findViewById(R.id.tv_album_name);
        TextView numberOfSongs = v.findViewById(R.id.tv_num_of_songs);

        albumName.setText(current.getmAlbumNname());
        numberOfSongs.setText("" + current.getmNumberOfSongs() + " songs");
        return v;
    }
}
