package id.univ.uaspbo.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Transaction model merepresentasikan transaksi pembelian di sistem.
 * 
 * Mewarisi Entity untuk memiliki field id unik.
 * Field utama:
 *  - userId    : ID pengguna yang melakukan transaksi
 *  - items     : daftar produk yang dibeli (TransactionItem)
 *  - timestamp : waktu transaksi dilakukan
 *  - total     : total harga seluruh item
 */
public class Transaction extends Entity {
    private String userId; // ID pengguna yang melakukan transaksi
    private List<TransactionItem> items; // daftar produk yang dibeli (TransactionItem)
    private LocalDateTime timestamp; // waktu transaksi dilakukan
    private int total; // total harga seluruh item

    public Transaction() {} // konstruktor default

     /**
     * Constructor lengkap
     * @param id        ID unik transaksi
     * @param userId    ID pengguna
     * @param items     Daftar item transaksi
     * @param timestamp Waktu transaksi
     * @param total     Total harga transaksi
     */
    public Transaction(String id, String userId, List<TransactionItem> items, LocalDateTime timestamp, int total) {
        super(id); // panggil konstruktor superclass untuk mengatur id
        this.userId = userId;
        this.items = items;
        this.timestamp = timestamp;
        this.total = total;
    }

    // Method getter dan setter untuk semua field
    public String getUserId() { 
        return userId; 
    }

    public void setUserId(String userId) { 
        this.userId = userId; 
    }

    public List<TransactionItem> getItems() { 
        return items; 
    }

    public void setItems(List<TransactionItem> items) { 
        this.items = items; 
    }

    // Method getter untuk field timestamp untuk menyimpan waktu transaksi
    public LocalDateTime getTimestamp() { 
        return timestamp; 
    }


    // Method setter untuk field timestamp
    public void setTimestamp(LocalDateTime timestamp) { 
        this.timestamp = timestamp; 
    }

    public int getTotal() { 
        return total; 
    }

    public void setTotal(int total) { 
        this.total = total; 
    }

    /**
     * Inner class TransactionItem
     * Mewakili satu item/produk dalam transaksi
     * Field:
     *  - productId   : ID produk
     *  - productName : nama produk
     *  - qty         : jumlah yang dibeli
     *  - price       : harga per unit
     */
    public static class TransactionItem {
        private String productId;
        private String productName;
        private int qty;
        private int price; // unit price

        public TransactionItem() {} // konstruktor default

        /**
         * Constructor lengkap
         * @param productId   ID produk
         * @param productName Nama produk
         * @param qty         Jumlah yang dibeli
         * @param price       Harga per unit
         */
        public TransactionItem(String productId, String productName, int qty, int price) {
            this.productId = productId;
            this.productName = productName;
            this.qty = qty;
            this.price = price;
        }

        // Method getter dan setter untuk semua field
        public String getProductId() { 
            return productId; 
        }

        public void setProductId(String productId) { 
            this.productId = productId; 
        }

        public String getProductName() { 
            return productName; 
        }

        public void setProductName(String productName) { 
            this.productName = productName; 
        }

        // Method getter dan setter untuk field qty (quantity, jumlah unit produk yang dibeli dalam satu transaksi)
        public int getQty() { 
            return qty; 
        }

        public void setQty(int qty) { 
            this.qty = qty; 
        }

        public int getPrice() { 
            return price; 
        }

        public void setPrice(int price) { 
            this.price = price; 
        }
    }
}