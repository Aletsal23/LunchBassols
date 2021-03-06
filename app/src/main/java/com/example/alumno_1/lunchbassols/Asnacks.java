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

public class Asnacks extends AppCompatActivity {

    Button btnTickets;
    Spinner spnSnacks;
    ListView lstSnacks;
    ImageView imgSnacks;
    String snack;
    int pagosnack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asnacks);

        btnTickets = (Button)findViewById(R.id.btnTickets);
        spnSnacks = (Spinner)findViewById(R.id.spnSnacks);
        lstSnacks = (ListView)findViewById(R.id.lstSnacks);
        imgSnacks = (ImageView)findViewById(R.id.imgSnacks);

        ArrayAdapter Snacks = ArrayAdapter.createFromResource(Asnacks.this, R.array.Snacks,
                android.R.layout.simple_spinner_item);
        spnSnacks.setAdapter(Snacks);

        spnSnacks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int position, long id)
            {
                if(lista.getItemAtPosition(position).equals("Papas"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(Asnacks.this, R.array.Papas, android.R.layout.simple_gallery_item);
                    lstSnacks.setAdapter(listacomida);
                    imgSnacks.setImageResource(R.drawable.papas);
                    papas();
                }
                if(lista.getItemAtPosition(position).equals("Chocolates"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(Asnacks.this, R.array.Chocolates, android.R.layout.simple_gallery_item);
                    lstSnacks.setAdapter(listacomida);
                    imgSnacks.setImageResource(R.drawable.chocolates);
                    chocolates();
                }
                if(lista.getItemAtPosition(position).equals("PaletasDeHielo"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(Asnacks.this, R.array.PaletasDeHielo, android.R.layout.simple_gallery_item);
                    lstSnacks.setAdapter(listacomida);
                    imgSnacks.setImageResource(R.drawable.paletas);
                    paletas();
                }
                if(lista.getItemAtPosition(position).equals("Donas"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(Asnacks.this, R.array.Donas, android.R.layout.simple_gallery_item);
                    lstSnacks.setAdapter(listacomida);
                    imgSnacks.setImageResource(R.drawable.donas);
                    donas();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> lista) {
            }
        });

        btnTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent env= new Intent (v.getContext(), tick.class);
                env.putExtra("Snack",snack);
                env.putExtra("PagoSnack",pagosnack);
                startActivity(env);
            }
        });
    }
    public void papas()
    {
        lstSnacks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgSnacks.setImageResource(R.drawable.sabritas);
                        snack="Sabritas";
                        pagosnack=12;
                        break;
                    case 1: imgSnacks.setImageResource(R.drawable.doritos);
                        snack="Doritos";
                        pagosnack=12;
                        break;
                    case 2: imgSnacks.setImageResource(R.drawable.cheetos);
                        snack="Cheetos";
                        pagosnack=12;
                        break;
                    case 3: imgSnacks.setImageResource(R.drawable.ruffles);
                        snack="Ruffles";
                        pagosnack=12;
                        break;
                    case 4: imgSnacks.setImageResource(R.drawable.fritos);
                        snack="Fritos";
                        pagosnack=12;
                        break;
                }

            }
        });
    }
    public void chocolates()
    {
        lstSnacks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgSnacks.setImageResource(R.drawable.kitkat);
                        snack="Kit Kat";
                        pagosnack=15;
                        break;
                    case 1: imgSnacks.setImageResource(R.drawable.snickers);
                        snack="Snickers";
                        pagosnack=15;
                        break;
                    case 2: imgSnacks.setImageResource(R.drawable.crunch);
                        snack="Crunch";
                        pagosnack=15;
                        break;
                    case 3: imgSnacks.setImageResource(R.drawable.milkyway);
                        snack="Milky Way";
                        pagosnack=15;
                        break;
                    case 4: imgSnacks.setImageResource(R.drawable.carlosv);
                        snack="Carlos V";
                        pagosnack=15;
                        break;
                }

            }
        });
    }
    public void paletas()
    {
        lstSnacks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgSnacks.setImageResource(R.drawable.chamoy);
                        snack="Paleta Chamoy";
                        pagosnack=10;
                        break;
                    case 1: imgSnacks.setImageResource(R.drawable.paletachoc);
                        snack="Paleta Chocolate";
                        pagosnack=10;
                        break;
                    case 2: imgSnacks.setImageResource(R.drawable.paletafresa);
                        snack="Paleta Fresa";
                        pagosnack=10;
                        break;
                    case 3: imgSnacks.setImageResource(R.drawable.paletalimon);
                        snack="Paleta Limon";
                        pagosnack=10;
                        break;
                    case 4: imgSnacks.setImageResource(R.drawable.uva);
                        snack="Paleta Uva";
                        pagosnack=10;
                        break;
                }

            }
        });
    }
    public void donas()
    {
        lstSnacks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgSnacks.setImageResource(R.drawable.glaseada);
                        snack="Dona Glaseada";
                        pagosnack=12;
                        break;
                    case 1: imgSnacks.setImageResource(R.drawable.donachoc);
                        snack="Dona Chocolate";
                        pagosnack=12;
                        break;
                    case 2: imgSnacks.setImageResource(R.drawable.donachispas);
                        snack="Dona Chispas";
                        pagosnack=12;
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
