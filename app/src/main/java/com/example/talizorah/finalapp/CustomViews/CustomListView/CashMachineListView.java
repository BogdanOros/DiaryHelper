package com.example.talizorah.finalapp.CustomViews.CustomListView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.talizorah.finalapp.R;
import com.example.talizorah.finalapp.cashMachine.CashMachineItem;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by xoll on 19.04.16.
 */
public class CashMachineListView extends ArrayAdapter<CashMachineItem> {
    private final Activity activity;
    private final List<CashMachineItem> items;

    public CashMachineListView(Activity activity, List<CashMachineItem> items) {
        super(activity, R.layout.cash_machine_list, items);
        this.activity = activity;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.cash_machine_item, null, true);

        TextView placeLabel = (TextView)rowView.findViewById(R.id.cash_item_place);
        TextView addressLabel = (TextView)rowView.findViewById(R.id.cash_address);
        TextView scheduleLablel = (TextView)rowView.findViewById(R.id.cash_schedule);

        placeLabel.setText(items.get(position).getPlace());
        addressLabel.setText(items.get(position).getAddress());

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

        scheduleLablel.setText(items.get(position).getSchedule().get(c.get(Calendar.DAY_OF_WEEK)));

        return rowView;
    }
}
