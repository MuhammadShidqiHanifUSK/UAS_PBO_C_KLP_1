package id.univ.uaspbo;  // Package tempat class ini berada. Menentukan struktur folder/namespace aplikasi.

import org.springframework.boot.SpringApplication;  // Class yang dipakai untuk menjalankan (start) aplikasi Spring Boot.

import org.springframework.boot.autoconfigure.SpringBootApplication;  // Anotasi utama Spring Boot yang mengaktifkan konfigurasi otomatis dan scanning komponen.

/**
 * Kelas utama aplikasi.
 * Sebagai entry point (titik masuk) ketika program dijalankan.
 */
@SpringBootApplication  // Mengaktifkan auto-configuration, component scan, dan konfigurasi Spring.
public class UasPboWebApplication {

    public static void main(String[] args) {
        // Method main sbgai titik awal eksekusi program Java.
        
        // Memulai aplikasi Spring Boot.
        // Spring akan menjalankan server Tomcat, memuat Controller, Service, Repository, template, dll.
        SpringApplication.run(UasPboWebApplication.class, args);
    }
}
