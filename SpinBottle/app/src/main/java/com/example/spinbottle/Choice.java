package com.example.spinbottle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class Choice extends AppCompatActivity {
    Button btn_truth;
    Button btn_dare;
    String name1;
    String name2;
    String name3;
    String name4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        Bundle extras = getIntent().getExtras();
        name1 = extras.getString("Name1");
        name2 = extras.getString("Name2");
        name3 = extras.getString("Name3");
        name4 = extras.getString("Name4");
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
                startActivity(it);
            }
        });


    }
}
