package com.example.talizorah.finalapp.CourseItems;

import android.util.Log;
import android.view.View;

import com.example.talizorah.finalapp.Visitor.BuilderElement;
import com.example.talizorah.finalapp.Visitor.DecoratorElement;
import com.example.talizorah.finalapp.Visitor.VisitorService;

/**
 * Created by talizorah on 16.11.4.
 */
public class CourseItem implements VisitorService {

    private View view;
    private double buyPrice;
    private double sellPrice;
    private double criticalPrice;

    public double getCriticalPrice() {
        return criticalPrice;
    }

    public void setCriticalPrice(double criticalPrice) {
        this.criticalPrice = criticalPrice;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    private String courseName;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }


    private CourseItem(){
        criticalPrice = 25;
    }
    public static CourseItem createEmptyCourseItem(){
        return new CourseItem();
    }
    @Override
    public View visitDecoratorElement(DecoratorElement element) {
        element.decorateCourseItemView(this);
        return view;
    }

    @Override
    public void visitBuilderElement(BuilderElement element) {
        try {
            element.createCourseItem(this);
        }
        catch (IndexOutOfBoundsException ex){
            Log.v("ITEM CREATING", "No data source for such item");
        }
    }
}
