package com.example.headsupdisplaygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class contador extends AppCompatActivity {

    TextView t1;
    CountDownTimer cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        t1 = findViewById(R.id.t1);



        cd = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                t1.setText(millisUntilFinished/1000+ "");
            }

            @Override
            public void onFinish() {
                // pa cuando terine se tendra que ir al juego

                Intent i = new Intent (getApplicationContext(), quizz.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(), "Listooooo!!!!",
                        Toast.LENGTH_LONG).show();
            }
        };

        cd.start();

    }
}
