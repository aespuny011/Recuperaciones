package UT7_EjerciciosinterfazComparableyComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Instituto {
    public static void main(String[] args) {
        ArrayList<PersonaCentroEducativo> instituto = new ArrayList<>();

        instituto.add(new Alumno("Juan", "123A", 18));
        instituto.add(new Alumno("Noelia", "456B", 19));
        instituto.add(new Alumno("Carla", "789C", 20));
        instituto.add(new Alumno(null, "000X", 21));
        instituto.add(new Docente("Jaime", 5, 2000));
        instituto.add(new Docente("Adriano", 10, 3000));
        instituto.add(new Docente("Carlos", 3, 2500));

        System.out.println("Antes de ordenar:");
        System.out.println(instituto);

        Collections.sort(instituto, new NombreComparatorCentroEducativo());

        System.out.println("Después de ordenar por nombre:");
        System.out.println(instituto);
    }
}
