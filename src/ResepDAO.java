import java.sql.*;
import java.util.*;

public class ResepDAO {

    // Mendapatkan daftar resep berdasarkan ID pasien
    public static List<Resep> getResepByPasienId(Connection connection, int pasienId) {
        List<Resep> resepList = new ArrayList<>();
        String query = "SELECT * FROM resep WHERE pasien_id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pasienId);
            ResultSet resultSet = stmt.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int dokterId = resultSet.getInt("dokter_id");
                java.sql.Date tanggal = resultSet.getDate("tanggal"); 
                resepList.add(new Resep(id, pasienId, dokterId, tanggal));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return resepList;
    }
}
