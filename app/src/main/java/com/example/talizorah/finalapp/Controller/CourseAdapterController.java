package com.example.talizorah.finalapp.Controller;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.talizorah.finalapp.CourseItems.CourseHandler;
import com.example.talizorah.finalapp.CourseItems.CourseHandlerProxy;
import com.example.talizorah.finalapp.CourseItems.CourseItem;
import com.example.talizorah.finalapp.Visitor.DecoratorElement;
import com.example.talizorah.finalapp.enums.ListViewAdapters;
import com.example.talizorah.finalapp.factoryMethod.AdapterFactory;

import java.util.List;

/**
 * Created by talizorah on 16.12.4.
 */
public class CourseAdapterController {
    private Activity activity;
    private AdapterFactory factory;
    private ListView listView;
    private CourseHandlerProxy courseHandler;
    private List<CourseItem> itemList;
    private DecoratorElement decoratorElement;
    private TextView dateLabel;
    private CourseAdapterController(Activity activity, ListView listView, TextView textView){
        this.activity = activity;
        this.listView = listView;
        this.dateLabel = textView;
        this.factory = AdapterFactory.createAdapterFactory();
        this.courseHandler = CourseHandlerProxy.createProxy(activity);
        this.itemList = courseHandler.createItems();
        decoratorElement = DecoratorElement.createDecoratorElement(activity);
        setDataLabel();
    }
    public static CourseAdapterController createAdapterController
            (Activity activity, ListView listView, TextView textView){
        return new CourseAdapterController(activity, listView, textView);
    }

    public void setAdapter(){
        AdapterHolder.courseAdapter = getAdapter(ListViewAdapters.CourseListView);
        listView.setAdapter(AdapterHolder.courseAdapter);
    }
    public BaseAdapter returnAdapter(){
        return AdapterHolder.courseAdapter;
    }
    private BaseAdapter getAdapter(ListViewAdapters adapter){
        return factory.getAdapter(adapter, activity, this.itemList);
    }

    private void setDataLabel(){
        SharedPreferences prefs = activity.getSharedPreferences(
                "com.example.talizorah.finalapp", activity.MODE_PRIVATE);
        this.dateLabel.setText(prefs.getString("jsonDownloadTime", "Not downloaded!"));
    }

}
