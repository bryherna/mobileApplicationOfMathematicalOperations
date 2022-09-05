package com.example.prueba.Pantalla;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prueba.MenuPrincipal;
import com.example.prueba.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pantalla_sumar_restar extends AppCompatActivity {
    private String operacion;
    private int cantidadProblemas;
    private TextView tv_ejerciciosRestantes,tv_signo,tv_numeroDosCifras,tv_ejerciciosResueltos;
    private Button btn_siguienteEjercicio,btn_cancelarEjercicios;
    private EditText edt_respuesta;
    private List<Integer> numerosDosCifras;
    private  int contador=0;
    private int num1=0,num2=0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_sumar);


        tv_ejerciciosRestantes = (TextView)findViewById(R.id.tv_ejerciciosRestantes);
        tv_signo =(TextView)findViewById(R.id.tv_signo);

        tv_ejerciciosResueltos = (TextView)findViewById(R.id.tv_ejerciciosResueltos);


        tv_numeroDosCifras = (TextView)findViewById(R.id.tv_numeroDosCifras);
        edt_respuesta = (EditText)findViewById(R.id.edt_respuesta);

        btn_siguienteEjercicio = (Button)findViewById(R.id.btn_siguienteEjercicio);
        btn_cancelarEjercicios = (Button)findViewById(R.id.btn_cancelarEjercicios);

        btn_cancelarEjercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent menuPrincipal = new Intent(Pantalla_sumar_restar.this, MenuPrincipal.class);
                startActivity(menuPrincipal);
                finish();
            }
        });

        btn_siguienteEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    actualizarInterfaz();
            }
        });

        Intent datos = getIntent();
        operacion = datos.getStringExtra("operacion");
        cantidadProblemas = datos.getIntExtra("cantidadProblemas",0);

        inicializarInterfaz();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void inicializarInterfaz(){
        tv_ejerciciosRestantes.setText(String.valueOf(cantidadProblemas));
        tv_signo.setText(operacion);
        Random rnd = new Random();

        numerosDosCifras= new ArrayList<>();

        rnd.ints(cantidadProblemas+1,10,20).forEach(numerosDosCifras::add);

        tv_numeroDosCifras.setText(String.valueOf(numerosDosCifras.get(0))+" "+String.valueOf(numerosDosCifras.get(1)));
        num1 = numerosDosCifras.get(0);
        num2 = numerosDosCifras.get(1);


    }
    private void actualizarNumeros(int contador){
        if(!(contador+1 == numerosDosCifras.size())){
            tv_numeroDosCifras.setText(String.valueOf(numerosDosCifras.get(contador))+" "+String.valueOf(numerosDosCifras.get(contador+1)));
            num1 = numerosDosCifras.get(contador);
            num2 = numerosDosCifras.get(contador+1);

        }else{
            Toast.makeText(this,"!!!!TERMINO TODOS LOS EJERCICIOS!!!!!",Toast.LENGTH_LONG).show();
        }

    }
    private void actualizarInterfaz(){

        if(contador < (numerosDosCifras.size()-1)){
            if(contador+1 == numerosDosCifras.size()){

            }else{

                if(!edt_respuesta.getText().toString().equals("")){
                    int resp = Integer.parseInt(edt_respuesta.getText().toString());
                    switch (operacion){
                        case "+":{
                            int aux = num1+num2;
                            if(aux == resp){
                                Toast.makeText(this,"!!!!EXCELENTE!!!!!",Toast.LENGTH_LONG).show();

                                contador++;
                                actualizarNumeros(contador);


                                tv_ejerciciosResueltos.setText(String.valueOf(contador));
                            }else{
                                Toast.makeText(this,"!!!ESTA INCORRECTO!!!!",Toast.LENGTH_LONG).show();

                            }


                        };
                        break;

                        case "-":{
                            int aux = num1 - num2;
                            if(aux == resp){
                                Toast.makeText(this,"!!!!EXCELENTE!!!!!",Toast.LENGTH_LONG).show();
                                contador++;
                                tv_ejerciciosResueltos.setText(String.valueOf(contador));
                            }else{
                                Toast.makeText(this,"!!!ESTA INCORRECTO!!!!",Toast.LENGTH_LONG).show();
                            }

                        };
                        break;


                    }


                }




            }


        }

        edt_respuesta.setText("");

    }





}