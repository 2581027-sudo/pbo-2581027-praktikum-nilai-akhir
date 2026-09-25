import java.util.Scanner;

public class NilaiAkhir {

    static final double BOBOT_PRAKTIKUM = 0.30;
    static final double BOBOT_TUGAS     = 0.20;
    static final double BOBOT_MID       = 0.20;
    static final double BOBOT_FINAL     = 0.30;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nilai praktikum : ");
        double praktikum = input.nextDouble();
        System.out.print("Nilai tugas     : ");
        double tugas = input.nextDouble();
        System.out.print("Nilai MID       : ");
        double mid = input.nextDouble();
        System.out.print("Nilai final     : ");
        double nilaiFinal = input.nextDouble();

        /*
         * Percobaan versi bilangan bulat:
         * int akhirInt = praktikumInt * 30 / 100 + tugasInt * 20 / 100
         *              + midInt * 20 / 100 + finalInt * 30 / 100;
         * Dengan 85, 78, 70, 80 hasilnya 78, bukan 79.1, karena tiap komponen
         * sudah dibagi dengan pembagian int (bagian pecahannya hilang)
         * sebelum sempat dijumlahkan.
         */

        // Satu ekspresi tanpa kurung sama sekali.
// Ini aman karena operator * memiliki precedence lebih tinggi daripada +,
// sehingga Java otomatis mengerjakan semua perkalian (nilai * bobot) lebih dulu
// sebelum menjumlahkannya. Urutan ini sudah benar tanpa perlu kurung tambahan.
        double akhir = praktikum * BOBOT_PRAKTIKUM + tugas * BOBOT_TUGAS + mid * BOBOT_MID;
        akhir += nilaiFinal * BOBOT_FINAL; // augmented assignment untuk komponen final

        int dipotong = (int) akhir;              // memotong: bagian pecahan langsung dibuang
        long dibulatkan = Math.round(akhir);     // membulatkan: ke atas/bawah tergantung pecahannya
        double selisih = akhir - dipotong;       // double, karena ini pecahan hasil, bukan salah hitung

        /*
         * Dengan 85, 78, 70, 80: akhir = 79.1 -> dipotong = 79, dibulatkan = 79 (sama),
         * karena pecahannya 0.1 < 0.5.
         * Dengan 85, 80, 75, 90: akhir = 83.5 -> dipotong = 83, dibulatkan = 84 (BEDA),
         * karena Math.round membulatkan ke atas begitu pecahan mencapai 0.5,
         * sedangkan (int) selalu memotong tanpa peduli besar pecahannya.
         */

        boolean lulus = akhir >= 60; // status kelulusan langsung sebagai boolean, tanpa if

        System.out.println();
        System.out.println("===== NILAI AKHIR =====");
        System.out.println("Praktikum  : " + praktikum + "  (30%)");
        System.out.println("Tugas      : " + tugas + "  (20%)");
        System.out.println("MID        : " + mid + "  (20%)");
        System.out.println("Final      : " + nilaiFinal + "  (30%)");
        System.out.println("------------------------");
        System.out.println("Nilai akhir : " + akhir);
        System.out.println("Dipotong    : " + dipotong + "  (int)");
        System.out.println("Dibulatkan  : " + dibulatkan + "  (Math.round)");
        System.out.println("Selisih     : " + selisih);
        System.out.println("Lulus (>=60): " + lulus);

        input.close();
    }
}