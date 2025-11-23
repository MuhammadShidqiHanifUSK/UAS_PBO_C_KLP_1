package id.univ.uaspbo.model;

/**
 * Product model mewakili barang yang tersedia untuk dijual dalam sistem.
 * 
 * Inherits dari Entity untuk memiliki field id umum.
 * Field spesifik:
 *  - name  : nama produk
 *  - price : harga produk (dalam satuan integer)
 *  - stock : jumlah stok produk tersedia
 */
public class Product extends Entity {
    private String name; // nama produk
    private int price; // harga produk (dalam satuan integer)
    private int stock; // jumlah stok produk tersedia

    public Product() {} // konstruktor default

    /**
     * Constructor dengan parameter lengkap.
     * @param id    ID unik produk (dari Entity)
     * @param name  Nama produk
     * @param price Harga produk
     * @param stock Jumlah stok produk
     */
    public Product(String id, String name, int price, int stock) {
        super(id); // panggil konstruktor superclass untuk mengatur id
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Method getter untuk field name
    public String getName() { 
        return name; 
    }

    // Method setter untuk field name
    public void setName(String name) { 
        this.name = name; 
    }

    // Method getter untuk field price
    public int getPrice() { 
        return price; 
    }

    // Method setter untuk field price
    public void setPrice(int price) { 
        this.price = price; 
    }

    // Method getter untuk field stock
    public int getStock() { 
        return stock; 
    }

    // Method setter untuk field stock
    public void setStock(int stock) { 
        this.stock = stock; 
    }
}