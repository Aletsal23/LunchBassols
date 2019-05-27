package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MenuInicio extends AppCompatActivity {

    ImageView imgCafeteria;
    AnimationDrawable animacion = new AnimationDrawable();
    ImageButton imgbComida,imgbBebidas,imgbSnacks,imgbTicket,imgbChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicio);

        imgCafeteria = (ImageView)findViewById(R.id.imgCafeteria);
        imgbComida = (ImageButton)findViewById(R.id.imgbComida);
        imgbBebidas = (ImageButton)findViewById(R.id.imgbBebidas);
        imgbSnacks = (ImageButton)findViewById(R.id.imgbSnacks);
        imgbChat = (ImageButton)findViewById(R.id.imgbChat);
    }
    public void comida(View view){
        Intent comida = new Intent (this,Acomida.class);
        startActivity(comida);
    }

    public void bebidas(View view){
        Intent bebidas = new Intent (this,Abebidas.class);
        startActivity(bebidas);
    }
    public void snacks(View view){
        Intent snacks = new Intent (this,Asnacks.class);
        startActivity(snacks);
    }
    public void chat(View view){
        Intent chat = new Intent (this,Compra.class);
        startActivity(chat);
    }
}
