package com.ortiz.p_th_app_movil.Vista.VistaLogin;

//Importacion de librerias, clases y paquetes
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
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ortiz.p_th_app_movil.Presentador.PresentadorLogin.PresentadorLogin;
import com.ortiz.p_th_app_movil.R;
import com.ortiz.p_th_app_movil.Vista.VistaRegistro.Rgt_User;

public class VistaLogin extends AppCompatActivity implements View.OnClickListener {

    //Declaracion de las variables
    private EditText txt_email, txt_clave;
    private PresentadorLogin presentadorLogin;
    ImageView image_logo;
    TextView tvt_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Instaciando la base de datos RealTime DataBase de Firebase
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        presentadorLogin = new PresentadorLogin(this,mAuth,mDatabase);


        //Texteo de las variables
        txt_email = findViewById(R.id.txt_email);
        txt_clave = findViewById(R.id.txt_clave);
        image_logo=findViewById(R.id.img_logo);
        tvt_registrar=findViewById(R.id.tvt_registrar);
        Button btnlogin =findViewById(R.id.btn_ingresar);
        btnlogin.setOnClickListener(this);


         //Animacion del logo que se mostrara en el login
        Animation mianimacion= AnimationUtils.loadAnimation(this,R.anim.blink);
        image_logo.startAnimation(mianimacion);


        //salto al registro de usuario
        tvt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Intent = new Intent(VistaLogin.this, Rgt_User.class);
                startActivity(Intent);

            }
        });
    }

    //Validacion del usuario y la clave
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ingresar:
                String email = txt_email.getText().toString().trim();
                String password =txt_clave.getText().toString().trim();
                presentadorLogin.Ingresar(email,password);
                break;
        }

    }
}