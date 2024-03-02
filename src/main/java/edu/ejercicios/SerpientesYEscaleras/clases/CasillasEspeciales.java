package edu.ejercicios.SerpientesYEscaleras.clases;

public class CasillasEspeciales {
    public final int[] origenCasillasEspeciales = {7, 11, 31, 30, 40, 43, 50, 59};
    public final int[] destinoCasillasEspeciales = {38, 37, 46, 2, 21, 60, 5, 42};

    public int obtenerNuevaPosicion(int posicion) {
        for (int i = 0; i < origenCasillasEspeciales.length; i++) {
            if (posicion == origenCasillasEspeciales[i]) {
                return destinoCasillasEspeciales[i];
            }
        }
        return posicion;
    }
}
