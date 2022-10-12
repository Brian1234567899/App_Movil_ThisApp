package com.ortiz.p_th_app_movil.Vista.VistaPrincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ortiz.p_th_app_movil.R;
import com.ortiz.p_th_app_movil.Vista.VistaRegistro.RegistroCitas;
import com.ortiz.p_th_app_movil.Vista.VistaRegistro.VistaRegistro;

public class VistaPrincipal extends AppCompatActivity {

    Button btn_registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_principal);

        btn_registro=findViewById(R.id.btn_registro);
        btn_registro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent_explicito = new Intent(VistaPrincipal.this, RegistroCitas.class);
            startActivity(intent_explicito);
        }
    });
    }


}