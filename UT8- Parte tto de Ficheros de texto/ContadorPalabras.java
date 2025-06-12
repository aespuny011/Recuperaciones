package UT8_PartettodeFicherosdetexto;

import java.io.*;

public class ContadorPalabras {

    // Método que crea el archivo si no existe y escribe texto de ejemplo
    public static void crearArchivoSiNoExiste(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            try (FileWriter fw = new FileWriter(archivo)) {
                fw.write("Hola, este es un archivo de ejemplo.\n");
                fw.write("Contiene varias líneas y palabras para contar.\n");
                fw.write("Java es divertido.");
                System.out.println("Archivo creado: " + nombreArchivo);
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }

    // Método que cuenta palabras usando BufferedReader
    public static void contarPalabras(String nombreArchivo) {
        try (
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr)
        ) {
            int palabras = 0;
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] palabrasLinea = linea.trim().split("\\s+");
                palabras += (linea.isEmpty()) ? 0 : palabrasLinea.length;
            }

            System.out.println(nombreArchivo + " contiene " + palabras + " palabras.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Método principal
    public static void main(String[] args) {
        String archivo = "ejemplo.txt";
        crearArchivoSiNoExiste(archivo);
        contarPalabras(archivo);
    }
}


