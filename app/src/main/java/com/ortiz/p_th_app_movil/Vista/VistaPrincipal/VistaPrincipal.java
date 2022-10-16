package com.ortiz.p_th_app_movil.Vista.VistaPrincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ortiz.p_th_app_movil.R;
import com.ortiz.p_th_app_movil.Vista.VistaLogin.VistaLogin;
import com.ortiz.p_th_app_movil.Vista.VistaRegistro.RegistroCitas;
import com.ortiz.p_th_app_movil.Vista.VistaRegistro.Rgt_User;
import com.ortiz.p_th_app_movil.Vista.VistaRegistro.VistaRegistro;

public class VistaPrincipal extends AppCompatActivity {

    Button btn_registro;
    Button btn_citas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_principal);

        btn_registro=findViewById(R.id.btn_registro);
        btn_citas=findViewById(R.id.btn_citas);


        btn_registro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent_explicito = new Intent(VistaPrincipal.this, RegistroCitas.class);
            startActivity(intent_explicito);
        }
    });
        btn_citas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_explicito = new Intent(VistaPrincipal.this, VistaRegistro.class);
                startActivity(intent_explicito);
            }
        });

    }


}