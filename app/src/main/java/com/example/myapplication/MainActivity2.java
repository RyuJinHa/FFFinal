package com.example.myapplication;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class MainActivity2 extends AppCompatActivity {

    MediaPlayer player;
    ConstraintLayout alarmscreen;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.release();
            player = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        alarmscreen = (ConstraintLayout) findViewById(R.id.alarmscreen);
        final int myRed = ContextCompat.getColor(this, R.color.myRed);
        final Button button1 = (Button) findViewById(R.id.button2);
        final Button button2 = (Button) findViewById(R.id.button3);

        player = MediaPlayer.create(MainActivity2.this, R.raw.siren);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.start();
                alarmscreen.setBackgroundColor(myRed);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.isPlaying()) {
                    player.reset();
                    alarmscreen.setBackgroundColor(Color.WHITE);
                    player = MediaPlayer.create(MainActivity2.this, R.raw.siren);
                }
            }
        });
    }
}
