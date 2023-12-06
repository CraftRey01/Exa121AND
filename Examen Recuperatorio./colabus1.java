import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CSNormal csNormal = new CSNormal();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos en la cola: ");
        int cantidadElementos = scanner.nextInt();

        System.out.println("Ingrese los elementos en la cola:");

        for (int i = 0; i < cantidadElementos; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            int elemento = scanner.nextInt();
            csNormal.encolar(elemento);
        }

        System.out.print("Ingrese el número a verificar en la cola: ");
        int M = scanner.nextInt();

        // Verificar si M se encuentra en la cola
        boolean seEncuentra = csNormal.verificarNumeroEnCola(M);

        if (seEncuentra) {
            System.out.println("Sí se encuentra");
        } else {
            System.out.println("No se encuentra");
        }

        scanner.close();
    }
}

class CSNormal {

    private Queue<Integer> colaSimple = new LinkedList<>();

    public void encolar(int elemento) {
        colaSimple.add(elemento);
    }

    public boolean verificarNumeroEnCola(int M) {
        while (!colaSimple.isEmpty()) {
            int elemento = colaSimple.poll();
            if (elemento == M) {
                return true;
            }
        }
        return false;
    }
}