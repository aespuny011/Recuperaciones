package DAO;

import Conexion.ConexionMDB;
import DTO.Autor;
import DTO.Libro;

import java.sql.*;
import java.util.ArrayList;

public class LibroDAO {

    private final AutorDAO autorDAO = new AutorDAO();

    public void insertarLibro(String titulo, int anio, int idAutor) {
        String sql = "INSERT INTO Libro (titulo, anio, id_autor) VALUES (?, ?, ?)";

        try (Connection conn = ConexionMDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            stmt.setInt(2, anio);
            stmt.setInt(3, idAutor);
            stmt.executeUpdate();
            System.out.println("Libro insertado.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Libro> obtenerLibros() {
        ArrayList<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libro";

        try (Connection conn = ConexionMDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int idAutor = rs.getInt("id_autor");
                Autor autor = autorDAO.buscarPorId(idAutor);

                libros.add(new Libro(
                        rs.getInt("id_libro"),
                        rs.getString("titulo"),
                        rs.getInt("anio"),
                        autor));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libros;
    }

    public void modificarTituloLibro(int idLibro, String nuevoTitulo) {
        String sql = "UPDATE Libro SET titulo = ? WHERE id_libro = ?";

        try (Connection conn = ConexionMDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevoTitulo);
            stmt.setInt(2, idLibro);
            int filas = stmt.executeUpdate();
            if (filas == 0) System.out.println("Libro no encontrado.");
            else System.out.println("Título actualizado.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarLibro(int idLibro) {
        String sql = "DELETE FROM Libro WHERE id_libro = ?";

        try (Connection conn = ConexionMDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idLibro);
            int filas = stmt.executeUpdate();
            if (filas == 0) System.out.println("Libro no encontrado.");
            else System.out.println("Libro eliminado.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

