package com.example.danielfigueroa_semana04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PantallaCActivity extends AppCompatActivity {

    private TextView ConexionesC;
    private Button RegresarC;
    private InetAddress hosts;
    private int contador;
    private String direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_c);

        ConexionesC = findViewById(R.id.ConexionesC);
        RegresarC = findViewById(R.id.RegresarC);


        new Thread ( //
                ()->{

                    try {

                        for (int i =1; i <255;i++){

                            contador +=1; //hace que contador suba
                            direccion = String.valueOf(contador); //convierte contador de int a un string
                        hosts = InetAddress.getByName("192.168.10."+direccion); //me habia faltado poner la variable que se suma en este caso contador


                        boolean conectado = hosts.isReachable(2000);

                        if (conectado == true) {
                            runOnUiThread(
                                    () -> {
                                        ConexionesC.setText(ConexionesC.getText().getClass() + "Conectado\n" + hosts + "\n");
                                    }
                            );

                        } else {
                            runOnUiThread(
                                    () -> {
                                        ConexionesC.setText(ConexionesC.getText().getClass() + "Perdida\n" + hosts + "\n");
                                    }
                            );
                        }
                        Thread.sleep(2000); //que lo haga cada 2 segundos
                    }



                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();

        RegresarC.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                }
        );
    }
}