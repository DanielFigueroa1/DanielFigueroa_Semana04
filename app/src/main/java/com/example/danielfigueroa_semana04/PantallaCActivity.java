package com.example.danielfigueroa_semana04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PantallaCActivity extends AppCompatActivity {

    private TextView ConexionesC;
    private Button RegresarC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_c);

        ConexionesC = findViewById(R.id.ConexionesC);
        RegresarC = findViewById(R.id.RegresarC);

        RegresarC.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                }
        );
    }
}