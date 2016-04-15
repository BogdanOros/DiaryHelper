package com.example.talizorah.finalapp.CourseDataService;

import android.app.Activity;

import com.example.talizorah.finalapp.CourseItems.CourseDataList;

/**
 * Created by talizorah on 16.11.4.
 */
public class DataLoader {
    private DataLoadingService service;
    public DataLoader(DataLoadingService service){
        this.service = service;
    }
    public CourseDataList loadData(Activity activity){
       return this.service.loadData(activity);
    }
}
