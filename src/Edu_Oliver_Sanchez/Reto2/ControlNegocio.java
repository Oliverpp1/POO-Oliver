import java.util.Scanner;

public class ControlNegocio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Autenticación del usuario
        while (!autenticarUsuario(scanner)) {
            System.out.println("Usuario y/o contraseña incorrectos. Inténtelo de nuevo.");
        }

        // Menú principal
        int opcion;
        int cajasCompradas = 0;
        double costoCajas = 0;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Comprar cajas de papel");
            System.out.println("2. Vender cajas de papel");
            System.out.println("3. Mostrar reporte");
            System.out.println("4. Salir del programa");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Número de cajas a comprar: ");
                    int numCajas = scanner.nextInt();
                    System.out.print("Costo de las cajas a comprar: ");
                    double costoPorCaja = scanner.nextDouble();

                    cajasCompradas += numCajas;
                    costoCajas += numCajas * costoPorCaja;

                    System.out.println("La compra realizada por " + numCajas + " cajas al costo " + costoPorCaja +
                            " es igual a " + (numCajas * costoPorCaja));
                    break;

                case 2:
                    // Implementar la lógica de venta si es necesario
                    System.out.println("Opción de venta aún no implementada.");
                    break;

                case 3:
                    System.out.println("\nReporte:");
                    System.out.println("Cajas compradas: " + cajasCompradas);
                    System.out.println("Costo total de cajas compradas: " + costoCajas);
                    break;

                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 4);

        scanner.close();
    }

    private static boolean autenticarUsuario(Scanner scanner) {
        System.out.print("Ingrese el usuario: ");
        String usuario = scanner.next();
        System.out.print("Ingrese la contraseña: ");
        String contraseña = scanner.next();

        // Usuario y contraseña predefinidos (solo para propósitos de ejemplo)
        return usuario.equals("admin") && contraseña.equals("1234");
    }
}
