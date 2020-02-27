package com.example.headsupdisplaygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        }

    }
}
