// Define el paquete al que pertenece la clase
package com.example.saturnhopper;

// Definición de la clase PaqueteViaje
public class PaqueteViaje {
    // Atributos de la clase: nombre del paquete y una imagen representativa
    private String name;
    private int picture;

    // Constructor de la clase que recibe el nombre y la imagen como argumentos
    public PaqueteViaje(String name, int picture) {
        // Asigna los argumentos a los atributos de la clase
        this.name = name;
        this.picture = picture;
    }

    // Método para obtener el valor del atributo name
    public String getName() {
        return name;
    }

    // Método para asignar un nuevo valor al atributo name
    public void setName(String name) {
        this.name = name;
    }

    // Método para obtener el valor del atributo picture
    public int getPicture() {
        return picture;
    }

    // Método para asignar un nuevo valor al atributo picture
    public void setPicture(int picture) {
        this.picture = picture;
    }
}
