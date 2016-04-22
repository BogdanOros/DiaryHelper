package com.example.talizorah.finalapp.Visitor;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;

import com.example.talizorah.finalapp.CourseItems.CourseItem;
import com.example.talizorah.finalapp.decorators.Decorator;
import com.example.talizorah.finalapp.decorators.NormalPriceDecorator;
import com.example.talizorah.finalapp.decorators.WarningDecorator;

/**
 * Created by talizorah on 16.11.4.
 */
public class DecoratorElement implements VisitorElementService {
    private Activity activity;
    Decorator decorator;
    private SharedPreferences preferences;
    private DecoratorElement(Activity activity)
    {
        this.activity = activity;
        this.preferences = activity.getSharedPreferences(
                "com.example.talizorah.finalapp", activity.MODE_PRIVATE);
    }
    public void setActivity(Activity activity){
        this.activity = activity;
    }
    public static DecoratorElement createDecoratorElement(Activity activity){
        return new DecoratorElement(activity);
    }
    @Override
    public View acceptVisitor(VisitorService visitorService) {
        return visitorService.visitDecoratorElement(this);
    }

    public View decorateCourseItemView(CourseItem item){
        double price = Double.valueOf(preferences.getString(item.getCourseName(), "0"));
        if(item.getBuyPrice() > price){
            decorator = new WarningDecorator(activity);
            decorator.setView(item.getView());
            return decorator.getDecoratedView();
        }
        else if(item.getBuyPrice() < price){
            decorator = new NormalPriceDecorator(activity);
            decorator.setView(item.getView());
            return decorator.getDecoratedView();
        }
        return null;
    }
}
