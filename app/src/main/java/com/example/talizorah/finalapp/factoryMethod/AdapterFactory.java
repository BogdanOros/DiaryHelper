package com.example.talizorah.finalapp.factoryMethod;

import android.app.Activity;
import android.widget.BaseAdapter;

import com.example.talizorah.finalapp.CustomViews.CustomListView.DetailListView;
import com.example.talizorah.finalapp.CustomViews.CustomListView.SimpleListView;
import com.example.talizorah.finalapp.enums.ListViewAdapters;
import com.example.talizorah.finalapp.notes.Note;

import java.util.List;

/**
 * Created by talizorah on 16.8.4.
 */
public class AdapterFactory {
    private AdapterFactory(){
    }
    public static AdapterFactory createAdapterFactory(){
        return new AdapterFactory();
    }
    public BaseAdapter getAdapter(ListViewAdapters adapterType, Activity context, List<Note> noteList){
        switch(adapterType){
            case SimpleListView: return new SimpleListView(context, noteList);
            case DetailListView: return new DetailListView(context, noteList);
            default: return null;
        }
    }
}
