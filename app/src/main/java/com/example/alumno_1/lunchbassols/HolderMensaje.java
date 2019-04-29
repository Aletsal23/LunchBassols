package com.example.alumno_1.lunchbassols;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HolderMensaje extends RecyclerView.ViewHolder {

    private TextView NombreMensaje;
    private TextView Mensaje;
    private TextView Hora;
    private CircleImageView FotoPerfilMensaje;

    public HolderMensaje(View itemView) {
        super(itemView);

        NombreMensaje = (TextView) itemView.findViewById(R.id.NombreMensaje);
        Mensaje = (TextView) itemView.findViewById(R.id.Mensaje);
        Hora = (TextView) itemView.findViewById(R.id.Hora);
        FotoPerfilMensaje = (CircleImageView) itemView.findViewById(R.id.FotoPerfilMensaje);

    }

    public TextView getNombreMensaje() {
        return NombreMensaje;
    }

    public void setNombreMensaje(TextView nombreMensaje) {
        NombreMensaje = nombreMensaje;
    }

    public TextView getMensaje() {
        return Mensaje;
    }

    public void setMensaje(TextView mensaje) {
        Mensaje = mensaje;
    }

    public TextView getHora() {
        return Hora;
    }

    public void setHora(TextView hora) {
        Hora = hora;
    }

    public CircleImageView getFotoPerfilMensaje() {
        return FotoPerfilMensaje;
    }

    public void setFotoPerfilMensaje(CircleImageView fotoPerfilMensaje) {
        FotoPerfilMensaje = fotoPerfilMensaje;
    }
}
