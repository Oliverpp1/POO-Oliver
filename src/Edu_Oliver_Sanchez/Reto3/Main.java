package Edu_Oliver_Sanchez.Reto3;

import java.util.Scanner;

public class Diccionario {

    private static final int MAX_PALABRAS = 10;
    private String[] palabras = new String[MAX_PALABRAS];
    private String[] significados = new String[MAX_PALABRAS];
    private int cantidadPalabras = 0;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Diccionario diccionario = new Diccionario();
        diccionario.ejecutar();
    }

    public void ejecutar() {
        char opcion;
        do {
            mostrarMenu();
            opcion = scanner.next().charAt(0);
            switch (Character.toUpperCase(opcion)) {
                case 'A':
                    enlistarPalabras();
                    break;
                case 'B':
                    buscarPalabra();
                    break;
                case 'C':
                    detalleDiccionario();
                    break;
                case 'S':
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 'S');
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("A. Enlistar palabras del diccionario");
        System.out.println("B. Buscar palabra en el diccionario");
        System.out.println("C. Detalle del diccionario");
        System.out.println("S. Finalizar programa");
        System.out.print("Seleccione una opción: ");
    }

    private void enlistarPalabras() {
        if (cantidadPalabras == 0) {
            System.out.println("El diccionario está vacío.");
        } else {
            System.out.println("Palabras en el diccionario:");
            for (int i = 0; i < cantidadPalabras; i++) {
                System.out.println(palabras[i]);
            }
        }
    }

    private void buscarPalabra() {
        if (cantidadPalabras == 0) {
            System.out.println("El diccionario está vacío.");
            return;
        }
        System.out.print("Ingrese la palabra que desea buscar: ");
        String palabraBuscar = scanner.next();
        boolean encontrada = false;
        for (int i = 0; i < cantidadPalabras; i++) {
            if (palabras[i].equalsIgnoreCase(palabraBuscar)) {
                System.out.println("Significado de " + palabraBuscar + ": " + significados[i]);
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("La palabra '" + palabraBuscar + "' no existe en el diccionario.");
        }
    }

    private void detalleDiccionario() {
        System.out.println("Cantidad de palabras en el diccionario: " + cantidadPalabras);
        System.out.println("Lista de palabras y sus significados:");
        for (int i = 0; i < cantidadPalabras; i++) {
            System.out.println(palabras[i] + " - Significado: " + significados[i]);
        }
    }
}
