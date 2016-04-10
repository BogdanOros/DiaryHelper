package com.example.talizorah.finalapp.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.talizorah.finalapp.Controller.AddNotesController;
import com.example.talizorah.finalapp.R;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        setTitle(R.string.title_add_note_act);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.add_note_radio_group);
        EditText noteName = (EditText)findViewById(R.id.add_note_edit_name);
        EditText noteText = (EditText)findViewById(R.id.add_note_edit_text);
        TextView label = (TextView)findViewById(R.id.add_note_name_cont);
        Button button = (Button)findViewById(R.id.add_note_btn);
        AddNotesController controller = AddNotesController.createAddNotesController
                (this, radioGroup, noteName, noteText, label, button);
        controller.createRadioButtonGroup();
    }
}
