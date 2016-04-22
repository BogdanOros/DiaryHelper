package com.example.talizorah.finalapp.Controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.talizorah.finalapp.CourseItems.CourseHandler;
import com.example.talizorah.finalapp.CourseItems.CourseHandlerProxy;
import com.example.talizorah.finalapp.CourseItems.CourseItem;
import com.example.talizorah.finalapp.Visitor.DecoratorElement;
import com.example.talizorah.finalapp.enums.ListViewAdapters;
import com.example.talizorah.finalapp.factoryMethod.AdapterFactory;

import java.util.List;

/**
 * Created by talizorah on 16.12.4.
 */
public class CourseAdapterController {
    private Activity activity;
    private AdapterFactory factory;
    private ListView listView;
    private CourseHandlerProxy courseHandler;
    private List<CourseItem> itemList;
    private DecoratorElement decoratorElement;
    private TextView dateLabel;
    private CourseAdapterController(Activity activity, ListView listView, TextView textView){
        this.activity = activity;
        this.listView = listView;
        this.dateLabel = textView;
        this.factory = AdapterFactory.createAdapterFactory();
        this.courseHandler = CourseHandlerProxy.createProxy(activity);
        this.itemList = courseHandler.createItems();
        decoratorElement = DecoratorElement.createDecoratorElement(activity);
        setDataLabel();
        setOnItemClickListener();
    }
    public static CourseAdapterController createAdapterController
            (Activity activity, ListView listView, TextView textView){
        return new CourseAdapterController(activity, listView, textView);
    }

    public void setAdapter(){
        AdapterHolder.courseAdapter = getAdapter(ListViewAdapters.CourseListView);
        listView.setAdapter(AdapterHolder.courseAdapter);
    }
    public BaseAdapter returnAdapter(){
        return AdapterHolder.courseAdapter;
    }
    private BaseAdapter getAdapter(ListViewAdapters adapter){
        return factory.getAdapter(adapter, activity, this.itemList);
    }
    private void setDataLabel(){
        SharedPreferences prefs = activity.getSharedPreferences(
                "com.example.talizorah.finalapp", activity.MODE_PRIVATE);
        String labelText = "Actual date: " + prefs.getString("jsonDownloadTime", "Not downloaded!");
        this.dateLabel.setText(labelText);
    }

    private void setOnItemClickListener(){
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(activity);
                final EditText editText = new EditText(activity);
                alert.setMessage("Write the buy price: ");
                alert.setTitle("Price checker");
                alert.setView(editText);
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefs = activity.getSharedPreferences(
                                "com.example.talizorah.finalapp", activity.MODE_PRIVATE);
                        prefs.edit().putString(itemList.get(position).getCourseName(),
                                editText.getText().toString()).apply();
                        itemList.get(position).setView(decoratorElement.acceptVisitor(itemList.get(position)));
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
        });
    }

}
