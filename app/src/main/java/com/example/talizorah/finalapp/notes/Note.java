package com.example.talizorah.finalapp.notes;

/**
 * Created by talizorah on 16.5.4.
 */
public class Note {
    private int noteId;
    private String noteName;
    private String noteText;
    private String noteDate;
    private ITemplate template;
    private Note(){

    }
    private Note(int noteId, String noteName, String noteText, String noteDate){
        this.noteId = noteId;
        this.noteName = noteName;
        this.noteText = noteText;
        this.noteDate = noteDate;
        setTemplate(GreetingTemplate.createGreetingTemplate());
    }
    public static Note createNote(int noteId, String noteName, String noteText, String noteDate){
        return new Note(noteId, noteName, noteText, noteDate);
    }
    public static Note createEmptyNote(){
        return new Note();
    }
    public int getNoteId(){
        return noteId;
    }
    public void setNoteId(int id ){
        this.noteId = id;
    }
    public void setTemplate(ITemplate template){
        this.template = template;
    }
    public String getBaseText(){
        return this.noteText;
    }
    public String getName(){
        return this.noteName;
    }
    public String getDate(){
        return this.noteDate;
    }
    public void setName(String name){
        this.noteName = name;
    }
    public void setText(String text){
        this.noteText = text;
    }
    public void setDate(String date){
        this.noteDate = date;
    }
}
