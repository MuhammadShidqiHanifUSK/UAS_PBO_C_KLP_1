# Project UAS Praktikum Pemrograman Berbasis Objek Kelas C Kelompok 1 T.A Ganjil 2025/2026 - Aplikasi Kasir Restoran
Anggota Kelompok 1:
1. 2408107010003 - Niswatul 'Azimah
2. 2408107010079 - Roseline Balqist
3. 2408107010091 - Teuku Farid Haqi
4. 2408107010096 - Muhammad Shidqi Hanif
5. 2408107010100 - Cut Farah Salsabila
6. 2408107010106 - Muhammad Fariz Alfisaputra

# Deskripsi Project
**Nama Project: Aplikasi Kasir Restoran**

Aplikasi Kasir Restoran ini dibuat sebagai project UAS Praktikum Pemrograman Berbasis Objek (PBO) kelas C 2025. Sistem ini pada tahap awal berjalan melalui Command Line Interface (CLI) dan dirancang untuk mensimulasikan proses operasional kasir restoran—mulai dari **pengelolaan menu, pemesanan, pembayaran, hingga pencatatan riwayat transaksi**. Sekarang aplikasi ini sudah dikembangkan menjadi sistem berbasis web localhost menggunakan arsitektur MVC sederhana, sehingga lebih modern dan mudah digunakan dibanding versi CLI.

Aplikasi ini menerapkan seluruh konsep inti OOP sesuai ketentuan UAS, termasuk  **encapsulation, inheritance, polymorphism, abstraction, serta penggunaan collection dan exception handling**. Seluruh class terstruktur rapi, terdokumentasi dengan Javadoc, dan disusun dalam package sesuai perannya.

Secara umum, aplikasi menyediakan dua jenis akun **Admin** dan **User** dengan fungsionalitas berbeda. Admin dapat mengelola seluruh data restoran seperti menambah, mengubah, dan menghapus menu, serta melihat user dan riwayat transaksi. Sementara User dapat melihat menu, melakukan pemesanan, melakukan pembayaran, dan melihat riwayat transaksi mereka sendiri. Semua proses transaksi dicatat secara otomatis untuk memastikan data tetap konsisten.

Aplikasi ini dibangun dengan **pendekatan modular** agar mudah dikembangkan, dibaca, dan dipelihara, sekaligus memenuhi seluruh standar penilaian baik dari sisi fungsional, konsep OOP, maupun dokumentasi dan struktur kode.

# UAS_PBO_C_KLP_1

Panduan ini menjelaskan cara menjalankan aplikasi dari repository ini, dengan instruksi khusus untuk:
- macOS (Apple Silicon / M1 / M2)
- Windows (PowerShell / CMD)

Jika repo memiliki Maven Wrapper (`mvnw` / `mvnw.cmd`), gunakan wrapper tersebut lebih mudah karena tidak perlu memasang Maven global.

---

## Isi
- Prasyarat
- Menjalankan (development)
- Build & jalankan jar
- Cara khusus: macOS (Apple Silicon) & Windows
- Menjalankan lewat Docker (opsional)
- Konfigurasi environment / database
- Troubleshooting cepat
- Kontribusi & Lisensi

---

## Prasyarat
- Git
- Java Development Kit (JDK) — rekomendasi: Java 17 (Temurin/OpenJDK 17)
- Maven (opsional bila tidak ada `mvnw`)
- (Opsional) Docker

Verifikasi dasar:
- java -version
- mvn -v

---

## Menjalankan aplikasi (development)
1. Clone repo:
   git clone https://github.com/MuhammadShidqiHanifUSK/UAS_PBO_C_KLP_1.git
   cd UAS_PBO_C_KLP_1

2. Pastikan berada di root project (ada pom.xml):
   ls -la | grep pom.xml

3. Jika ada Maven wrapper:
   chmod +x ./mvnw
   ./mvnw spring-boot:run

   Jika tidak ada wrapper:
   mvn spring-boot:run

4. Buka browser:
   http://localhost:8080

---

## Cara khusus: macOS (Apple Silicon / M1 / M2)

Jika sebelumnya mengalami crash JVM (SIGBUS / Abort trap), kemungkinan JDK yang terpasang tidak cocok. Gunakan Temurin/OpenJDK 17.

1. Pasang Homebrew (jika belum):
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

2. Pasang Temurin 17 dan (opsional) Maven:
   brew install --cask temurin17
   brew install maven

3. Untuk sesi sekarang (terminal aktif):
   export JAVA_HOME=$(/usr/libexec/java_home -v17)
   export PATH="$JAVA_HOME/bin:$PATH"

   Untuk permanen (zsh):
   echo 'export JAVA_HOME=$(/usr/libexec/java_home -v17)' >> ~/.zshrc
   echo 'export PATH="$JAVA_HOME/bin:$PATH"' >> ~/.zshrc
   source ~/.zshrc

4. Verifikasi:
   java -version
   mvn -v

5. Jalankan aplikasi (di root project):
   mvn spring-boot:run
   atau pakai wrapper:
   ./mvnw spring-boot:run

Catatan: jika ingin memaksa satu perintah menggunakan JDK 17 tanpa mengubah shell:
   JAVA_HOME=$(/usr/libexec/java_home -v17) mvn spring-boot:run

---

## Cara khusus: Windows (PowerShell / CMD)

1. Masuk folder project:
   cd C:\path\to\UAS-PBO-WEB

2. Cek Maven wrapper:
   dir mvnw*  (lihat mvnw atau mvnw.cmd)

3. Jika ada wrapper:
   .\mvnw.cmd spring-boot:run

4. Jika tidak ada wrapper — pasang JDK 17 dan Maven:
   - Dengan Chocolatey (PowerShell as Admin):
     choco install temurin17 -y
     choco install maven -y
   - Atur JAVA_HOME dan PATH melalui System Environment Variables atau:
     setx JAVA_HOME "C:\Program Files\Eclipse Adoptium\jdk-17.x.x.x-hotspot"
     setx PATH "%JAVA_HOME%\bin;%PATH%"

5. Verifikasi:
   java -version
   mvn -v

6. Jalankan:
   mvn compile && mvn spring-boot:run

---

## Verifikasi sukses
Setelah berhasil, di terminal akan muncul log Spring Boot dengan baris seperti:
  Started Application in ... seconds

Buka:
  http://localhost:8080

---

## Kontribusi
- Buat issue untuk bug atau fitur.
- Buat pull request dengan deskripsi dan langkah tes.
- Sertakan environment (OS, Java version) saat melaporkan bug.

---

## Pembagian Tugas Anggota Kelompok

Pada project ini, pembagian tugas dilakukan secara proporsional sesuai kemampuan dan kontribusi masing-masing anggota. Kelompok terdiri dari 6 orang, yaitu 3 laki-laki dan 3 perempuan, dengan fokus kerja yang dibagi menjadi dua bagian utama: pengembangan kode program dan penyusunan presentasi. Setiap anggota juga terlibat dalam proses commit dan kolaborasi repository GitHub.

1. Tugas Tim Developer (3 Laki-laki)

Tiga anggota laki-laki bertanggung jawab pada seluruh bagian pengembangan aplikasi, meliputi:

- Implementasi seluruh logic backend berbasis Java & Spring Boot
- Penyusunan struktur folder MVC (model, controller, repository, service)
- Pembuatan seluruh class model dengan konsep OOP lengkap (inheritance, encapsulation, abstraction, polymorphism, collection)
- Penerapan file-based repository (JSON)
- Implementasi fitur Admin & User
- Implementasi transaksi, menu, autentikasi, dan riwayat transaksi
- Testing fitur dan debugging
- Integrasi ke web localhost melalui Spring Boot
- Commit rutin ke GitHub selama proses pengembangan

2. Tugas Tim Dokumentasi & Presentasi (3 Perempuan)

Tiga anggota perempuan bertanggung jawab pada dokumentasi dan penyajian project, meliputi:
- Penyusunan slide presentasi (PPT)
- Menyusun deskripsi sistem, use case, alur aplikasi, dan struktur OOP
- Menyusun penjelasan setiap fitur untuk keperluan presentasi UAS
- Membuat diagram pendukung (UML sederhana, flowchart menu, alur transaksi)
- Dokumentasi tambahan seperti cara run, struktur folder, dan penjelasan class
- Review akhir agar dokumen dan penjelasan konsisten

3. Kolaborasi Bersama (Semua Anggota)

Seluruh anggota kelompok tetap terlibat dalam tahap akhir:
- Mengisi commit GitHub sesuai kontribusi
- Review kode dan dokumentasi bersama
- Menyusun penjelasan lisan untuk UAS
- Pengujian aplikasi sebelum finalisasi
- Penyusunan laporan dan file pendukung lainnya

Pembagian kerja ini memastikan semua anggota memiliki kontribusi nyata baik pada sisi teknis maupun non-teknis, serta memenuhi standar penilaian kerja kelompok.