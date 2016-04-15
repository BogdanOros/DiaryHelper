package com.example.talizorah.finalapp.Controller;

import android.app.Activity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

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
    private CourseAdapterController(Activity activity, ListView listView){
        this.activity = activity;
        this.listView = listView;
        this.factory = AdapterFactory.createAdapterFactory();
        this.courseHandler = CourseHandlerProxy.createProxy(activity);
        this.itemList = courseHandler.createItems();
        decoratorElement = DecoratorElement.createDecoratorElement(activity);
    }
    public static CourseAdapterController createAdapterController
            (Activity activity, ListView listView){
        return new CourseAdapterController(activity, listView);
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
}
