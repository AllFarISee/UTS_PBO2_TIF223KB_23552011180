import java.sql.*;
import java.util.*;

public class ObatDAO {

    // Mendapatkan obat berdasarkan ID
    public static Obat getObatById(Connection connection, int obatId) {
        String query = "SELECT * FROM obat WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, obatId);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                String nama = resultSet.getString("nama");
                double harga = resultSet.getDouble("harga");
                int stok = resultSet.getInt("stok");
                return new Obat(obatId, nama, harga, stok);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Mendapatkan semua obat
    public static List<Obat> getAllObat(Connection connection) {
        List<Obat> obatList = new ArrayList<>();
        String query = "SELECT * FROM obat";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                double harga = resultSet.getDouble("harga");
                int stok = resultSet.getInt("stok");
                obatList.add(new Obat(id, nama, harga, stok));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obatList;
    }
}
