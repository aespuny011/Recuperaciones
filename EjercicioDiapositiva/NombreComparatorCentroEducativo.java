package UT7_EjerciciosinterfazComparableyComparator;

import java.util.Comparator;

public class NombreComparatorCentroEducativo implements Comparator<PersonaCentroEducativo> {
    @Override
    public int compare(PersonaCentroEducativo p1, PersonaCentroEducativo p2) {
        String n1 = p1.getNombre();
        String n2 = p2.getNombre();
        if (n1 == null && n2 == null) return 0;
        if (n1 == null) return 1;
        if (n2 == null) return -1;
        return n1.compareTo(n2);
    }
}

