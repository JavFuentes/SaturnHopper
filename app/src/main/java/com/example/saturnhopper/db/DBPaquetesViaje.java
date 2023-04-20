package com.example.saturnhopper.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.saturnhopper.PaqueteViaje;

import java.util.ArrayList;

public class DBPaquetesViaje extends DBHelper{
    Context context;

    public DBPaquetesViaje(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarPaqueteViaje(String destino, String base_lunar, int duracion, double precio, int imagen){
        long id = 0;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("destino", destino);
            values.put("base_lunar", base_lunar);
            values.put("duracion", duracion);
            values.put("precio", precio);
            values.put("imagen", imagen);

            id = db.insert(TABLE_PAQUETES_VIAJE, null, values);

        } catch(Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<PaqueteViaje> mostrarPaquetesViaje(){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<PaqueteViaje> listaPaqueteViajes = new ArrayList<>();
        PaqueteViaje paqueteViaje = null;
        Cursor cursorPaquetesViaje = null;

        cursorPaquetesViaje = db.rawQuery("SELECT * FROM " + TABLE_PAQUETES_VIAJE, null);

        if(cursorPaquetesViaje.moveToFirst()){
            do{
                paqueteViaje = new PaqueteViaje();

                paqueteViaje.setId(cursorPaquetesViaje.getInt(0));
                paqueteViaje.setDestino(cursorPaquetesViaje.getString(1));
                paqueteViaje.setBaseLunar(cursorPaquetesViaje.getString(2));
                paqueteViaje.setDuracion(cursorPaquetesViaje.getInt(3));
                paqueteViaje.setPrecio(cursorPaquetesViaje.getDouble(4));
                paqueteViaje.setImagen(cursorPaquetesViaje.getInt(5));

                listaPaqueteViajes.add(paqueteViaje);
            } while(cursorPaquetesViaje.moveToNext());
        }


        cursorPaquetesViaje.close();

        return listaPaqueteViajes;
    }
}
