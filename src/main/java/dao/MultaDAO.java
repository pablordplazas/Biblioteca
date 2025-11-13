package dao;

import conexion.Conexion;
import modelo.Multa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MultaDAO {

    // ✅ INSERTAR MULTA
    public boolean insertar(Multa m) {
        String sql = "INSERT INTO multas (prestamoid, monto, pagada) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, m.getPrestamoid());
            ps.setDouble(2, m.getMonto());
            ps.setBoolean(3, m.isPagada());

            ps.executeUpdate();
            System.out.println("✅ Multa registrada correctamente.");
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar multa: " + e.getMessage());
            return false;
        }
    }

    // ✅ LISTAR MULTAS
    public List<Multa> listar() {
        List<Multa> lista = new ArrayList<>();
        String sql = "SELECT * FROM multas";

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Multa m = new Multa();
                m.setMultaid(rs.getInt("multaid"));
                m.setPrestamoid(rs.getInt("prestamoid"));
                m.setMonto(rs.getDouble("monto"));
                m.setPagada(rs.getBoolean("pagada"));
                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar multas: " + e.getMessage());
        }
        return lista;
    }

    // ✅ ACTUALIZAR MULTA
    public boolean actualizar(Multa m) {
        String sql = "UPDATE multas SET prestamoid = ?, monto = ?, pagada = ? WHERE multaid = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, m.getPrestamoid());
            ps.setDouble(2, m.getMonto());
            ps.setBoolean(3, m.isPagada());
            ps.setInt(4, m.getMultaid());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Multa actualizada correctamente.");
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar multa: " + e.getMessage());
        }
        return false;
    }

    // ✅ ELIMINAR MULTA
    public boolean eliminar(int multaid) {
        String sql = "DELETE FROM multas WHERE multaid = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, multaid);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("🗑️ Multa eliminada correctamente.");
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar multa: " + e.getMessage());
        }
        return false;
    }
}
