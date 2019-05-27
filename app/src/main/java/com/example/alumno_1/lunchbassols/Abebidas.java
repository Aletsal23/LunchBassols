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

public class Abebidas extends AppCompatActivity {

    Spinner spnBebidas;
    ListView lstBebidas;
    ImageView imgBebidas;
    Button btnTicketb;
    String bebi;
    int pagobebi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abebidas);

        spnBebidas = (Spinner) findViewById(R.id.spnBebidas);
        lstBebidas = (ListView) findViewById(R.id.lstBebidas);
        imgBebidas = (ImageView) findViewById(R.id.imgBebidas);
        btnTicketb = (Button) findViewById(R.id.btnTicketb);

        ArrayAdapter Bebidas = ArrayAdapter.createFromResource(Abebidas.this, R.array.Bebidas,
                android.R.layout.simple_spinner_item);
        spnBebidas.setAdapter(Bebidas);

        spnBebidas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int position, long id)
            {
                if(lista.getItemAtPosition(position).equals("Refrescos"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(Abebidas.this, R.array.Refrescos, android.R.layout.simple_gallery_item);
                    lstBebidas.setAdapter(listacomida);
                    imgBebidas.setImageResource(R.drawable.refrescos);
                    refresco();
                }
                if(lista.getItemAtPosition(position).equals("Licuados"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(Abebidas.this, R.array.Licuados, android.R.layout.simple_gallery_item);
                    lstBebidas.setAdapter(listacomida);
                    imgBebidas.setImageResource(R.drawable.licuados);
                    licuados();
                }
                if(lista.getItemAtPosition(position).equals("Jugos"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(Abebidas.this, R.array.Jugos, android.R.layout.simple_gallery_item);
                    lstBebidas.setAdapter(listacomida);
                    imgBebidas.setImageResource(R.drawable.jugos);
                    jugos();
                }
                if(lista.getItemAtPosition(position).equals("Agua"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(Abebidas.this, R.array.Agua, android.R.layout.simple_gallery_item);
                    lstBebidas.setAdapter(listacomida);
                    imgBebidas.setImageResource(R.drawable.aguas);
                    agua();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> lista) {
            }
        });

        btnTicketb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent envio= new Intent (v.getContext(), tick.class);
                envio.putExtra("Bebida",bebi);
                envio.putExtra("PagoBebida",pagobebi);
                startActivity(envio);
            }
        });
    }
    public void refresco()
    {
        lstBebidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgBebidas.setImageResource(R.drawable.coca);
                        bebi="Coca-Cola";
                        pagobebi=10;
                        break;
                    case 1: imgBebidas.setImageResource(R.drawable.pepsi);
                        bebi="Pepsi";
                        pagobebi=10;
                        break;
                    case 2: imgBebidas.setImageResource(R.drawable.mirinda);
                        bebi="Mirinda";
                        pagobebi=10;
                        break;
                    case 3: imgBebidas.setImageResource(R.drawable.jarrito);
                        bebi="Jarrito";
                        pagobebi=10;
                        break;
                    case 4: imgBebidas.setImageResource(R.drawable.pepper);
                        bebi="Dr. Pepper";
                        pagobebi=10;
                        break;
                }

            }
        });
    }
    public void licuados()
    {
        lstBebidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgBebidas.setImageResource(R.drawable.fresa);
                        bebi="Licuado Fresa";
                        pagobebi=15;
                        break;
                    case 1: imgBebidas.setImageResource(R.drawable.platano);
                        bebi="Licuado Platano";
                        pagobebi=15;
                        break;
                    case 2: imgBebidas.setImageResource(R.drawable.chocolate);
                        bebi="Licuado Chocolate";
                        pagobebi=15;
                        break;
                    case 3: imgBebidas.setImageResource(R.drawable.mamey);
                        bebi="Licuado Mamey";
                        pagobebi=15;
                        break;
                    case 4: imgBebidas.setImageResource(R.drawable.avena);
                        bebi="Licuado Avena";
                        pagobebi=15;
                        break;
                }

            }
        });
    }
    public void jugos()
    {
        lstBebidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgBebidas.setImageResource(R.drawable.naranja);
                        bebi="Jugo Naranja";
                        pagobebi=12;
                        break;
                    case 1: imgBebidas.setImageResource(R.drawable.toronja);
                        bebi="Jugo Toronja";
                        pagobebi=12;
                        break;
                    case 2: imgBebidas.setImageResource(R.drawable.zanahoria);
                        bebi="Jugo Zanahoria";
                        pagobebi=12;
                        break;
                    case 3: imgBebidas.setImageResource(R.drawable.mandarina);
                        bebi="Jugo Mandarina";
                        pagobebi=12;
                        break;
                }

            }
        });
    }
    public void agua()
    {
        lstBebidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgBebidas.setImageResource(R.drawable.aguan);
                        bebi="Agua Natural";
                        pagobebi=10;
                        break;
                    case 1: imgBebidas.setImageResource(R.drawable.limon);
                        bebi="Agua Limon";
                        pagobebi=15;
                        break;
                    case 2: imgBebidas.setImageResource(R.drawable.moras);
                        bebi="Agua Moras";
                        pagobebi=15;
                        break;
                    case 3: imgBebidas.setImageResource(R.drawable.horchata);
                        bebi="Agua Horchata";
                        pagobebi=15;
                        break;
                    case 4: imgBebidas.setImageResource(R.drawable.aguafresa);
                        bebi="Agua Fresa";
                        pagobebi=15;
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
