package com.example.talizorah.finalapp.notes;

/**
 * Created by talizorah on 16.5.4.
 */
public class ApologyTemplate implements ITemplate{
    private String template;
    private String name = "Apology";
    private ApologyTemplate(){
        template = "My apologize, ";
    }
    public static ITemplate createApologyTemplate(){
        return new ApologyTemplate();
    }
    @Override
    public String getTemplate() {
        return this.template;
    }
    public String getName(){ return name; }
}