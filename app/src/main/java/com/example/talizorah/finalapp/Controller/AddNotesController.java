package com.example.talizorah.finalapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.talizorah.finalapp.R;
import com.example.talizorah.finalapp.Views.NoteActivity;
import com.example.talizorah.finalapp.builder.NoteBuilder;
import com.example.talizorah.finalapp.notes.Note;
import com.example.talizorah.finalapp.notes.NoteHandler;
import com.example.talizorah.finalapp.notes.TemplateHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by talizorah on 16.8.4.
 */
public class AddNotesController {
    private NoteHandler handler;
    private NoteBuilder builder;
    private Activity activity;
    private RadioGroup radioGroup;
    private EditText noteName;
    private EditText noteText;
    private TextView textView;
    private Button button;


    private AddNotesController
            (final Activity activity, RadioGroup radioGroup, EditText noteName, EditText noteText,
             TextView textView, Button button){
        this.activity = activity;
        this.radioGroup = radioGroup;
        this.noteText = noteText;
        this.noteName = noteName;
        this.textView = textView;
        this.button = button;
        this.builder = NoteBuilder.createNoteBuilder(Note.createEmptyNote());
        // Great-great SHIT ->
        this.handler = NoteHandler.createNoteHandler(activity);
        setListeners();
    }

    public void setListeners(){
        setTextChangeListener();
        btnOnClickListener();
    }

    public static AddNotesController createAddNotesController
            (Activity activity, RadioGroup radioGroup, EditText noteName, EditText noteText,
             TextView textView, Button button){
        return new AddNotesController(activity, radioGroup, noteName, noteText, textView, button);
    }
    public void createRadioButtonGroup(){
        final RadioButton[] radioButtons = new RadioButton[TemplateHandler.TEMPLATES_COUNT];
        for (int i = 0; i < TemplateHandler.TEMPLATES_COUNT; i++) {
            radioButtons[i] = new RadioButton(activity);
            radioButtons[i].setText(TemplateHandler.createTemplate(i).getName());
            radioGroup.addView(radioButtons[i]);
        }
    }

    private void setTextChangeListener(){
        radioGroup.clearCheck();
        this.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(checkedId);
                int checkedIndex = radioGroup.indexOfChild(checkedRadioButton);
                builder.setTemplate(TemplateHandler.createTemplate(checkedIndex));
                noteText.setText(TemplateHandler.createTemplate(checkedIndex).getTemplate());
           }
       });
    }

    private void btnOnClickListener(){
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkFields()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd", Locale.UK);
                    String currentDateAndTime = sdf.format(new Date());
                    builder.setDate(currentDateAndTime);
                    handler.saveNewNote(activity, builder.createObject());
                    activity.startActivity(new Intent(activity, NoteActivity.class));
                }
            }
        });
    }

    private boolean checkFields(){
        boolean textCheck = builder.setText(noteText.getText().toString());
        boolean nameCheck = builder.setName(noteName.getText().toString());
        if(nameCheck){
            textView.setText(R.string.add_note_name_cont_true);
        }
        else{
            noteName.setText("");
            textView.setText(R.string.add_note_name_cont_false);
        }
        return textCheck & nameCheck;
    }
}
