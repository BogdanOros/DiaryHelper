package com.example.talizorah.finalapp.Visitor;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 * Created by talizorah on 16.11.4.
 */
public interface VisitorService {
    View visitDecoratorElement(DecoratorElement element);
    void visitBuilderElement(BuilderElement element);
}
