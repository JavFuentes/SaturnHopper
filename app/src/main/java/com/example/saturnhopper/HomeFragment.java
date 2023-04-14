package com.example.saturnhopper;

import android.os.Bundle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.navigation.Navigation;

// Define la clase HomeFragment que hereda de la clase Fragment
public class HomeFragment extends Fragment {

    // Constructor vacío requerido
    public HomeFragment() {

    }

    // Método que crea la vista del fragmento
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el archivo de diseño fragment_pantalla_uno.xml
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    // Método llamado cuando se crea la vista del fragmento
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Encuentra los botones en la vista utilizando sus IDs
        Button btnIrListaViajes = view.findViewById(R.id.btnListaViajes);

        // Establece el comportamiento de clic para el botón btnIrListaViajes
        btnIrListaViajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navega al fragmento ViajesFragment
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_viajesFragment);
            }
        });
    }
}