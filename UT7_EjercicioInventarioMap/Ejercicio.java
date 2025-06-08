package UT7_EjercicioInventarioMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio {

    private static HashMap<String, Integer> productos = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Inventario ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Actualizar stock");
            System.out.println("3. Mostrar cantidad de un producto");
            System.out.println("4. Mostrar stock total");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Mostrar producto con mayor stock");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    añadirProducto(sc);
                    break;
                case 2:
                    actualizarStock(sc);
                    break;
                case 3:
                    mostrarCantidad(sc);
                    break;
                case 4:
                    mostrarStockTotal();
                    break;
                case 5:
                    eliminarProducto(sc);
                    break;
                case 6:
                    mostrarProductoMayorStock();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void añadirProducto(Scanner sc) {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();
        if (productos.containsKey(nombre)) {
            System.out.println("El producto ya existe.");
        } else {
            System.out.print("Cantidad inicial: ");
            int cantidad = sc.nextInt();
            productos.put(nombre, cantidad);
            System.out.println("Producto añadido.");
        }
    }

    private static void actualizarStock(Scanner sc) {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();
        if (productos.containsKey(nombre)) {
            System.out.print("Cantidad a sumar/restar (puede ser negativa): ");
            int cantidad = sc.nextInt();
            int nuevoStock = productos.getOrDefault(nombre, 0) + cantidad;
            productos.put(nombre, Math.max(nuevoStock, 0)); // No permitir stock negativo
            System.out.println("Stock actualizado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void mostrarCantidad(Scanner sc) {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();
        if (productos.containsKey(nombre)) {
            System.out.println("Cantidad disponible: " + productos.get(nombre));
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void mostrarStockTotal() {
        int total = 0;
        for (int cantidad : productos.values()) {
            total += cantidad;
        }
        System.out.println("Stock total: " + total);
    }

    private static void eliminarProducto(Scanner sc) {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();
        if (productos.remove(nombre) != null) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void mostrarProductoMayorStock() {
        if (productos.isEmpty()) {
            System.out.println("Inventario vacío.");
            return;
        }

        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : productos.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        System.out.println("Producto con mayor stock: " + maxEntry.getKey() +
                           " (" + maxEntry.getValue() + " unidades)");
    }
}
