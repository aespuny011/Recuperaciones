package DAO;

import Conexion.ConexionMDB;
import DTO.Autor;
import java.sql.*;
import java.util.ArrayList;

public class AutorDAO {

    public void insertarAutor(String nombre, String pais) {
        String sql = "INSERT INTO Autor (nombre, pais) VALUES (?, ?)";

        try (Connection conn = ConexionMDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, pais);
            stmt.executeUpdate();
            System.out.println("Autor insertado.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Autor> obtenerAutores() {
        ArrayList<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM Autor";

        try (Connection conn = ConexionMDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                autores.add(new Autor(
                        rs.getInt("id_autor"),
                        rs.getString("nombre"),
                        rs.getString("pais")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autores;
    }

    public Autor buscarPorId(int id) {
        String sql = "SELECT * FROM Autor WHERE id_autor = ?";
        try (Connection conn = ConexionMDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Autor(rs.getInt("id_autor"), rs.getString("nombre"), rs.getString("pais"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

