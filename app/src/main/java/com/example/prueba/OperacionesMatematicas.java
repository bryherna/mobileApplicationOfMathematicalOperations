package com.example.prueba;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OperacionesMatematicas extends AppCompatActivity {
    private EditText edt_primer_numero,edt_segundo_numero,edt_resultado;
    private TextView tv_numeros_una_cifra,tv_numeros_dos_cifras;
    private Button btn_sumar;
    private  int contador;
    private List<Integer> numerosDosCifras;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_operaciones_matematicas);
        contador =0;


        edt_primer_numero = (EditText) findViewById(R.id.edt_primer_numero);
        edt_segundo_numero = (EditText) findViewById(R.id.edt_segundo_numero);
        edt_resultado = (EditText) findViewById(R.id.edt_resultado);
        btn_sumar = (Button) findViewById(R.id.btn_sumar);
        tv_numeros_una_cifra =(TextView)findViewById(R.id.tv_numeros_una_cifra);
        tv_numeros_dos_cifras =(TextView)findViewById(R.id.tv_numeros_dos_cifras);



        Random rnd = new Random();

        numerosDosCifras= new ArrayList<>();

        rnd.ints(10,10,20).forEach(numerosDosCifras::add);
        btn_sumar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                agregarNumero();
            }
        });

    }


    public void agregarNumero(){

        //tv_numeros_una_cifra.setText("4 5");



        if(contador <= (numerosDosCifras.size()-1)){
            if(contador+1 == numerosDosCifras.size()){
                Log.i("NUMEROS","TERMINO LOS DIEZ NUMEROS",null);
            }else{
                int num1 = numerosDosCifras.get(contador);
                int num2 = numerosDosCifras.get(contador+1);
                contador++;
                tv_numeros_dos_cifras.setText(String.valueOf(num1)+" "+String.valueOf(num2));
            }


        }







    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("PAUSE","ONPAUSE",null);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("STOP","ONSTOP",null);
        
    }
    /*
     @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        edt_primer_numero.setText(savedInstanceState.getString("PRIMER_NUMERO"));
        edt_segundo_numero.setText(savedInstanceState.getString("SEGUNDO_NUMERO"));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        outState.putString("PRIMER_NUMERO",edt_primer_numero.getText().toString());
        outState.putString("SEGUNDO_NUMERO",edt_segundo_numero.getText().toString());
        super.onSaveInstanceState(outState);
    }

     */






    public void sumar(){
        int sumar=0;
        sumar = Integer.parseInt(edt_primer_numero.getText().toString()) + Integer.parseInt(edt_segundo_numero.getText().toString());
        edt_resultado.setText(String.valueOf(sumar));
        edt_resultado.setText(String.valueOf(edt_resultado.getText().toString()));
    }


}