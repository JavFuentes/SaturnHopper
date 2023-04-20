// Define el paquete al que pertenece la clase
package com.example.saturnhopper;

// Definición de la clase PaqueteViaje
public class PaqueteViaje {
    // Identificador único del paquete de viaje
    private int id;

    // Nombre del destino del viaje
    private String destino;

    // Nombre de la base lunar desde donde se hospedarán los turistas
    private String baseLunar;

    // Duración de la estancia en la luna de destino (En años)
    private int duracion;

    // Precio del paquete de viaje
    private double precio;

    // ID de la imagen asociada al paquete de viaje
    private int imagen;

    public PaqueteViaje(int id, String destino, String baseLunar, int duracion, double precio, int imagen) {
        this.id = id;
        this.destino = destino;
        this.baseLunar = baseLunar;
        this.duracion = duracion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public PaqueteViaje(){

    }

    // Métodos getters y setters para acceder a los atributos de la clase
    public int getId() {return id;}

    public void setId(int id){this.id = id;}

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

    // Método para convertir el objeto a una cadena de texto
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