import java.sql.*;

public class TransaksiDAO {

    public static void prosesTransaksi(Connection connection, int pasienId, double total) {
        String query = "INSERT INTO transaksi (pasien_id, total, tanggal) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pasienId);
            stmt.setDouble(2, total);
            stmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
