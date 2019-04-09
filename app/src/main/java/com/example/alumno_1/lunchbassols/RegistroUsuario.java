package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroUsuario extends AppCompatActivity {

    EditText txteNom,txtnBoleta,txteEmail,pswPass,txteDir,txtnTel;
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        txteNom=(EditText) findViewById(R.id.txteNom);
        txtnBoleta=(EditText) findViewById(R.id.txteEmail);
        txteEmail=(EditText) findViewById(R.id.txteEmail);
        pswPass=(EditText) findViewById(R.id.pswPass);
        txteDir=(EditText) findViewById(R.id.txteDir);
        txtnTel=(EditText) findViewById(R.id.txtnTel);
        btnReg=(Button) findViewById(R.id.btnReg);


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menudrawer= new Intent(v.getContext(),MenuDrawer.class);
                startActivity(menudrawer);
            }
        });
    }
}
