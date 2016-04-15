package com.example.talizorah.finalapp.builder;

import com.example.talizorah.finalapp.notes.ITemplate;
import com.example.talizorah.finalapp.notes.Note;

/**
 * Created by talizorah on 16.5.4.
 */
public class NoteBuilder implements Builder {

    private Note note;
    private int MAX_NAME_LEN = 16;
    private int MAX_TEXT_LEN = 240;

    private NoteBuilder(Note note){
        this.note = note;
    }
    public static NoteBuilder createNoteBuilder(Note note){
        return new NoteBuilder(note);
    }

    @Override
    public void setTemplate(ITemplate template) {
        this.note.setTemplate(template);
    }

    @Override
    public boolean setName(String name) {
        if(name.length() < MAX_NAME_LEN && name.length() > 0) {
            this.note.setName(name);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean setText(String text) {
        if(text.length() < MAX_TEXT_LEN){
            this.note.setText(text);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void setDate(String date) {
        this.note.setDate(date);
    }

    @Override
    public Note createObject() {
        return note;
    }
}
