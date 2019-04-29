package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroUsuario extends AppCompatActivity {

    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        btnReg = (Button) findViewById(R.id.btnReg);

    }
    public void MenuDrawer(View view)
    {
        Intent menudraw=new Intent(this, MenuDrawer.class);
        startActivity(menudraw);
    }
}
