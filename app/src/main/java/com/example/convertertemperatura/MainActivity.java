package com.example.convertertemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtCelsius;
    Button btnConverter;
    TextView txtMensagem ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCelsius = (EditText)findViewById(R.id.edtCelsius);
        btnConverter = (Button)findViewById(R.id.btnConverter);
        txtMensagem = (TextView) findViewById(R.id.txtMensagem);

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtCelsius.getText().toString().equals("")){
                    txtMensagem.setText("DIGITE A TEMPERATURA");
                }
                else {
                    txtMensagem.setText("");
                    Double celsius = Double.parseDouble(edtCelsius.getText().toString()) ;

                    Intent intent = new Intent(MainActivity.this,ResultadoActivity.class);
                    Bundle params = new Bundle();

                    params.putDouble("temperatura",celsius);
                    intent.putExtras(params);

                    startActivity(intent);
                }


            }
        });


    }
}
