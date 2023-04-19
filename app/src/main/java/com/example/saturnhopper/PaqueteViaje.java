// Define el paquete al que pertenece la clase
package com.example.saturnhopper;

// Definición de la clase PaqueteViaje
public class PaqueteViaje {
    private int id;
    private String destino;
    private String baseLunar;
    private int duracion;
    private double precio;
    private int imagen;

    public PaqueteViaje(int id, String destino, String baseLunar, int duracion, double precio, int imagen) {
        this.id = id;
        this.destino = destino;
        this.baseLunar = baseLunar;
        this.duracion = duracion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getId() {return id;}

    public void setId(){this.id = id;}

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getBaseLunar() {
        return baseLunar;
    }

    public void setBaseLunar(String baseLunar) {
        this.baseLunar = baseLunar;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "PaqueteViaje{" +
                "destino='" + destino + '\'' +
                ", baseLunar='" + baseLunar + '\'' +
                ", duracion=" + duracion +
                ", precio=" + precio +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}