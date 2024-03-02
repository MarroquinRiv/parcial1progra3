package edu.ejercicios.SerpientesYEscaleras.clases;
import java.util.Scanner;
import edu.ejercicios.SerpientesYEscaleras.clases.Jugador;

public class InteraccionUsuario {
    private final Scanner scanner;

    public InteraccionUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public void solicitarLanzamientoDado(Jugador jugador) {
        System.out.println("¡Es el turno de " + jugador.getNombre() + "! Presione Enter para lanzar el dado.");
    }

    public void esperarInputEnter() {
        scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

