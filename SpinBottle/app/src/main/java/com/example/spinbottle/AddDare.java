package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDare extends AppCompatActivity {

    Button btn_add_dare;
    EditText myDare;
    SqlLiteDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dare);
        btn_add_dare=(Button)findViewById(R.id.btn_add_dare);
        myDare= (EditText) findViewById(R.id.myDare);
        db=new SqlLiteDataBase(this);
        btn_add_dare.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String dare=myDare.getText().toString();
                db.insert(dare);
            }
        });
    }
}
