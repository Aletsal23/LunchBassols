package com.example.alumno_1.lunchbassols;

import android.app.ProgressDialog;
import  android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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
    private FirebaseAuth mFireauth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empleado);

        mFireauth = FirebaseAuth.getInstance();

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

        progressDialog = new ProgressDialog(this);

        btnRegistrar.setOnClickListener(this);
    }

    private void registrar(){
        String email = txteCorreoInicio.getText().toString().trim();
        String pass = pswContraInicio.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un correo",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Se debe ingresar una contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        mFireauth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(RegistroEmpleado.this,"Se ha registrado el correo",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegistroEmpleado.this,"No se pudo registrar el correo",Toast.LENGTH_SHORT).show();
                }
         progressDialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View v) {
       registrar();
    }
}
