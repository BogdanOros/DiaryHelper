package com.example.talizorah.finalapp.cashMachine;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.Uri;

import com.example.talizorah.finalapp.AsyncDataLoaders.Loader;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by xoll on 20.04.16.
 */
public class EthernetLoader extends AbstractLoader {
    @Override
    public void setUri(String city, String address) {
        try {
            address = URLEncoder.encode(address, "utf-8");
            city = URLEncoder.encode(city, "utf-8");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        this.url = "https://api.privatbank.ua/p24api/infrastructure?json&atm&address=" + address + "&city=" + city;
    }

    @Override
    public String getJson(Activity context) {
        SharedPreferences prefs =
                context.getSharedPreferences("com.example.talizorah.finalapp", context.MODE_PRIVATE);
        Loader loader = new Loader();
        loader.setActivity(context);
        try {
            loader.execute(url, prefsName).get(10, TimeUnit.SECONDS);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        catch (TimeoutException ex){
            ex.printStackTrace();
        }
        catch (ExecutionException ex){
            ex.printStackTrace();
        }

        return prefs.getString(prefsName, url);
    }
}
