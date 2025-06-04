package EjerciciosT1;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio5 {
    public static void main(String[] args) {
        Map<String, Double> productos = new HashMap<>();
        productos.put("Manzana", 1.20);
        productos.put("Pan", 0.80);
        productos.put("Leche", 1.50);
        productos.put("Huevos", 2.00);

        System.out.println("Productos disponibles:");
        for (String producto : productos.keySet()) {
            System.out.println(producto);
        }

        System.out.println("\nPrecios de los productos:");
        for (Double precio : productos.values()) {
            System.out.println(precio);
        }

        System.out.println("\nListado completo de productos y precios:");
        for (Map.Entry<String, Double> entry : productos.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }

        List<Map.Entry<String, Double>> listaEntradas = new ArrayList<>(productos.entrySet());

        listaEntradas.sort(Comparator.comparing(Map.Entry::getValue));

        System.out.println("Productos ordenados por precio:");
        for (Map.Entry<String, Double> entry : listaEntradas) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }

        Map<String, List<String>> asignaturas = new HashMap<>();
        asignaturas.put("Matemáticas", Arrays.asList("Ana", "Luis", "Carlos"));
        asignaturas.put("Historia", Arrays.asList("Luis", "María", "Carlos"));
        asignaturas.put("Biología", Arrays.asList("Ana", "Carlos", "Jorge"));

        Map<String, Integer> contadorNombres = new HashMap<>();

        for (List<String> estudiantes : asignaturas.values()) {
            for (String nombre : estudiantes) {
                contadorNombres.put(nombre, contadorNombres.getOrDefault(nombre, 0) + 1);
            }
        }

        System.out.println("Estudiantes en más de una asignatura:");
        for (Map.Entry<String, Integer> entry : contadorNombres.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " (en " + entry.getValue() + " asignaturas)");
            }
        }
    }
}

