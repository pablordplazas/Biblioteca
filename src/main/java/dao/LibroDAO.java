package dao;

import conexion.Conexion;
import modelo.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    // ✅ INSERTAR LIBRO
    public boolean insertar(Libro libro) {
        String sql = "INSERT INTO libros (titulo, autorid, genero, aniopublicacion) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setInt(2, libro.getAutorid());
            ps.setString(3, libro.getGenero());
            ps.setInt(4, libro.getAnioPublicacion());
            ps.executeUpdate();

            System.out.println("✅ Libro insertado correctamente.");
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar libro: " + e.getMessage());
            return false;
        }
    }

    // ✅ LISTAR LIBROS
    public List<Libro> listar() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Libro l = new Libro();
                l.setLibroid(rs.getInt("libroid"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutorid(rs.getInt("autorid"));
                l.setGenero(rs.getString("genero"));
                l.setAnioPublicacion(rs.getInt("aniopublicacion"));
                lista.add(l);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar libros: " + e.getMessage());
        }

        return lista;
    }

    // ✅ ACTUALIZAR LIBRO
    public boolean actualizar(Libro libro) {
        String sql = "UPDATE libros SET titulo = ?, autorid = ?, genero = ?, aniopublicacion = ? WHERE libroid = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setInt(2, libro.getAutorid());
            ps.setString(3, libro.getGenero());
            ps.setInt(4, libro.getAnioPublicacion());
            ps.setInt(5, libro.getLibroid());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar libro: " + e.getMessage());
            return false;
        }
    }

    // ✅ ELIMINAR LIBRO
    public boolean eliminar(int libroid) {
        String sql = "DELETE FROM libros WHERE libroid = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, libroid);
            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar libro: " + e.getMessage());
            return false;
        }
    }
}
