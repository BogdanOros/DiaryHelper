package com.example.talizorah.finalapp.AsyncDataLoaders;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.example.talizorah.finalapp.Controller.AdapterHolder;
import com.example.talizorah.finalapp.CourseItems.CourseDataHolder;
import com.example.talizorah.finalapp.CourseItems.CourseDataList;
import com.example.talizorah.finalapp.CourseItems.CourseHandler;

import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by talizorah on 16.11.4.
 */
public class CourseLoader extends AsyncTask<Void, Void, Void> {
    private Activity activity;
    public void setActivity(Activity activity){
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void ... params) {
        SharedPreferences prefs = activity.getSharedPreferences(
                "com.example.talizorah.finalapp", activity.MODE_PRIVATE);
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String jsonStr = null;
        try {
            URL url = new URL("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5");
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream stream = connection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if(stream == null)
                return null;
            reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }
            if(buffer.length() == 0){
                return null;
            }
            jsonStr = buffer.toString();
            prefs.edit().putString("jsonCourseData", jsonStr).apply();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd", Locale.UK);
            String currentDateAndTime = sdf.format(new Date());
            prefs.edit().putString("jsonDownloadTime", currentDateAndTime).apply();
        }
        catch (Exception ex){
            return null;
        }
        finally {
            if(connection != null){
                connection.disconnect();
            }
            if(reader != null){
                try {
                    reader.close();
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }
}
