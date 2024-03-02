package edu.ejercicios.SerpientesYEscaleras.clases;

public class Jugador {
    private String nombre;
    private int posicion;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicion = 1; // Inicializar la posición del jugador en la casilla 1
    }

    public Jugador() {
        this.nombre = nombre;
        this.posicion = 1; // Inicia en la casilla 1
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }
}

