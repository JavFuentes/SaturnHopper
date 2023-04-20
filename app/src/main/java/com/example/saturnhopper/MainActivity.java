package com.example.saturnhopper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

import com.example.saturnhopper.db.DBHelper;
import com.example.saturnhopper.db.DBPaquetesViaje;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private long id;
    private int registrosCreados = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("MiPref", Context.MODE_PRIVATE);
        registrosCreados = sharedPreferences.getInt("registrosCreados", 0);

        if(registrosCreados == 0){

            DBHelper dbHelper = new DBHelper(MainActivity.this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            if(db != null){
                Toast.makeText(this, "Base de datos creada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al crear base de datos", Toast.LENGTH_SHORT).show();
            }

            DBPaquetesViaje dbPaquetesViaje = new DBPaquetesViaje(MainActivity.this);
            id = dbPaquetesViaje.insertarPaqueteViaje("Encélado","Cassini",2, 2.5,1);
            id = dbPaquetesViaje.insertarPaqueteViaje("Mimas","The Dome",3, 3.2,2);
            id = dbPaquetesViaje.insertarPaqueteViaje("Tetis","Big Igloo",2, 2.3,3);
            id = dbPaquetesViaje.insertarPaqueteViaje("Titán","Big Carinae",4, 3.8,4);

            if(id > 0){
                Toast.makeText(this, "Registros creados", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("registrosCreados", 1);
                editor.apply();
            } else{
                Toast.makeText(this, "Error al guardar registros", Toast.LENGTH_SHORT).show();
            }
        }
    }
}