package com.example.prueba.Pantalla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prueba.MenuPrincipal;
import com.example.prueba.R;

public class Pantalla_detalle_operaciones extends AppCompatActivity {
    private TextView tv_titulo_tema;
    private RadioGroup rg_nombre_operaciones,rg_cantidad_problemas;
    private RadioButton rb_aux;
    private Button btn_cancelar_detalle_operacion,btn_aceptar_detalle_operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_detalle_operaciones);
        tv_titulo_tema = (TextView)findViewById(R.id.tv_titulo_tema);
        rg_nombre_operaciones = (RadioGroup)findViewById(R.id.rg_nombre_operaciones);
        rg_cantidad_problemas =(RadioGroup)findViewById(R.id.rg_cantidad_problemas);
        btn_cancelar_detalle_operacion= (Button)findViewById(R.id.btn_cancelar_detalle_operacion);
        btn_aceptar_detalle_operacion = (Button)findViewById(R.id.btn_aceptar_detalle_operacion);


        Intent datos = getIntent();
        tv_titulo_tema.setText(datos.getStringExtra("TITULO"));
        setRadioGroup(datos.getStringExtra("TITULO"));

        btn_cancelar_detalle_operacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuPrincipal = new Intent(Pantalla_detalle_operaciones.this, MenuPrincipal.class);
                startActivity(menuPrincipal);
                finish();
            }
        });


        btn_aceptar_detalle_operacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String operacion = operacionMatematica();
                int numProblemas = cantidadProblemas();
                if((operacion != " ") && (numProblemas!=0)){
                    Intent pantalla_sumar_restar = new Intent(Pantalla_detalle_operaciones.this, Pantalla_sumar_restar.class);
                    pantalla_sumar_restar.putExtra("operacion",operacion);
                    pantalla_sumar_restar.putExtra("cantidadProblemas",numProblemas);
                    startActivity(pantalla_sumar_restar);
                    finish();
                }
            }
        });



    }
    private int cantidadProblemas(){
        int idSelect = rg_cantidad_problemas.getCheckedRadioButtonId();
        rb_aux = (RadioButton) findViewById(idSelect);
        return  Integer.parseInt(rb_aux.getText().toString());
    }

    private String operacionMatematica(){

        String operacion = " ";
        int idSelect = rg_nombre_operaciones.getCheckedRadioButtonId();
        rb_aux = (RadioButton) findViewById(idSelect);

        if(rb_aux != null){
                if(rb_aux.getText().equals("SUMAR")){
                    operacion ="+";

                }else if(rb_aux.getText().equals("RESTAR")) {
                    operacion = "-";
                }

        }else{
            Toast.makeText(this,"SELECCIONE UNA OPERACION",Toast.LENGTH_SHORT).show();
        }


        return operacion;

    }


    private void  setRadioGroup(String tituloRB){
        if(tituloRB.equals("MULTIPLICAR")){
            rg_nombre_operaciones.removeAllViews();
            RadioButton rb = new RadioButton(this);
            rb.setText("MULTIPLICAR");
            rg_nombre_operaciones.addView(rb);
        }



    }


}