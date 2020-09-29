package com.example.ejerhilosnumeroascendentedescendente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText entrada;
    private TextView acendente;
    private TextView descendente;
    private TextView ambos;
    private Button btnEjecutar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = findViewById(R.id.etNumero);
        acendente = findViewById(R.id.tvAscendente);
        descendente = findViewById(R.id.tvDescendente);
        ambos = findViewById(R.id.tvAmbos);
        btnEjecutar = findViewById(R.id.butEjecutar);

        btnEjecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(entrada.getText().toString());
                MiThread miThread = new MiThread(numero);
                miThread.start();

                MiThread2 miThread2 = new MiThread2(numero);
                miThread2.start();



            }
        });

    }

    public void ascendete(int num) {

        for (int i = 1; i<=num; i++){
            int valorDado = (int) Math.floor(Math.random()*600+1);


            acendente.append(i+", ");
            ambos.append(i+",");
            SystemClock.sleep(valorDado);
            System.out.println("Ascendente: "+i);
        }

    }

    public void descendente(int num){


        for (int i = num; i>=1; i--){
            descendente.append(i+", ");
            ambos.append(i+",");
            int valorDado = (int) Math.floor(Math.random()*234+1);
            SystemClock.sleep(valorDado);
            System.out.println("Descendente: "+i);

        }

    }

    public  class  MiThread extends Thread{
        private int num;


        public MiThread (int num) {
            this.num = num;
        }

        @Override
        public  void run(){

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ascendete(num);
                }
            });

        }
    }
     public  class  MiThread2 extends Thread{
        private int num2;


        public MiThread2 (int num) {
            this.num2 = num;
        }

        @Override
        public  void run(){

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    descendente(num2);
                }
            });

        }
    }
}