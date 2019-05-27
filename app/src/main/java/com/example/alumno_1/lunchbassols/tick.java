package com.example.alumno_1.lunchbassols;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tick extends AppCompatActivity {

    TextView txtCliente, txtAlimentos,txtCuenta,txtIva,txtTotal;
    Button btnSalir;
    int pagocom,pagobebi,pagosna,cuenta;
    double iva,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tick);

        txtCliente= (TextView) findViewById(R.id.txtCliente);
        txtAlimentos= (TextView) findViewById(R.id.txtAlimentos);
        txtCuenta= (TextView) findViewById(R.id.txtCuenta);
        txtIva= (TextView) findViewById(R.id.txtIva);
        txtTotal= (TextView) findViewById(R.id.txtTotal);
        btnSalir= (Button) findViewById(R.id.btnSalir);

        Bundle recibir= this.getIntent().getExtras();
        String comida=recibir.getString("Comida");
        int pagocomida = recibir.getInt("PagoComida");

        Bundle recibirbeb= this.getIntent().getExtras();
        String bebida=recibirbeb.getString("Bebida");
        int pagobebida=recibirbeb.getInt("PagoBebida");

        Bundle recibirsna= this.getIntent().getExtras();
        String snack=recibirsna.getString("Snack");
        int pagosnack=recibirsna.getInt("PagoSnack");

        cuenta=pagocomida+pagobebida+pagosnack;
        iva=(pagocomida+pagobebida+pagosnack)*0.16;
        total=cuenta+iva;

        txtAlimentos.setText(comida);
        txtAlimentos.setText(bebida);
        txtAlimentos.setText(snack);
        txtCuenta.setText(String.valueOf(cuenta));
        txtIva.setText(String.valueOf(iva));
        txtTotal.setText(String.valueOf(total));

        txtAlimentos.setText((comida));
    }

    public void salir(View view){
        Intent salir = new Intent (this,Index.class);
        startActivity(salir);
    }
    public void inicio(View view){
        Intent inicio = new Intent (this,MenuInicio.class);
        startActivity(inicio);
    }

}
