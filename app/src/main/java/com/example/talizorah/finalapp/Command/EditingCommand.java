package com.example.talizorah.finalapp.Command;

import android.app.Activity;

import com.example.talizorah.finalapp.notes.NoteHandler;

/**
 * Created by talizorah on 16.10.4.
 */
public interface EditingCommand {
    void execute();
    //Need the dynamic change of position
    void setPosition(int pos);
}
