package com.example.athena.musicorum.objects;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by athena on 8/10/17.
 */

public class Artist {

    String name;
    Bitmap picture;
    List<String> albums;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    public List<String> getAlbums() {
        return albums;
    }

    public void setAlbums(List<String> albums) {
        this.albums = albums;
    }
}
