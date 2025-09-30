package model;

public class KegiatanKuliah extends Kegiatan implements IKegiatan {
    private String mataKuliah;

    public KegiatanKuliah(String nama, String tanggal, String mataKuliah) {
        super(nama, tanggal);
        this.mataKuliah = mataKuliah;
    }

    @Override
    public String getDetail() {
        return "Kuliah - Mata Kuliah: " + mataKuliah;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println(nama + " | Tanggal: " + tanggal + " | Status: " + status + " | " + getDetail());
    }
}
