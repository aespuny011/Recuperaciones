package UT7_EjerciciosIterableyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CatalogoLibros implements Iterable<Libro> {
 private List<Libro> lista = new ArrayList<>();

 public void add(Libro libro) {
     lista.add(libro);
 }

 @Override
 public Iterator<Libro> iterator() {
     return lista.iterator();
 }

 public Iterable<Libro> publicadosDespuesDe(int anio) {
     return new Iterable<Libro>() {
         @Override
         public Iterator<Libro> iterator() {
             return new Iterator<Libro>() {
                 private int idx = 0;
                 private Libro siguienteFiltrado = buscarSiguiente();

                 private Libro buscarSiguiente() {
                     while (idx < lista.size()) {
                         Libro l = lista.get(idx++);
                         if (l.getAnioPublicacion() > anio) {
                             return l;
                         }
                     }
                     return null;
                 }

                 @Override
                 public boolean hasNext() {
                     return siguienteFiltrado != null;
                 }

                 @Override
                 public Libro next() {
                     Libro actual = siguienteFiltrado;
                     siguienteFiltrado = buscarSiguiente();
                     return actual;
                 }
             };
         }
     };
 }
}

