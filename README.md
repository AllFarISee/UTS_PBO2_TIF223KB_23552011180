# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: {Alfarisi Azhar}</li>
  <li>NIM: {23552011180}</li>
  <li>Studi Kasus: {Kasir Apotek}</li>
</ul>

## Judul Studi Kasus
<p>Aplikasi Pegelola Kasir Apotek Permata</p>

## Penjelasan Studi Kasus
<p>1. Latar Belakang
Apotek merupakan fasilitas pelayanan kesehatan yang menyediakan obat-obatan kepada pasien, baik dengan resep dari dokter maupun pembelian langsung. Dalam operasional sehari-hari, dibutuhkan sistem yang dapat:

Mengelola data pasien dan tenaga medis

Mengelola data obat dan stok

Memproses pembelian obat berdasarkan resep atau langsung

Mencatat transaksi secara otomatis

Untuk itu, dibuatlah aplikasi Kasir Apotek berbasis Java dengan paradigma OOP (Object-Oriented Programming) dan koneksi ke database MySQL.

2. Tujuan
Membangun aplikasi kasir apotek yang:

Menerapkan prinsip OOP (encapsulation, inheritance, polymorphism, abstract class)

Mempermudah proses transaksi dan pencatatan

Menjamin integritas data melalui relasi tabel di database

Memberikan kemudahan verifikasi resep dan stok obat

3. Fitur Aplikasi
Fitur utama aplikasi:

Menampilkan daftar pasien dan obat

Menambah, mengedit, dan menghapus data pasien atau obat (melalui DAO)

Proses transaksi pembelian obat:

Dengan resep dokter: Verifikasi resep → Hitung total → Catat transaksi

Pembelian langsung: Pilih obat dan jumlah → Hitung total → Catat transaksi

Penyimpanan semua data ke dalam MySQL Database

4. Struktur OOP
Aplikasi ini menggunakan konsep OOP sebagai berikut:

Encapsulation: Setiap class (Pasien, Obat, Resep, dll.) memiliki atribut private dan getter/setter.

Inheritance: TenagaMedis sebagai superclass, diwarisi oleh Dokter dan Apoteker.

Polymorphism: Interface MetodeResep diimplementasikan oleh class ResepDenganDokter untuk proses resep.

Abstract Class (opsional): Bisa digunakan bila ingin membuat dasar umum untuk entitas medis.

5. Struktur Database
pasien: Menyimpan data pasien

tenaga_medis: Data dokter dan apoteker

obat: Data obat dan stok

resep & detail_resep: Resep pasien dan detail obat yang diresepkan

transaksi: Catatan pembelian pasien

Relasi menggunakan foreign key untuk menjaga integritas data, contohnya:

resep.dokter_id → tenaga_medis.id

detail_resep.obat_id → obat.id

6. Proses Bisnis
Petugas memilih transaksi dengan resep atau langsung

Jika dengan resep:

Masukkan ID pasien → tampilkan resep → hitung harga berdasarkan isi resep

Simpan data transaksi

Jika langsung:

Pilih obat dan jumlah → hitung total → simpan transaksi

Semua data otomatis tersimpan di database

7. Manfaat Sistem
Mengurangi kesalahan pencatatan manual

Mempercepat proses transaksi apotek

Memudahkan pemantauan data pasien, obat, dan transaksi

Fleksibel untuk pengembangan lebih lanjut (seperti cetak struk, login, laporan)</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Penjelasan:
Inheritance memungkinkan kita membuat class baru (child) yang mewarisi properti dan method dari class yang sudah ada (parent).

Cara Kerja di Aplikasi:
Class Dokter dan Apoteker mewarisi dari class TenagaMedis:

public class Dokter extends TenagaMedis { ... }
public class Apoteker extends TenagaMedis { ... }

Dengan ini, Dokter dan Apoteker otomatis memiliki atribut seperti id, nama, dan jabatan, serta bisa memiliki method tambahan sesuai kebutuhan masing-masing.</p>

### 2. Encapsulation
<p>Penjelasan:
Encapsulation adalah proses menyembunyikan data (atribut) suatu objek agar tidak bisa diakses langsung dari luar class, kecuali melalui method khusus seperti getter dan setter.

Cara Kerja di Aplikasi:
Class seperti Pasien, Obat, dan TenagaMedis memiliki atribut private, contoh:

private String nama;
Untuk mengakses atau mengubah nilai nama, digunakan method:

public String getNama() { return nama; }
public void setNama(String nama) { this.nama = nama; }

Tujuannya untuk menjaga agar data tidak diubah sembarangan, dan bisa divalidasi terlebih dahulu di dalam setter jika dibutuhkan.</p>

### 3. Polymorphism
<p>Penjelasan:
Polymorphism memungkinkan sistem untuk menggunakan satu interface atau superclass untuk berbagai implementasi berbeda.

Cara Kerja di Aplikasi:
Interface MetodeResep memiliki beberapa implementasi, misalnya ResepDenganDokter.

Saat dijalankan:

MetodeResep metode = new ResepDenganDokter(pasienId, resepId);
metode.verifikasi(connection);
metode.hitungTotal(connection);

Dengan cara ini jenis resep lain bisa ditambahkan tanpa mengubah kode utama. Ini membuat aplikasi fleksibel terhadap perubahan atau penambahan fitur baru.</p>

### 4. Abstract
<p>Penjelasan:
Abstraction menyembunyikan detail kompleks dari pengguna dan hanya menunjukkan bagian penting dari suatu objek.

Cara Kerja di Aplikasi:
Interface MetodeResep adalah abstraksi dari cara memproses resep:

public interface MetodeResep {
    boolean verifikasi(Connection connection);
    double hitungTotal(Connection connection);
}
User tidak perlu tahu detail cara menghitung total atau proses verifikasi, cukup memanggil method-nya.</p>

## Demo Proyek
<ul>
  <li>Github: <a href="">https://github.com/AllFarISee</a></li>
  <li>Youtube: <a href="">Youtube</a></li>
</ul>
