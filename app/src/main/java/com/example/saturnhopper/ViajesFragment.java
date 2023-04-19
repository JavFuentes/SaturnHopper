package com.example.saturnhopper;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;


public class ViajesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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

        // Establece un LayoutManager (por ejemplo, LinearLayoutManager) para el RecyclerView
        rvViajes.setLayoutManager(new LinearLayoutManager(getContext()));

        // Crea una lista de objetos de tipo PaqueteViaje y añade 4 paquetes de viaje a la lista
        List<PaqueteViaje> listaPaquetesViaje = new ArrayList<>();
        listaPaquetesViaje.add(new PaqueteViaje("Encélado","Cassini Facilities",2, 0.1, R.drawable.image1));
        listaPaquetesViaje.add(new PaqueteViaje("Mimas","The Dome",3, 0.2, R.drawable.image2));
        listaPaquetesViaje.add(new PaqueteViaje("Tetis","Big Igloo",3, 0.2, R.drawable.image3));
        listaPaquetesViaje.add(new PaqueteViaje("Titán","Carinae",2, 0.1, R.drawable.image4));


        // Crea un adaptador personalizado para el RecyclerView, pasándole la lista de paquetes de viaje
        AdaptadorPaqueteViaje adaptadorPaqueteViaje = new AdaptadorPaqueteViaje(listaPaquetesViaje);

        // Establece el adaptador personalizado en el RecyclerView
        rvViajes.setAdapter(adaptadorPaqueteViaje);
    }
}