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
    private int imagenCardView;

    //ID de la imagen asociada a la vista de detalle del paquete de viaje
    private int imagenDetalle;

    public PaqueteViaje(int id, String destino, String baseLunar, int duracion, double precio, int imagenCardView, int imagenDetalle) {
        this.id = id;
        this.destino = destino;
        this.baseLunar = baseLunar;
        this.duracion = duracion;
        this.precio = precio;
        this.imagenCardView = imagenCardView;
        this.imagenDetalle = imagenDetalle;
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

    public int getImagenCardView() { return imagenCardView; }

    public void setImagenCardView(int imagen) {
        this.imagenCardView= imagen;
    }

    public int getImagenDetalle() {
        return imagenDetalle;
    }

    public void setImagenDetalle(int imagen) {
        this.imagenDetalle = imagen;
    }

}