package com.sugarliteapp.examinationmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name,subject,date,semester;
    Button submit;
    TextView viewdata;
    SQLiteDatabase sd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        subject = findViewById(R.id.subject);
        date = findViewById(R.id.date);
        semester = findViewById(R.id.semester);
        viewdata = findViewById(R.id.view);
        submit = findViewById(R.id.submit);
        sd= openOrCreateDatabase("Dbname",0,null);
        sd.execSQL("create table if not exists tbname(Name VARCHAR(100),Subject VARCHAR(100),Date VARCHAR(250),Semester VARCHAR(100))");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sd.execSQL("insert into tbname values('"+name.getText().toString()+"','"+subject.getText().toString()+"','"+date.getText().toString()+"','"+semester.getText().toString()+"')");
                name.setText("");
                subject.setText("");
                date.setText("");
                semester.setText("");
            }
        });
        viewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DataActivity.class));
            }
        });
    }
}
