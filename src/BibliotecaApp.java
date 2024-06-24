import java.util.Scanner;

import modelo.libro;
import servicio.Biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    // Agregar un nuevo libro
                    agregarLibro(scanner, biblioteca);
                    break;
                case 2:
                    // Listar todos los libros
                    biblioteca.listarLibros();
                    break;
                case 3:
                    // Buscar un libro por título
                    buscarLibro(scanner, biblioteca);
                    break;
                case 4:
                    // Eliminar un libro
                    eliminarLibro(scanner, biblioteca);
                    break;
                case 5:
                    // Salir de la aplicación
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar un nuevo libro");
        System.out.println("2. Listar todos los libros");
        System.out.println("3. Buscar un libro por título");
        System.out.println("4. Eliminar un libro");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
        System.out.println("\n______________________________");
    }

    private static void agregarLibro(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("\n--- Agregar un nuevo libro ---");
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el año de publicación: ");
        int anio = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Ingrese el género del libro: ");
        String genero = scanner.nextLine();

        libro libro = new libro(titulo, autor, anio, genero);
        biblioteca.agregarLibro(libro);
        System.out.println("Libro agregado correctamente.");
        System.out.println("\n______________________________");
    }

    private static void buscarLibro(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("\n--- Buscar un libro por título ---");
        System.out.print("Ingrese el título del libro a buscar: ");
        String titulo = scanner.nextLine();

        libro libroEncontrado = biblioteca.buscarPorTitulo(titulo);
        if (libroEncontrado != null) {
            System.out.println("Libro encontrado:");
           System.out.println(libroEncontrado);
        } else {
            System.out.println("No se encontró ningún libro con ese título.");
        }
        System.out.println("\n______________________________");
    }

    private static void eliminarLibro(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("\n--- Eliminar un libro ---");
        System.out.print("Ingrese el título del libro a eliminar: ");
        String titulo = scanner.nextLine();

        biblioteca.eliminarLibro(titulo);
        System.out.println("\n______________________________");
    }
}
