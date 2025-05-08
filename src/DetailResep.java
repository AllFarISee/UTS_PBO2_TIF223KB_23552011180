public class DetailResep {
    private int resepId;
    private int obatId;
    private int jumlah;

    public DetailResep(int resepId, int obatId, int jumlah) {
        this.resepId = resepId;
        this.obatId = obatId;
        this.jumlah = jumlah;
    }

    public int getResepId() {
        return resepId;
    }

    public int getObatId() {
        return obatId;
    }

    public int getJumlah() {
        return jumlah;
    }

    @Override
    public String toString() {
        return "DetailResep{resepId=" + resepId + ", obatId=" + obatId + ", jumlah=" + jumlah + "}";
    }
}

