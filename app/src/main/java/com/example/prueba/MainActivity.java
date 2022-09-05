package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edt_texto;
    private Button btn_enviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_texto = findViewById(R.id.edt_texto);
        btn_enviar = findViewById(R.id.btn_enviar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarTexto();
            }
        });

    }


    private void enviarTexto(){

        /*
        //telefono
        Uri numero = Uri.parse("tel:190292321");
        Intent telefono = new Intent(Intent.ACTION_DIAL,numero);

        if(telefono.resolveActivity(getPackageManager()) != null){
            startActivity(telefono);
        }

         */



        //enviar mensaje
        /*
        Intent msg = new Intent();
        msg.setAction(Intent.ACTION_SEND);
        msg.putExtra(Intent.EXTRA_TEXT,edt_texto.getText().toString());
        msg.setType("text/plain");

        if(msg.resolveActivity(getPackageManager()) != null){
            startActivity(msg);
        }

         */


    }
}