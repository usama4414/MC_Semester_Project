package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddDare extends AppCompatActivity {

    Button btn_add_dare,btn_go_back;
    EditText myDare;
    SqlLiteDataBase db;
    RecyclerView tvResult;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter mAdapter;
    String Mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dare);
        Bundle extras = getIntent().getExtras();
        Mode = extras.getString("Mode");
        db=new SqlLiteDataBase(this);
        List<String> input= new ArrayList<String>();
        if(Mode.equals("Kids"))
        {
            input=db.getKidsDareData();
        }
        else
        {
            input=db.getDareData();
        }

        btn_add_dare=(Button)findViewById(R.id.btn_add_dare);
        btn_go_back=(Button) findViewById(R.id.btn_go_back);
        myDare= (EditText) findViewById(R.id.myDare);
        tvResult= (RecyclerView) findViewById(R.id.tvResult);
        tvResult.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        tvResult.setLayoutManager(layoutManager);
        mAdapter=new MyAdapter(input,db,Mode);
        tvResult.setAdapter(mAdapter);


        btn_go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), FirstActivity.class);
                it.putExtra("Mode",Mode);
                startActivity(it);
            }
        });

       // tvResult.setText(data);
        btn_add_dare.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                boolean fine=true;
                try
                {
                    String dare=myDare.getText().toString();
                    if (Mode.equals("Kids"))
                    {
                        db.insertKidsDare(dare);
                    }
                    else
                    {
                        db.insertDare(dare);
                    }

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
                        List<String> input =new ArrayList<String>();
                        if(Mode.equals("Kids"))
                        {
                            input=db.getKidsDareData();
                        }
                        else
                        {
                            input=db.getDareData();
                        }
                        mAdapter=new MyAdapter(input,db,Mode);
                        tvResult.setAdapter(mAdapter);
                        myDare.setText(null);
                        //tvResult.setText(input);
                    }
                }

            }
        });
    }
}
