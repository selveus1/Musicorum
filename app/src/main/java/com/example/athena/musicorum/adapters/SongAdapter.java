package com.example.athena.musicorum.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.athena.musicorum.R;
import com.example.athena.musicorum.objects.Song;

import java.util.List;


/**
 * Created by athena on 8/7/17.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private final Context context;
    public List<Song> songs;


    public SongAdapter(Context context, List<Song> songs){
        this.context = context;
        this.songs = songs;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.field_song, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(songs != null || songs.size() > 0){
            //get and bind the book cover
//            Bitmap bmp = BitmapFactory
//                    .decodeByteArray(songs.get(position).getAlbumCover(),
//                            0, songs.get(position).getAlbumCover().length);
            //holder.cover.setImageBitmap( bmp );
            holder.cover.setImageBitmap(songs.get(position).getAlbumCover() );
            holder.title.setText(songs.get(position).getTitle());
            holder.artist.setText(songs.get(position).getArtist());
            holder.album.setText(songs.get(position).getAlbum());
        }

    }


    @Override
    public int getItemCount() {
        return songs.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        public ImageView cover;
        public TextView title;
        public TextView artist;
        public TextView album;

        public ViewHolder(View itemView){
            super(itemView);
            cover = (ImageView)itemView.findViewById(R.id.album_cover);
            title = (TextView)itemView.findViewById(R.id.song_title);
            artist = (TextView)itemView.findViewById(R.id.song_artist);
            album = (TextView)itemView.findViewById(R.id.song_album);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Clicked...", Toast.LENGTH_SHORT).show();
        }

    }
}
