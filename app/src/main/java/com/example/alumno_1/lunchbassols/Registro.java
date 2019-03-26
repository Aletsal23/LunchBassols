package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Registro extends AppCompatActivity {

    ImageButton imgbEmpleado, imgbCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        imgbEmpleado= (ImageButton) findViewById(R.id.imgbEmpleado);
        imgbCliente= (ImageButton) findViewById(R.id.imgbCliente);
    }
    public void Empleado(View view)
    {
        Intent empleado=new Intent(this, RegistroEmpleado.class);
        startActivity(empleado);
    }
    public void Cliente(View view)
    {
        Intent cliente=new Intent(this, RegistroUsuario.class);
        startActivity(cliente);
    }
}
