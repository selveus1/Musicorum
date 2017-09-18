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
import com.example.athena.musicorum.objects.Artist;

import java.util.List;

/**
 * Created by athena on 9/16/17.
 */

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {

    private final Context context;
    public List<Artist> artists;

    public ArtistAdapter(Context context, List<Artist> artists){
        this.context = context;
        this.artists = artists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.field_artist, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        if(artists != null || artists.size() > 0){
            holder.picture.setImageBitmap(artists.get(position).getPicture() );
            holder.name.setText(artists.get(position).getName());
        }
    }


    @Override
    public int getItemCount(){
        return artists.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        public ImageView picture;
        public TextView name;

        public ViewHolder(View itemView){
            super(itemView);
            picture = (ImageView)itemView.findViewById(R.id.artist_image);
            name = (TextView)itemView.findViewById(R.id.artist_name);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            Toast.makeText(context, "Clicked artist...", Toast.LENGTH_SHORT).show();
        }
    }



}
