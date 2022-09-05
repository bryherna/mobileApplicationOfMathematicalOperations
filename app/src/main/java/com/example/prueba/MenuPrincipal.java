package com.example.prueba;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.prueba.Clases.Aplicacion;
import com.example.prueba.Pantalla.Pantalla_detalle_operaciones;
import com.example.prueba.Pantalla.Pantalla_sumar_restar;
import com.google.android.material.snackbar.Snackbar;

public class MenuPrincipal extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static final int RESULT_CODE=111;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        
        return super.onCreateOptionsMenu(menu);
    }

    public void mostrarPantalla(int id){
        switch (id){
            case 0:{

                Intent detalle_operaciones = new Intent(this, Pantalla_detalle_operaciones.class);
                detalle_operaciones.putExtra("TITULO","SUMAR Y RESTAR");
                startActivity(detalle_operaciones);


            };
            break;
            case 1:{
                Intent multiplicar = new Intent(this, Pantalla_detalle_operaciones.class);
                multiplicar.putExtra("TITULO","MULTIPLICAR");
                startActivity(multiplicar);
                Toast.makeText(this,"AUN EN DESARROLLO",Toast.LENGTH_LONG).show();

            };
            break;

        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_CODE){
            if(resultCode == RESULT_OK){
                Toast.makeText(this,"TODO CORRECTO",Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this,"FALLO",Toast.LENGTH_LONG).show();
            }
        }
    }
}