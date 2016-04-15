package com.example.talizorah.finalapp.CourseItems;

import android.content.ClipData;

import com.example.talizorah.finalapp.Visitor.BuilderElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by talizorah on 16.11.4.
 */
public class CourseHandler {
    private BuilderElement builderElement;
    private List<CourseItem> items;
    public CourseHandler(){
        builderElement = BuilderElement.createBuilderElement();
        items = new ArrayList<>();
    }
    public void setTemporaryList(CourseDataList list){
        builderElement.setDataSource(list);
    }
    public CourseDataList getDataSource(){
        return builderElement.getDataSource();
    }
    public List<CourseItem> createItems(){
        for(int i = 0; i < builderElement.getDataSource().getList().size(); i++){
            CourseItem item = CourseItem.createEmptyCourseItem();
            builderElement.acceptVisitor(item);
            items.add(item);
        }
        builderElement.clearDataSource();
        return items;
    }
}
