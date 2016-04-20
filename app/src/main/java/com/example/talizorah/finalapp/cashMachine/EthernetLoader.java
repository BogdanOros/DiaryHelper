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
        loader.execute("https://api.privatbank.ua/p24api/infrastructure?json&atm&address=%D0%BF%D0%BE%D0%B1%D0%B5%D0%B4%D1%8B&city=%D0%9A%D0%BE%D0%BD%D1%81%D1%82%D0%B0%D0%BD%D1%82%D0%B8%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0", prefsName);

        return prefs.getString(prefsName, null);
    }
}
