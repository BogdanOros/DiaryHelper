package com.example.talizorah.finalapp.Command;

import android.app.Activity;
import android.content.Intent;

import com.example.talizorah.finalapp.Views.AddNoteActivity;

/**
 * Created by talizorah on 16.10.4.
 */
public class NoteCreateCommand implements CreatingCommand {
    private Activity activity;
    public NoteCreateCommand(Activity activity){
        this.activity = activity;
    }
    @Override
    public void execute() {
        Intent intent = new Intent(activity, AddNoteActivity.class);
        activity.startActivity(intent);
    }
}
