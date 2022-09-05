package com.example.prueba.Clases;

import com.example.prueba.R;

import java.util.ArrayList;
import java.util.List;

public class Tema {
    private String id_tema;
    private String nombreTema;
    private int recursoImagen;
    private String dificultad;


    public Tema(String id_tema,String nombreTema, int recursoImagen, String dificultad) {
        this.id_tema=id_tema;
        this.nombreTema = nombreTema;
        this.recursoImagen = recursoImagen;
        this.dificultad = dificultad;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public void setRecursoImagen(int recursoImagen) {
        this.recursoImagen = recursoImagen;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public int getRecursoImagen() {
        return recursoImagen;
    }

    public String getDificultad() {
        return dificultad;
    }

    public String getId_tema() {
        return id_tema;
    }

    public void setId_tema(String id_tema) {
        this.id_tema = id_tema;
    }

    public static List<Tema> listaTemas(){
        List<Tema> lista = new ArrayList<>();
        lista.add(new Tema("SUMA_RESTA","Suma y Resta ", R.drawable.ic_suma_resta,"Facil, Medio"));
        lista.add(new Tema("MULTIPLICACION","Multiplicacion",R.drawable.ic_multiplicar,"Facil, Medio"));
        return lista;
    }
}
