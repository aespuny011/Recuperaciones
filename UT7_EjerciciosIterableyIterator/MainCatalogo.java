package UT7_EjerciciosIterableyIterator;

public class MainCatalogo {
 public static void main(String[] args) {
     CatalogoLibros cat = new CatalogoLibros();
     cat.add(new Libro("1984", "George Orwell", 1949));
     cat.add(new Libro("El nombre del viento", "Patrick Rothfuss", 2007));
     cat.add(new Libro("Don Quijote", "Miguel de Cervantes", 1605));
     cat.add(new Libro("La sombra del viento", "Carlos Ruiz Zafón", 2001));

     System.out.println("Todos los libros:");
     for (Libro l : cat) {
         System.out.println("  " + l);
     }

     System.out.println("\nPublicados después de 2000:");
     for (Libro l : cat.publicadosDespuesDe(2000)) {
         System.out.println("  " + l);
     }
 }
}

