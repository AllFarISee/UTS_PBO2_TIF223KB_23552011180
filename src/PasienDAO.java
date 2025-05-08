import java.sql.*;
import java.util.*;

public class PasienDAO {

    public static List<Pasien> getAllPasien(Connection connection) {
        List<Pasien> pasienList = new ArrayList<>();
        String query = "SELECT * FROM pasien";
        
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                int umur = resultSet.getInt("umur");
                pasienList.add(new Pasien(id, nama, umur));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pasienList;
    }
}
