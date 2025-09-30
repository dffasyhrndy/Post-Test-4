package view;

import controller.KegiatanController;
import model.KegiatanKuliah;
import model.KegiatanOrganisasi;
import model.KegiatanPraktikum;

import java.util.Scanner;

public class MainView {
    private KegiatanController controller = new KegiatanController();
    private Scanner input = new Scanner(System.in);

    public void tampilkanMenu() {
        while (true) {
            System.out.println("\n=== PROGRAM TO DO LIST ===");
            System.out.println("1. Tambah Kegiatan");
            System.out.println("2. Lihat Daftar Kegiatan");
            System.out.println("3. Update Kegiatan");
            System.out.println("4. Hapus Kegiatan");
            System.out.println("5. Cari Kegiatan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            if (!input.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
                continue;
            }
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahKegiatan();
                    break;
                case 2:
                    controller.lihatKegiatan();
                    break;
                case 3:
                    updateKegiatan();
                    break;
                case 4:
                    hapusKegiatan();
                    break;
                case 5:
                    cariKegiatan();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan program!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void tambahKegiatan() {
        System.out.println("Pilih jenis kegiatan:");
        System.out.println("1. Kuliah");
        System.out.println("2. Organisasi");
        System.out.println("3. Praktikum");
        System.out.print("Pilihan: ");
        int jenis = input.nextInt();
        input.nextLine();

        System.out.print("Masukkan Nama Kegiatan: ");
        String nama = input.nextLine();

        int dd, mm, yyyy;
        do {
            System.out.print("Masukkan Tanggal: ");
            dd = input.nextInt();
        } while (dd <= 0);

        do {
            System.out.print("Masukkan Bulan: ");
            mm = input.nextInt();
        } while (mm <= 0);

        do {
            System.out.print("Masukkan Tahun: ");
            yyyy = input.nextInt();
        } while (yyyy <= 0);
        input.nextLine();

        String tanggal = dd + "-" + mm + "-" + yyyy;

        switch (jenis) {
            case 1:
                System.out.print("Masukkan Mata Kuliah: ");
                String mk = input.nextLine();
                controller.tambahKegiatan(new KegiatanKuliah(nama, tanggal, mk));
                break;
            case 2:
                controller.tambahKegiatan(new KegiatanOrganisasi(nama, tanggal), true);
                break;
            case 3:
                System.out.print("Masukkan Nama Praktikum: ");
                String praktikum = input.nextLine();
                // Praktikum -> dengan pesan
                controller.tambahKegiatan(new KegiatanPraktikum(nama, tanggal, praktikum), true);
                break;
            default:
                System.out.println("Pilihan jenis tidak valid.");
        }
    }

    private void updateKegiatan() {
        controller.lihatKegiatan();
        System.out.print("Nomor kegiatan yang ingin diupdate: ");
        int idx = input.nextInt() - 1;
        input.nextLine();

        System.out.print("Update Nama (kosongkan jika tidak diubah): ");
        String newNama = input.nextLine();

        System.out.print("Update Tanggal (kosongkan = skip): ");
        String ddStr = input.nextLine();
        System.out.print("Update Bulan (kosongkan = skip): ");
        String mmStr = input.nextLine();
        System.out.print("Update Tahun (kosongkan = skip): ");
        String yyyyStr = input.nextLine();

        String newTgl = "";
        if (!ddStr.isEmpty() && !mmStr.isEmpty() && !yyyyStr.isEmpty()) {
            int dd = Integer.parseInt(ddStr);
            int mm = Integer.parseInt(mmStr);
            int yyyy = Integer.parseInt(yyyyStr);

            if (dd > 0 && mm > 0 && yyyy > 0) {
                newTgl = dd + "-" + mm + "-" + yyyy;
            } else {
                System.out.println("Tanggal tidak valid, update tanggal dibatalkan.");
            }
        }

        System.out.print("Update Status (1 = Selesai, 2 = Belum Selesai, 0 = tidak diubah): ");
        int status = input.nextInt();
        input.nextLine();

        controller.updateKegiatan(idx, newNama, newTgl, status);
    }

    private void hapusKegiatan() {
        controller.lihatKegiatan();
        System.out.print("Nomor kegiatan yang ingin dihapus: ");
        int del = input.nextInt() - 1;
        input.nextLine();
        controller.hapusKegiatan(del);
    }

    private void cariKegiatan() {
        System.out.print("Masukkan keyword pencarian: ");
        String keyword = input.nextLine();
        controller.cariKegiatan(keyword);
    }
}
