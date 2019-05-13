package com.example.alumno_1.lunchbassols;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.zip.Inflater;

public class snacks extends Fragment {

    Button btnTicket;
    Spinner spnSnacks;
    ListView lstSnacks;
    ImageView imgSnacks;
    String snack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_snacks,container,false);
        spnSnacks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int position, long id)
            {
                if(lista.getItemAtPosition(position).equals("Papas"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Papas, android.R.layout.simple_gallery_item);
                    lstSnacks.setAdapter(listacomida);
                    imgSnacks.setImageResource(R.drawable.papas);
                    papas();
                }
                if(lista.getItemAtPosition(position).equals("Chocolates"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Chocolates, android.R.layout.simple_gallery_item);
                    lstSnacks.setAdapter(listacomida);
                    imgSnacks.setImageResource(R.drawable.chocolates);
                    chocolates();
                }
                if(lista.getItemAtPosition(position).equals("PaletasDeHielo"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.PaletasDeHielo, android.R.layout.simple_gallery_item);
                    lstSnacks.setAdapter(listacomida);
                    imgSnacks.setImageResource(R.drawable.paletas);
                    paletas();
                }
                if(lista.getItemAtPosition(position).equals("Donas"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Donas, android.R.layout.simple_gallery_item);
                    lstSnacks.setAdapter(listacomida);
                    imgSnacks.setImageResource(R.drawable.donas);
                    donas();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> lista) {
            }
        });
        return inflater.inflate(R.layout.fragment_snacks, container, false);
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
                            break;
                    case 1: imgSnacks.setImageResource(R.drawable.doritos);
                        snack="Doritos";
                        break;
                    case 2: imgSnacks.setImageResource(R.drawable.cheetos);
                        snack="Cheetos";
                        break;
                    case 3: imgSnacks.setImageResource(R.drawable.ruffles);
                        snack="Ruffles";
                        break;
                    case 4: imgSnacks.setImageResource(R.drawable.fritos);
                        snack="Fritos";
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
                        break;
                    case 1: imgSnacks.setImageResource(R.drawable.snickers);
                        snack="Snickers";
                        break;
                    case 2: imgSnacks.setImageResource(R.drawable.crunch);
                        snack="Crunch";
                        break;
                    case 3: imgSnacks.setImageResource(R.drawable.milkyway);
                        snack="Milky Way";
                        break;
                    case 4: imgSnacks.setImageResource(R.drawable.carlosv);
                        snack="Carlos V";
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
                        break;
                    case 1: imgSnacks.setImageResource(R.drawable.paletachoc);
                        snack="Paleta Chocolate";
                        break;
                    case 2: imgSnacks.setImageResource(R.drawable.paletafresa);
                        snack="Paleta Fresa";
                        break;
                    case 3: imgSnacks.setImageResource(R.drawable.paletalimon);
                        snack="Paleta Limon";
                        break;
                    case 4: imgSnacks.setImageResource(R.drawable.uva);
                        snack="Paleta Uva";
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
                        break;
                    case 1: imgSnacks.setImageResource(R.drawable.donachoc);
                        snack="Dona Chocolate";
                        break;
                    case 2: imgSnacks.setImageResource(R.drawable.donachispas);
                        snack="Dona Chispas";
                        break;
                }

            }
        });
    }
}
