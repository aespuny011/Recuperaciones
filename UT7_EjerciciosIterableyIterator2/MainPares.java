package UT7_EjerciciosIterableyIterator2;

public class MainPares {
 public static void main(String[] args) {
     RangoPares pares = new RangoPares(10, 30);
     System.out.println("Pares entre 10 y 30:");
     for (int p : pares) {
         System.out.print(p + " ");
     }
     System.out.println();
 }
}

