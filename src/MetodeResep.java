import java.sql.Connection;

public interface MetodeResep {
    boolean verifikasi(Connection connection);
    double hitungTotal(Connection connection);
}
