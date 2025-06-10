package UT7_EjerciciosinterfazComparableyComparator;

public class Docente implements PersonaCentroEducativo {
    private String nombre;
    private int permanencia;
    private double salario;

    public Docente(String nombre, int permanencia, double salario) {
        this.nombre = nombre;
        this.permanencia = permanencia;
        this.salario = salario;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

