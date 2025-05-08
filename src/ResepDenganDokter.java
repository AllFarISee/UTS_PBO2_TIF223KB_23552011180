import java.sql.Connection;
import java.util.List;


public class ResepDenganDokter implements MetodeResep {
    private int resepId;
    private int pasienId;

    public ResepDenganDokter(int resepId, int pasienId) {
        this.resepId = resepId;
        this.pasienId = pasienId;
    }

    @Override
    public boolean verifikasi(Connection connection) {
        // Misalnya: periksa apakah resep valid untuk pasien
        List<Resep> resepList = ResepDAO.getResepByPasienId(connection, pasienId);
        for (Resep resep : resepList) {
            if (resep.getId() == resepId) return true;
        }
        return false;
    }

    @Override
    public double hitungTotal(Connection connection) {
        double total = 0;
        List<DetailResep> detailList = DetailResepDAO.getDetailResepByResepId(connection, resepId);
        for (DetailResep detail : detailList) {
            Obat obat = ObatDAO.getObatById(connection, detail.getObatId());
            total += obat.getHarga() * detail.getJumlah();
        }
        return total;
    }
}
