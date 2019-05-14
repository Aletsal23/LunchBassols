package com.example.alumno_1.lunchbassols;

import android.app.ProgressDialog;
import  android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Index extends AppCompatActivity implements View.OnClickListener
{

    private Button btnRegistro,btnInicioSes;
    private EditText txteCorreo,pswContraseña;
    private FirebaseFirestore mFirestore;
    private FirebaseAuth mFireauth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        mFirestore = FirebaseFirestore.getInstance();
        mFireauth = FirebaseAuth.getInstance();

        btnRegistro = (Button) findViewById(R.id.btnRegistro);
        btnInicioSes = (Button)findViewById(R.id.btnInicioSes);
        txteCorreo = (EditText)findViewById(R.id.txteCorreo);
        pswContraseña = (EditText) findViewById(R.id.pswContraseña);


        progressDialog = new ProgressDialog(this);

        btnRegistro.setOnClickListener(this);
        btnInicioSes.setOnClickListener(this);
    }

    private void registrar(){
        String email = txteCorreo.getText().toString().trim();
        String pass = pswContraseña.getText().toString().trim();

        if(TextUtils.isEmpty(email)){//(precio.equals(""))
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
                    Toast.makeText(Index.this,"Se ha registrado el correo",Toast.LENGTH_SHORT).show();
                    Intent datos = new Intent(Index.this,DatosPersonales.class);
                    startActivity(datos);
                }else{
                    if(task.getException()instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(Index.this,"Ese correo ha sido registrado",Toast.LENGTH_SHORT).show();}
                    else{
                        Toast.makeText(Index.this,"No se pudo registrar el correo",Toast.LENGTH_SHORT).show();
                    }
                }
                progressDialog.dismiss();
            }
        });
    }

    public void login(){
        final String email = txteCorreo.getText().toString().trim();
        String pass = pswContraseña.getText().toString().trim();

        if(TextUtils.isEmpty(email)){//(precio.equals(""))
            Toast.makeText(Index.this,"Se debe ingresar un correo",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(pass)){
            Toast.makeText(Index.this,"Se debe ingresar una contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Realizando consulta en linea...");
        progressDialog.show();

        mFireauth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    int pos = email.indexOf("@");
                    String user = email.substring(0, pos);
                    Toast.makeText(Index.this,"Bienvenido: " + txteCorreo.getText(),Toast.LENGTH_SHORT).show();
                    Intent intencion = new Intent (getApplication(),MenuDrawer.class);
                    intencion.putExtra(MenuDrawer.user, email);
                    startActivity(intencion);
                }else{
                    if(task.getException()instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(Index.this,"Ese correo ha sido registrado",Toast.LENGTH_SHORT).show();}
                    else{
                        Toast.makeText(Index.this,"No se pudo registrar el correo",Toast.LENGTH_SHORT).show();
                    }
                }
                progressDialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId()){
            case R.id.btnRegistro:
                registrar();
                break;
            case R.id.btnInicioSes:
                login();
                break;
        }
    }
}
