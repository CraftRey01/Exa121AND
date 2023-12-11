import java.util.Scanner;

public class EliminarNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero positivo: ");
        int numeroOriginal = scanner.nextInt();

        System.out.print("Ingrese el dígito a eliminar: ");
        int digitoQ = scanner.nextInt();

        int numeroSinQ = eliminarDigito(numeroOriginal, digitoQ);

        System.out.println("Número original: " + numeroOriginal);
        System.out.println("Número sin el dígito Q: " + numeroSinQ);
        
        scanner.close();
    }

    public static int eliminarDigito(int numero, int digitoQ) {
        return eliminarDigitoRecursivo(numero, digitoQ, 0);
    }

    private static int eliminarDigitoRecursivo(int numero, int digitoQ, int resultado) {
        if (numero == 0) {
            return resultado;
        } else {
            int digito = numero % 10;
            if (digito != digitoQ) {
                resultado = resultado * 10 + digito;
            }
            return eliminarDigitoRecursivo(numero / 10, digitoQ, resultado);
        }
    }
}
