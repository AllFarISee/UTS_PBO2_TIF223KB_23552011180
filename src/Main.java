import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Koneksi ke database
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connection = dbConnection.getConnection();
        
        // Menampilkan menu utama
        Scanner scanner = new Scanner(System.in);
        boolean runApp = true;
        
        while (runApp) {
            System.out.println("\n----- Menu Kasir Apotek -----");
            System.out.println("1. Lihat Pasien");
            System.out.println("2. Lihat Obat");
            System.out.println("3. Proses Transaksi dengan Resep");
            System.out.println("4. Proses Pembelian Langsung");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // untuk menangkap enter

            switch (choice) {
                case 1:
                    // Menampilkan daftar pasien
                    List<Pasien> pasienList = PasienDAO.getAllPasien(connection);
                    pasienList.forEach(pasien -> System.out.println(pasien));
                    break;
                case 2:
                    // Menampilkan daftar obat
                    List<Obat> obatList = ObatDAO.getAllObat(connection);
                    obatList.forEach(obat -> System.out.println(obat));
                    break;
                case 3:
                    // Proses transaksi dengan resep
                    prosesTransaksiDenganResep(scanner, connection);
                    break;
                case 4:
                    // Proses pembelian langsung
                    prosesPembelianLangsung(scanner, connection);
                    break;
                case 5:
                    runApp = false;
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fungsi untuk memproses transaksi dengan resep
    private static void prosesTransaksiDenganResep(Scanner scanner, Connection connection) {
        System.out.print("Masukkan ID Pasien: ");
        int pasienId = scanner.nextInt();
        scanner.nextLine();
    
        System.out.print("Masukkan ID Resep: ");
        int resepId = scanner.nextInt();
        scanner.nextLine();
    
        MetodeResep metode = new ResepDenganDokter(resepId, pasienId);
    
        if (!metode.verifikasi(connection)) {
            System.out.println("Resep tidak valid atau tidak ditemukan.");
            return;
        }
    
        double total = metode.hitungTotal(connection);
        System.out.println("Total harga resep: Rp" + total);
        TransaksiDAO.prosesTransaksi(connection, pasienId, total);
        System.out.println("Transaksi dengan resep berhasil!");
    }
    

    // Fungsi untuk memproses pembelian langsung
    private static void prosesPembelianLangsung(Scanner scanner, Connection connection) {
        System.out.print("Masukkan ID Pasien: ");
        int pasienId = scanner.nextInt();
        scanner.nextLine();

        // Menampilkan daftar obat yang tersedia
        List<Obat> obatList = ObatDAO.getAllObat(connection);
        System.out.println("Daftar Obat yang tersedia:");
        obatList.forEach(obat -> System.out.println(obat));

        System.out.print("Masukkan ID Obat yang ingin dibeli: ");
        int obatId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Jumlah Obat: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();

        // Mendapatkan harga obat dan menghitung total
        Obat obat = ObatDAO.getObatById(connection, obatId);
        double total = obat.getHarga() * jumlah;

        // Menyelesaikan transaksi
        System.out.println("Total harga: Rp" + total);
        TransaksiDAO.prosesTransaksi(connection, pasienId, total);
        System.out.println("Pembelian langsung berhasil!");
    }
}
