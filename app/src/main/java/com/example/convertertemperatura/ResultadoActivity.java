package com.example.convertertemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;


public class ResultadoActivity extends AppCompatActivity {

    TextView txtFahrenheit ;
    TextView txtKelvin ;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        double valor = params.getDouble("temperatura");

        txtFahrenheit = (TextView) findViewById(R.id.txtResultadoFahrenheit);
        txtKelvin = (TextView) findViewById(R.id.txtResultadoKelvin);
        voltar = (Button) findViewById(R.id.voltar);

        double valor1 = (valor*1.8) + 32;
        double valor2 = valor + 273.15;
        DecimalFormat formatador = new DecimalFormat("0.00");


        txtFahrenheit.setText(""+formatador.format(valor1)+" °F");
        txtKelvin.setText(""+formatador.format(valor2)+" K");

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
