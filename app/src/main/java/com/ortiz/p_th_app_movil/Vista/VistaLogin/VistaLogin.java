package com.ortiz.p_th_app_movil.Vista.VistaLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ortiz.p_th_app_movil.Presentador.PresentadorLogin.PresentadorLogin;
import com.ortiz.p_th_app_movil.R;

public class VistaLogin extends AppCompatActivity implements View.OnClickListener {

    private EditText txt_email, txt_clave;
    private Button btn_ingresar, btn_registro;
    private PresentadorLogin presentadorLogin;
    ImageView image_logo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        presentadorLogin = new PresentadorLogin(this, mAuth, mDatabase);

        txt_email = findViewById(R.id.txt_email);
        txt_clave = findViewById(R.id.txt_clave);
        btn_ingresar = findViewById(R.id.btn_ingresar);
        btn_ingresar.setOnClickListener(this);
        image_logo=findViewById(R.id.img_logo);



        Animation mianimacion= AnimationUtils.loadAnimation(this,R.anim.blink);
        image_logo.startAnimation(mianimacion);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ingresar:
                String email = txt_email.getText().toString().trim();
                String clave = txt_clave.getText().toString().trim();
                presentadorLogin.Login(email, clave);
                break;
        }

    }
}