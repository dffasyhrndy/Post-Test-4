package model;

public abstract class Kegiatan {
    protected String nama;
    protected String tanggal;
    protected String status;

    public Kegiatan(String nama, String tanggal) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.status = "Belum Selesai";
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract String getDetail();
}
