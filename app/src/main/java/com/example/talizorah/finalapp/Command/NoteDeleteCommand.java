package com.example.talizorah.finalapp.Command;

import android.app.Activity;

import com.example.talizorah.finalapp.notes.NoteHandler;

/**
 * Created by talizorah on 16.10.4.
 */
public class NoteDeleteCommand implements EditingCommand {
    private Activity activity;
    private NoteHandler handler;
    private int pos;
    public NoteDeleteCommand(Activity activity, NoteHandler handler)
    {
        this.activity = activity;
        this.handler = handler;
    }

    @Override
    public void setPosition(int pos) {
        this.pos = pos;
    }

    @Override
    public void execute() {
        handler.deleteNote(activity, pos);
    }
}
