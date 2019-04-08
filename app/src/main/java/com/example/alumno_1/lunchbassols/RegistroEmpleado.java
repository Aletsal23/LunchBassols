package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegistroEmpleado extends AppCompatActivity {

    EditText txteNombre, txteCorreo, txteDireccion, txtnEdad, txtnTelefono, pswContra;
    RadioGroup rdbgPuestos;
    RadioButton rdbCajero, rdbCocinero;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empleado);

        txteNombre= (EditText) findViewById(R.id.txteNombre);
        txteCorreo= (EditText) findViewById(R.id.txteCorreo);
        txteDireccion= (EditText) findViewById(R.id.txteDireccion);
        txtnEdad= (EditText) findViewById(R.id.txtnEdad);
        txtnTelefono= (EditText) findViewById(R.id.txtnTelefono);
        pswContra= (EditText) findViewById(R.id.pswContra);
        rdbgPuestos=(RadioGroup) findViewById(R.id.rdbgPuestos);
        rdbCajero=(RadioButton) findViewById(R.id.rdbCajero);
        rdbCocinero=(RadioButton) findViewById(R.id.rdbCocinero);
        btnRegistrar=(Button) findViewById(R.id.btnRegistrar);


    }
    public void entrar(View view)
    {
        Intent inicio=new Intent(this, MenuDrawer.class);
        startActivity(inicio);
    }
}
