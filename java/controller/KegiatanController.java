package controller;

import java.util.ArrayList;
import model.IKegiatan;

public class KegiatanController {
    private ArrayList<IKegiatan> daftarKegiatan = new ArrayList<>();

    public void tambahKegiatan(IKegiatan kegiatan) {
        daftarKegiatan.add(kegiatan);
    }

    public void tambahKegiatan(IKegiatan kegiatan, boolean pesan) {
        daftarKegiatan.add(kegiatan);
        if (pesan) {
            System.out.println("Kegiatan berhasil ditambahkan!");
        }
    }

    public void lihatKegiatan() {
        if (daftarKegiatan.isEmpty()) {
            System.out.println("Belum ada kegiatan.");
        } else {
            for (int i = 0; i < daftarKegiatan.size(); i++) {
                System.out.print((i + 1) + ". ");
                daftarKegiatan.get(i).tampilkanInfo();
            }
        }
    }

    public void updateKegiatan(int index, String nama, String tanggal, int status) {
        if (index >= 0 && index < daftarKegiatan.size()) {
            IKegiatan kegiatan = daftarKegiatan.get(index);
            if (kegiatan instanceof model.Kegiatan) {
                model.Kegiatan k = (model.Kegiatan) kegiatan;
                if (!nama.isEmpty()) k.setNama(nama);
                if (!tanggal.isEmpty()) k.setTanggal(tanggal);
                if (status == 1) k.setStatus("Selesai");
                else if (status == 2) k.setStatus("Belum Selesai");
                System.out.println("Kegiatan berhasil diperbarui!");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    public void hapusKegiatan(int index) {
        if (index >= 0 && index < daftarKegiatan.size()) {
            daftarKegiatan.remove(index);
            System.out.println("Kegiatan berhasil dihapus!");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    public void cariKegiatan(String keyword) {
        boolean ditemukan = false;
        for (IKegiatan kegiatan : daftarKegiatan) {
            if (kegiatan instanceof model.Kegiatan) {
                model.Kegiatan k = (model.Kegiatan) kegiatan;
                if (k.getNama().toLowerCase().contains(keyword.toLowerCase())) {
                    kegiatan.tampilkanInfo();
                    ditemukan = true;
                }
            }
        }
        if (!ditemukan) {
            System.out.println("Kegiatan dengan keyword '" + keyword + "' tidak ditemukan.");
        }
    }

    public int getJumlahKegiatan() {
        return daftarKegiatan.size();
    }
}
