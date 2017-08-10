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
import com.example.athena.musicorum.objects.Album;

import java.util.List;

/**
 * Created by athena on 8/10/17.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private final Context context;
    public List<Album> albums;


    public AlbumAdapter(Context context, List<Album> albums){
        this.context = context;
        this.albums = albums;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.field_album, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(albums != null || albums.size() > 0){
            holder.cover.setImageBitmap(albums.get(position).getCover() );
            holder.artist.setText(albums.get(position).getAlbumArtists());
            holder.album.setText(albums.get(position).getTitle());
        }

    }


    @Override
    public int getItemCount() {
        return albums.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        public ImageView cover;
        public TextView artist;
        public TextView album;

        public ViewHolder(View itemView){
            super(itemView);
            cover = (ImageView)itemView.findViewById(R.id.album_image);
            artist = (TextView)itemView.findViewById(R.id.album_title);
            album = (TextView)itemView.findViewById(R.id.album_artist);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Clicked...", Toast.LENGTH_SHORT).show();
        }

    }
}
