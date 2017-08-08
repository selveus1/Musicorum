package com.example.athena.musicorum.objects;

import android.graphics.Bitmap;

/**
 * Created by athena on 8/7/17.
 */

public class Song {

    private String title;
    private String artist;
    private String album;
    private Bitmap album_cover;


    public Song(){}


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Bitmap getAlbumCover() {
        return album_cover;
    }

    public void setAlbumCover(Bitmap album_cover) {
        this.album_cover = album_cover;
    }
}
