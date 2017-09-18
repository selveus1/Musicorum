package com.example.athena.musicorum.util;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by athena on 9/18/17.
 */

public class JSONParser {
    //declarations
    private JSONObject jObj;
    private static StringBuilder sb;
    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;




    public JSONObject getJson(String url_string){

        try{

            //create the new url
            URL url = new URL(url_string);

            //to send a http request
            urlConnection = (HttpURLConnection)url.openConnection();

            //sends an error message so it's easily visible
            Log.e("url", url_string);

            urlConnection.connect();

            InputStream stream = urlConnection.getInputStream();

            String result = readStream(stream);
            jObj = new JSONObject(result);

        }catch (Exception e){
            //to diagnose and trace what went wrong and where
            e.printStackTrace();
        } finally {

            urlConnection.disconnect();
            //try{
            //reader.close();
            //}catch (IOException e){
            //    e.printStackTrace();
            // }
        }

        return jObj;
    } //end getJson method




    private static String readStream(InputStream is){

        BufferedReader reader;

        try{
            //turns a byte stream into a character stream
            reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            sb = new StringBuilder();
            String line = null;

            try{
                while((line = reader.readLine()) != null){
                    sb.append(line + "\n");
                }
            } catch(IOException e){
                e.printStackTrace();
            } finally{
                try{
                    is.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        } catch(UnsupportedEncodingException e1){
            e1.printStackTrace();
        }

        return sb.toString();

    } //end readStream method
}
