package com.example.saturnhopper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// Adaptador personalizado para el RecyclerView que maneja la lista de paquetes de viaje
public class AdaptadorPaqueteViaje extends RecyclerView.Adapter<AdaptadorPaqueteViaje.ViewHolder> {

    private List<PaqueteViaje> listaViajes;

    public AdaptadorPaqueteViaje(List<PaqueteViaje> listaViajes) {
        this.listaViajes = listaViajes;
    }

    // Método para inflar el layout del ítem y crear un ViewHolder personalizado
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_viaje, parent, false);
        return new ViewHolder(vista);
    }

    // Método para enlazar los datos del equipo con el ViewHolder personalizado
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PaqueteViaje viaje = listaViajes.get(position);

        holder.tvNombre.setText(viaje.getName());
        holder.ivImagen.setImageResource(viaje.getPicture());
    }

    // Método para obtener la cantidad de elementos en la lista de equipos
    @Override
    public int getItemCount() {
        return listaViajes.size();
    }

    // Clase ViewHolder personalizada que maneja las vistas del ítem del RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre;
        ImageView ivImagen;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.nombre);
            ivImagen = itemView.findViewById(R.id.imagen);
        }
    }
}