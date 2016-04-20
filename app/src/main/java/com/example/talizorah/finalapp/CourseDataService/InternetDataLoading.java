package com.example.talizorah.finalapp.CourseDataService;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.talizorah.finalapp.AsyncDataLoaders.JsonParser;
import com.example.talizorah.finalapp.CourseItems.CourseDataList;
import com.example.talizorah.finalapp.AsyncDataLoaders.Loader;

import org.json.JSONException;

import java.util.Arrays;

/**
 * Created by talizorah on 16.11.4.
 */
public class InternetDataLoading implements DataLoadingService{
    @Override
    public CourseDataList loadData(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences(
                "com.example.talizorah.finalapp", activity.MODE_PRIVATE);
        Loader loader = new Loader();
        loader.setActivity(activity);
        loader.execute("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5", "jsonCourseData");
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
