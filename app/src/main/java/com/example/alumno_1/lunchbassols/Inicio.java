package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    Button btnInicio, btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnInicio= (Button) findViewById(R.id.btnInicio);
        btnRegistro=(Button) findViewById(R.id.btnRegistro);



    }

    public void InicioSesion(View view)
    {
        Intent inicio=new Intent(this, InicioSesion.class);
        startActivity(inicio);
    }
    public void Registro(View view)
    {
        Intent registro=new Intent(this, Registro.class);
        startActivity(registro);
    }
}
