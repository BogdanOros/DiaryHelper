package com.example.talizorah.finalapp.decorators;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.example.talizorah.finalapp.R;

/**
 * Created by talizorah on 16.16.4.
 */
public class NormalPriceDecorator extends View implements Decorator{
    private View view;
    public NormalPriceDecorator(Context context) {
        super(context);
    }
    public void setView(View view){
        this.view = view;
    }
    public View getDecoratedView() {
        ImageView imageView = (ImageView) view.findViewById(R.id.course_image_view);
        imageView.setImageResource(R.drawable.ic_normal_price);
        return view;
    }
}
