package com.example.talizorah.finalapp.decorators;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import com.example.talizorah.finalapp.R;

/**
 * Created by talizorah on 16.13.4.
 */
public class WarningDecorator extends View implements Decorator{
    private View view;
    public WarningDecorator(Context context) {
        super(context);
    }
    public void setView(View view){
        this.view = view;
    }
    public View getDecoratedView(){
        ImageView imageView = (ImageView)view.findViewById(R.id.course_image_view);
        imageView.setImageResource(R.drawable.ic_warning);
        return view;
    }
}
