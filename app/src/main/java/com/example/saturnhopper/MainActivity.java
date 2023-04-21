package com.example.saturnhopper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.widget.Toast;

import com.example.saturnhopper.db.DBHelper;
import com.example.saturnhopper.db.DBPaquetesViaje;

public class MainActivity extends AppCompatActivity {
    private long id;
    private int registrosCreados = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos la referencia al archivo de preferencias
        SharedPreferences sharedPreferences = getSharedPreferences("MiPref", Context.MODE_PRIVATE);

        // Obtenemos el número de registros creados desde las preferencias
        registrosCreados = sharedPreferences.getInt("registrosCreados", 0);

        // Si aún no se han creado registros en la base de datos, los creamos
        if(registrosCreados == 0){

            // Creamos la instancia de nuestra base de datos
            DBHelper dbHelper = new DBHelper(MainActivity.this);

            // Obtenemos una instancia de la base de datos en modo escritura
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // Verificamos si la base de datos se ha creado correctamente
            if(db != null){
                Toast.makeText(this, "Base de datos creada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al crear base de datos", Toast.LENGTH_SHORT).show();
            }

            // Insertamos los paquetes de viaje en la tabla correspondiente
            DBPaquetesViaje dbPaquetesViaje = new DBPaquetesViaje(MainActivity.this);
            id = dbPaquetesViaje.insertarPaqueteViaje("Encélado","Cassini",2, 2.5,1,5);
            id = dbPaquetesViaje.insertarPaqueteViaje("Mimas","The Dome",3, 3.2,2,6);
            id = dbPaquetesViaje.insertarPaqueteViaje("Tetis","Big Igloo",2, 2.3,3,7);
            id = dbPaquetesViaje.insertarPaqueteViaje("Titán","Big Carinae",4, 3.8,4,8);

            // Verificamos si los registros se han creado correctamente
            if(id > 0){
                Toast.makeText(this, "Registros creados", Toast.LENGTH_SHORT).show();
                // Actualizamos el número de registros creados en las preferencias
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("registrosCreados", 1);
                editor.apply();
            } else{
                Toast.makeText(this, "Error al guardar registros", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
