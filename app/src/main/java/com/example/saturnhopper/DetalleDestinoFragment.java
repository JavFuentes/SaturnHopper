package com.example.saturnhopper;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class DetalleDestinoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // inflar el diseño del fragmento de detalle del destino
        return inflater.inflate(R.layout.fragment_detalle_destino, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Encuentra los botones en la vista utilizando sus IDs
        Button btnVolver = view.findViewById(R.id.btnVolver);

        // Establece el comportamiento de clic para el botón btnVolver
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navega al fragmento ViajesFragment
                Navigation.findNavController(v).navigate(R.id.action_detallesDestinoFragment_to_viajesFragment);
            }
        });

        // Recuperar los datos del paquete de viaje del Bundle
        int id = getArguments().getInt("id");
        String destino = getArguments().getString("destino");
        String baseLunar = getArguments().getString("baseLunar");
        int duracion = getArguments().getInt("duracion");
        double precio = getArguments().getDouble("precio");
        int imagenCardView = getArguments().getInt("imagenCardView");
        int imagenDetalle = getArguments().getInt("imagenDetalle");

        // Mostrar los datos del paquete de viaje en la interfaz de usuario
        TextView tvDestino = view.findViewById(R.id.tv_destino);
        // establecer el destino en el TextView correspondiente
        tvDestino.setText(destino);

        TextView tvBaseLunar = view.findViewById(R.id.tv_base_lunar);
        // establecer la base lunar en el TextView correspondiente
        tvBaseLunar.setText(baseLunar);

        TextView tvDuracion = view.findViewById(R.id.tv_duracion);
        // establecer la duración en el TextView correspondiente
        tvDuracion.setText(String.valueOf(duracion + " años"));

        TextView tvPrecio = view.findViewById(R.id.tv_precio);
        // establecer el precio en el TextView correspondiente
        tvPrecio.setText(String.valueOf(precio + " ETH"));

        ImageView ivImagen = view.findViewById(R.id.iv_imagen);
        // establecer la imagen en el ImageView correspondiente
        ivImagen.setImageResource(imagenDetalle);
    }
}
