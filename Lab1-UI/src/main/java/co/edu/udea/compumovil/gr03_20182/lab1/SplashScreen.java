package co.edu.udea.compumovil.gr03_20182.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;
import android.app.*;
import android.content.*;
import android.widget.*;

public class SplashScreen extends Activity {
    private Timer tiempo;
    private ProgressBar barraProgreso;
    private int i=0;
    Button bottomidiom;


    bottomidiom=(Button)findViewById(R.id.buttomIdioma);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        barraProgreso = (ProgressBar) findViewById(R.id.barraProgreso);
        barraProgreso.setProgress(0);
        final long intervalo = 45;
        tiempo = new Timer();
        tiempo.schedule(new TimerTask() {
            @Override
            public void run() {
                if(i < 100){
                    barraProgreso.setProgress(i);
                    i++;
                }else{
                    tiempo.cancel();
                    Intent intent = new Intent().setClass(
                            SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },0,intervalo);

    }
}
