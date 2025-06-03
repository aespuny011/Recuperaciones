package EjerciciosT1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio1 {

	public static void main(String[] args) {
		List<Integer> num = new ArrayList<>();

	    for (int i = 1; i <= 5; i++) {
	    	num.add(i);
	    }
	    System.out.println("Lista de enteros del 1 al 5: " + num);
	    
	    Set<Integer> numeros = new HashSet<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(2); 
        numeros.add(4);
        numeros.add(1); 
        numeros.add(5);

        System.out.println("Elementos en el set: " + numeros);

        System.out.println("Cantidad de elementos únicos: " + numeros.size());
       
        List<String> nombres = new ArrayList<>();
        nombres.add("Noelia");
        nombres.add("Juan");
        nombres.add("Carlos");
        nombres.add("Jaime");

        System.out.println("Recorrido con for tradicional:");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("Nombre en posición " + i + ": " + nombres.get(i));
        }

        System.out.println("\nRecorrido con foreach:");
        for (String nombre : nombres) {
            System.out.println("Nombre: " + nombre);
	    }
	}    
}

