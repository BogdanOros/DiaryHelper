package com.example.talizorah.finalapp.Visitor;

import com.example.talizorah.finalapp.CourseItems.CourseDataList;
import com.example.talizorah.finalapp.CourseItems.CourseItem;
import com.example.talizorah.finalapp.builder.NoteBuilder;

/**
 * Created by talizorah on 16.11.4.
 */
public class BuilderElement implements VisitorElementService {
    private CourseDataList dataSource;
    private int dataSourceIterator;
    private BuilderElement(){
        dataSource = null;
        dataSourceIterator = 0;
    }
    public static BuilderElement createBuilderElement(){
        return new BuilderElement();
    }
    @Override
    public void acceptVisitor(VisitorService visitorService) {
       visitorService.visitBuilderElement(this);
    }

    public void createCourseItem(CourseItem item) throws IndexOutOfBoundsException{
        item.setCourseName(getCourseName());
        item.setBuyPrice(getCourseBuyPrice());
        item.setSellPrice(getCourseSalePrice());
        //Always call it when finished ->
        finishCreation();
    }
    public void setDataSource(CourseDataList temporaryList){
        dataSource = temporaryList;
    }
    public CourseDataList getDataSource(){
        return dataSource;
    }
    public void clearDataSource(){
        dataSource.getList().clear();
        dataSource = null;
    }
    private String getCourseName(){
        return dataSource.getList().get(dataSourceIterator).cFrom + " - " +
                dataSource.getList().get(dataSourceIterator).cTo;
    }
    private Double getCourseBuyPrice(){
        return Double.valueOf(dataSource.getList().get(dataSourceIterator).cBuy);
    }
    private Double getCourseSalePrice(){
        return Double.valueOf(dataSource.getList().get(dataSourceIterator).cSale);
    }
    private void finishCreation() throws IndexOutOfBoundsException{
        if(dataSourceIterator < dataSource.getList().size())
            dataSourceIterator++;
    }
}
