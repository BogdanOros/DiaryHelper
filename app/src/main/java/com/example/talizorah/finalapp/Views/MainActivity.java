package com.example.talizorah.finalapp.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import com.example.talizorah.finalapp.Controller.CourseAdapterController;
import com.example.talizorah.finalapp.CourseItems.CourseHandler;
import com.example.talizorah.finalapp.CourseItems.CourseHandlerProxy;
import com.example.talizorah.finalapp.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.title_main_act);
        final Context mContext = this;
        LinearLayout noteL = (LinearLayout)findViewById(R.id.note_layout);
        LinearLayout courseL = (LinearLayout)findViewById(R.id.course_layout);
        courseL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CourseActivity.class);
                startActivity(intent);
            }
        });
        noteL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NoteActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
