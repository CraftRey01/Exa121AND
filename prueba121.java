import java.util.HashSet;
import java.util.LinkedList;

public class EliminarRepetidos {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(2);
        lista.add(4);
        lista.add(3);

        System.out.println("Lista original: " + lista);
        eliminarRepetidos(lista);
        System.out.println("Lista sin repetidos: " + lista);
    }

    public static void eliminarRepetidos(LinkedList<Integer> lista) {
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> sinRepetidos = new LinkedList<>();

        for (Integer elemento : lista) {
            if (set.add(elemento)) {
                // Si el elemento se añade al conjunto, es único
                sinRepetidos.add(elemento);
            } else {
                // Si el elemento ya está en el conjunto, no lo añadimos a la lista
                sinRepetidos.remove(elemento);
            }
        }

        // Actualizar la lista original con los elementos sin repetir
        lista.clear();
        lista.addAll(sinRepetidos);
    }
}
