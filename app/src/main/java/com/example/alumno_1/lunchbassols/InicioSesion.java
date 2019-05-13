package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.json.JSONException;
import org.json.JSONObject;

public class InicioSesion extends AppCompatActivity {

    private EditText txteCorreoInicioSes, pswContraInicioses;
    private Button btnEntrar;
    private FirebaseFirestore mFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        mFirestore = FirebaseFirestore.getInstance();

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        txteCorreoInicioSes = (EditText) findViewById(R.id.txteCorreoInicioSes);
        pswContraInicioses = (EditText) findViewById(R.id.pswContraInicioses);

         btnEntrar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Query email = mFirestore.collection("Usuarios").whereEqualTo("email", true);

                 Query pass = mFirestore.collection("Usuarios").whereEqualTo("password", true);

                 if(txteCorreoInicioSes.equals(email) && pswContraInicioses.equals(pass)){
                     Intent menudrawer=new Intent(InicioSesion.this, MenuDrawer.class);
                     startActivity(menudrawer);
                 }
                 else{
                     Toast.makeText(InicioSesion.this,"Error : Usuario/Contraseña incorrectos" , Toast.LENGTH_SHORT).show();
                     txteCorreoInicioSes.setText("");
                     pswContraInicioses.setText("");
                 }
             }
         });
    }
    }
