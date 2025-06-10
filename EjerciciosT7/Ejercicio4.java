package EjerciciosT7;

import java.util.*;

class Alumno1 {
    private String nombre;
    private double nota;

    public Alumno1(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return nombre + " (" + nota + ")";
    }
}

public class Ejercicio4 {
    public static void main(String[] args) {
        List<Alumno> alumnos = Arrays.asList(
            new Alumno("Carlos", 8.5),
            new Alumno("Ana", 9.2),
            new Alumno("Beatriz", 7.8),
            new Alumno("Daniel", 6.4),
            new Alumno("Eva", 9.0)
        );

        // Ordenar por longitud del nombre
        alumnos.sort(Comparator.comparingInt(a -> a.getNombre().length()));
        System.out.println("Ordenados por longitud del nombre:");
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
        
        alumnos.sort(Comparator
            .comparingDouble(Alumno::getNota).reversed()
            .thenComparing(Alumno::getNombre)
        );
        System.out.println("\nOrdenados por nota descendente y nombre:");
        for (Alumno a : alumnos) {
            System.out.println(a);
        }

        Comparator<Alumno> compNotaNombre = Comparator
            .comparingDouble(Alumno::getNota).reversed()
            .thenComparing(Alumno::getNombre);

        Set<Alumno> conjuntoOrdenado = new TreeSet<>(compNotaNombre);
        conjuntoOrdenado.addAll(alumnos);

        System.out.println("\nTreeSet (ordenado por nota descendente y nombre):");
        for (Alumno a : conjuntoOrdenado) {
            System.out.println(a);
        }
    }
}

