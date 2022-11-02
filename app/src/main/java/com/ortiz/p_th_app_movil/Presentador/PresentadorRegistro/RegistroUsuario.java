package com.ortiz.p_th_app_movil.Presentador.PresentadorRegistro;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.ortiz.p_th_app_movil.Vista.VistaLogin.VistaLogin;
import com.ortiz.p_th_app_movil.Vista.VistaPrincipal.VistaPrincipal;
import com.ortiz.p_th_app_movil.Vista.VistaRegistro.Rgt_User;

import java.util.HashMap;
import java.util.Map;

public class RegistroUsuario {

    private Context mContext;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private String TAG = "RegistroUsuario";


    public RegistroUsuario(Context mContext, FirebaseAuth mAuth, DatabaseReference mDatabase) {
        this.mContext = mContext;
        this.mAuth = mAuth;
        this.mDatabase = mDatabase;
    }

    public void registrousuario(final String email,final String password,final String nombre, final String username){

        ProgressDialog dialog = new ProgressDialog(mContext);
        dialog.setMessage("Registrando Usuario");
        dialog.setCancelable(false);
        dialog.show();
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            dialog.dismiss();
                            Log.d(TAG, "createUserWithEmail:success");
                            Map<String,Object>crearUsuario = new HashMap<>();
                            crearUsuario.put("nombre",nombre);
                            crearUsuario.put("username",username);
                            crearUsuario.put("email",email);
                            mDatabase.child("Usuarios").child(task.getResult().getUser().getUid()).updateChildren(crearUsuario);

                            Intent intent = new Intent(mContext, VistaLogin.class);
                            mContext.startActivity(intent);

                        } else {
                            dialog.dismiss();
                            Log.w(TAG, "createUserWithEmail:failure",task.getException());
                            Toast.makeText(mContext, "Authentication failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}
