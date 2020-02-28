package com.example.headsupdisplaygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class finaly extends AppCompatActivity {

    TextView tnt;
    TextView tnf;
    String laclase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finaly);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tnt = findViewById(R.id.rt);
        tnf = findViewById(R.id.rf);

        tnt.setText(getIntent().getIntExtra("pt",1)+"PT");
       laclase=(getIntent().getStringExtra("nameclass")+"");


    }


    public void menu(View view) {
        Intent i = new Intent (getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void reset(View view) {
        if(laclase.equals("quizz")){
            Intent i = new Intent (getApplicationContext(), quizz.class);
            startActivity(i);
        }else if(laclase.equals("quizzC")){
            Intent i = new Intent (getApplicationContext(), quizzC.class);
            startActivity(i);
        }else if(laclase.equals("quizzA")){
            Intent i = new Intent (getApplicationContext(), quizzA.class);
            startActivity(i);
        }else if(laclase.equals("quizzG")){
            Intent i = new Intent (getApplicationContext(), quizzG.class);
            startActivity(i);
        }

    }
}
