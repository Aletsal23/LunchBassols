package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicioSesion extends AppCompatActivity {

    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);

    }

        public void MenuDrawer(View view)
        {
            Intent menudraw=new Intent(this, MenuDrawer.class);
            startActivity(menudraw);
        }
    }
