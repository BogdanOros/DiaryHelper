package com.example.talizorah.finalapp.cashMachine;

import android.app.Activity;

import java.util.List;

/**
 * Created by xoll on 20.04.16.
 */
public abstract class AbstractLoader {
    //protected String url = "https://api.privatbank.ua/p24api/infrastructure?json&atm&address=%D0%BF%D0%BE%D0%B1%D0%B5%D0%B4%D1%8B&city=%D0%9A%D0%B8%D0%B5%D0%B2";
    protected String prefsName = "cashMachineJson";
    protected String url = null;
    public abstract String getJson(Activity context);
    public abstract void setUri(String city, String address);
}
