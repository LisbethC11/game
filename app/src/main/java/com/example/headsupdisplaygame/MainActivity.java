package com.example.headsupdisplaygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void llamar(View view){
        Intent i = new Intent (this, contador.class);
        startActivity(i);

        while (n < 3){
            n++;
            System.out.println(n);
        }
    }
}
