package com.example.talizorah.finalapp.cashMachine;

import android.app.Activity;

import com.example.talizorah.finalapp.AsyncDataLoaders.JsonParser;

import org.json.JSONException;

import java.util.List;

/**
 * Created by xoll on 20.04.16.
 */
public class GetListMachineAlgorithm {
    private AbstractLoader loader;

    public GetListMachineAlgorithm(AbstractLoader loader){
        this.loader = loader;
    }

    public List<CashMachineItem> getDataList(Activity activity) throws JSONException {
        String json = loader.getJson(activity);
        return JsonParser.parseCashMachineJson(json);
    }

    public AbstractLoader getLoader() {
        return loader;
    }

    public void setLoader(AbstractLoader loader) {
        this.loader = loader;
    }
}
