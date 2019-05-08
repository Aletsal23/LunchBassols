package com.example.alumno_1.lunchbassols;

import  android.content.Intent;
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

import org.json.JSONException;
import org.json.JSONObject;

public class RegistroUsuario extends AppCompatActivity implements View.OnClickListener
{

    Button btnReg;
    EditText txteNom,txtnBoleta, txteEmail, pswPass, txteDir, txtnTel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);


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
        final String nombre= txteNom.getText().toString();
        final int boleta= Integer.parseInt(txtnBoleta.getText().toString());
        final String correo= txteEmail.getText().toString();
        final String password= pswPass.getText().toString();
        final String direccion= txteDir.getText().toString();
        final int telefono=Integer.parseInt(txtnTel.getText().toString());


        Response.Listener<String> respoListener= new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                    try
                    { JSONObject jsonResponse= new JSONObject(response);
                     boolean success = jsonResponse.getBoolean("success");
                     if (success)
                     {
                         Intent regini = new Intent(RegistroUsuario.this,InicioSesion.class);
                         startActivity(regini);
                     }
                     else
                     {
                         AlertDialog.Builder msgError = new AlertDialog.Builder(RegistroUsuario.this);
                         msgError.setMessage("Error en el registro")
                                 .setNegativeButton("Retry",null)
                                 .create().show();
                     }
                    } catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }

        };

        RegisterRequest registro = new RegisterRequest(nombre,boleta,correo,password,direccion,telefono,respoListener);
        RequestQueue queue = Volley.newRequestQueue(RegistroUsuario.this);
        queue.add(registro);

    }
}
