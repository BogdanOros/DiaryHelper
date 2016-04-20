package com.example.talizorah.finalapp.Controller;

import android.app.Activity;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.talizorah.finalapp.ConnectionChecker.ConnectionChecker;
import com.example.talizorah.finalapp.cashMachine.CashMachineItem;
import com.example.talizorah.finalapp.cashMachine.EthernetLoader;
import com.example.talizorah.finalapp.cashMachine.GetListMachineAlgorithm;
import com.example.talizorah.finalapp.cashMachine.OfflineLoader;
import com.example.talizorah.finalapp.enums.ListViewAdapters;
import com.example.talizorah.finalapp.factoryMethod.AdapterFactory;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xoll on 19.04.16.
 */
public class CashMachineController {
    private Activity activity;
    private ListView listView;
    private AdapterFactory adapterFactory;
    private GetListMachineAlgorithm algorithm;
    private List<CashMachineItem> itemsList;
    private BaseAdapter adapter;

    public CashMachineController(Activity activity, ListView listView) {
        this.activity = activity;
        this.listView = listView;
        this.adapterFactory = AdapterFactory.createAdapterFactory();
        if(ConnectionChecker.isNetworkAvailable(activity))
            this.algorithm = new GetListMachineAlgorithm(new EthernetLoader());
        else
            this.algorithm = new GetListMachineAlgorithm(new OfflineLoader());

        try {
            itemsList = algorithm.getDataList(activity);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void setAdapter(){
        adapter = adapterFactory.getAdapter(
                ListViewAdapters.CashMachineListView, activity, itemsList);
        listView.setAdapter(adapter);
    }
}
