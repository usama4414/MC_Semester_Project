package com.example.spinbottle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class Choice extends AppCompatActivity {
    Button btn_truth;
    Button btn_dare;
    String name1,name2,name3,name4,turn;
    int scoreName1,scoreName2,scoreName3,scoreName4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        Bundle extras = getIntent().getExtras();
        name1 = extras.getString("Name1");
        name2 = extras.getString("Name2");
        name3 = extras.getString("Name3");
        name4 = extras.getString("Name4");
        scoreName1=extras.getInt("Score1");
        scoreName2=extras.getInt("Score2");
        scoreName3=extras.getInt("Score3");
        scoreName4=extras.getInt("Score4");
        turn=   extras.getString("Turn");
        btn_truth= (Button) findViewById(R.id.btn_truth);
        btn_dare= (Button) findViewById(R.id.btn_dare);
        btn_truth.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), Truth.class);
                it.putExtra("Name1", name1);
                it.putExtra("Name2", name2);
                it.putExtra("Name3", name3);
                it.putExtra("Name4", name4);
                it.putExtra("Score1",scoreName1);
                it.putExtra("Score2",scoreName2);
                it.putExtra("Score3",scoreName3);
                it.putExtra("Score4",scoreName4);
                it.putExtra("Turn",turn);
                startActivity(it);
            }
        });
        btn_dare.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), Dare.class);
                it.putExtra("Name1", name1);
                it.putExtra("Name2", name2);
                it.putExtra("Name3", name3);
                it.putExtra("Name4", name4);
                it.putExtra("Score1", scoreName1);
                it.putExtra("Score2", scoreName2);
                it.putExtra("Score3", scoreName3);
                it.putExtra("Score4", scoreName4);
                it.putExtra("Turn", turn);
                startActivity(it);
            }
        });


    }
}
