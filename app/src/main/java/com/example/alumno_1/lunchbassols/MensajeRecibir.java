package com.example.alumno_1.lunchbassols;

public class MensajeRecibir extends Mensaje {
    private Long hora;

    public MensajeRecibir() {
    }

    public MensajeRecibir(Long hora) {
        this.hora = hora;
    }

    public MensajeRecibir(String mensaje, String nombre, String fotoperfil, String type_mensaje, Long hora) {
        super(mensaje, nombre, fotoperfil, type_mensaje);
        this.hora = hora;
    }

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }
}
