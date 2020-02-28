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
        i.putExtra("imagen", "legend");
        startActivity(i);
        System.out.println("legendeddddddddddd");

    }

    public void llamarC(View view) {
        Intent i = new Intent (this, contador.class);
        i.putExtra("imagen", "celebrity");
        startActivity(i);
        System.out.println("celebytyyyyyyyyyyyyyyyyyyy");
    }

    public void llamarA(View view) {
        Intent i = new Intent (this, contador.class);
        i.putExtra("imagen", "animal");
        startActivity(i);
        System.out.println("animalllllllllll");
    }

    public void llamarG(View view) {

        Intent i = new Intent (this, contador.class);
        i.putExtra("imagen", "geography");
        startActivity(i);
        System.out.println("geographyyyyyyyyyyyyyyy");
    }
}
