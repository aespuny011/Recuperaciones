package Main;

import DAO.AutorDAO;
import DAO.LibroDAO;
import DTO.Autor;
import DTO.Libro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutorDAO autorDAO = new AutorDAO();
        LibroDAO libroDAO = new LibroDAO();
        int opcion;

        do {
            System.out.println("\n=== Gestión de Biblioteca ===");
            System.out.println("1. Insertar autor");
            System.out.println("2. Ver autores");
            System.out.println("3. Insertar libro");
            System.out.println("4. Ver libros");
            System.out.println("5. Modificar título de un libro");
            System.out.println("6. Eliminar un libro");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del autor: ");
                    String nombre = sc.nextLine();
                    System.out.print("País del autor: ");
                    String pais = sc.nextLine();
                    autorDAO.insertarAutor(nombre, pais);
                    break;
                case 2:
                    for (Autor a : autorDAO.obtenerAutores()) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    System.out.print("Título del libro: ");
                    String titulo = sc.nextLine();
                    System.out.print("Año de publicación: ");
                    int anio = sc.nextInt();
                    System.out.print("ID del autor: ");
                    int idAutor = sc.nextInt();
                    sc.nextLine();
                    libroDAO.insertarLibro(titulo, anio, idAutor);
                    break;
                case 4:
                    for (Libro l : libroDAO.obtenerLibros()) {
                        System.out.println(l);
                    }
                    break;
                case 5:
                    System.out.print("ID del libro a modificar: ");
                    int idLibro = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo título: ");
                    String nuevoTitulo = sc.nextLine();
                    libroDAO.modificarTituloLibro(idLibro, nuevoTitulo);
                    break;
                case 6:
                    System.out.print("ID del libro a eliminar: ");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    libroDAO.eliminarLibro(idEliminar);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}

