public class Dokter extends TenagaMedis {
    public Dokter(String nama, String nomorIdentitas) {
        super(nama, nomorIdentitas);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Dokter: " + nama);
    }
}