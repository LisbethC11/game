package com.example.headsupdisplaygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class quizz extends AppCompatActivity {
    TextView txt;
    TextView t1;
    SensorManager sensorManager;
    Sensor elsensor;
    SensorEventListener sensorEventListener;

    CountDownTimer cd;

    private static final String TAG = "QUIZZ";

    private Retrofit retrofit;

    int g = 0;

    String v1 = "";
    String v2 = "";
    String v3 = "";
    String v4 = "";
    String v5 = "";

    int cont = 0;

    int puntosT = 0;
    int puntosF = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        txt = (TextView) findViewById(R.id.textView7);

        t1 = (TextView) findViewById(R.id.txt);

        /************EL API*************/
        EmpezarJuego();
/**********************************/



        sensores();

        /*******************cuenta regresiva************************/

        cd = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                t1.setText(millisUntilFinished/1000+ "");
            }

            @Override
            public void onFinish() {
                // pa cuando terine se tendra que ir

                Intent i = new Intent (getApplicationContext(), MainActivity.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(), "TERMINO!!!!",
                        Toast.LENGTH_LONG).show();
            }
        };

        cd.start();

/**************************/

    }

    private void Start() {
        sensorManager.registerListener(sensorEventListener, elsensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void Stop() {
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Start();
    }

     public void sensores(){
         sensorManager = (SensorManager) getApplicationContext().getSystemService(SENSOR_SERVICE);
         elsensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
         //sensorManager.registerListener(this, elsensor,sensorManager.SENSOR_DELAY_FASTEST);

         if (elsensor == null) {
             Toast.makeText(this, "no tienes sensor, sorry :( ", Toast.LENGTH_LONG);
             finish();
         }
         sensorEventListener = new SensorEventListener() {
             @Override
             public void onSensorChanged(SensorEvent event) {

                 final String[] v = {v1, v2, v3, v4, v5};

                 float x = event.values[2];
                 System.out.println("valor de giro " + x);
                 if (x >7 && g == 0) {

                     g++;

                     if (cont == 0) {
                         txt.setText(v[0]);
                         cont++;

                     }
                     if (cont == 1) {

puntosT++;
                         txt.setText(v[0]);
                         cont++;
                       mostrarDialogoPersonalizado();


                     } else if (cont == 2) {

                         puntosT++;
                         txt.setText(v[1]);
                         cont++;
                         mostrarDialogoPersonalizado();
                     } else if (cont == 3) {
                         puntosT++;

                         txt.setText(v[2]);
                         cont++;
                         mostrarDialogoPersonalizado();
                     } else if (cont == 4) {
                         puntosT++;

                         txt.setText(v[3]);
                         cont++;
                         mostrarDialogoPersonalizado();
                     } else if (cont == 5) {
                         puntosT++;

                         txt.setText(v[4]);
                         cont++;
                         mostrarDialogoPersonalizado();
                     }
                     if (cont == 6) {

                         cont = 0;
                         Intent i = new Intent (getApplicationContext(), finaly.class);
                         startActivity(i);
                     }


                     getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                     System.out.println("pariba");

                     /********PASSSSSS********/
                 } else if (x <- 7 && g == 1) {
                     g++;

                     if (cont == 0) {

                         txt.setText("pabajo: " + v[0]);
                         cont++;

                     }
                     if (cont == 1) {

puntosF++;

                         txt.setText("pabajo1: " + v[0]);
                         cont++;
                         mostrarDialogoPersonalizado1("PASS");
                     } else if (cont == 2) {

puntosF++;


                         txt.setText("pabajo2: " + v[1]);
                         cont++;
                         mostrarDialogoPersonalizado1("PASS");
                     } else if (cont == 3) {

                         puntosF++;
                         txt.setText("pabajo3: " + v[2]);
                         cont++;
                         mostrarDialogoPersonalizado1("PASS");
                     } else if (cont == 4) {
                         txt.setText("pabajo4: " + v[3]);
                         cont++;
                         puntosF++;
                         mostrarDialogoPersonalizado1("PASS");
                     } else if (cont == 5) {
                         txt.setText("pabajo5: " + v[4]);
                         cont++;
                         puntosF++;
                         mostrarDialogoPersonalizado1("PASS");
                     }
                     if (cont == 6) {
                         cont = 0;


                         Intent i = new Intent (getApplicationContext(), finaly.class);
                         startActivity(i);
                     }
                     getWindow().getDecorView().setBackgroundColor(Color.RED);

                     //txt.setText("pabajo"+g);
                     System.out.println("pa bajp");
                 }
                 if (g == 2) {
                     g = 0;
                 }
             }

             @Override
             public void onAccuracyChanged(Sensor sensor, int accuracy) {

             }
         };
         Start();

     }

    public void EmpezarJuego() {

        final ArrayList<Result>[] result;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://opentdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService postService = retrofit.create(PostService.class);
        Call<Post> call = postService.getPost();
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post>
                    response) {

                if (response.isSuccessful()) {
                    Post p = response.body();
                    ArrayList<Result> list = (ArrayList<Result>) p.getResults();


                    for (int i = 0; i < list.size(); i++) {
                        Result r = list.get(i);
                        Result r1 = list.get(0);
                        Result r2 = list.get(1);
                        Result r3 = list.get(2);
                        Result r4 = list.get(3);
                        Result r5 = list.get(4);

                        System.out.println(r.getCorrect_answer());

                        v1 = r1.getCorrect_answer();
                        v2 = r2.getCorrect_answer();
                        v3 = r3.getCorrect_answer();
                        v4 = r4.getCorrect_answer();
                        v5 = r5.getCorrect_answer();

                    }
                    //txt.setText(v1);
                }

                // result[0] = new ArrayList<>(response.body().getResults());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                txt.setText("fallo: " + t.getMessage());
            }
        });

    }

    private void mostrarDialogoPersonalizado() {
        AlertDialog.Builder builder = new AlertDialog.Builder(quizz.this);

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.correcto, null);

        builder.setView(view);

        //TODO BOTONES POR DEFECTO
        /**
         builder.setView(inflater.inflate(R.layout.dialog_personalizado,null))
         .setPositiveButton("Reintentar", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getApplicationContext(),"Conectando...",Toast.LENGTH_SHORT).show();
        }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT).show();
        }
        });
         */

        final AlertDialog dialog = builder.create();
        dialog.show();

        TextView txt = view.findViewById(R.id.txt1);
        txt.setText("Correcto");

        new Handler().postDelayed(new Runnable() {
            public void run() {
                dialog.dismiss();

                //finish();
            }


        }, 3000);

    }

    private void mostrarDialogoPersonalizado1(String msm) {
        AlertDialog.Builder builder = new AlertDialog.Builder(quizz.this);

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.correcto, null);

        builder.setView(view);

        //TODO BOTONES POR DEFECTO
        /**
         builder.setView(inflater.inflate(R.layout.dialog_personalizado,null))
         .setPositiveButton("Reintentar", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getApplicationContext(),"Conectando...",Toast.LENGTH_SHORT).show();
        }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT).show();
        }
        });
         */

        final AlertDialog dialog = builder.create();
        dialog.show();

        TextView txt = view.findViewById(R.id.txt1);
        txt.setText(msm);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                dialog.dismiss();

                //finish();
            }


        }, 3000);

    }


}
