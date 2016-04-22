package com.example.talizorah.finalapp.cashMachine;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.talizorah.finalapp.AsyncDataLoaders.Loader;

/**
 * Created by xoll on 20.04.16.
 */
public class OfflineLoader extends AbstractLoader {
    @Override
    public void setUri(String uri, String city) {
        this.url = uri + city;
    }

    @Override
    public String getJson(Activity context) {
        SharedPreferences prefs =
                context.getSharedPreferences("com.example.talizorah.finalapp", context.MODE_PRIVATE);
        return prefs.getString(prefsName, null);
    }
}
