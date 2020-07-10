package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity {

    TextView pname1,pname2,pname3,pname4, pscore1,pscore2,pscore3,pscore4;
    Button keepPlay,startAgain;
    String name1,name2,name3,name4,Mode;
    int scoreName1,scoreName2,scoreName3,scoreName4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        Bundle extras = getIntent().getExtras();
        name1 = extras.getString("Name1");
        name2 = extras.getString("Name2");
        name3 = extras.getString("Name3");
        name4 = extras.getString("Name4");
        scoreName1=extras.getInt("Score1");
        scoreName2=extras.getInt("Score2");
        scoreName3=extras.getInt("Score3");
        scoreName4=extras.getInt("Score4");
        Mode= extras.getString("Mode");
        pname1= (TextView) findViewById(R.id.pname1);
        pname2= (TextView) findViewById(R.id.pname2);
        pname3= (TextView) findViewById(R.id.pname3);
        pname4= (TextView) findViewById(R.id.pname4);
        pscore1= (TextView) findViewById(R.id.pscore1);
        pscore2= (TextView) findViewById(R.id.pscore2);
        pscore3= (TextView) findViewById(R.id.pscore3);
        pscore4= (TextView) findViewById(R.id.pscore4);
        pname1.setText(name1);
        pname2.setText(name2);
        pname3.setText(name3);
        pname4.setText(name4);
        pscore1.setText(String.valueOf(scoreName1));
        pscore2.setText(String.valueOf(scoreName2));
        pscore3.setText(String.valueOf(scoreName3));
        pscore4.setText(String.valueOf(scoreName4));
        keepPlay=(Button)findViewById(R.id.keepPlay);
        startAgain=(Button)findViewById(R.id.startAgain);
        keepPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("Name1",name1);
                i.putExtra("Name2",name2);
                i.putExtra("Name3",name3);
                i.putExtra("Name4",name4);
                i.putExtra("Score1",scoreName1);
                i.putExtra("Score2",scoreName2);
                i.putExtra("Score3",scoreName3);
                i.putExtra("Score4",scoreName4);
                i.putExtra("Mode",Mode);
                startActivity(i);
            }
        });
        startAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), Mode.class);
                startActivity(i);
            }
        });
    }
}