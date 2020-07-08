package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    Button add_truth_option;
    Button add_dare_option;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        add_dare_option= (Button)findViewById(R.id.add_dare_option);
        add_truth_option= (Button)findViewById(R.id.add_truth_option);
        add_dare_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AddDare.class);
                startActivity(it);
            }
        });
        add_truth_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void btnStartClick(View view) {
        EditText edit1= findViewById(R.id.editName1);
        EditText edit2= findViewById(R.id.editName2);
        EditText edit3= findViewById(R.id.editName3);
        EditText edit4= findViewById(R.id.editName4);

        String name1=edit1.getText().toString();
        String name2=edit2.getText().toString();
        String name3=edit3.getText().toString();
        String name4=edit4.getText().toString();

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("Name1", name1);
        i.putExtra("Name2", name2);
        i.putExtra("Name3", name3);
        i.putExtra("Name4", name4);
        startActivity(i);
    }
}
