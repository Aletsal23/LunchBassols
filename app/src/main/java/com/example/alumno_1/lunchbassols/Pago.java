package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pago extends AppCompatActivity {

    Button btnSalir;
    TextView txtCliente,txtAlimentos,txtCuenta,txtIva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);

        txtCliente=(TextView) findViewById(R.id.txtCliente);
        txtAlimentos=(TextView) findViewById(R.id.txtAlimentos);
        txtCuenta=(TextView) findViewById(R.id.txtCuenta);
        txtIva=(TextView) findViewById(R.id.txtIva);

        Intent revreg= getIntent();

        String cliente=revreg.getStringExtra("nombre");
        txtCliente.setText(cliente);



    }
}
