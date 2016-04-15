package com.example.talizorah.finalapp.CourseDataService;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.talizorah.finalapp.AsyncDataLoaders.JsonParser;
import com.example.talizorah.finalapp.CourseItems.CourseDataList;

import org.json.JSONException;

import java.util.Arrays;
import java.util.jar.JarException;

/**
 * Created by talizorah on 16.11.4.
 */
public class PreferenceDataLoading implements DataLoadingService {

    @Override
    public CourseDataList loadData(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences
                ("com.example.talizorah.finalapp", Context.MODE_PRIVATE);
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
