package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroEmpleado extends AppCompatActivity {

    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empleado);

        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

    }
    public void MenuDrawer(View view)
    {
        Intent menudraw=new Intent(this, MenuDrawer.class);
        startActivity(menudraw);
    }
}
