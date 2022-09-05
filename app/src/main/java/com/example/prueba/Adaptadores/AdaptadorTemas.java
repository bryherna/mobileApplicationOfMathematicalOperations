package com.example.prueba.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba.Clases.Tema;
import com.example.prueba.R;

import java.util.List;

public class AdaptadorTemas extends RecyclerView.Adapter<AdaptadorTemas.ViewHolder> {
    private LayoutInflater inflador;
    protected List<Tema> temaList;
    private Context context;
    private View.OnClickListener onClickListener;
    private View.OnLongClickListener onLongClickListener;

    public AdaptadorTemas(List<Tema> temaList, Context context) {
        inflador = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.temaList = temaList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflador.inflate(R.layout.elemento_selector,null);
        view.setOnClickListener(onClickListener);
        view.setOnLongClickListener(onLongClickListener);

        return new ViewHolder(view);
    }
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener){
        this.onLongClickListener= onLongClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tema tema = temaList.get(position);
        holder.iv_foto_tema.setImageResource(tema.getRecursoImagen());
        holder.tv_nombre_tema.setText(tema.getNombreTema());
        holder.tv_tema_dificultad.setText(tema.getDificultad());

    }

    @Override
    public int getItemCount() {
        return temaList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_nombre_tema,tv_tema_dificultad;
        private ImageView iv_foto_tema;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nombre_tema = (TextView) itemView.findViewById(R.id.tv_nombre_tema);
            tv_tema_dificultad= (TextView) itemView.findViewById(R.id.tv_tema_dificultad);
            iv_foto_tema = (ImageView) itemView.findViewById(R.id.iv_foto_tema);

        }

    }
}
