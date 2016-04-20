package com.example.talizorah.finalapp.cashMachine;

import android.app.Activity;

import java.util.List;

/**
 * Created by xoll on 20.04.16.
 */
public abstract class AbstractLoader {
    protected String url = "https://api.privatbank.ua/p24api/infrastructure?json&atm&address=&city=%D0%9A%D0%BE%D0%BD%D1%81%D1%82%D0%B0%D0%BD%D1%82%D0%B8%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0";
    protected String prefsName = "cashMachineJson";

    public abstract String getJson(Activity context);
}
