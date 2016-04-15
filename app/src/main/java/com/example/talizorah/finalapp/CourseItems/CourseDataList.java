package com.example.talizorah.finalapp.CourseItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by talizorah on 16.11.4.
 */
//Temporary data holder ->
public class CourseDataList {
    private List<CourseDataHolder> list;
    public CourseDataList(){
        list = new ArrayList<>();
    }
    public List<CourseDataHolder> getList(){
        return list;
    }
    public void add(CourseDataHolder holder){
        list.add(holder);
    }
}
