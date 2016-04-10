package com.example.talizorah.finalapp.Command;

import android.app.Activity;
import android.widget.Toast;

import com.example.talizorah.finalapp.notes.NoteHandler;

/**
 * Created by talizorah on 16.10.4.
 */
public class NoteOpenCommand implements EditingCommand {
    private Activity activity;
    private NoteHandler handler;
    private int pos;
    public NoteOpenCommand(Activity activity, NoteHandler handler)
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
        Toast.makeText(activity, handler.getNoteText(pos), Toast.LENGTH_LONG).show();
    }
}
