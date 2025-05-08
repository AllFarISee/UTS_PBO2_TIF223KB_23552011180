import java.sql.Date;

public class Resep {
    private int id;
    private int pasienId;
    private int dokterId;
    private Date tanggal;

    public Resep(int id, int pasienId, int dokterId, Date tanggal) {
        this.id = id;
        this.pasienId = pasienId;
        this.dokterId = dokterId;
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public int getPasienId() {
        return pasienId;
    }

    public int getDokterId() {
        return dokterId;
    }

    public Date getTanggal() {
        return tanggal;
    }

    @Override
    public String toString() {
        return "Resep{id=" + id + ", pasienId=" + pasienId + ", dokterId=" + dokterId + ", tanggal=" + tanggal + "}";
    }
}
