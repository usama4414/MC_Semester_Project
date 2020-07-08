package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddDare extends AppCompatActivity {

    Button btn_add_dare;
    EditText myDare;
    SqlLiteDataBase db;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dare);
        btn_add_dare=(Button)findViewById(R.id.btn_add_dare);
        myDare= (EditText) findViewById(R.id.myDare);
        tvResult= (TextView) findViewById(R.id.tvResult);
        db=new SqlLiteDataBase(this);
        String data= db.getDareData();
        tvResult.setText(data);
        btn_add_dare.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                boolean fine=true;
                try
                {
                    String dare=myDare.getText().toString();
                    db.insertDare(dare);
                }
                catch(Exception ex)
                {
                    fine=false;
                    String error=ex.toString();
                    Dialog d = new Dialog(AddDare.this);
                    d.setTitle("Err");
                    TextView tv= new TextView(AddDare.this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                } finally {
                    if (fine)
                    {
                        Dialog d = new Dialog(AddDare.this);
                        d.setTitle("Success");
                        TextView tv= new TextView(AddDare.this);
                        tv.setText("Successfully inserted.");
                        d.setContentView(tv);
                        d.show();
                        String data= db.getDareData();
                        tvResult.setText(data);
                    }
                }

            }
        });
    }
}
