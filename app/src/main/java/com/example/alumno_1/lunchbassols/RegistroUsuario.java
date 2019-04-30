package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegistroUsuario extends AppCompatActivity {

    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        btnReg = (Button) findViewById(R.id.btnReg);

    }
    public void InicioSesion(View view)
    {

        Intent iniciosesion=new Intent(this, Inicio.class);
        startActivity(iniciosesion);
        Toast toast=Toast.makeText(this,"Se ha resgitrado exitosamente",Toast.LENGTH_LONG);
        toast.show();
    }
}
