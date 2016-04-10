package com.example.talizorah.finalapp.CustomViews.CustomListView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.talizorah.finalapp.R;
import com.example.talizorah.finalapp.notes.Note;

import java.util.List;

/**
 * Created by talizorah on 16.8.4.
 */
public class DetailListView extends ArrayAdapter<Note> {
    private final Activity context;
    private final List<Note> noteList;
    public DetailListView(Activity context, List<Note> notes){
        super(context, R.layout.note_item_detail, notes);
        this.context = context;
        this.noteList = notes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.note_item_detail, null, true);
        TextView txtName = (TextView) rowView.findViewById(R.id.list_item_note_list_detail_name);
        TextView txtText = (TextView) rowView.findViewById(R.id.list_item_note_list_detail_text);
        TextView txtDate = (TextView) rowView.findViewById(R.id.list_item_note_list_detail_date);
        txtDate.setText(noteList.get(position).getDate());
        txtName.setText(noteList.get(position).getName());
        txtText.setText(noteList.get(position).getBaseText());
        return rowView;
    }

}
