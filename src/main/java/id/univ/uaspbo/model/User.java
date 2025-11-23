package id.univ.uaspbo.model;

/**
 * User model menyimpan data pengguna sistem.
 * 
 * Mewarisi Entity untuk memiliki field id unik.
 * Field utama:
 *  - email    : email pengguna
 *  - password : password pengguna
 *  - role     : peran pengguna ("ADMIN" atau "USER")
 */
public class User extends Entity {
    private String email; // Email pengguna
    private String password; // Password pengguna
    private String role; // "ADMIN" or "USER"

    public User() {} // Konstruktor default

    /**
     * Constructor lengkap
     * @param id       ID unik pengguna (dari Entity)
     * @param email    Email pengguna
     * @param password Password pengguna
     * @param role   Role pengguna ("ADMIN" atau "USER")
     */
    public User(String id, String email, String password, String role) {
        super(id);
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getter dan Setter untuk setiap field
    public String getEmail() { 
        return email; 
    }

    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getPassword() { 
        return password; 
    }

    public void setPassword(String password) { 
        this.password = password; 
    }

    public String getRole() { 
        return role; 
    }

    public void setRole(String role) { 
        this.role = role; 
    }
}