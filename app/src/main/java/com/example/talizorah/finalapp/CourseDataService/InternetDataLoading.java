package com.example.talizorah.finalapp.CourseDataService;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.example.talizorah.finalapp.AsyncDataLoaders.JsonParser;
import com.example.talizorah.finalapp.CourseItems.CourseDataList;
import com.example.talizorah.finalapp.AsyncDataLoaders.CourseLoader;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by talizorah on 16.11.4.
 */
public class InternetDataLoading implements DataLoadingService{
    @Override
    public CourseDataList loadData(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences(
                "com.example.talizorah.finalapp", activity.MODE_PRIVATE);
        CourseLoader loader = new CourseLoader();
        loader.setActivity(activity);
        loader.execute();
        CourseDataList list = new CourseDataList();
        try {
            list.getList().addAll(Arrays.asList(JsonParser.parseJson(prefs.getString("jsonCourseData", null), 3)));
        }
        catch (JSONException ex){
            ex.printStackTrace();
        }
        return list;
    }
}
