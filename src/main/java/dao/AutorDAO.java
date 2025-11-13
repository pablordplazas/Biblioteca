package dao;

import conexion.Conexion;
import modelo.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

    // ✅ INSERTAR AUTOR
    public boolean insertar(Autor autor) {
        String sql = "INSERT INTO autores (nombre, nacionalidad) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getNacionalidad());
            ps.executeUpdate();
            System.out.println("✅ Autor insertado correctamente.");
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar autor: " + e.getMessage());
            return false;
        }
    }

    // ✅ LISTAR AUTORES
    public List<Autor> listar() {
        List<Autor> lista = new ArrayList<>();
        String sql = "SELECT * FROM autores";

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Autor a = new Autor();
                a.setAutorid(rs.getInt("autorid"));
                a.setNombre(rs.getString("nombre"));
                a.setNacionalidad(rs.getString("nacionalidad"));
                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar autores: " + e.getMessage());
        }

        return lista;
    }

    // ✅ ACTUALIZAR AUTOR
    public boolean actualizar(Autor autor) {
        String sql = "UPDATE autores SET nombre = ?, nacionalidad = ? WHERE autorid = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getNacionalidad());
            ps.setInt(3, autor.getAutorid());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar autor: " + e.getMessage());
            return false;
        }
    }

    // ✅ ELIMINAR AUTOR
    public boolean eliminar(int autorid) {
        String sql = "DELETE FROM autores WHERE autorid = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, autorid);
            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar autor: " + e.getMessage());
            return false;
        }
    }
}
