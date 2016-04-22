package com.example.talizorah.finalapp.Controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.BaseAdapter;
import android.widget.EditText;
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

    public void setNewCity(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        final EditText editText = new EditText(activity);
        alert.setMessage("Write city: ");
        alert.setTitle("City!");
        alert.setView(editText);
        alert.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = editText.getText().toString();
                if(ConnectionChecker.isNetworkAvailable(activity)){
                    algorithm = new GetListMachineAlgorithm(new EthernetLoader());
                    algorithm.getLoader().setUri(str, "");
                    try{
                        itemsList = algorithm.getDataList(activity);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setAdapter();
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.show();
    }

    public void setNewAddress(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        final EditText editText = new EditText(activity);
        alert.setMessage("Write the address: ");
        alert.setTitle("Address!");
        alert.setView(editText);
        alert.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = editText.getText().toString();
                if (ConnectionChecker.isNetworkAvailable(activity)) {
                    algorithm = new GetListMachineAlgorithm(new EthernetLoader());
                    algorithm.getLoader().setUri("Киев", str);
                    try {
                        itemsList = algorithm.getDataList(activity);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setAdapter();
            }
        });
        alert.setNegativeButton("Nope", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.show();
    }

    public void setAdapter(){
        adapter = adapterFactory.getAdapter(
                ListViewAdapters.CashMachineListView, activity, itemsList);
        listView.setAdapter(adapter);
    }
}
