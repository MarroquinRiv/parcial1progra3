package edu.ejercicios;

import static org.junit.jupiter.api.Assertions.*;
import edu.ejercicios.ListaEnlazada.Nodos;
import edu.ejercicios.ListaEnlazada.OrdenAscendente;
import edu.ejercicios.Matriz.PosicionesAdyacentes;
import edu.ejercicios.SerpientesYEscaleras.clases.Juego;
import edu.ejercicios.SerpientesYEscaleras.clases.Jugador;
import edu.ejercicios.SerpientesYEscaleras.clases.Tablero;
import edu.ejercicios.SerpientesYEscaleras.clases.InteraccionUsuario;
import edu.ejercicios.SerpientesYEscaleras.clases.Dado;
import edu.ejercicios.SerpientesYEscaleras.clases.CasillasEspeciales;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testHaGanadoAlgunJugador() {
        // Crear los jugadores
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        // Crear los objetos necesarios
        Tablero tablero = new Tablero();
        Dado dado = new Dado();
        CasillasEspeciales casillasEspeciales = new CasillasEspeciales();
        InteraccionUsuario interaccionUsuario = new InteraccionUsuario();

        // Crear el objeto Juego y empezar a jugar
        Juego juego = new Juego(tablero, new Jugador[]{jugador1, jugador2}, dado, casillasEspeciales, interaccionUsuario);

        // Jugar hasta que alguien gane o se acaben las casillas
        while (!juego.haGanadoAlgunJugador() && jugador1.getPosicion() < tablero.obtenerNumeroCasillas()) {
            juego.jugarTurno();
        }

        // Verificar si algún jugador ha ganado
        assertTrue(juego.haGanadoAlgunJugador(), "Al menos un jugador debería haber ganado.");
    }

    @Test
    public void testInciso2() {
        // Pruebas unitarias para inciso2()
        // Preparar datos de prueba
        int fila = 1;
        int columna = 1;
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        PosicionesAdyacentes posicionesAdyacentes = new PosicionesAdyacentes();

        // Ejecutar el método
        int[][] adyacentes = posicionesAdyacentes.encontrarPosicionesAdyacentes(matriz, fila, columna);

        // Verificar el resultado esperado
        assertEquals(0, adyacentes[0][0]);
        assertEquals(1, adyacentes[0][1]);

        assertEquals(2, adyacentes[1][0]);
        assertEquals(1, adyacentes[1][1]);

        assertEquals(1, adyacentes[2][0]);
        assertEquals(0, adyacentes[2][1]);

        assertEquals(1, adyacentes[3][0]);
        assertEquals(2, adyacentes[3][1]);
    }

    @Test
    public void testInciso3() {
        // Prueba 1: [4, 2, 1, 3]
        Nodos head1 = new Nodos(4);
        head1.next = new Nodos(2);
        head1.next.next = new Nodos(1);
        head1.next.next.next = new Nodos(3);
        OrdenAscendente ordenAscendente = new OrdenAscendente();
        Nodos resultado1 = ordenAscendente.ordenarLista(head1);
        assertEquals(1, resultado1.val);
        assertEquals(2, resultado1.next.val);
        assertEquals(3, resultado1.next.next.val);
        assertEquals(4, resultado1.next.next.next.val);

        // Prueba 2: [-1, 5, 3, 4, 0]
        Nodos head2 = new Nodos(-1);
        head2.next = new Nodos(5);
        head2.next.next = new Nodos(3);
        head2.next.next.next = new Nodos(4);
        head2.next.next.next.next = new Nodos(0);
        Nodos resultado2 = ordenAscendente.ordenarLista(head2);
        assertEquals(-1, resultado2.val);
        assertEquals(0, resultado2.next.val);
        assertEquals(3, resultado2.next.next.val);
        assertEquals(4, resultado2.next.next.next.val);
        assertEquals(5, resultado2.next.next.next.next.val);

        // Prueba 3: Lista vacía
        Nodos head3 = null;
        Nodos resultado3 = ordenAscendente.ordenarLista(head3);
        assertNull(resultado3); // Verificar si la lista ordenada está vacía (null)
    }
}