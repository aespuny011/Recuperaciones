package EjerciciosT7;

import java.util.*;
	class Alumno implements Comparable<Alumno> {
	    private String nombre;
	    private double nota;

	    public Alumno(String nombre, double nota) {
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
	    public int compareTo(Alumno otro) {
	        return Double.compare(this.nota, otro.nota);
	    }

	    @Override
	    public String toString() {
	        return nombre + " (" + nota + ")";
	    }
	}

	public class Ejercicio3 {
	    public static void main(String[] args) {
	        List<Alumno> alumnos = new ArrayList<>();
	        alumnos.add(new Alumno("Carlos", 8.5));
	        alumnos.add(new Alumno("Ana", 9.2));
	        alumnos.add(new Alumno("Beatriz", 7.8));
	        alumnos.add(new Alumno("Daniel", 6.4));
	        alumnos.add(new Alumno("Eva", 9.0));

	        Collections.sort(alumnos);
	        System.out.println("Ordenados por nota:");
	        for (Alumno a : alumnos) {
	            System.out.println(a);
	        }

	        alumnos.sort(Comparator.comparing(Alumno::getNombre));
	        System.out.println("\nOrdenados por nombre:");
	        for (Alumno a : alumnos) {
	            System.out.println(a);
	        }
	    }
	}
