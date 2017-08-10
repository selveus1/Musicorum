package com.example.athena.musicorum.fragments;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.athena.musicorum.R;
import com.example.athena.musicorum.adapters.AlbumAdapter;
import com.example.athena.musicorum.objects.Album;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by athena on 8/8/17.
 */

public class AlbumsFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    private AlbumAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_albums, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Albums");

        displayAlbums();
    }


    private void displayAlbums(){
        ContentResolver contentResolver = getActivity().getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = contentResolver.query(uri, null, null, null, null);

        Uri uriAlbum =  MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
        Cursor cursor1 = contentResolver.query(uri, null, null, null, null);

        if(cursor == null){
            //query failed for some reason
        }
        else if( !cursor.moveToFirst() ){
            //no media on device
        }
        else {
            //device has music
            int artistColumn = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int albumColumn = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
            int albumIdColumn = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);
            int idColumn = cursor.getColumnIndex(MediaStore.Audio.Media._ID);

            //list to hold song titles
            List<Album> albums = new ArrayList<Album>();

            do {

                long thisId = cursor.getLong(idColumn);
                String thisArtist = cursor.getString(artistColumn);
                String thisAlbum = cursor.getString(albumColumn);
                long thisAlbumId = cursor.getLong(albumIdColumn);

                Uri sArtworkUri = Uri
                        .parse("content://media/external/audio/albumart");
                Uri albumArtUri = ContentUris.withAppendedId(sArtworkUri, thisAlbumId);

                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(
                            getActivity().getApplicationContext()
                                    .getContentResolver(), albumArtUri);
                    bitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, true);

                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                    bitmap = BitmapFactory
                            .decodeResource(getActivity().getApplicationContext().getResources(),
                                    R.drawable.icon_music);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //process entry
                Album album = new Album();
                album.setTitle(thisAlbum);
                album.setAlbumArtists(thisArtist);
                album.setCover(bitmap);
                albums.add(album);


            } while (cursor.moveToNext());

            recyclerView = (RecyclerView) getActivity().findViewById(R.id.album_covers);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
            adapter = new AlbumAdapter(getActivity(), albums);
            recyclerView.setAdapter(adapter);

        }
    }
}
