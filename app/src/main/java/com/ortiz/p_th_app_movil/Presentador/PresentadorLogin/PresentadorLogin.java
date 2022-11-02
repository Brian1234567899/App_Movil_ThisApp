package com.ortiz.p_th_app_movil.Presentador.PresentadorLogin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.ortiz.p_th_app_movil.Vista.VistaPrincipal.VistaPrincipal;

public class PresentadorLogin {
    private Context mContext;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private String TAG = "PresentadorLogin";

    public PresentadorLogin(Context mContext, FirebaseAuth mAuth, DatabaseReference mDatabase) {
        this.mContext = mContext;
        this.mAuth = mAuth;
        this.mDatabase = mDatabase;
    }

    public void Ingresar(String email, String password){
        ProgressDialog dialog = new ProgressDialog(mContext);
        dialog.setMessage("Inciando Sesión");
        dialog.setCancelable(false);
        dialog.show();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) mContext, (OnCompleteListener<AuthResult>) task -> {
                    if(task.isSuccessful()){
                        dialog.dismiss();
                        Log.d(TAG, "signInWithEmailAndPassword:exitoso");

                        mDatabase.child("Usuarios").child(task.getResult().getUser().getUid()).child("Cuenta").setValue("Nueva Creada");

                        Intent intent = new Intent(mContext, VistaPrincipal.class);
                        mContext.startActivity(intent);

                    }else{
                        Log.d(TAG, "signInWithEmailAndPassword:fallido", task.getException());
                        Toast.makeText(mContext, "Autentificacion Fallido", Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
