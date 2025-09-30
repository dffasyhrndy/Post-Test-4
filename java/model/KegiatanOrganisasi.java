package model;

public class KegiatanOrganisasi extends Kegiatan implements IKegiatan {

    public KegiatanOrganisasi(String nama, String tanggal) {
        super(nama, tanggal);
    }

    @Override
    public String getDetail() {
        return "Organisasi - INFORSA";
    }

    @Override
    public void tampilkanInfo() {
        System.out.println(nama + " | Tanggal: " + tanggal + " | Status: " + status + " | " + getDetail());
    }
}
