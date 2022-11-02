package com.ortiz.p_th_app_movil.Presentador.PresentadorVistaPrincipal;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.ortiz.p_th_app_movil.Datos.usarioDatos;
import com.ortiz.p_th_app_movil.R;

import java.util.HashMap;
import java.util.Map;

public class VistaPrincipalP implements View.OnClickListener{

    private Context mContext;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private EditText txtnombre, txtcorreo, txtcelular, txtfecha, txthora;
    private Dialog dialog;


    public VistaPrincipalP(Context mContext, FirebaseAuth mAuth, DatabaseReference mDatabase) {
        this.mContext = mContext;
        this.mAuth = mAuth;
        this.mDatabase = mDatabase;
    }

    public void MensajeBienvenida(){
        mDatabase.child("Usuarios").child(mAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usarioDatos usarioDatos = dataSnapshot.getValue(com.ortiz.p_th_app_movil.Datos.usarioDatos.class);
                Toast.makeText(mContext, "BIENBENIDO: "+dataSnapshot.child("nombre").getValue(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    public void cargardedatos(){
        dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.dialog_row);
        txtnombre=dialog.findViewById(R.id.txtnombre);
        txtcorreo=dialog.findViewById(R.id.txtcorreo);
        txtcelular=dialog.findViewById(R.id.txtcelular);
        txtfecha=dialog.findViewById(R.id.txtfecha);
        txthora=dialog.findViewById(R.id.txthora);
        Button cargardedatos=dialog.findViewById(R.id.btn_registro_citas);
        cargardedatos.setOnClickListener(this);
        dialog.show();


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_registro_citas:
                                        String txtnombres = txtnombre.getText().toString().trim();
                                        String txtcorreos = txtcorreo.getText().toString().trim();
                                        String txtcelulares = txtcelular.getText().toString().trim();
                                        String txtfechas = txtfecha.getText().toString().trim();
                                        String txthoras = txthora.getText().toString().trim();
                                        cargadedatosfirebase(txtnombres,txtcorreos,txtcelulares,txtfechas,txthoras);
                                        break;
        }

    }

    private void cargadedatosfirebase(String txtnombres, String txtcorreos, String txtcelulares, String txtfechas, String txthoras){
        Map<String, Object> registrocita = new HashMap<>();
        registrocita.put("nombre",txtnombres);
        registrocita.put("correo",txtcorreos);
        registrocita.put("celular",txtcelulares);
        registrocita.put("fecha",txtfechas);
        registrocita.put("hora",txthoras);
        mDatabase.child("Usuarios").child(mAuth.getCurrentUser().getUid()).child("Cita").updateChildren(registrocita).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                dialog.dismiss();
                Toast.makeText(mContext, "Se registro la cita de manera correcta", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
