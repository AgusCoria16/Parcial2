package servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.libro;

public class Biblioteca {
    private List<libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(libro libro) {
        libros.add(libro);
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            for (libro libro : libros) {
                System.out.println(libro);
            }
        }
    }

    public libro buscarPorTitulo(String titulo) {
        for (libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public void eliminarLibro(String titulo) {
        Iterator<libro> iter = libros.iterator();
        while (iter.hasNext()) {
            libro libro = iter.next();
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                iter.remove();
                System.out.println("Libro eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún libro con ese título.");
    }
}
