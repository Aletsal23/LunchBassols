package com.example.alumno_1.lunchbassols;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class Comida extends Fragment {

    Button btnComprar;
    Spinner spnComida;
    ListView lstComida;
    ImageView imgComida;
    String comida,pago;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comida,container,false);
        spnComida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int position, long id)
            {
                if(lista.getItemAtPosition(position).equals("Chilaquiles"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Chilaquiles, android.R.layout.simple_gallery_item);
                    lstComida.setAdapter(listacomida);
                    imgComida.setImageResource(R.drawable.chilaquiles);
                    chilaquiles();
                }
                if(lista.getItemAtPosition(position).equals("Hamburguesa"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Hamburguesa, android.R.layout.simple_gallery_item);
                    lstComida.setAdapter(listacomida);
                    imgComida.setImageResource(R.drawable.hamburguesa);
                    hamburguesa();
                }
                if(lista.getItemAtPosition(position).equals("Huevos"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Huevos, android.R.layout.simple_gallery_item);
                    lstComida.setAdapter(listacomida);
                    imgComida.setImageResource(R.drawable.huevos);
                    huevos();
                }
                if(lista.getItemAtPosition(position).equals("Torta"))
                {
                    ArrayAdapter listacomida= ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Torta, android.R.layout.simple_gallery_item);
                    lstComida.setAdapter(listacomida);
                    imgComida.setImageResource(R.drawable.torta);
                    torta();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> lista) {

            }
        });

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent enviodatos= new Intent(v.getContext(), tick.class);
                enviodatos.putExtra("Comida",comida);
                enviodatos.putExtra("PagoComida",pago);
                startActivity(enviodatos);

            }
        });

        return inflater.inflate(R.layout.fragment_comida, container, false);


    }
    public void chilaquiles()
    {
        lstComida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgComida.setImageResource(R.drawable.chilaquilesverdes);
                        comida="Chilaquiles Verdes";
                        pago="25";
                        break;
                    case 1: imgComida.setImageResource(R.drawable.chilaquilesrojos);
                        comida="Chilaquiles Rojos";
                        pago="25";
                        break;
                }

            }
        });
    }
    public void hamburguesa()
    {
        lstComida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgComida.setImageResource(R.drawable.sencilla);
                        comida="Hamburguesa Sencilla";
                        pago="20";
                        break;
                    case 1: imgComida.setImageResource(R.drawable.doble);
                        comida="Hamburguesa Doble";
                        pago="25";
                        break;
                    case 2: imgComida.setImageResource(R.drawable.hawaiana);
                        comida="Hamburguesa Hawaianna";
                        pago="28";
                        break;
                    case 3: imgComida.setImageResource(R.drawable.queso);
                        comida="Hamburguesa Queso";
                        pago="22";
                        break;
                }

            }
        });
    }
    public void huevos()
    {
        lstComida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgComida.setImageResource(R.drawable.estrella);
                        comida="Huevos Estrellados";
                        pago="25";
                        break;
                    case 1: imgComida.setImageResource(R.drawable.revuelto);
                        comida="Hamburguesa Revueltos";
                        pago="25";
                        break;
                    case 2: imgComida.setImageResource(R.drawable.rancheros);
                        comida="Hamburguesa Rancheros";
                        pago="25";
                        break;
                }

            }
        });
    }
    public void torta()
    {
        lstComida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: imgComida.setImageResource(R.drawable.jamon);
                        comida="Torta Jamon";
                        pago="15";
                        break;
                    case 1: imgComida.setImageResource(R.drawable.salchicha);
                        comida="Torta Salchicha";
                        pago="15";
                        break;
                    case 2: imgComida.setImageResource(R.drawable.pierna);
                        comida="Torta Pierna";
                        pago="15";
                        break;
                    case 3: imgComida.setImageResource(R.drawable.huevo);
                        comida="Torta Huevo";
                        pago="15";
                        break;
                }

            }
        });
    }
    }

