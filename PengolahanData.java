import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    int nim;

    public Mahasiswa(String nama, int nim) {
        this.nama = nama;
        this.nim = nim;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", NIM: " + nim;
    }
}

public class PengolahanData {
    static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Pengolahan Data Mahasiswa:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Hapus Mahasiswa");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahMahasiswa(scanner);
                    break;
                case 2:
                    tampilkanMahasiswa();
                    break;
                case 3:
                    hapusMahasiswa(scanner);
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);

        scanner.close();
    }

    private static void tambahMahasiswa(Scanner scanner) {
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM mahasiswa: ");
        int nim = scanner.nextInt();
        dataMahasiswa.add(new Mahasiswa(nama, nim));
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private static void tampilkanMahasiswa() {
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            System.out.println("\nData Mahasiswa:");
            for (int i = 0; i < dataMahasiswa.size(); i++) {
                System.out.println((i + 1) + ". " + dataMahasiswa.get(i));
            }
        }
    }

    private static void hapusMahasiswa(Scanner scanner) {
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa yang bisa dihapus.");
            return;
        }
        tampilkanMahasiswa();
        System.out.print("Pilih nomor mahasiswa yang ingin dihapus: ");
        int nomor = scanner.nextInt();
        if (nomor > 0 && nomor <= dataMahasiswa.size()) {
            dataMahasiswa.remove(nomor - 1);
            System.out.println("Mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Nomor mahasiswa tidak valid.");
        }
    }
}
