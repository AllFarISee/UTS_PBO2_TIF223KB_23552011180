public class Obat {
    private int id;
    private String nama;
    private double harga;
    private int stok;

    // Constructor
    public Obat(int id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // Override toString() method for displaying Obat object info
    @Override
    public String toString() {
        return "Obat [ID=" + id + ", Nama=" + nama + ", Harga=" + harga + ", Stok=" + stok + "]";
    }
}
