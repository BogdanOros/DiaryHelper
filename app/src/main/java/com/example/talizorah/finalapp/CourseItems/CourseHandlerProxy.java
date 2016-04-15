package com.example.talizorah.finalapp.CourseItems;

import android.app.Activity;

import com.example.talizorah.finalapp.ConnectionChecker.ConnectionChecker;
import com.example.talizorah.finalapp.CourseDataService.DataLoader;
import com.example.talizorah.finalapp.CourseDataService.InternetDataLoading;
import com.example.talizorah.finalapp.CourseDataService.PreferenceDataLoading;

import java.util.List;


/**
 * Created by talizorah on 16.11.4.
 */
public class CourseHandlerProxy extends CourseHandler{
    private Activity activity;
    private CourseHandlerProxy(Activity activity){
        this.activity = activity;
    }
    public void setActivity(Activity activity){
        this.activity = activity;
    }
    public static CourseHandlerProxy createProxy(Activity activity){
        return new CourseHandlerProxy(activity);
    }
    public void loadData(){
        DataLoader loader;
        if(ConnectionChecker.isNetworkAvailable(activity)){
            loader = new DataLoader(new InternetDataLoading());
        }
        else{
            loader = new DataLoader(new PreferenceDataLoading());
        }
        super.setTemporaryList(loader.loadData(activity));
    }

    @Override
    public List<CourseItem> createItems(){
        if(super.getDataSource() == null){
            this.loadData();
        }
        return super.createItems();
    }

}
