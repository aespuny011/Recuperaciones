package UT7_EjerciciosIterableyIterator;

public class Libro {
 private String titulo;
 private String autor;
 private int anioPublicacion;

 public Libro(String titulo, String autor, int anioPublicacion) {
     this.titulo = titulo;
     this.autor = autor;
     this.anioPublicacion = anioPublicacion;
 }

 public String getTitulo() { return titulo; }
 public String getAutor() { return autor; }
 public int getAnioPublicacion() { return anioPublicacion; }

 @Override
 public String toString() {
     return String.format("%s — %s (%d)", titulo, autor, anioPublicacion);
 }
}


