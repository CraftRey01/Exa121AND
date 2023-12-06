import java.util.*;

class Impresora {
    int codigo;
    String marca;
    double precio;
    String industria;

    public Impresora(int codigo, String marca, double precio, String industria) {
        this.codigo = codigo;
        this.marca = marca;
        this.precio = precio;
        this.industria = industria;
    }
}

class Sucursal {
    int num;
    String direccion;
    Stack<Impresora> impresoras;

    public Sucursal(int num, String direccion) {
        this.num = num;
        this.direccion = direccion;
        this.impresoras = new Stack<>();
    }
}

class Responsable {
    int carnet;
    String nombre;

    public Responsable(int carnet, String nombre) {
        this.carnet = carnet;
        this.nombre = nombre;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de impresoras: ");
        int numImpresoras = scanner.nextInt();

        Sucursal sucursal1 = crearSucursal(scanner);
        Sucursal sucursal2 = crearSucursal(scanner);

        Responsable responsable1 = crearResponsable(scanner);
        Responsable responsable2 = crearResponsable(scanner);

        asignarResponsable(sucursal1, responsable1);
        asignarResponsable(sucursal2, responsable2);

        for (int i = 0; i < numImpresoras; i++) {
            Impresora impresora = crearImpresora(scanner);
            System.out.print("Ingrese el número de sucursal (1 o 2) para agregar la impresora: ");
            int numSucursal = scanner.nextInt();

            if (numSucursal == 1) {
                sucursal1.agregarImpresora(impresora);
            } else if (numSucursal == 2) {
                sucursal2.agregarImpresora(impresora);
            }
        }

        Sucursal sucursalConMasImpresoras = encontrarSucursalConMasImpresoras(sucursal1, sucursal2);

        System.out.println("El responsable de la sucursal con más impresoras es: " +
                           sucursalConMasImpresoras.responsable.nombre);
    }

    public static Sucursal crearSucursal(Scanner scanner) {
        System.out.print("Ingrese el número de la sucursal: ");
        int num = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese la dirección de la sucursal: ");
        String direccion = scanner.nextLine();
        return new Sucursal(num, direccion);
    }

    public static Responsable crearResponsable(Scanner scanner) {
        System.out.print("Ingrese el carnet del responsable: ");
        int carnet = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese el nombre del responsable: ");
        String nombre = scanner.nextLine();
        return new Responsable(carnet, nombre);
    }

    public static Impresora crearImpresora(Scanner scanner) {
        System.out.print("Ingrese el código de la impresora: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese la marca de la impresora: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el precio de la impresora: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese la industria de la impresora: ");
        String industria = scanner.nextLine();
        return new Impresora(codigo, marca, precio, industria);
    }

    public static void asignarResponsable(Sucursal sucursal, Responsable responsable) {
        sucursal.responsable = responsable;
    }

    public static Sucursal encontrarSucursalConMasImpresoras(Sucursal sucursal1, Sucursal sucursal2) {
        return sucursal1.impresoras.size() > sucursal2.impresoras.size() ? sucursal1 : sucursal2;
    }
}
