package UT8_PartettodeFicherosdetexto;

import java.io.*;
import java.util.StringJoiner;

public class Capitalizador {

    // Método que transforma cada palabra del archivo para que empiece con mayúscula
    public static void capitalizarPalabrasArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        StringBuilder contenidoModificado = new StringBuilder();

        // Leer y transformar
        try (
            BufferedReader br = new BufferedReader(new FileReader(archivo))
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.trim().split("\\s+");
                StringJoiner lineaNueva = new StringJoiner(" ");
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        String palabraCapitalizada = palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
                        lineaNueva.add(palabraCapitalizada);
                    }
                }
                contenidoModificado.append(lineaNueva.toString()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Escribir el contenido modificado en el mismo archivo
        try (
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))
        ) {
            bw.write(contenidoModificado.toString());
            System.out.println("Archivo modificado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    // Método principal para probarlo
    public static void main(String[] args) {
        String archivo = "ejemplo2.txt"; // Asegúrate de que el archivo exista
        capitalizarPalabrasArchivo(archivo);
    }
}

