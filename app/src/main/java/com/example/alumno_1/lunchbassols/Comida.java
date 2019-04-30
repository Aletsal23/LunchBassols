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
import android.widget.Button;
import android.widget.TextView;


public class Comida extends Fragment {

    Button btnComprar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comida, container, false);


    }

    public void Comprar(View view)
    {
        Intent intent = new Intent(getActivity(), Compra.class);
        getActivity().startActivity(intent);
    }
    }

