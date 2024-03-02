package edu.ejercicios.SerpientesYEscaleras.clases;

public class Juego {
    // Atributos que representan los componentes del juego
    private final Tablero tablero;
    private final Jugador[] jugadores;
    private final Dado dado;
    private final CasillasEspeciales casillasEspeciales;
    private final InteraccionUsuario interaccionUsuario;

    // Variables para controlar el estado del juego
    private int turnoActual;
    private int consecutivoSeis;

    // Constructor que inicializa los componentes del juego
    public Juego(Tablero tablero, Jugador[] jugadores, Dado dado, CasillasEspeciales casillasEspeciales, InteraccionUsuario interaccionUsuario) {
        this.tablero = tablero;
        this.jugadores = jugadores;
        this.dado = dado;
        this.casillasEspeciales = casillasEspeciales;
        this.interaccionUsuario = interaccionUsuario;
        this.turnoActual = 0;
        this.consecutivoSeis = 0;
    }

    // Método principal que inicia y controla el juego
    public void jugar() {
        // Mientras no haya ganado algún jugador, continuar el juego
        while (!haGanadoAlgunJugador()) {
            // Mostrar mensaje indicando el turno del jugador actual
            interaccionUsuario.mostrarMensaje("Es el turno de " + jugadores[turnoActual].getNombre());
            // Realizar el turno del jugador actual
            jugarTurno();
            // Pasar al siguiente jugador
            avanzarTurno();
        }
    }

    // Método para jugar el turno de un jugador
    public void jugarTurno() {
        // Lanzar el dado y obtener el resultado
        int resultadoDado = dado.lanzarDado();

        // Si el resultado es 6, verificar si se han obtenido tres 6 consecutivos
        if (resultadoDado == 6) {
            consecutivoSeis++;
            if (consecutivoSeis == 3) {
                // En caso de tres 6 consecutivos, volver al inicio
                jugadores[turnoActual].setPosicion(1);
                consecutivoSeis = 0;
                interaccionUsuario.mostrarMensaje("¡El jugador " + jugadores[turnoActual].getNombre() + " ha sacado tres 6 consecutivos! Regresa a la casilla inicial.");
                return;
            }
        } else {
            // Reiniciar el contador de 6 consecutivos
            consecutivoSeis = 0;
        }

        // Calcular la nueva posición del jugador después de lanzar el dado
        int nuevaPosicion = jugadores[turnoActual].getPosicion() + resultadoDado;
        // Verificar si la nueva posición corresponde a una casilla especial y ajustarla si es necesario
        nuevaPosicion = casillasEspeciales.obtenerNuevaPosicion(nuevaPosicion);
        // Actualizar la posición del jugador
        jugadores[turnoActual].setPosicion(nuevaPosicion);

        // Mostrar mensaje indicando la nueva posición del jugador
        interaccionUsuario.mostrarMensaje("El jugador " + jugadores[turnoActual].getNombre() + " ha sacado un " + resultadoDado + " y está en la casilla " + nuevaPosicion);

        // Verificar si el jugador ha ganado el juego
        if (nuevaPosicion == tablero.obtenerNumeroCasillas()) {
            interaccionUsuario.mostrarMensaje("¡El jugador " + jugadores[turnoActual].getNombre() + " ha ganado!");
        } else if (nuevaPosicion > tablero.obtenerNumeroCasillas()) {
            // Si el jugador se pasa de la última casilla, volver al inicio
            nuevaPosicion = 1;
            jugadores[turnoActual].setPosicion(nuevaPosicion);
            interaccionUsuario.mostrarMensaje("El jugador " + jugadores[turnoActual].getNombre() + " se ha pasado de la casilla 64. Regresa a la casilla 1");
        }
    }

    // Método para avanzar al siguiente turno
    private void avanzarTurno() {
        // Avanzar al siguiente jugador circularmente
        turnoActual = (turnoActual + 1) % jugadores.length;
    }

    // Método para verificar si algún jugador ha ganado el juego
    public boolean haGanadoAlgunJugador() {
        // Iterar sobre los jugadores para verificar si alguno ha alcanzado la última casilla
        for (Jugador jugador : jugadores) {
            if (jugador.getPosicion() == tablero.obtenerNumeroCasillas()) {
                return true;
            }
        }
        return false;
    }
}