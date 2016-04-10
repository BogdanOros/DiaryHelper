package com.example.talizorah.finalapp.notes;

import android.content.Context;
import android.database.Cursor;

import com.example.talizorah.finalapp.database.SchedulerDataBaseHelper;
import com.example.talizorah.finalapp.database.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by talizorah on 16.5.4.
 */
public class NoteHandler {
    private NoteHandler noteHandler;
    private List<Note> notes;
    private SchedulerDataBaseHelper db;
    private NoteHandler(Context context){
        notes = new ArrayList<>();
        getNotesFromDb(context);
    }
    public static NoteHandler createNoteHandler(Context context){
        return new NoteHandler(context);
    }
    public void getNotesFromDb(Context context){
        db = new SchedulerDataBaseHelper(context);
        //Getting data from cursor ->
        getDataFromCursor(db.getAll());
    }

    private void getDataFromCursor(Cursor cursor){
        notes.clear();
        if(cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(SchedulerProvider.TABLE_ID));
                String name = cursor.getString(cursor.getColumnIndex(SchedulerProvider.TABLE_SCHED_NAME));
                String text = cursor.getString(cursor.getColumnIndex(SchedulerProvider.TABLE_SCHED_TEXT));
                String date = cursor.getString(cursor.getColumnIndex(SchedulerProvider.TABLE_SCHED_DATE));
                Note currentNote = Note.createNote(id, name, text, date);
                this.notes.add(currentNote);
            } while (cursor.moveToNext());
        }
    }

    public void saveNewNote(Context context, Note note){
        //Refreshing the note list ->
        db = new SchedulerDataBaseHelper(context);
        //Wish - call it in async thread ->
        //Adding directly to the list ->
        int id = getNoteIdFromList();
        note.setNoteId(++id);
        notes.add(note);
        //Inserting into the database ->
        db.add(note.getName(), note.getBaseText(), note.getDate());
        //Maybe will be useful ->
        //getNotesFromDb(context);
    }
    public void deleteNote(Context context, int id){
        db = new SchedulerDataBaseHelper(context);
        Note note = notes.get(id);
        db.delete(note.getNoteId());
        notes.remove(id);
    }
    public void clearScheduler(Context context){
        db = new SchedulerDataBaseHelper(context);
        //Clearing the table in database ->
        db.clear();
        //Refreshing the list ->
        getNotesFromDb(context);
    }

    public String getNoteText(int id){
        return notes.get(id).getBaseText();
    }

    public List<String> getNoteNames(){
        List<String> tmpList = new ArrayList<>();
        for(Note n: notes){
            tmpList.add(n.getName());
        }
        return tmpList;
    }

    public List<Note> getNotes(){
        return this.notes;
    }

    private int getNoteIdFromList(){
        if(notes.isEmpty()){
            return -1;
        }
        else {
            return notes.get(notes.size() - 1).getNoteId();
        }
    }

}
