package com.sugarliteapp.examinationmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    TextView tvname,tvsubject,tvdate,tvsemester;
    SQLiteDatabase sd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        tvname = findViewById(R.id.tvname);
        tvsubject = findViewById(R.id.tvsubject);
        tvdate = findViewById(R.id.tvdate);
        tvsemester = findViewById(R.id.tvsemester);
        sd = openOrCreateDatabase("Dbname",0,null);
        Cursor c = sd.rawQuery("Select * from tbname",null);
        tvname.setText("");
        tvsubject.setText("");
        tvdate.setText("");
        tvsemester.setText("");
        c.moveToFirst();
        if(c.isFirst()){
            while(c.moveToNext()){
                tvname.append(c.getString(0));
                tvname.append("\n");
                tvsubject.append(c.getString(1));
                tvsubject.append("\n");
                tvdate.append(c.getString(2));
                tvdate.append("\n");
                tvsemester.append(c.getString(3));
                tvsemester.append("\n");
            }
        }
    }
}
