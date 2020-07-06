package com.example.spinbottle;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;
    private Random random = new Random();
    private float lastDirection;
    String name1;
    String name2;
    String name3;
    String name4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        name1 = extras.getString("Name1");
        name2 = extras.getString("Name2");
        name3 = extras.getString("Name3");
        name4 = extras.getString("Name4");

        TextView tView1=findViewById(R.id.textView1);
        TextView tView2=findViewById(R.id.textView2);
        TextView tView3=findViewById(R.id.textView3);
        TextView tView4=findViewById(R.id.textView4);

        tView1.setTextColor(Color.BLUE);
        tView2.setTextColor(Color.BLUE);
        tView3.setTextColor(Color.BLUE);
        tView4.setTextColor(Color.BLUE);

        tView1.setText(name1);
        tView2.setText(name2);
        tView3.setText(name3);
        tView4.setText(name4);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

    }

    public void spin(View v)
    {
        TextView tView1=findViewById(R.id.textView1);
        TextView tView2=findViewById(R.id.textView2);
        TextView tView3=findViewById(R.id.textView3);
        TextView tView4=findViewById(R.id.textView4);

        tView1.setTextColor(Color.BLUE);
        tView2.setTextColor(Color.BLUE);
        tView3.setTextColor(Color.BLUE);
        tView4.setTextColor(Color.BLUE);



        float  newDirection = random.nextInt(3600);
        int dir= (int)Math.abs(newDirection)%360;
        TextView turn=findViewById(R.id.textView1);
        if(dir<=45 || dir>315) {
            turn=findViewById(R.id.textView2);
        }
        else if(dir>45 && dir<=135)
        {
            turn=findViewById(R.id.textView3);
        }
        else if(dir>135 && dir<=225)
        {
            turn=findViewById(R.id.textView4);
        }

        final TextView turnL= turn;
        float pivoitX = imageView.getWidth()/2;
        float pivoitY = imageView.getHeight()/2;
        if (Math.abs(lastDirection - newDirection) < 360)
        {
            newDirection = lastDirection + newDirection + 360;
        }


        Animation rotate = new RotateAnimation(lastDirection,  newDirection, pivoitX, pivoitY);

        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                turnL.setTextColor(Color.RED);
                button.setEnabled(true);
                Toast.makeText(getApplicationContext(),turnL.getText().toString()+"\'s turn",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), Choice.class);
                i.putExtra("Name1", name1);
                i.putExtra("Name2", name2);
                i.putExtra("Name3", name3);
                i.putExtra("Name4", name4);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lastDirection = newDirection;
        imageView.startAnimation(rotate);

    }
}

