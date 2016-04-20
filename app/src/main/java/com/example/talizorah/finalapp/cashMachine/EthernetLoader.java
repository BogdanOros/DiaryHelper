package com.example.talizorah.finalapp.cashMachine;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.talizorah.finalapp.AsyncDataLoaders.Loader;

/**
 * Created by xoll on 20.04.16.
 */
public class EthernetLoader extends AbstractLoader {
    @Override
    public String getJson(Activity context) {
        SharedPreferences prefs =
                context.getSharedPreferences("com.example.talizorah.finalapp", context.MODE_PRIVATE);
        Loader loader = new Loader();
        loader.setActivity(context);
        loader.execute(url, prefsName);

        return prefs.getString(prefsName, null);
    }
}
