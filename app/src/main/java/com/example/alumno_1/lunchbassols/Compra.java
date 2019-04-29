package com.example.alumno_1.lunchbassols;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

import java.lang.ref.Reference;

import de.hdodenhof.circleimageview.CircleImageView;

public class Compra extends AppCompatActivity {

    private CircleImageView FotoPerfil;
    private TextView Nombre;
    private RecyclerView rvMensajes;
    private EditText txtMensaje;
    private Button btnEnviar;
    private AdapterMensajes adapter;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

        FotoPerfil = (CircleImageView) findViewById(R.id.FotoPerfil);
        Nombre = (TextView) findViewById(R.id.Nombre);
        rvMensajes = (RecyclerView) findViewById(R.id.rvMensajes);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Chat"); //Sala de chat

        adapter = new AdapterMensajes(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        rvMensajes.setLayoutManager(l);
        rvMensajes.setAdapter(adapter);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.push().setValue(new MensajeEnviar(txtMensaje.getText().toString(),Nombre.getText().toString(),"","1",ServerValue.TIMESTAMP));
                txtMensaje.setText("");
            }
        });

        FotoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
              MensajeRecibir m = dataSnapshot.getValue(MensajeRecibir.class);
              adapter.addMensaje(m);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void setScrollbar(){
        rvMensajes.scrollToPosition(adapter.getItemCount()-1);
    }

}
