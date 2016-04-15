package com.example.talizorah.finalapp.CourseDataService;

import android.app.Activity;

import com.example.talizorah.finalapp.CourseItems.CourseDataList;


/**
 * Created by talizorah on 16.11.4.
 */
public interface DataLoadingService {
    CourseDataList loadData(Activity activity);
}
