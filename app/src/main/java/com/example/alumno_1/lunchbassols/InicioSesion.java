package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InicioSesion extends AppCompatActivity {

    EditText txteCorreoInicioSes, pswContraInicioses;
    Button btnEntrar;
    String correoinicio,pswinicio,nom,correo,contra,pues,direccion,edad,telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        txteCorreoInicioSes = (EditText) findViewById(R.id.txteCorreoInicioSes);
        pswContraInicioses = (EditText) findViewById(R.id.pswContraInicioses);

        correoinicio=txteCorreoInicioSes.getText().toString();
        pswinicio=pswContraInicioses.getText().toString();

        Bundle recibirdatos= getIntent().getExtras();
        nom=recibirdatos.getString("Nombre");
        correo=recibirdatos.getString("Correo");
        contra=recibirdatos.getString("Contraseña");
        pues=recibirdatos.getString("Puesto");
        direccion=recibirdatos.getString("Direccion");
        edad=recibirdatos.getString("Edad");
        telefono=recibirdatos.getString("Telefono");
        if(correoinicio.equals(correo)&&pswinicio.equals(contra))
        {
            Intent menudraw = new Intent(this, MenuDrawer.class);
            startActivity(menudraw);
        }
    }
    }
