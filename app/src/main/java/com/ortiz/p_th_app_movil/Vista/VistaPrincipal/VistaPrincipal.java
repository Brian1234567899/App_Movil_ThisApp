package com.ortiz.p_th_app_movil.Vista.VistaPrincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ortiz.p_th_app_movil.Presentador.PresentadorVistaPrincipal.VistaPrincipalP;
import com.ortiz.p_th_app_movil.R;
import com.ortiz.p_th_app_movil.Vista.VistaCatalogo.Catalogo;
import com.ortiz.p_th_app_movil.Vista.VistaRegistro.VistaRegistro;

public class VistaPrincipal extends AppCompatActivity implements  View.OnClickListener{


    Button btn_citas;
    Button btn_catalogo;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private VistaPrincipalP vistaPrincipalP;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_principal);


        btn_citas=findViewById(R.id.btn_citas);
        btn_catalogo=findViewById(R.id.btn_catalogo);
        mAuth=FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        vistaPrincipalP = new VistaPrincipalP(this,mAuth,mDatabase);
        vistaPrincipalP.MensajeBienvenida();
        Button button = findViewById(R.id.btn_registro);
        button.setOnClickListener(this);



        btn_citas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_explicito = new Intent(VistaPrincipal.this, VistaRegistro.class);
                startActivity(intent_explicito);
            }
        });
        btn_catalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_explicito = new Intent(VistaPrincipal.this, Catalogo.class);
                startActivity(intent_explicito);
            }
        });






    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btn_registro: vistaPrincipalP.cargardedatos();
                break;
        }
    }
}