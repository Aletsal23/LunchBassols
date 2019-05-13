package com.example.alumno_1.lunchbassols;

import  android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class RegistroUsuario extends AppCompatActivity implements View.OnClickListener
{

    private Button btnReg;
    private EditText txteNom,txtnBoleta, txteEmail, pswPass, txteDir, txtnTel;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        mFirestore = FirebaseFirestore.getInstance();

        btnReg = (Button) findViewById(R.id.btnReg);
        txteNom = (EditText) findViewById(R.id.txteNom);
        txtnBoleta = (EditText) findViewById(R.id.txtnBoleta);
        txteEmail = (EditText) findViewById(R.id.txteEmail);
        pswPass = (EditText) findViewById(R.id.pswPass);
        txteDir = (EditText) findViewById(R.id.txteDir);
        txtnTel = (EditText) findViewById(R.id.txtnTel);

        btnReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String nombre = txteNom.getText().toString();
        String boleta = txtnBoleta.getText().toString();
        String email = txteEmail.getText().toString();
        String pass = pswPass.getText().toString();
        String dir = txteDir.getText().toString();
        String tel = txtnTel.getText().toString();
        Map<String, String> userMap = new HashMap<>();

        userMap.put("nombre",nombre);
        userMap.put("boleta", boleta);
        userMap.put("email", email);
        userMap.put("password", pass);
        userMap.put("direccion", dir);
        userMap.put("telefono", tel);

        mFirestore.collection("Usuarios").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(RegistroUsuario.this, "Usuario creado", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                String error = e.getMessage();

                Toast.makeText(RegistroUsuario.this,"Error : " + error, Toast.LENGTH_SHORT).show();

            }
        });
        Intent inicio=new Intent(this, Inicio.class);
        startActivity(inicio);
    }
}
