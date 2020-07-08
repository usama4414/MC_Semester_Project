package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Dare extends AppCompatActivity {

    SqlLiteDataBase db;
    TextView assignedTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dare);
        assignedTV= (TextView) findViewById(R.id.assignedTV);
        db=new SqlLiteDataBase(this);
        String assignDare=db.getOneDare();
        assignedTV.setText(assignDare);
    }
}
