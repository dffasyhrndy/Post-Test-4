### Nama  : Daffa Syahrandy Husain
### NIM   : 2409116069
---

## Deskripsi Singkat
Program **To-Do List** ini dibuat menggunakan bahasa **Java** dengan konsep **CRUD (Create, Read, Update, Delete)**.  
Program memungkinkan pengguna untuk:
- Menambahkan kegiatan baru dengan nama dan tanggal.
- Melihat daftar kegiatan beserta statusnya.
- Mengupdate kegiatan (nama, tanggal, dan status).
- Menghapus kegiatan tertentu.
- Mencari kegiatan berdasarkan keyword.
- Keluar dari program.

---

## Alur Program

1. **Tampilan Menu Utama**  
   User diberikan 6 pilihan menu: Tambah, Lihat, Update, Hapus, Cari, atau Keluar.  
   Input menu diproses menggunakan `switch-case`.

2. **Tambah Kegiatan (Create)**  
   - Saat memilih menu `1`, user diminta memilih jenis kegiatan:  
     1. Kegiatan Kuliah  
     2. Kegiatan Organisasi  
     3. Kegiatan Praktikum  
   - Setelah memilih jenis kegiatan:  
     - **Kegiatan Kuliah** → user mengisi nama kegiatan, tanggal, dan mata kuliah.  
     - **Kegiatan Organisasi** → user mengisi nama kegiatan dan tanggal, organisasi otomatis terisi **INFORSA**.  
     - **Kegiatan Praktikum** → user mengisi nama kegiatan, tanggal, dan nama praktikum.  
   - Data yang diinput disimpan sebagai objek subclass (`KegiatanKuliah`, `KegiatanOrganisasi`, `KegiatanPraktikum`) ke dalam `ArrayList<Kegiatan>`.

3. **Lihat Daftar Kegiatan (Read)**  
   - Jika daftar kosong → tampil pesan *"Belum Ada Kegiatan"*.  
   - Jika ada → tampil semua kegiatan sesuai urutan penyimpanan.  

4. **Update Kegiatan (Update)**  
   - User memilih nomor kegiatan.  
   - Bisa mengubah nama, tanggal, atau status.  
   - Input kosong pada bagian nama → data lama tetap dipertahankan.  
   - Input tanggal bisa di-skip jika tidak ingin diubah.  
   - Input status menggunakan angka (0, 1, 2).  

5. **Hapus Kegiatan (Delete)**  
   - User memilih nomor kegiatan yang ingin dihapus.  
   - Data dihapus dari `ArrayList`.  

6. **Cari Kegiatan (Search)**  
   - User memasukkan keyword.  
   - Program menampilkan daftar kegiatan yang cocok dengan keyword tersebut.  

7. **Keluar Program**  
   - Program berhenti saat user memilih menu `6`.  

---

## Penerapan Konsep OOP

### Abstraction  
- Program menggunakan **abstract class** `Kegiatan` yang berisi atribut umum (`nama`, `tanggal`, `status`) serta method abstrak `getDetail()`.  
- Dibuat juga **interface** `IKegiatan` dengan method `tampilkanInfo()`.  
- Semua subclass (`KegiatanKuliah`, `KegiatanOrganisasi`, `KegiatanPraktikum`) wajib mengimplementasikan interface tersebut.  
- Abstraksi ini memisahkan kerangka umum dari detail implementasi tiap jenis kegiatan sehingga program lebih fleksibel dan mudah diperluas.  

### Polymorphism  
- **Overriding**: Subclass menimpa method `getDetail()` dari superclass `Kegiatan` untuk menampilkan detail sesuai jenis kegiatan.  
  - Contoh: `KegiatanOrganisasi` otomatis menambahkan teks `"Organisasi: INFORSA"`.  
- **Overloading**: Pada class `KegiatanController`, terdapat dua versi method `tambahKegiatan()`:  
  - `tambahKegiatan(IKegiatan kegiatan)`  
  - `tambahKegiatan(IKegiatan kegiatan, boolean pesan)`  
  Dengan overloading, satu nama method bisa dipakai untuk kebutuhan berbeda (dengan atau tanpa pesan sukses).

<img width="739" height="682" alt="image" src="https://github.com/user-attachments/assets/817eb1cc-d414-4c0f-b0f3-4d0ae852684c" />

---

## Letak Hasil Penerapan Abstraction & Polymorphism

- **Abstraction (Abstract Class + Interface)**  
  - Terlihat ketika menampilkan daftar kegiatan.  
  - Output setiap kegiatan ditampilkan melalui pemanggilan method abstrak `getDetail()` (abstract class) dan `tampilkanInfo()` (interface).  

<img width="1070" height="112" alt="image" src="https://github.com/user-attachments/assets/8e400d4a-9fd4-4c64-b29b-9f1dd8855311" />

- **Polymorphism (Overriding)**  
  - Saat memanggil `getDetail()`, hasil yang muncul berbeda tergantung subclass yang dipilih user.  
  - Contoh:  
    - `KegiatanKuliah` menampilkan tambahan `"Mata Kuliah: ..."`  
    - `KegiatanOrganisasi` menampilkan tambahan `"Organisasi: INFORSA"`  
    - `KegiatanPraktikum` menampilkan tambahan `"Praktikum: ..."`

- **Polymorphism (Overloading)**  
  - Terjadi saat menambah kegiatan menggunakan `tambahKegiatan()`.  
  - Jika dipanggil dengan parameter `boolean true`, program menampilkan pesan `"Kegiatan berhasil ditambahkan!"`.  
  - Jika tanpa parameter tambahan, kegiatan hanya ditambahkan tanpa menampilkan pesan.  

<img width="739" height="682" alt="image" src="https://github.com/user-attachments/assets/4276c88f-b3a2-404e-8fe3-149d3b3d507e" />

---
