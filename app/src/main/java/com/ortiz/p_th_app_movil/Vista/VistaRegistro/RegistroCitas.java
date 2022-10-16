package com.ortiz.p_th_app_movil.Vista.VistaRegistro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ortiz.p_th_app_movil.R;
import com.ortiz.p_th_app_movil.Vista.VistaLogin.VistaLogin;
import com.ortiz.p_th_app_movil.Vista.VistaPrincipal.VistaPrincipal;

public class RegistroCitas extends AppCompatActivity {
    TextView tvt_volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_citas);

        tvt_volver=findViewById(R.id.tvt_volver);



        tvt_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Intent = new Intent(RegistroCitas.this, VistaPrincipal.class);
                startActivity(Intent);

            }
        });
    }
}