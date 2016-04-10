package com.example.talizorah.finalapp.notes;

import com.example.talizorah.finalapp.enums.NoteTemplates;

/**
 * Created by talizorah on 16.5.4.
 */
public class TemplateHandler {
    public static int TEMPLATES_COUNT = 3;
    //Used static because it is enough ->
    public static ITemplate createTemplate(int template){
        switch (template){
            case 0: return EmptyTemplate.createEmptyTemplate();
            case 1: return GreetingTemplate.createGreetingTemplate();
            case 2: return ApologyTemplate.createApologyTemplate();
            default: return null;
        }
    }
}