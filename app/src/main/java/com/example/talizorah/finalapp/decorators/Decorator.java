package com.example.talizorah.finalapp.decorators;

import android.view.View;

/**
 * Created by talizorah on 16.16.4.
 */
public interface Decorator {
    void setView(View view);
    View getDecoratedView();
}
