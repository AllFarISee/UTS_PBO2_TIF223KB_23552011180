public abstract class TenagaMedis {
    protected String nama;
    protected String nomorIdentitas;

    public TenagaMedis(String nama, String nomorIdentitas) {
        this.nama = nama;
        this.nomorIdentitas = nomorIdentitas;
    }

    public abstract void tampilkanInfo();
}
