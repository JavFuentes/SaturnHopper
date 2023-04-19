package com.example.saturnhopper.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "datos.db";
    private static final String TABLE_PAQUETES_VIAJE = "paquetes_viaje";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PAQUETES_VIAJE + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "destino TEXT NOT NULL," +
                "base_lunar TEXT NOT NULL," +
                "duracion INTEGER NOT NULL," +
                "precio INTEGER NOT NULL," +
                "imagen INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PAQUETES_VIAJE);
        onCreate(sqLiteDatabase);
    }
}
