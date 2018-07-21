package com.example.android.musicstructure.data;

public class Song {
    private String mSongName;
    private String mArtistName;
    private String mAlbumNname;
    private int mNumberOfSongs;


    public Song(String albumNname, int numberOfSongs) {
        mAlbumNname = albumNname;
        mNumberOfSongs = numberOfSongs;
    }

    public Song(String songName, String artistName) {
        mSongName = songName;
        mArtistName = artistName;
    }

    public String getmSongName() {
        return mSongName;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public String getmAlbumNname() {
        return mAlbumNname;
    }

    public int getmNumberOfSongs() {
        return mNumberOfSongs;
    }
}
