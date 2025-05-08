public class Apoteker extends TenagaMedis {
    public Apoteker(String nama, String nomorIdentitas) {
        super(nama, nomorIdentitas);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Apoteker: " + nama);
    }
}