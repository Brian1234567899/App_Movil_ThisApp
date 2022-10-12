package com.ortiz.p_th_app_movil.Presentador.PresentadorLogin;

import android.app.Activity;
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
    private String TAG = "PresentadorLogin";
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public PresentadorLogin(Context mContext, FirebaseAuth mAuth, DatabaseReference mDatabase){
        this.mContext = mContext;
        this.mAuth = mAuth;
        this.mDatabase = mDatabase;
    }
    public void Login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) mContext, (OnCompleteListener<AuthResult>) task -> {
                    if(task.isSuccessful()){
                        Log.d(TAG, "signInWithEmailAndPassword:exitoso");

                        mDatabase.child("Usuarios").setValue(task.getResult().getUser().getUid());

                        Intent intent = new Intent(mContext, VistaPrincipal.class);
                        mContext.startActivity(intent);

                    }else{
                        Log.d(TAG, "signInWithEmailAndPassword:fallido", task.getException());
                        Toast.makeText(mContext, "Autentificacion Fallido", Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
