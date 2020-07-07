package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    Animation rotate;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread td= new Thread(){
            public void run()
            {
                try {
                    iv= (ImageView) findViewById(R.id.startLogoSpin);
                    rotate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                    iv.setVisibility(View.VISIBLE);
                    iv.startAnimation(rotate);
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
