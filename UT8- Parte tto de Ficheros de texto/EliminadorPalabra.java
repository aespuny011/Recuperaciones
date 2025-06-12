package UT8_PartettodeFicherosdetexto;

import java.io.*;

public class EliminadorPalabra {

    // Método que elimina una palabra y guarda el contenido en un nuevo archivo
    public static void eliminarPalabraDeArchivo(String nombreArchivo, String palabraAEliminar) {
        File archivoOriginal = new File(nombreArchivo);

        // Obtener el nuevo nombre del archivo
        String nombreNuevo = obtenerNombreNuevo(nombreArchivo);

        try (
            BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreNuevo))
        ) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Eliminar la palabra usando expresión regular (\b = límite de palabra)
                String nuevaLinea = linea.replaceAll("\\b" + palabraAEliminar + "\\b", "").replaceAll("\\s+", " ").trim();
                bw.write(nuevaLinea);
                bw.newLine();
            }

            System.out.println("Archivo generado: " + nombreNuevo);
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

    // Método auxiliar para generar el nuevo nombre
    private static String obtenerNombreNuevo(String nombreOriginal) {
        int punto = nombreOriginal.lastIndexOf(".");
        if (punto == -1) {
            return nombreOriginal + "_2"; // Sin extensión
        } else {
            return nombreOriginal.substring(0, punto) + "_2" + nombreOriginal.substring(punto);
        }
    }

    // Método principal para probar
    public static void main(String[] args) {
        String archivo = "fichero.txt";
        String palabraAEliminar = "Java";
        eliminarPalabraDeArchivo(archivo, palabraAEliminar);
    }
}

