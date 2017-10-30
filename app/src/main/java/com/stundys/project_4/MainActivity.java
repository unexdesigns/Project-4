package com.stundys.project_4;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    View body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        body = findViewById(R.id.body);
    }

    public void reposition(View view){
        Random rx = new Random();
        Random ry = new Random();

        int maxX = body.getWidth() - view.getWidth();
        int maxY = body.getHeight() - view.getHeight();
        int dx = rx.nextInt(maxX) - maxX/2;
        int dy = ry.nextInt(maxY) - maxY/2;

        ObjectAnimator animation = ObjectAnimator.ofFloat(
                view,
                "translationX",
                dx
        );
        animation.setDuration(200);
        animation.start();

        ObjectAnimator animationY = ObjectAnimator.ofFloat(
                view,
                "translationY",
                dy
        );
        animationY.setDuration(200);
        animationY.start();
    }
}
