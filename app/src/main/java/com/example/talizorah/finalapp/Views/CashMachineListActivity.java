package com.example.talizorah.finalapp.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.talizorah.finalapp.Controller.CashMachineController;
import com.example.talizorah.finalapp.R;

/**
 * Created by xoll on 19.04.16.
 */
public class CashMachineListActivity extends AppCompatActivity{

    private CashMachineController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cash_machine_list);
        setTitle("Cash machines");
        ListView listView = (ListView)findViewById(R.id.cash_machine_list);
        controller = new CashMachineController(this, listView);
        controller.setAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.address_settings){
            controller.setNewAddress();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}