package com.example.saturnhopper.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.saturnhopper.PaqueteViaje;

import java.util.ArrayList;

// Clase que extiende de DBHelper para interactuar con la tabla
public class DBPaquetesViaje extends DBHelper {
    Context context;

    // Constructor que recibe un contexto y llama al constructor de la superclase
    public DBPaquetesViaje(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    // Método para insertar un registro en la tabla "paquetes_viaje"
    public long insertarPaqueteViaje(String destino, String base_lunar, int duracion, double precio, int imagen_cardview, int imagen_detalle) {
        long id = 0;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            // Agregar valores a la ContentValues
            values.put("destino", destino);
            values.put("base_lunar", base_lunar);
            values.put("duracion", duracion);
            values.put("precio", precio);
            values.put("imagen_cardview", imagen_cardview);
            values.put("imagen_detalle", imagen_detalle);

            // Insertar los valores en la tabla
            id = db.insert(TABLE_PAQUETES_VIAJE, null, values);

        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    // Método para obtener todos los registros de la tabla "paquetes_viaje" y devolverlos en un ArrayList
    public ArrayList<PaqueteViaje> mostrarPaquetesViaje() {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<PaqueteViaje> listaPaqueteViajes = new ArrayList<>();
        PaqueteViaje paqueteViaje = null;
        Cursor cursorPaquetesViaje = null;

        // Obtener todos los registros de la tabla
        cursorPaquetesViaje = db.rawQuery("SELECT * FROM " + TABLE_PAQUETES_VIAJE, null);

        if (cursorPaquetesViaje.moveToFirst()) {
            do {
                paqueteViaje = new PaqueteViaje();

                // Obtener valores del cursor y asignarlos al objeto PaqueteViaje
                paqueteViaje.setId(cursorPaquetesViaje.getInt(0));
                paqueteViaje.setDestino(cursorPaquetesViaje.getString(1));
                paqueteViaje.setBaseLunar(cursorPaquetesViaje.getString(2));
                paqueteViaje.setDuracion(cursorPaquetesViaje.getInt(3));
                paqueteViaje.setPrecio(cursorPaquetesViaje.getDouble(4));
                paqueteViaje.setImagenCardView(cursorPaquetesViaje.getInt(5));
                paqueteViaje.setImagenDetalle(cursorPaquetesViaje.getInt(6));

                listaPaqueteViajes.add(paqueteViaje);
            } while (cursorPaquetesViaje.moveToNext());
        }

        cursorPaquetesViaje.close();

        return listaPaqueteViajes;
    }
}