package com.example.alumno_1.lunchbassols;

import  android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistroEmpleado extends AppCompatActivity implements View.OnClickListener {

    private EditText txteNombre,txteCorreoInicio,pswContraInicio,txteDireccion,txtnEdad,txtnTelefono;
    private RadioGroup rdbgPuestos;
    private RadioButton rdbCajero, rdbCocinero;
    private Button btnRegistrar;
    private String puesto;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empleado);

        mFirestore = FirebaseFirestore.getInstance();

        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        txteNombre = (EditText) findViewById(R.id.txteNombre);
        txteCorreoInicio = (EditText) findViewById(R.id.txteCorreoInicioSes);
        pswContraInicio = (EditText) findViewById(R.id.pswContraInicioses);
        txteDireccion = (EditText) findViewById(R.id.txteDireccion);
        txtnEdad = (EditText) findViewById(R.id.txtnEdad);
        txtnTelefono = (EditText) findViewById(R.id.txtnTelefono);
        rdbCajero = (RadioButton) findViewById(R.id.rdbCajero);
        rdbCocinero = (RadioButton) findViewById(R.id.rdbCocinero);
        rdbgPuestos = (RadioGroup) findViewById(R.id.rdbgPuestos);

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

        btnRegistrar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String nombre = txteNombre.getText().toString();
        String email = txteCorreoInicio.getText().toString();
        String pass = pswContraInicio.getText().toString();
        String dir = txteDireccion.getText().toString();
        String edad = txtnEdad.getText().toString();
        String tel = txtnTelefono.getText().toString();
        Map<String, String> userMap = new HashMap<>();

        userMap.put("nombre",nombre);
        userMap.put("email", email);
        userMap.put("password", pass);
        userMap.put("direccion", dir);
        userMap.put("edad", edad);
        userMap.put("telefono", tel);
        userMap.put("puesto", puesto);

        mFirestore.collection("Usuarios").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(RegistroEmpleado.this, "Usuario creado", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                String error = e.getMessage();

                Toast.makeText(RegistroEmpleado.this,"Error : " + error, Toast.LENGTH_SHORT).show();

            }
        });
        Intent inicio=new Intent(this, Inicio.class);
        startActivity(inicio);
    }
}
