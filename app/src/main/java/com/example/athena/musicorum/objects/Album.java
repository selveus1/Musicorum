package com.example.athena.musicorum.objects;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by athena on 8/10/17.
 */

public class Album {

    Bitmap album_cover;
    String title;
    String album_artists;
    List<String> songs;
    int release_year;


    public Bitmap getCover(){
        return album_cover;
    }


    public void setCover(Bitmap album_cover){
        this.album_cover = album_cover;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbumArtists() {
        return album_artists;
    }

    public void setAlbumArtists(String album_artists) {
        this.album_artists = album_artists;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public int getReleaseYear() {
        return release_year;
    }

    public void setReleaseYear(int release_year) {
        this.release_year = release_year;
    }
}
