package com.example.talizorah.finalapp.builder;

import com.example.talizorah.finalapp.notes.ITemplate;

/**
 * Created by talizorah on 16.5.4.
 */
public interface Builder {
    boolean setName(String name);
    boolean setText(String text);
    void setDate(String date);
    void setTemplate(ITemplate template);
    Object createObject();
}
