package com.ortiz.p_th_app_movil.Vista.VistaLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ortiz.p_th_app_movil.R;

public class MainActivity_Present extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity_Present.this, VistaLogin.class));
                finish();
            }
        }, 2000);

    }
}