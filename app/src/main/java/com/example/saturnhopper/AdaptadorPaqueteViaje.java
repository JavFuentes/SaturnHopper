package com.example.saturnhopper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;
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

    // Método para enlazar los datos del paquete de viaje con el ViewHolder personalizado
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PaqueteViaje viaje = listaViajes.get(position);

        holder.tvNombre.setText(viaje.getDestino());
        holder.ivImagen.setImageResource(viaje.getImagen());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Bundle para pasar los datos del paquete de viaje al Fragment DetalleDestinoFragment
                Bundle bundle = new Bundle();
                bundle.putInt("id", viaje.getId());
                bundle.putString("destino", viaje.getDestino());
                bundle.putString("baseLunar", viaje.getBaseLunar());
                bundle.putInt("duracion", viaje.getDuracion());
                bundle.putInt("precio", viaje.getPrecio());
                bundle.putInt("imagen", viaje.getImagen());

                // Navegar al Fragment DetalleDestinoFragment y pasar los datos del paquete de viaje usando el Bundle
                Navigation.findNavController(v).navigate(R.id.action_viajesFragment_to_detallesDestinoFragment, bundle);
            }
        });

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
