package edu.ejercicios.ListaEnlazada;

public class OrdenAscendente {
    public Nodos ordenarLista(Nodos head) {
        if (head == null || head.next == null) {
            return head;
        }

        Nodos current = head;
        while (current != null) {
            Nodos minNode = current;
            Nodos innerCurrent = current.next;

            while (innerCurrent != null) {
                if (innerCurrent.val < minNode.val) {
                    minNode = innerCurrent;
                }
                innerCurrent = innerCurrent.next;
            }

            int temp = current.val;
            current.val = minNode.val;
            minNode.val = temp;

            current = current.next;
        }

        return head;
    }
}
