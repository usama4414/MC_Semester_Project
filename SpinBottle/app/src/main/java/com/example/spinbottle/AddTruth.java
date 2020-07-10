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

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class AddTruth extends AppCompatActivity {

    Button btn_add_truth,truth_btn_go_back;
    EditText myTruth;
    SqlLiteDataBase db;
    RecyclerView truth_tvResult;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter mAdapter;
    String Mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_truth);
        Bundle extras = getIntent().getExtras();
        db=new SqlLiteDataBase(this);
        Mode = extras.getString("Mode");
        List<String> input= new ArrayList<String>();

        btn_add_truth=(Button)findViewById(R.id.btn_add_truth);
        truth_btn_go_back=(Button) findViewById(R.id.truth_btn_go_back);
        myTruth= (EditText) findViewById(R.id.myTruth);
        truth_tvResult= (RecyclerView) findViewById(R.id.truth_tvResult);
        truth_tvResult.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        truth_tvResult.setLayoutManager(layoutManager);
        mAdapter=new MyAdapterTruth(input,db,Mode);
        truth_tvResult.setAdapter(mAdapter);


        truth_btn_go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), FirstActivity.class);
                it.putExtra("Mode",Mode);
                startActivity(it);
            }
        });

        // tvResult.setText(data);
        btn_add_truth.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                boolean fine=true;
                try
                {
                    String truth=myTruth.getText().toString();
                    if (Mode.equals("Kids"))
                    {
                        db.insertKidsTruth(truth);
                    }
                    else
                    {
                        db.insertTruth(truth);
                    }
                }
                catch(Exception ex)
                {
                    fine=false;
                    String error=ex.toString();
                    Dialog d = new Dialog(AddTruth.this);
                    d.setTitle("Err");
                    TextView tv= new TextView(AddTruth.this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                } finally {
                    if (fine)
                    {
                        Dialog d = new Dialog(AddTruth.this);
                        d.setTitle("Success");
                        TextView tv= new TextView(AddTruth.this);
                        tv.setText("Successfully inserted.");
                        d.setContentView(tv);
                        d.show();

                        List<String> input = new ArrayList<String>();

                        mAdapter=new MyAdapterTruth(input,db,Mode);
                        truth_tvResult.setAdapter(mAdapter);
                        myTruth.setText(null);
                        //tvResult.setText(input);
                    }
                }

            }
        });



    }
}
