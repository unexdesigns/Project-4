package com.stundys.project_4;

import android.animation.ObjectAnimator;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    View body;
    MediaPlayer mediaPlayer = new MediaPlayer();
    int lastPlayed = -1;

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

        playSound();
    }
    public void playSound(){
        int sounds[] = {
                R.raw.bum,
                R.raw.hit,
                R.raw.snap,
                R.raw.splat,
                R.raw.woosh
        };

        // pick random sound
        Random i = new Random();
        int ri = i.nextInt(sounds.length);
        if (ri == lastPlayed){
            while(ri == lastPlayed){
                ri = i.nextInt(sounds.length);
            }
        }
        int sound = sounds[ri];
        lastPlayed = ri;

        // play sound
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, sound);
        mediaPlayer.start();

    }

}
