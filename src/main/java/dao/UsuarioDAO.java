package dao;

import conexion.Conexion;
import modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // ✅ INSERTAR USUARIO
    public boolean insertar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getTelefono());
            ps.executeUpdate();

            System.out.println("✅ Usuario insertado correctamente.");
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }

    // ✅ LISTAR USUARIOS
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setUsuarioid(rs.getInt("usuarioid"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
                lista.add(u);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar usuarios: " + e.getMessage());
        }

        return lista;
    }

    // ✅ ACTUALIZAR USUARIO
    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE usuarioid = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getTelefono());
            ps.setInt(5, usuario.getUsuarioid());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Usuario actualizado correctamente.");
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar usuario: " + e.getMessage());
        }
        return false;
    }

    // ✅ ELIMINAR USUARIO
    public boolean eliminar(int usuarioid) {
        String sql = "DELETE FROM usuarios WHERE usuarioid = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, usuarioid);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("🗑️ Usuario eliminado correctamente.");
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar usuario: " + e.getMessage());
        }
        return false;
    }
}
