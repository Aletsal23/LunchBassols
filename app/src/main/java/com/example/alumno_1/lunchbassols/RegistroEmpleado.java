package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegistroEmpleado extends AppCompatActivity {

    EditText txteNombre,txteCorreoInicio,pswContraInicio,txteDireccion,txtnEdad,txtnTelefono;
    RadioGroup rdbgPuestos;
    RadioButton rdbCajero, rdbCocinero;
    Button btnRegistrar;
    String nom,correo,contra,puesto,direccion,edad,telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empleado);

        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        txteNombre = (EditText) findViewById(R.id.txteNombre);
        txteCorreoInicio = (EditText) findViewById(R.id.txteCorreoInicio);
        pswContraInicio = (EditText) findViewById(R.id.pswContraInicio);
        txteDireccion = (EditText) findViewById(R.id.txteDireccion);
        txtnEdad = (EditText) findViewById(R.id.txtnEdad);
        txtnTelefono = (EditText) findViewById(R.id.txtnTelefono);

        rdbgPuestos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.rdbCajero: puesto="Cajero";
                    case R.id.rdbCocinero: puesto="Cocinero";
                }
            }
        });

    }
    public void InisioSesion(View view)
    {

        Intent enviodatos= new Intent(view.getContext(), InicioSesion.class);
        enviodatos.putExtra("Nombre", txteNombre.getText().toString());
        enviodatos.putExtra("Correo", txteCorreoInicio.getText().toString());
        enviodatos.putExtra("Contraseña", pswContraInicio.getText().toString());
        enviodatos.putExtra("Puesto", puesto);
        enviodatos.putExtra("Dirección", txteDireccion.getText().toString());
        enviodatos.putExtra("Edad", txtnEdad.getText().toString());
        enviodatos.putExtra("Telefono", txtnTelefono.getText().toString());
        startActivity(enviodatos);
        Intent iniciosesion=new Intent(this, InicioSesion.class);
        startActivity(iniciosesion);
        Toast toast=Toast.makeText(this,"Se ha resgitrado exitosamente",Toast.LENGTH_LONG);
        toast.show();

    }
}
