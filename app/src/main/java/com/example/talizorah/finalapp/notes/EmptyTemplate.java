package com.example.talizorah.finalapp.notes;

/**
 * Created by talizorah on 16.8.4.
 */
public class EmptyTemplate implements ITemplate {
    private String template;
    private String name = "Empty";
    private EmptyTemplate(){
        template = "";
    }
    public static ITemplate createEmptyTemplate(){
        return new EmptyTemplate();
    }
    @Override
    public String getTemplate() {
        return this.template;
    }

    @Override
    public String getName() {
        return name;
    }
}
