package com.example.saturnhopper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetalleDestinoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle_destino, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Recuperar los datos del paquete de viaje del Bundle
        int id = getArguments().getInt("id");
        String destino = getArguments().getString("destino");
        String baseLunar = getArguments().getString("baseLunar");
        int duracion = getArguments().getInt("duracion");
        int precio = getArguments().getInt("precio");
        int imagen = getArguments().getInt("imagen");

        // Mostrar los datos del paquete de viaje en la interfaz de usuario
        TextView tvDestino = view.findViewById(R.id.tv_destino);
        tvDestino.setText(destino);

        TextView tvBaseLunar = view.findViewById(R.id.tv_base_lunar);
        tvBaseLunar.setText(baseLunar);

        TextView tvDuracion = view.findViewById(R.id.tv_duracion);
        tvDuracion.setText(String.valueOf(duracion));

        TextView tvPrecio = view.findViewById(R.id.tv_precio);
        tvPrecio.setText(String.valueOf(precio));

        ImageView ivImagen = view.findViewById(R.id.iv_imagen);
        ivImagen.setImageResource(imagen);
    }
}