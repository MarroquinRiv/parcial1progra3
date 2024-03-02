package edu.ejercicios.ListaEnlazada;

public class ImprimirLista {
    // Método para imprimir la lista enlazada
    public static void imprimirLista(Nodos head) {
        Nodos current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
