package edu.ejercicios.SerpientesYEscaleras.clases;

import java.util.Random;

public class Dado {
    private final Random random;

    public Dado() {
        this.random = new Random();
    }

    public int lanzarDado() {
        return random.nextInt(6) + 1; // Números del 1 al 6
    }
}

