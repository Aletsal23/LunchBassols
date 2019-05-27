package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

public class Acomida extends AppCompatActivity {

    Spinner spnCom;
    ListView lstCom;
    ImageView imgCom;
    Button btnTicketcom;
    String comi;
    int pagocomi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acomida);

        spnCom = (Spinner) findViewById(R.id.spnCom);
        lstCom = (ListView) findViewById(R.id.lstCom);
        imgCom = (ImageView) findViewById(R.id.imgCom);
        btnTicketcom = (Button) findViewById(R.id.btnTicketcom);

        ArrayAdapter com = ArrayAdapter.createFromResource(Acomida.this, R.array.Comida,
                android.R.layout.simple_spinner_item);
        spnCom.setAdapter(com);

        spnCom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int position, long id)
            {
                if(lista.getItemAtPosition(position).equals("Chilaquiles"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(Acomida.this, R.array.Chilaquiles, android.R.layout.simple_gallery_item);
                    lstCom.setAdapter(listacomida);
                    imgCom.setImageResource(R.drawable.chilaquiles);
                    chilaq();
                }
                if(lista.getItemAtPosition(position).equals("Hamburguesa"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(Acomida.this, R.array.Hamburguesa, android.R.layout.simple_gallery_item);
                    lstCom.setAdapter(listacomida);
                    imgCom.setImageResource(R.drawable.hamburguesa);
                    hamb();
                }
                if(lista.getItemAtPosition(position).equals("Huevos"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(Acomida.this, R.array.Huevos, android.R.layout.simple_gallery_item);
                    lstCom.setAdapter(listacomida);
                    imgCom.setImageResource(R.drawable.huevos);
                    huevos();
                }
                if(lista.getItemAtPosition(position).equals("Torta"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(Acomida.this, R.array.Torta, android.R.layout.simple_gallery_item);
                    lstCom.setAdapter(listacomida);
                    imgCom.setImageResource(R.drawable.torta);
                    torta();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> lista) {
            }
        });

        btnTicketcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent envio= new Intent (Acomida.this, tick.class);
                envio.putExtra("Comida",comi);
                envio.putExtra("PagoComida",pagocomi);
                startActivity(envio);
            }
        });
    }
    public void chilaq()
    {
        lstCom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgCom.setImageResource(R.drawable.chilaquilesverdes);
                        comi="Chilaquiles Verdes";
                        pagocomi=25;
                        break;
                    case 1: imgCom.setImageResource(R.drawable.chilaquilesrojos);
                        comi="Chilaquiles Rojos";
                        pagocomi=25;
                        break;
                }

            }
        });
    }
    public void hamb()
    {
        lstCom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgCom.setImageResource(R.drawable.sencilla);
                        comi="Hamburguesa Sencilla";
                        pagocomi=20;
                        break;
                    case 1: imgCom.setImageResource(R.drawable.doble);
                        comi="Hambuerguesa Doble";
                        pagocomi=25;
                        break;
                    case 2: imgCom.setImageResource(R.drawable.hawaiana);
                        comi="Hamburguesa Hawaiana";
                        pagocomi=28;
                        break;
                    case 3: imgCom.setImageResource(R.drawable.queso);
                        comi="Hamburguesa Queso";
                        pagocomi=22;
                        break;
                }

            }
        });
    }
    public void huevos()
    {
        lstCom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgCom.setImageResource(R.drawable.estrella);
                        comi="Huevos Estrellados";
                        pagocomi=25;
                        break;
                    case 1: imgCom.setImageResource(R.drawable.revuelto);
                        comi="Huevos Revueltos";
                        pagocomi=25;
                        break;
                    case 2: imgCom.setImageResource(R.drawable.rancheros);
                        comi="Huevos Rancheros";
                        pagocomi=25;
                        break;
                }

            }
        });
    }
    public void torta()
    {
        lstCom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgCom.setImageResource(R.drawable.jamon);
                        comi="Torta Jamon";
                        pagocomi=15;
                        break;
                    case 1: imgCom.setImageResource(R.drawable.salchicha);
                        comi="Torta Salchicha";
                        pagocomi=15;
                        break;
                    case 2: imgCom.setImageResource(R.drawable.pierna);
                        comi="Torta Pierna";
                        pagocomi=15;
                        break;
                    case 3: imgCom.setImageResource(R.drawable.huevos);
                        comi="Torta Huevo";
                        pagocomi=15;
                        break;
                }

            }
        });
    }
    public void inicio(View view){
        Intent inicio = new Intent (this,MenuInicio.class);
        startActivity(inicio);
    }
}
