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

Aplikasi Kasir Restoran ini dibuat sebagai project UAS Praktikum Pemrograman Berbasis Objek (PBO) kelas C 2025. Sistem ini pada tahap awal berjalan melalui Command Line Interface (CLI) dan dirancang untuk mensimulasikan proses operasional kasir restoran—mulai dari **pengelolaan menu, pemesanan, pembayaran, hingga pencatatan riwayat transaksi**. Ke depannya, aplikasi ini diharapkan dapat dikembangkan menjadi sistem yang lebih lengkap dan fleksibel, seperti versi berbasis GUI, integrasi web, maupun fitur tambahan lainnya yang mendukung kebutuhan operasional restoran secara lebih modern.

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
   (port default: 8080 — cek `src/main/resources/application.properties`/`application.yml` bila beda)

---

## Build dan jalankan jar (alternatif)
1. Build:
   mvn clean package

2. Jalankan:
   java -jar target/*.jar

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
   mvn spring-boot:run
   atau build & jalankan jar:
   mvn clean package
   java -jar target\<nama-file>.jar

---

## Menjalankan dengan Docker (opsional)
Jika tidak ingin memasang Java/Maven lokal:

- macOS / Linux:
  docker run --rm -it -v "$PWD":/usr/src/app -w /usr/src/app maven:3.8.8-openjdk-17 mvn spring-boot:run

- Windows PowerShell:
  docker run --rm -it -v "${PWD}:/usr/src/app" -w /usr/src/app maven:3.8.8-openjdk-17 mvn spring-boot:run

---

## Konfigurasi environment / database
- Periksa file contoh atau konfigurasi:
  - .env.example, .env
  - src/main/resources/application.properties
  - src/main/resources/application.yml

- Contoh mengganti konfigurasi secara temporer:
  SPRING_DATASOURCE_URL=jdbc:... SPRING_DATASOURCE_USERNAME=user SPRING_DATASOURCE_PASSWORD=pass mvn spring-boot:run

- Untuk Spring Boot, kamu juga bisa mengubah profile:
  mvn spring-boot:run -Dspring-boot.run.profiles=dev

---

## Troubleshooting cepat

- zsh: command not found: mvn
  - Gunakan ./mvnw jika ada, atau pasang Maven dan pastikan PATH benar.

- JVM crash (SIGBUS / Abort trap)
  - Biasanya JDK tidak cocok untuk arsitektur. Gunakan Temurin/OpenJDK 17.
  - Coba jalankan:
    JAVA_HOME=$(/usr/libexec/java_home -v17) mvn spring-boot:run
  - Periksa file `hs_err_pid*.log` jika ada:
    head -n 200 hs_err_pid*.log

- Port 8080 sudah dipakai
  - Cari proses dan hentikan:
    lsof -i :8080
    kill <PID>
  - Atau jalankan di port lain:
    mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"

- Dependensi/build error
  - mvn clean install -DskipTests
  - Periksa stacktrace untuk petunjuk dependensi yang gagal.

- ~/.zshrc berantakan setelah paste perintah
  - Edit file dan hapus baris yang salah:
    nano ~/.zshrc
  - Simpan, lalu:
    source ~/.zshrc

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
