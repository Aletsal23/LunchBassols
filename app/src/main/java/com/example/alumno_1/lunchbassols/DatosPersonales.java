package com.example.alumno_1.lunchbassols;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DatosPersonales extends AppCompatActivity implements View.OnClickListener {

    private Button btnReg;
    private EditText txteNom,txtnBoleta, txteOcupacion, txteDir, txtnTel, txtnEdad;
    private Spinner spnEdoCivil;
    private String EdoCivil;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        mFirestore = FirebaseFirestore.getInstance();

        btnReg = (Button) findViewById(R.id.btnReg);
        txteNom = (EditText) findViewById(R.id.txteNom);
        txtnBoleta = (EditText) findViewById(R.id.txtnBoleta);
        txteOcupacion = (EditText) findViewById(R.id.txteOcupacion);
        txteDir = (EditText) findViewById(R.id.txteDir);
        txtnTel = (EditText) findViewById(R.id.txtnTel);
        txtnEdad = (EditText) findViewById(R.id.txtnEdad);

        spnEdoCivil = (Spinner) findViewById(R.id.spnEdoCivil);

        spnEdoCivil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View view, int position, long id) {
                if(lista.getItemAtPosition(position).equals("Soltero"))
                {
                    EdoCivil="Soltero";
                }
                if(lista.getItemAtPosition(position).equals("Casado"))
                {
                    EdoCivil="Casado";
                }
                if(lista.getItemAtPosition(position).equals("Viudo"))
                {
                    EdoCivil="Viudo";
                }
                if(lista.getItemAtPosition(position).equals("Otro"))
                {
                    EdoCivil="Otro";
                }
            }
        });

        btnReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nombre = txteNom.getText().toString();
        String boleta = txtnBoleta.getText().toString();
        String edad = txtnEdad.getText().toString();
        String ocup = txteOcupacion.getText().toString();
        String dir = txteDir.getText().toString();
        String tel = txtnTel.getText().toString();
        String edociv = EdoCivil;
        Map<String, String> userMap = new HashMap<>();

        userMap.put("nombre",nombre);
        userMap.put("boleta", boleta);
        userMap.put("edad", edad);
        userMap.put("ocupacion", ocup);
        userMap.put("direccion", dir);
        userMap.put("telefono", tel);
        userMap.put("edocivil", edociv);

        mFirestore.collection("Usuarios").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(DatosPersonales.this, "Usuario creado", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                String error = e.getMessage();

                Toast.makeText(DatosPersonales.this,"Error : " + error, Toast.LENGTH_SHORT).show();

            }
        });
        Intent inicio=new Intent(this, Index.class);
        startActivity(inicio);
    }
}
