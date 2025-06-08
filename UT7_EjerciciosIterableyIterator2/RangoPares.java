package UT7_EjerciciosIterableyIterator2;

import java.util.Iterator;

public class RangoPares implements Iterable<Integer> {
 private final int inicio;
 private final int fin;

 public RangoPares(int inicio, int fin) {
     this.inicio = inicio;
     this.fin = fin;
 }

 @Override
 public Iterator<Integer> iterator() {
     return new Iterator<Integer>() {
         private int actual = (inicio % 2 == 0 ? inicio : inicio + 1);

         @Override
         public boolean hasNext() {
             return actual <= fin;
         }

         @Override
         public Integer next() {
             int valor = actual;
             actual += 2;
             return valor;
         }
     };
 }
}

