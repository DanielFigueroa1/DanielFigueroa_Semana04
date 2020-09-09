package com.example.danielfigueroa_semana04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Bloque1;
    private EditText Bloque2;
    private EditText Bloque3;
    private EditText Bloque4;
    private Button Ping;
    private Button BuscarHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bloque1 = findViewById(R.id.Bloque1);
        Bloque2 = findViewById(R.id.Bloque2);
        Bloque3 = findViewById(R.id.Bloque3);
        Bloque4 = findViewById(R.id.Bloque4);
        Ping = findViewById(R.id.Ping);
        BuscarHost = findViewById(R.id.RegresarB);


        Ping.setOnClickListener(
                (v)->{
                    /*String bloque1 = Bloque1.getText().toString();
                    String bloque2 = Bloque2.getText().toString();
                    String bloque3 = Bloque3.getText().toString();
                    String bloque4 = Bloque4.getText().toString();*/
                    String bloques = Bloque1.getText().toString()+"."+Bloque2.getText().toString()+"."+Bloque3.getText().toString()+"."+Bloque4.getText().toString();

                    Intent i = new Intent(this, PantallaBActivity.class);
                    /*i.putExtra("1",bloque1);
                    i.putExtra("2",bloque2);
                    i.putExtra("3",bloque3);
                    i.putExtra("4",bloque4);*/
                    i.putExtra("ip",bloques);
                    startActivity(i);

                }
        );

        BuscarHost.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, PantallaCActivity.class);
                    startActivity(i);
                }
        );
    }


}
