package id.univ.uaspbo.model;

/**
 * Kelas abstrak Entity.
 * 
 * Ini adalah **base class** untuk semua entitas (model) dalam sistem kasir.
 * Semua model seperti Product, Transaction, dan User akan mewarisi kelas ini.
 * Tujuan utamanya adalah menyediakan field dan method umum yang dibutuhkan semua entitas.
 * 
 * Field:
 * - id : String
 *     Sebagai identifier unik untuk setiap entitas. Bisa digunakan sebagai primary key 
 *     ketika menyimpan data ke file JSON atau database.
 * 
 * Konstruktor:
 * - Entity() 
 *     Konstruktor default, membuat objek kosong.
 * - Entity(String id) 
 *     Konstruktor dengan parameter id untuk langsung menginisialisasi identifier entitas.
 * 
 * Method:
 * - getId() : String
 *     Mengembalikan nilai id dari entitas.
 * - setId(String id) : void
 *     Mengatur atau memperbarui nilai id entitas.
 * 
 * Catatan:
 * - Karena kelas ini abstrak, tidak bisa langsung dibuat objek Entity.
 * - Kelas ini dirancang agar mudah di-extend oleh model-model lain.
 */
public abstract class Entity {
    protected String id; // Field id sebagai identifier unik untuk setiap entitas

    public Entity() {} // Konstruktor default

    // Konstruktor dengan parameter id
    public Entity(String id) {
        this.id = id;
    }
    // Getter untuk id
    public String getId() { 
        return id; 
    }
    // Setter untuk id
    public void setId(String id) { 
        this.id = id; 
    }
}