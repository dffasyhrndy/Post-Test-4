package model;

public class KegiatanPraktikum extends Kegiatan implements IKegiatan {
    private String praktikum;

    public KegiatanPraktikum(String nama, String tanggal, String praktikum) {
        super(nama, tanggal);
        this.praktikum = praktikum;
    }

    @Override
    public String getDetail() {
        return "Praktikum - " + praktikum;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println(nama + " | Tanggal: " + tanggal + " | Status: " + status + " | " + getDetail());
    }
}
