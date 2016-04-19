package com.example.talizorah.finalapp.Controller;

import android.app.Activity;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.talizorah.finalapp.cashMachine.CashMachineItem;
import com.example.talizorah.finalapp.enums.ListViewAdapters;
import com.example.talizorah.finalapp.factoryMethod.AdapterFactory;

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
    private List<CashMachineItem> itemsList;
    private BaseAdapter adapter;

    public CashMachineController(Activity activity, ListView listView) {
        this.activity = activity;
        this.listView = listView;
        this.adapterFactory = AdapterFactory.createAdapterFactory();
        itemsList = new ArrayList<CashMachineItem>();

        List<String> schedule = new ArrayList<>();
        schedule.add("9-10 mon");
        schedule.add("9-10 tuesday");
        schedule.add("9-10 wednesday");
        schedule.add("9-10 thursday");
        schedule.add("9-10 friday");
        schedule.add("9-10 saturday");
        schedule.add("9-10 sunday");

        itemsList.add(new CashMachineItem("Test address 1", "Test place 1", schedule));
        itemsList.add(new CashMachineItem("Test address 2", "Test place 2", schedule));
        itemsList.add(new CashMachineItem("Test address 3", "Test place 3", schedule));
        itemsList.add(new CashMachineItem("Test address 4", "Test place 4", schedule));
    }

    public void setAdapter(){
        adapter = adapterFactory.getAdapter(
                ListViewAdapters.CashMachineListView, activity, itemsList);
        listView.setAdapter(adapter);
    }
}
