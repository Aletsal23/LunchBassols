package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Activity_transicion extends AppCompatActivity {

    ImageButton btnCarta,btnChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transicion);

        btnCarta = (ImageButton)findViewById(R.id.btnCarta);
        btnChat = (ImageButton)findViewById(R.id.imgbChat);

        btnCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Activity_transicion.this, MenuInicio.class);
                startActivity(menu);
            }
        });

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chat = new Intent(Activity_transicion.this, Compra.class);
                startActivity(chat);
            }
        });
    }
}
