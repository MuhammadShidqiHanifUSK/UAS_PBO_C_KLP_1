package id.univ.uaspbo.service;

import id.univ.uaspbo.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Kelas service yang bertanggung jawab mengelola semua operasi yang berhubungan dengan entitas Product.
 * Kelas ini mewarisi AbstractService untuk mendapatkan fungsi dasar CRUD (Create, Read, Update, Delete)
 * secara otomatis, serta memperluasnya dengan fitur tambahan seperti pencarian dan pengurutan produk.
 *
 * Kelas ini mengatur pengambilan data produk dari file JSON yang path-nya dikonfigurasi
 * melalui properti aplikasi, memastikan konsistensi penyimpanan dan pengambilan data.
 *
 * Konsep Object Oriented Programming (OOP) yang dipakai:
 * - Inheritance (Pewarisan): Memanfaatkan implementasi CRUD dasar dari AbstractService.
 * - Encapsulation (Enkapsulasi): Variabel productsPath bersifat private dan diakses lewat method.
 * - Polymorphism (Polimorfisme): Meng-override method abstrak dari AbstractService.
 */
@Service
public class ProductService extends AbstractService<Product> {

    @Value("${uas.data.products}")
    private String productsPath;  // Path file data produk

    /**
     * Mendapatkan path data produk untuk repository file.
     *
     * @return Path file produk
     */
    @Override
    protected String getDataPath() {
        return productsPath;
    }

    /**
     * Mendapatkan kelas array tipe Product untuk deserialisasi JSON.
     *
     * @return Kelas array produk
     */
    @Override
    protected Class<Product[]> getTypeClass() {
        return Product[].class;
    }

    /**
     * Mendapatkan ID dari objek produk.
     *
     * @param product Produk
     * @return ID produk
     */
    @Override
    protected String getEntityId(Product product) {
        return product.getId();
    }

    /**
     * Mengatur ID pada objek produk.
     *
     * @param product Produk
     * @param id ID yang akan diset
     */
    @Override
    protected void setEntityId(Product product, String id) {
        product.setId(id);
    }

    
}
