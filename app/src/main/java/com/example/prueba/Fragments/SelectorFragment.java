package com.example.prueba.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba.Adaptadores.AdaptadorTemas;
import com.example.prueba.Clases.Aplicacion;
import com.example.prueba.MainActivity;
import com.example.prueba.MenuPrincipal;
import com.example.prueba.Pantalla.Pantalla_detalle_operaciones;
import com.example.prueba.R;

public class SelectorFragment extends Fragment {
    private Activity activity;
    private RecyclerView recyclerView;
    private AdaptadorTemas adaptadorTemas;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
        Aplicacion app = (Aplicacion) activity.getApplication();
        this.adaptadorTemas = app.getAdaptadorTemas();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_selector,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(adaptadorTemas);
        adaptadorTemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(activity,"SELECCIONO"+,Toast.LENGTH_LONG).show();

                ((MenuPrincipal) activity).mostrarPantalla(recyclerView.getChildAdapterPosition(view));

            }
        });

        return v;


    }


}
