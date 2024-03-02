package edu.ejercicios;

import edu.ejercicios.ListaEnlazada.Nodos;
import edu.ejercicios.ListaEnlazada.OrdenAscendente;
import edu.ejercicios.SerpientesYEscaleras.clases.*;
import edu.ejercicios.Matriz.PosicionesAdyacentes;
import edu.ejercicios.ListaEnlazada.ImprimirLista;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        inciso1();
        inciso2();
        inciso3();
    }

    public static void inciso1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a Serpientes y Escaleras!");

        System.out.print("Ingrese el nombre del primer jugador: ");
        String nombreJugador1 = scanner.nextLine();
        Jugador jugador1 = new Jugador(nombreJugador1);

        System.out.print("Ingrese el nombre del segundo jugador: ");
        String nombreJugador2 = scanner.nextLine();
        Jugador jugador2 = new Jugador(nombreJugador2);

        // Crear los objetos necesarios
        Tablero tablero = new Tablero();
        Dado dado = new Dado();
        CasillasEspeciales casillasEspeciales = new CasillasEspeciales();
        InteraccionUsuario interaccionUsuario = new InteraccionUsuario();

        // Crear el objeto Juego y empezar a jugar
        Juego juego = new Juego(tablero, new Jugador[]{jugador1, jugador2}, dado, casillasEspeciales, interaccionUsuario);
        juego.jugar();
    }

    public static void inciso2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la posición en la matriz para encontrar las posiciones adyacentes:");
        System.out.print("Fila: ");
        int fila = scanner.nextInt();
        System.out.print("Columna: ");
        int columna = scanner.nextInt();

        // Definir la matriz
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Crear instancia de PosicionesAdyacentes
        PosicionesAdyacentes posicionesAdyacentes = new PosicionesAdyacentes();

        // Encontrar posiciones adyacentes
        System.out.println("Posiciones adyacentes a la posición (" + fila + ", " + columna + "):");
        int[][] adyacentes = posicionesAdyacentes.encontrarPosicionesAdyacentes(matriz, fila, columna);
        for (int i = 0; i < adyacentes.length; i++) {
            System.out.println("(" + adyacentes[i][0] + ", " + adyacentes[i][1] + ")");
        }
    }

    public static void inciso3() {
        // Crear la lista enlazada
        Nodos head = new Nodos(4);
        head.next = new Nodos(2);
        head.next.next = new Nodos(1);
        head.next.next.next = new Nodos(3);

        // Imprimir la lista original
        System.out.println("Lista original:");
        ImprimirLista.imprimirLista(head);

        // Ordenar la lista enlazada
        OrdenAscendente ordenador = new OrdenAscendente();
        head = ordenador.ordenarLista(head);

        // Imprimir la lista ordenada
        System.out.println("\nLista ordenada:");
        ImprimirLista.imprimirLista(head);
    }
}