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
 * Created by talizorah on 16.7.4.
 */
public class SimpleListView extends ArrayAdapter<Note> {
    private final Activity context;
    private final List<Note> noteList;
    public SimpleListView(Activity context, List<Note> notes){
        super(context, R.layout.note_item_simple, notes);
        this.context = context;
        this.noteList = notes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.note_item_simple, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.list_item_note_list);
        txtTitle.setText(noteList.get(position).getName());
        return rowView;
    }
}
