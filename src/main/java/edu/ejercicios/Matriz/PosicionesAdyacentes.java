package edu.ejercicios.Matriz;

import java.util.ArrayList;
import java.util.List;

public class PosicionesAdyacentes {
    // Método para encontrar las posiciones adyacentes en una matriz dada una posición (fila, columna)
    public int[][] encontrarPosicionesAdyacentes(int[][] matriz, int fila, int columna) {
        // Definir las coordenadas de las posiciones adyacentes
        int[][] adyacentes = {
                {fila - 1, columna}, // Arriba
                {fila + 1, columna}, // Abajo
                {fila, columna - 1}, // Izquierda
                {fila, columna + 1}  // Derecha
        };

        return adyacentes;
    }
}