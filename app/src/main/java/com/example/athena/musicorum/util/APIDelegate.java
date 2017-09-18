package com.example.athena.musicorum.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONObject;

/**
 * Created by athena on 9/18/17.
 */

public class APIDelegate {
    private static APIDelegate delegate;
    private String apiKey = "ae0125e4880a1bac90139fdf8bc45e49";
    Context context;
    JSONParser parser;

    private APIDelegate(){}

    public APIDelegate getAPIDelegate(){

        if(delegate == null){
            delegate = new APIDelegate();
            parser = new JSONParser();
        }
        return delegate;
    }


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivity.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }


    public String createUrl(String query){

        //create url
       return ("http://api.musicgraph.com/api/v2/artist/search?api_key="
                + apiKey + "&" + query);

    }

    public String requestArtist(Context context, String artistName){
        this.context = context;

        //strip query of space if there are any
        artistName = artistName.replace(" ", "+");

        String url = createUrl( "name=" + artistName );

        //perform request if internet
        if( isNetworkAvailable(context) ){
            JSONObject json = parser.getJson( url );
        }

        return "";


    }
}
