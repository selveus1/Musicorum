package com.example.athena.musicorum.fragments;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.athena.musicorum.R;
import com.example.athena.musicorum.adapters.ArtistAdapter;
import com.example.athena.musicorum.objects.Artist;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by athena on 8/8/17.
 */

public class ArtistsFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    private ArtistAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_artists, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Artists");

        displayArtists();
    }


    private void displayArtists(){
        ContentResolver contentResolver = getActivity().getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = contentResolver.query(uri, null, null, null, null);



        if(cursor == null){
            //query failed for some reason
        }
        else if( !cursor.moveToFirst() ){
            //no media on device
        }
        else {
            //device has music
            int artistColumn = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int idColumn = cursor.getColumnIndex(MediaStore.Audio.Media._ID);

            //list to hold song titles
            List<Artist> artists = new ArrayList<Artist>();

            do {

                long thisId = cursor.getLong(idColumn);
                String thisArtist = cursor.getString(artistColumn);

                //process entry
                Artist artist = new Artist();
                artist.setName(thisArtist);

                //perform additional requests
                //artist.setPicture( getArtistPicture( artist.getName() ) );

                artists.add(artist);

            } while (cursor.moveToNext());

            recyclerView = (RecyclerView) getActivity().findViewById(R.id.artist_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new ArtistAdapter(getActivity(), artists);
            recyclerView.setAdapter(adapter);

        }
    }


    //private Bitmap getArtistPicture(String artist_name){}
}
