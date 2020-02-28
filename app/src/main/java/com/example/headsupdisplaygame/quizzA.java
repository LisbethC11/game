package com.example.headsupdisplaygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.headsupdisplaygame.api1.Result;
import com.example.headsupdisplaygame.api3.PostA;
import com.example.headsupdisplaygame.api3.PostServiceA;
import com.example.headsupdisplaygame.api3.ResultA;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class quizzA extends AppCompatActivity {
    TextView txt;
    TextView t1;
    SensorManager sensorManager;
    Sensor elsensor;
    SensorEventListener sensorEventListener;
    List<Sensor> s;

    CountDownTimer cd;

    private static final String TAG = "QUIZZ";

    private Retrofit retrofit;

    int g = 0;
    int h = 0;

    String v1 = "";
    String v2 = "";
    String v3 = "";
    String v4 = "";
    String v5 = "";
    String v6 = "";
    String v7 = "";
    String v8 = "";
    String v9 = "";
    String v10 = "";

    int cont = 0;

    int puntosT = 0;
    int puntosF = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_a);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        txt = (TextView) findViewById(R.id.textView7);

        t1 = (TextView) findViewById(R.id.txt);

        /************EL API*************/
        EmpezarJuego();
        /**********************************/

        sensores();

        System.out.println("eoooooooo: " + cont);

        /*******************cuenta regresiva************************/

        cd = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                t1.setText(millisUntilFinished / 1000 + "");
            }

            @Override
            public void onFinish() {
                // pa cuando terine se tendra que ir

                Intent i = new Intent(getApplicationContext(), finaly.class);
                i.putExtra("pt", puntosT);
                i.putExtra("nameclass", getLocalClassName());
                startActivity(i);


                Toast.makeText(getApplicationContext(), "TERMINO!!!!",
                        Toast.LENGTH_LONG).show();
            }
        };

        cd.start();

/**************************/

    }

    private void Start() {
        sensorManager.registerListener(sensorEventListener, elsensor, SensorManager.SENSOR_DELAY_GAME);
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

    private void sensores() {
        sensorManager = (SensorManager) getApplicationContext().getSystemService(SENSOR_SERVICE);
        elsensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//         //sensorManager.registerListener((sensorEventListener) getApplicationContext(),elsensor.get(0),SensorManager.SENSOR_DELAY_GAME);


        if (elsensor == null) {
            Toast.makeText(this, "no tienes sensor, sorry :( ", Toast.LENGTH_LONG);
            finish();
        }
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                Sensor si = event.sensor;
                final String[] v = {v1, v2, v3, v4, v5, v6, v7, v8, v9, v10};

                int p = 0;

                long la = 0;


                float x = event.values[2];
                System.out.println("valor de giro " + x);

                if (x > 7 && g == 0) {


                    if (cont == 0) {

                        // puntosT++;
                        txt.setText(v[0]);
                        cont++;
                        mostrarDialogoPersonalizado1("Lest Go!!");


                    } else if (cont == 1) {

                        puntosT++;
                        txt.setText(v[1]);
                        cont++;
                        mostrarDialogoPersonalizado();
                    } else if (cont == 2) {
                        puntosT++;

                        txt.setText(v[2]);
                        cont++;
                        mostrarDialogoPersonalizado();
                    } else if (cont == 3) {
                        puntosT++;

                        txt.setText(v[3]);
                        cont++;
                        mostrarDialogoPersonalizado();
                    } else if (cont == 4) {
                        puntosT++;

                        txt.setText(v[4]);
                        cont++;
                        mostrarDialogoPersonalizado();
                    } else if (cont == 5) {
                        puntosT++;

                        txt.setText(v[5]);
                        cont++;
                        mostrarDialogoPersonalizado();
                    }else if (cont == 6) {

                        puntosT++;
                        txt.setText(v[6]);
                        cont++;
                        mostrarDialogoPersonalizado();
                    } else if (cont == 7) {
                        puntosT++;

                        txt.setText(v[7]);
                        cont++;
                        mostrarDialogoPersonalizado();
                    } else if (cont == 8) {
                        puntosT++;

                        txt.setText(v[8]);
                        cont++;
                        mostrarDialogoPersonalizado();
                    } else if (cont == 9) {
                        puntosT++;

                        txt.setText(v[9]);
                        cont++;
                        mostrarDialogoPersonalizado();
                    } else if (cont == 10) {
                        puntosT++;

                        //txt.setText(v[4]);
                        cont=1;
                        mostrarDialogoPersonalizado();
                    }
                    g++;

                } else if (x < 3 && x > -3 && g == 1) {
                    //txt.setText("en el medio: "+ cont);
                    g++;
                }

                if (g == 2) {
                    g = 0;
                }
                /********************abajo*************************/

                if (x < -7 && h == 0) {


                    if (cont == 0) {

//                         puntosF++;

                        txt.setText(v[0]);
                        cont++;
                        mostrarDialogoPersonalizado1("Lest Go!!");
                    } else if (cont == 1) {

                        puntosF++;


                        txt.setText(v[1]);
                        cont++;
                        mostrarDialogoPersonalizado1("PASS");
                    } else if (cont == 2) {

                        puntosF++;
                        txt.setText(v[2]);
                        cont++;
                        mostrarDialogoPersonalizado1("PASS");
                    } else if (cont == 3) {
                        txt.setText(v[3]);
                        cont++;
                        puntosF++;
                        mostrarDialogoPersonalizado1("PASS");
                    } else if (cont == 4) {
                        txt.setText(v[4]);
                        cont++;
                        puntosF++;
                        mostrarDialogoPersonalizado1("PASS");
                    } else if (cont == 5) {
                        //txt.setText(v[]);
                        cont++;
                        puntosF++;
                        mostrarDialogoPersonalizado1("PASS");

                    } else if (cont == 6) {

                        puntosF++;
                        txt.setText(v[6]);
                        cont++;
                        mostrarDialogoPersonalizado1("PASS");
                    } else if (cont == 7) {
                        puntosF++;

                        txt.setText(v[7]);
                        cont++;
                        mostrarDialogoPersonalizado1("PASS");
                    } else if (cont == 8) {
                        puntosF++;

                        txt.setText(v[8]);
                        cont++;
                        mostrarDialogoPersonalizado1("PASS");
                    } else if (cont == 9) {
                        puntosF++;

                        txt.setText(v[9]);
                        cont++;
                        mostrarDialogoPersonalizado1("PASS");
                    } else if (cont == 10) {
                        puntosF++;

                        //txt.setText(v[4]);
                        cont=1;
                        mostrarDialogoPersonalizado1("PASS");
                    }
                    h++;

                } else if (x < 3 && x > -3 && h == 1) {
                    //txt.setText("en el medio: "+ cont);
                    h++;
                }

                if (h == 2) {
                    h = 0;
                }
            }


            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        Start();


        System.out.println(puntosF);
        System.out.println(puntosT);
    }

    public void EmpezarJuego() {

        final ArrayList<Result>[] result;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://opentdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostServiceA postService = retrofit.create(PostServiceA.class);
        Call<PostA> call = postService.getPost();
        call.enqueue(new Callback<PostA>() {
            @Override
            public void onResponse(Call<PostA> call, Response<PostA>
                    response) {

                if (response.isSuccessful()) {
                    PostA p = response.body();
                    ArrayList<ResultA> list = (ArrayList<ResultA>) p.getResults();


                    for (int i = 0; i < list.size(); i++) {
                        ResultA r = list.get(i);
                        ResultA r1 = list.get(0);
                        ResultA r2 = list.get(1);
                        ResultA r3 = list.get(2);
                        ResultA r4 = list.get(3);
                        ResultA r5 = list.get(4);
                        ResultA r6 = list.get(5);
                        ResultA r7 = list.get(6);
                        ResultA r8 = list.get(7);
                        ResultA r9 = list.get(8);
                        ResultA r10 = list.get(9);

                        System.out.println(r.getCorrect_answer());

                        v1 = r1.getCorrect_answer();
                        v2 = r2.getCorrect_answer();
                        v3 = r3.getCorrect_answer();
                        v4 = r4.getCorrect_answer();
                        v5 = r5.getCorrect_answer();

                        v6 = r6.getCorrect_answer();
                        v7 = r7.getCorrect_answer();
                        v8 = r8.getCorrect_answer();
                        v9 = r9.getCorrect_answer();
                        v10 = r10.getCorrect_answer();

                    }
                    //txt.setText(v1);
                }

                // result[0] = new ArrayList<>(response.body().getResults());

            }

            @Override
            public void onFailure(Call<PostA> call, Throwable t) {
                txt.setText("fallo: " + t.getMessage());
            }
        });

    }


    private void mostrarDialogoPersonalizado() {
        AlertDialog.Builder builder = new AlertDialog.Builder(quizzA.this);

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.correcto, null);

        builder.setView(view);

        //TODO BOTONES POR DEFECTO

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
        AlertDialog.Builder builder = new AlertDialog.Builder(quizzA.this);

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.correcto, null);

        builder.setView(view);

        //TODO BOTONES POR DEFECTO


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
