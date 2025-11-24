package id.univ.uaspbo.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Transaction model merepresentasikan transaksi pembelian di sistem.
 * Kelas ini mewarisi kelas Entity yang menyediakan atribut dan metode id unik.
 * Model ini menyimpan informasi userId (pengguna pembeli), daftar item transaksi, waktu transaksi, dan total harga keseluruhan
 * 
 * Konsep Object Oriented Programming (OOP) yang dipakai
 * - Inheritance (Pewarisan): Mewarisi kelas abstrak Entity untuk atribut id unik.
 * - Enkapsulasi: Atribut private dilindungi dengan getter dan setter.
 * - Collection: Menggunakan List<TransactionItem> untuk menampung daftar item transaksi.
 * - Nested Class: Kelas statis inner TransactionItem mendeskripsikan detail item.
 */
public class Transaction extends Entity {
    private String userId;                      // ID pengguna yang melakukan transaksi
    private List<TransactionItem> items;        // daftar produk yang dibeli (TransactionItem)
    private LocalDateTime timestamp;            // waktu transaksi dilakukan
    private int total;                          // total harga seluruh item

    /**
     * Konstruktor default tanpa parameter.
     * Membuat objek transaksi dengan atribut default.
     */
    public Transaction() {}

    /**
     * Konstruktor dengan parameter lengkap.
     * Inisialisasi objek transaksi dengan semua atribut.
     *
     * @param id Identifier unik transaksi, diwariskan dari Entity
     */
    public Transaction(String id, String userId, List<TransactionItem> items, LocalDateTime timestamp, int total) {
        super(id); // panggil konstruktor superclass untuk mengatur id
        this.userId = userId;
        this.items = items;
        this.timestamp = timestamp;
        this.total = total;
    }

    /**
     * Method getter untuk mengambil ID pengguna yang melakukan transaksi.
     */
    public String getUserId() { 
        return userId; 
    }

    /**
     * Method setter untuk mengatur ID pengguna yang melakukan transaksi.
     */
    public void setUserId(String userId) { 
        this.userId = userId; 
    }
    /**
     * Method getter untuk mengambil daftar item dalam transaksi.
     */
    public List<TransactionItem> getItems() { 
        return items; 
    }

    /**
     * Method setter untuk mengatur daftar item dalam transaksi.
     */
    public void setItems(List<TransactionItem> items) { 
        this.items = items; 
    }

    /**
     * Method getter untuk mengambil waktu dan tanggal transaksi dilakukan.
     */
    public LocalDateTime getTimestamp() { 
        return timestamp; 
    }


    /**
     * Method setter untuk mengatur waktu dan tanggal transaksi dilakukan.
     */
    public void setTimestamp(LocalDateTime timestamp) { 
        this.timestamp = timestamp; 
    }

    /**
     * Method getter untuk mengambil total harga transaksi.
     */
    public int getTotal() { 
        return total; 
    }

    /**
     * Method setter untuk mengatur total harga transaksi.
     */
    public void setTotal(int total) { 
        this.total = total; 
    }

    /**
     * Inner class TransactionItem
     * Kelas inner statis yang merepresentasikan detail item dalam transaksi.
     * Mewakili satu item/produk dalam transaksi
     */
    public static class TransactionItem {
        private String productId;   // ID produk
        private String productName; // nama produk
        private int qty;            // jumlah produk yang dibeli
        private int price;          // harga per unit

        /**
         * Konstruktor default tanpa parameter.
         */
        public TransactionItem() {}

        /**
         * Konstruktor lengkap dengan parameter.
         */
        public TransactionItem(String productId, String productName, int qty, int price) {
            this.productId = productId;
            this.productName = productName;
            this.qty = qty;
            this.price = price;
        }

        /**
         * Method getter untuk mengambil ID produk.
         */
        public String getProductId() { 
            return productId; 
        }

        /**
         * Method setter untuk mengatur ID produk.
         */
        public void setProductId(String productId) { 
            this.productId = productId; 
        }

        /**
         * Method getter untuk mengambil nama produk.
         */
        public String getProductName() { 
            return productName; 
        }

        /**
         * Method setter untuk mengatur nama produk.
         */
        public void setProductName(String productName) { 
            this.productName = productName; 
        }

        /**
         * Mengambil jumlah produk yang dibeli.
         */
        public int getQty() { 
            return qty; 
        }

        /**
         * Method setter untuk mengatur jumlah produk yang dibeli.
         */
        public void setQty(int qty) { 
            this.qty = qty; 
        }

        /**
         * Method getter untuk mengambil harga per unit produk.
         */
        public int getPrice() { 
            return price; 
        }

        /**
         * Method setter untuk mengatur harga per unit produk.
         */
        public void setPrice(int price) { 
            this.price = price; 
        }
    }
}