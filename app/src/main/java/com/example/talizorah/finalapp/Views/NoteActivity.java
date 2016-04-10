package com.example.talizorah.finalapp.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import com.example.talizorah.finalapp.Controller.NoteAdapterController;
import com.example.talizorah.finalapp.R;


/**
 * Created by talizorah on 16.5.4.
 */
public class NoteActivity extends AppCompatActivity {

    private NoteAdapterController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list);
        setTitle(R.string.title_note_act);
        ListView listView = (ListView)findViewById(R.id.listView_note_list);
        Switch aSwitch = (Switch)findViewById(R.id.note_list_switch);
        Button newNoteAddingButton = (Button)findViewById(R.id.note_list_add_button);
        controller = NoteAdapterController.createNoteAdapterController
                (this, listView, newNoteAddingButton, aSwitch);
        // Setting up the list adapter ->
        controller.setAdapter();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
