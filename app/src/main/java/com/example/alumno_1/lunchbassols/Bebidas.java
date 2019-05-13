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

public class Bebidas extends Fragment {

    Spinner spnBebidas;
    ListView lstBebidas;
    ImageView imgBebidas;
    Button btnTicket;
    String bebi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bebidas,container,false);
        spnBebidas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int position, long id)
            {
                if(lista.getItemAtPosition(position).equals("Refrescos"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Refrescos, android.R.layout.simple_gallery_item);
                    lstBebidas.setAdapter(listacomida);
                    imgBebidas.setImageResource(R.drawable.refrescos);
                    refresco();
                }
                if(lista.getItemAtPosition(position).equals("Licuados"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Licuados, android.R.layout.simple_gallery_item);
                    lstBebidas.setAdapter(listacomida);
                    imgBebidas.setImageResource(R.drawable.licuados);
                    licuados();
                }
                if(lista.getItemAtPosition(position).equals("Jugos"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Jugos, android.R.layout.simple_gallery_item);
                    lstBebidas.setAdapter(listacomida);
                    imgBebidas.setImageResource(R.drawable.jugos);
                    jugos();
                }
                if(lista.getItemAtPosition(position).equals("Agua"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Agua, android.R.layout.simple_gallery_item);
                    lstBebidas.setAdapter(listacomida);
                    imgBebidas.setImageResource(R.drawable.aguas);
                    agua();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> lista) {
            }
            });
        return inflater.inflate(R.layout.fragment_bebidas, container, false);
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
                            break;
                    case 1: imgBebidas.setImageResource(R.drawable.pepsi);
                        bebi="Pepsi";
                        break;
                    case 2: imgBebidas.setImageResource(R.drawable.mirinda);
                        bebi="Mirinda";
                        break;
                    case 3: imgBebidas.setImageResource(R.drawable.jarrito);
                        bebi="Jarrito";
                        break;
                    case 4: imgBebidas.setImageResource(R.drawable.pepper);
                        bebi="Dr. Pepper";
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
                        break;
                    case 1: imgBebidas.setImageResource(R.drawable.platano);
                        bebi="Licuado Platano";
                        break;
                    case 2: imgBebidas.setImageResource(R.drawable.chocolate);
                        bebi="Licuado Chocolate";
                        break;
                    case 3: imgBebidas.setImageResource(R.drawable.mamey);
                        bebi="Licuado Mamey";
                        break;
                    case 4: imgBebidas.setImageResource(R.drawable.avena);
                        bebi="Licuado Avena";
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
                        break;
                    case 1: imgBebidas.setImageResource(R.drawable.toronja);
                        bebi="Jugo Toronja";
                        break;
                    case 2: imgBebidas.setImageResource(R.drawable.zanahoria);
                        bebi="Jugo Zanahoria";
                        break;
                    case 3: imgBebidas.setImageResource(R.drawable.mandarina);
                        bebi="Jugo Mandarina";
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
                        break;
                    case 1: imgBebidas.setImageResource(R.drawable.limon);
                        bebi="Agua Limon";
                        break;
                    case 2: imgBebidas.setImageResource(R.drawable.moras);
                        bebi="Agua Moras";
                        break;
                    case 3: imgBebidas.setImageResource(R.drawable.horchata);
                        bebi="Agua Horchata";
                        break;
                    case 4: imgBebidas.setImageResource(R.drawable.aguafresa);
                        bebi="Agua Fresa";
                        break;

                }

            }
        });
    }
}
