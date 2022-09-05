package com.example.prueba.Clases;

import android.app.Application;

import com.example.prueba.Adaptadores.AdaptadorTemas;

import java.util.List;

public class Aplicacion extends Application {
    private List<Tema> temaList;
    private AdaptadorTemas adaptadorTemas;


    @Override
    public void onCreate() {
        super.onCreate();
        temaList = Tema.listaTemas();
        adaptadorTemas = new AdaptadorTemas(temaList,this);

    }

    public List<Tema> getTemaList() {
        return temaList;
    }

    public AdaptadorTemas getAdaptadorTemas() {
        return adaptadorTemas;
    }
}
