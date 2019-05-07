package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class InicioSesion extends AppCompatActivity {

    EditText txteCorreoInicioSes, pswContraInicioses;
    Button btnEntrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        txteCorreoInicioSes = (EditText) findViewById(R.id.txteCorreoInicioSes);
        pswContraInicioses = (EditText) findViewById(R.id.pswContraInicioses);




        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String correoinicio =txteCorreoInicioSes.getText().toString();
                final String pswinicio =pswContraInicioses.getText().toString();

                Response.Listener<String> responseListener= new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success= jsonResponse.getBoolean("success");

                                if (success)
                                {
                                    String nombre=jsonResponse.getString("nombre");
                                    int boleta=jsonResponse.getInt("boleta");
                                    String direccion=jsonResponse.getString("direccion");
                                    String telefono=jsonResponse.getString("telefono");

                                    Intent envreg= new Intent(InicioSesion.this, Pago.class);
                                    envreg.putExtra("nombre",nombre);
                                    envreg.putExtra("boleta",boleta);
                                    envreg.putExtra("correo",correoinicio);
                                    envreg.putExtra("password",pswinicio);
                                    envreg.putExtra("direccion",direccion);
                                    envreg.putExtra("telefono",telefono);

                                    startActivity(envreg);
                                }
                                else
                                {
                                    AlertDialog.Builder msgError= new AlertDialog.Builder(InicioSesion.this);
                                    msgError.setMessage("Error en el Login")
                                            .setNegativeButton("Retry",null)
                                            .create().show();
                                }
                            } catch (JSONException e)
                            {
                                e.printStackTrace();
                            }
                    }
                };

                LoginRequest loginRequest= new LoginRequest(correoinicio, pswinicio,responseListener);

                RequestQueue queue = Volley.newRequestQueue(InicioSesion.this);
                queue.add(loginRequest);

            }
        });
    }
    }
