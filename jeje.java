import java.util.List;
import java.util.ArrayList;

public class EliminarRepetidos {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
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

    public static void eliminarRepetidos(List<Integer> lista) {
        List<Integer> sinRepetidos = new ArrayList<>();

        for (Integer elemento : lista) {
            if (!sinRepetidos.contains(elemento)) {
                // Si el elemento no está en la lista, lo añadimos
                sinRepetidos.add(elemento);
            }
        }

        // Actualizar la lista original con los elementos sin repetir
        lista.clear();
        lista.addAll(sinRepetidos);
    }
}
