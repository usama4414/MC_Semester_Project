package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mode extends AppCompatActivity {
    Button kids,teen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
        kids= (Button)findViewById(R.id.kids);
        teen=(Button)findViewById(R.id.teen);
        kids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Mode.this,FirstActivity.class);
                it.putExtra("Mode","Kids");
                startActivity(it);
            }
        });
        teen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Mode.this,FirstActivity.class);
                it.putExtra("Mode","Teen");
                startActivity(it);
            }
        });
    }
}
