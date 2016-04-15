package com.example.talizorah.finalapp.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.talizorah.finalapp.Controller.CourseAdapterController;
import com.example.talizorah.finalapp.R;

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_list);
        setTitle(R.string.title_course_act);
        ListView listView = (ListView)findViewById(R.id.course_list);
        CourseAdapterController controller =
                CourseAdapterController.createAdapterController(this, listView);
        // Setting up the list adapter ->
        controller.setAdapter();
    }
}
