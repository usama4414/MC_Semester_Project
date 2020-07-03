package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread td= new Thread(){
            public void run()
            {
                try {
                    sleep(4000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }finally
                {
                    Intent it=new Intent(Splash.this,FirstActivity.class);
                    startActivity(it);
                }
            }
        };
        td.start();
    }
}
