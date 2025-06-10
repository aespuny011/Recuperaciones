package EjerciciosT7;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio2 {

	public static void main(String[] args) {
		ArrayList<String> palabras = new ArrayList<String>();
		palabras.add("Mesa");
		palabras.add("Silla");
		palabras.add("Papelera");
		palabras.add("Pizarra");
		palabras.add("Puerta");
		System.out.println("Palabras en mayúscula: ");

		Iterator<String> mayus = palabras.iterator();
		while (mayus.hasNext()) {
			String palabra = mayus.next();
			System.out.println(palabra.toUpperCase());
		}
	}
}
