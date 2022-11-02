package com.ortiz.p_th_app_movil.Vista.VistaRegistro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ortiz.p_th_app_movil.Presentador.PresentadorRegistro.RegistroUsuario;
import com.ortiz.p_th_app_movil.R;
import com.ortiz.p_th_app_movil.Vista.VistaLogin.VistaLogin;

public class Rgt_User extends AppCompatActivity implements View.OnClickListener{


    private EditText txt_username, txt_email, txt_clave, txt_nombre;
    private RegistroUsuario registroUsuario;
    FloatingActionButton tvt_volver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgt_user);

        FirebaseAuth mAuth= FirebaseAuth.getInstance();
        DatabaseReference mDatbase = FirebaseDatabase.getInstance().getReference();
        registroUsuario = new RegistroUsuario(this, mAuth, mDatbase);
        tvt_volver=findViewById(R.id.tvt_volver);
        txt_email=findViewById(R.id.txt_email);
        txt_username=findViewById(R.id.txt_username);
        txt_clave=findViewById(R.id.txt_clave);
        txt_nombre=findViewById(R.id.txt_nombre);
        Button mRegistrarBtn = findViewById(R.id.btn_registro_usuario);
        mRegistrarBtn.setOnClickListener(this);



        tvt_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Intent = new Intent(Rgt_User.this, VistaLogin.class);
                startActivity(Intent);

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_registro_usuario:
                String nombre = txt_nombre.getText().toString().trim();
                String username =txt_username.getText().toString().trim();
                String email = txt_email.getText().toString().trim();
                String password = txt_clave.getText().toString().trim();
                registroUsuario.registrousuario(email, password, nombre, username);
                break;
        }

    }
}