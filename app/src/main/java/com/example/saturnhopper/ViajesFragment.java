package com.example.saturnhopper;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saturnhopper.db.DBPaquetesViaje;

import java.util.ArrayList;
import java.util.List;

public class ViajesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Infla el layout del fragmento
        return inflater.inflate(R.layout.fragment_viajes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Encuentra los botones en la vista utilizando sus IDs
        Button btnIrHome = view.findViewById(R.id.btnHome);

        // Establece el comportamiento de clic para el botón btnIrListaViajes
        btnIrHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navega al fragmento ViajesFragment
                Navigation.findNavController(v).navigate(R.id.action_viajesFragment_to_homeFragment);
            }
        });

        // Encuentra el RecyclerView y el botón desde el layout
        RecyclerView rvViajes = view.findViewById(R.id.rv_viajes);
        Button btnHome = view.findViewById(R.id.btnHome);

        // Crea una instancia de la clase DBPaquetesViaje para acceder a la base de datos
        DBPaquetesViaje dbPaquetesViaje = new DBPaquetesViaje(getContext());

        // Establece un LayoutManager (por ejemplo, LinearLayoutManager) para el RecyclerView
        rvViajes.setLayoutManager(new LinearLayoutManager(getContext()));

        // Obtiene la lista de paquetes de viaje de la base de datos
        List<PaqueteViaje> listaPaquetesViaje = dbPaquetesViaje.mostrarPaquetesViaje();
        Log.d("TAG", "Lista de paquetes de viaje: " + listaPaquetesViaje.toString());

        // Iterar sobre la lista de paquetes y actualizar el atributo de imagen_cardview
        for (PaqueteViaje paqueteViaje : listaPaquetesViaje) {
            // Actualizar el atributo de imagen del paquete
            switch (paqueteViaje.getImagenCardView()) {
                case 1:
                    paqueteViaje.setImagenCardView(R.drawable.encendalo_cardview_1);
                    break;
                case 2:
                    paqueteViaje.setImagenCardView(R.drawable.mimas_cardview_2);
                    break;
                case 3:
                    paqueteViaje.setImagenCardView(R.drawable.tetis_cardview_3);
                    break;
                case 4:
                    paqueteViaje.setImagenCardView(R.drawable.titan_cardview_4);
                    break;
                default:
                    // No se encontró una imagen correspondiente, no se realiza ninguna acción
                    break;
            }
        }

        // Iterar sobre la lista de paquetes y actualizar el atributo de imagen_detalle
        for (PaqueteViaje paqueteViaje : listaPaquetesViaje) {
            // Actualizar el atributo de imagen del paquete
            switch (paqueteViaje.getImagenDetalle()) {
                case 5:
                    paqueteViaje.setImagenDetalle(R.drawable.encelado_detalle_5);
                    break;
                case 6:
                    paqueteViaje.setImagenDetalle(R.drawable.mimas_detalle_6);
                    break;
                case 7:
                    paqueteViaje.setImagenDetalle(R.drawable.tetis_detalle_7);
                    break;
                case 8:
                    paqueteViaje.setImagenDetalle(R.drawable.titan_detalle_8);
                    break;
                default:
                    // No se encontró una imagen correspondiente, no se realiza ninguna acción
                    break;
            }
        }

        // Crea un adaptador personalizado para el RecyclerView y lo establece en el RecyclerView
        AdaptadorPaqueteViaje adaptadorPaqueteViaje = new AdaptadorPaqueteViaje(listaPaquetesViaje);
        rvViajes.setAdapter(adaptadorPaqueteViaje);
    }
}