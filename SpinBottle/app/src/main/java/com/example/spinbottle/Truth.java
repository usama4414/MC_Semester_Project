package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Truth extends AppCompatActivity {

    SqlLiteDataBase db;
    TextView truth_assignedTV;
    Button truthDone,truthForfeit;
    int scoreName1=0;
    int scoreName2=0;
    int scoreName3=0;
    int scoreName4=0;
    String name1,name2,name3,name4,turn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth);

        truth_assignedTV= (TextView) findViewById(R.id.truth_assignedTV);
        db=new SqlLiteDataBase(this);
        String assignTruth=db.getOneTruth(); //getting Truth from DB
        truth_assignedTV.setText(assignTruth);
        truthDone= (Button) findViewById(R.id.truthDone);
        truthForfeit= (Button) findViewById(R.id.truthForfeit);
        Bundle extras = getIntent().getExtras();
        name1 = extras.getString("Name1");
        name2 = extras.getString("Name2");
        name3 = extras.getString("Name3");
        name4 = extras.getString("Name4");
        turn=   extras.getString("Turn");
        scoreName1=extras.getInt("Score1");
        scoreName2=extras.getInt("Score2");
        scoreName3=extras.getInt("Score3");
        scoreName4=extras.getInt("Score4");
        truthDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turn.equals(name1))
                {
                    scoreName1=scoreName1+1;
                }
                else if(turn.equals(name2))
                {
                    scoreName2=scoreName2+1;
                }
                else if(turn.equals(name3))
                {
                    scoreName3=scoreName3+1;
                }
                else if(turn.equals(name4))
                {
                    scoreName4=scoreName4+1;
                }
                Intent i = new Intent(Truth.this, ScoreBoard.class);
                i.putExtra("Name1", name1);
                i.putExtra("Name2", name2);
                i.putExtra("Name3", name3);
                i.putExtra("Name4", name4);
                i.putExtra("Score1", scoreName1);
                i.putExtra("Score2", scoreName2);
                i.putExtra("Score3", scoreName3);
                i.putExtra("Score4", scoreName4);
                startActivity(i);
            }
        });
        truthForfeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ScoreBoard.class);
                i.putExtra("Name1",name1);
                i.putExtra("Name2",name2);
                i.putExtra("Name3",name3);
                i.putExtra("Name4",name4);
                i.putExtra("Score1",scoreName1);
                i.putExtra("Score2",scoreName2);
                i.putExtra("Score3",scoreName3);
                i.putExtra("Score4",scoreName4);
                startActivity(i);
            }
        });
    }
}
