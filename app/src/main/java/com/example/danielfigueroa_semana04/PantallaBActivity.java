package com.example.danielfigueroa_semana04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PantallaBActivity extends AppCompatActivity {

    private TextView ConexionesB;
    private Button RegresarB;
    private InetAddress inet;
    private int loops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_b);

        /*String bloque1 = getIntent().getExtras().getString("1");
        String bloque2 = getIntent().getExtras().getString("2");
        String bloque3 = getIntent().getExtras().getString("3");
        String bloque4 = getIntent().getExtras().getString("4");*/
        String bloques = getIntent().getExtras().getString("ip");
        //Log.e("ip","%"+bloques+"%");
        ConexionesB = findViewById(R.id.ConexionesB);
        RegresarB = findViewById(R.id.RegresarB);

        loops = 0;

        new Thread ( //
                ()->{
                    try {
                        while(loops < 10){


                        inet = InetAddress.getByName(bloques);


                        boolean conectado = inet.isReachable(2000);

                        if(conectado == true){
                            runOnUiThread(
                                    ()-> {
                                        ConexionesB.setText(ConexionesB.getText().toString()+"Conectado\n"+bloques+"\n");
                                    }
                            );

                        }else{
                            runOnUiThread(
                                    ()-> {
                                        ConexionesB.setText(ConexionesB.getText().toString() + "Perdida\n"+bloques+"\n");
                                    }
                            );
                        }
                        Thread.sleep(2000); //que lo haga cada 2 segundos
                            loops++;
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
        //repeticion, ponerle los permisos de internet.  permiso de internet android studio



        /*ConexionesB.setText(bloque1+"."+bloque2+"."+bloque3+"."+bloque4);
        ConexionesB.setText(bloques);*/
        RegresarB.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                }
        );
    }
}