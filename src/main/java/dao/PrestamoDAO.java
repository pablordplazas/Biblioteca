package dao;

import conexion.Conexion;
import modelo.Prestamo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    // ✅ INSERTAR PRÉSTAMO
    public boolean insertar(Prestamo p) {
        String sql = "INSERT INTO prestamos (libroid, usuarioid, fecha_prestamo, fecha_devolucion, devuelto) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getLibroid());
            ps.setInt(2, p.getUsuarioid());
            ps.setDate(3, p.getFechaPrestamo());
            ps.setDate(4, p.getFechaDevolucion());
            ps.setBoolean(5, p.isDevuelto());

            ps.executeUpdate();
            System.out.println("✅ Préstamo registrado correctamente.");
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar préstamo: " + e.getMessage());
            return false;
        }
    }

    // ✅ LISTAR PRÉSTAMOS
    public List<Prestamo> listar() {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM prestamos";

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Prestamo p = new Prestamo();
                p.setPrestamoid(rs.getInt("prestamoid"));
                p.setLibroid(rs.getInt("libroid"));
                p.setUsuarioid(rs.getInt("usuarioid"));
                p.setFechaPrestamo(rs.getDate("fecha_prestamo"));
                p.setFechaDevolucion(rs.getDate("fecha_devolucion"));
                p.setDevuelto(rs.getBoolean("devuelto"));
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar préstamos: " + e.getMessage());
        }
        return lista;
    }

    // ✅ ACTUALIZAR PRÉSTAMO
    public boolean actualizar(Prestamo p) {
        String sql = "UPDATE prestamos SET libroid = ?, usuarioid = ?, fecha_prestamo = ?, fecha_devolucion = ?, devuelto = ? WHERE prestamoid = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getLibroid());
            ps.setInt(2, p.getUsuarioid());
            ps.setDate(3, p.getFechaPrestamo());
            ps.setDate(4, p.getFechaDevolucion());
            ps.setBoolean(5, p.isDevuelto());
            ps.setInt(6, p.getPrestamoid());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Préstamo actualizado correctamente.");
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar préstamo: " + e.getMessage());
        }
        return false;
    }

    // ✅ ELIMINAR PRÉSTAMO
    public boolean eliminar(int prestamoid) {
        String sql = "DELETE FROM prestamos WHERE prestamoid = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, prestamoid);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("🗑️ Préstamo eliminado correctamente.");
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar préstamo: " + e.getMessage());
        }
        return false;
    }
}
