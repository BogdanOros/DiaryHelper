package com.example.talizorah.finalapp.CustomViews.CustomListView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.talizorah.finalapp.CourseItems.CourseItem;
import com.example.talizorah.finalapp.R;
import com.example.talizorah.finalapp.Visitor.DecoratorElement;
import com.example.talizorah.finalapp.notes.Note;

import java.sql.Array;
import java.util.List;

/**
 * Created by talizorah on 16.12.4.
 */
public class CourseListView extends ArrayAdapter<CourseItem> {
    private final Activity context;
    private final List<CourseItem> itemsList;
    private DecoratorElement decoratorElement;
    public CourseListView(Activity context, List<CourseItem> items){
        super(context, R.layout.course_list_item, items);
        this.context = context;
        this.itemsList = items;
        this.decoratorElement = DecoratorElement.createDecoratorElement(context);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.course_list_item, null, true);
        TextView nameLabel = (TextView)rowView.findViewById(R.id.course_list_item_name);
        TextView buyLabel = (TextView)rowView.findViewById(R.id.course_list_item_buyprice);
        TextView saleLabel = (TextView)rowView.findViewById(R.id.course_list_item_saleprice);
        nameLabel.setText(itemsList.get(position).getCourseName());
        String buyStr = "Buy: " + Double.toString(itemsList.get(position).getBuyPrice());
        String saleStr = "Sale: " + Double.toString(itemsList.get(position).getSellPrice());
        buyLabel.setText(buyStr);
        saleLabel.setText(saleStr);
        itemsList.get(position).setView(rowView);
        //Changed a little the pattern ->
        //decoratorElement.acceptVisitor(itemsList.get(position));
        //return itemsList.get(position).getView();
        return itemsList.get(position).visitDecoratorElement(decoratorElement);
    }
}
