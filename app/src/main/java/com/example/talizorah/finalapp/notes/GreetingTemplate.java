package com.example.talizorah.finalapp.notes;

/**
 * Created by talizorah on 16.5.4.
 */
public class GreetingTemplate implements ITemplate {
    private String template;
    private String name = "Greetings";
    @Override
    public String getName() {
        return name;
    }

    private GreetingTemplate(){
        template = "Hello,  ";
    }
    public static ITemplate createGreetingTemplate(){
        return new GreetingTemplate();
    }
    @Override
    public String getTemplate() {
        return this.template;
    }
}
