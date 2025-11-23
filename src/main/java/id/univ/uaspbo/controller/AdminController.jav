package id.univ.uaspbo.controller;

import id.univ.uaspbo.service.ProductService;
import id.univ.uaspbo.service.TransactionService;
import id.univ.uaspbo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final TransactionService transactionService;
    private final UserService userService;

    public AdminController(ProductService productService, TransactionService transactionService, UserService userService) {
        this.productService = productService;
        this.transactionService = transactionService;
        this.userService = userService;
    }

    private boolean isAdmin(HttpSession s) {
        var u = s.getAttribute("user");
        return u != null && ((id.univ.uaspbo.model.User)u).getRole().equalsIgnoreCase("ADMIN");
    }

    @GetMapping
    public String dashboard(HttpSession s, Model m) {
        if (!isAdmin(s)) return "redirect:/login";
        m.addAttribute("products", productService.getAll());
        m.addAttribute("transactions", transactionService.getAll());
        m.addAttribute("users", userService.getAll());
        return "admin/dashboard";
    }

    @GetMapping("/products")
    public String products(HttpSession s, Model m) {
        if (!isAdmin(s)) return "redirect:/login";
        m.addAttribute("products", productService.getAll());
        return "admin/products";
    }

    @GetMapping("/users")
    public String users(HttpSession s, Model m) {
        if (!isAdmin(s)) return "redirect:/login";
        m.addAttribute("users", userService.getAll());
        m.addAttribute("transactions", transactionService.getAll());
        return "admin/users";
    }

    @GetMapping("/reports")
    public String reports(HttpSession s, Model m) {
        if (!isAdmin(s)) return "redirect:/login";
        int totalRevenue = transactionService.getTotalRevenue();
        int totalOrders = transactionService.getTotalOrders();
        double averageOrder = transactionService.getAverageOrder();
        int highestOrder = transactionService.getHighestOrder();

        m.addAttribute("totalRevenue", totalRevenue);
        m.addAttribute("totalOrders", totalOrders);
        m.addAttribute("averageOrder", averageOrder);
        m.addAttribute("highestOrder", highestOrder);
        return "admin/reports";
    }

    @GetMapping("/transactions")
    public String transactions(HttpSession s, Model m) {
        if (!isAdmin(s)) return "redirect:/login";
        m.addAttribute("transactions", transactionService.getAll());
        return "admin/transactions";
    }

    @PostMapping("/users/add")
    public String addUser(HttpSession s, @RequestParam String email, @RequestParam String password, @RequestParam String role) {
        if (!isAdmin(s)) return "redirect:/login";
        id.univ.uaspbo.model.User u = new id.univ.uaspbo.model.User();
        u.setEmail(email);
        u.setPassword(password);
        u.setRole(role.toUpperCase());
        userService.add(u);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/update-role")
    public String updateUserRole(HttpSession s, @RequestParam String email, @RequestParam String role) {
        if (!isAdmin(s)) return "redirect:/login";
        id.univ.uaspbo.model.User u = userService.findByEmail(email);
        if (u != null) {
            u.setRole(role.toUpperCase());
            userService.update(u);
        }
        return "redirect:/admin/users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(HttpSession s, @RequestParam String email) {
        if (!isAdmin(s)) return "redirect:/login";
        userService.delete(email);
        return "redirect:/admin/users";
    }

    @PostMapping("/save")
    public String saveData(HttpSession s) {
        if (!isAdmin(s)) return "redirect:/login";
        // Data sudah otomatis tersimpan oleh FileRepository, method ini hanya untuk force save
        return "redirect:/admin";
    }
    
    @PostMapping("/products/add")
    public String addProduct(HttpSession s,
                             @RequestParam String name,
                             @RequestParam int price,
                             @RequestParam int stock) {
        if (!isAdmin(s)) return "redirect:/login";
        id.univ.uaspbo.model.Product p = new id.univ.uaspbo.model.Product();
        p.setName(name);
        p.setPrice(price);
        p.setStock(stock);
        productService.add(p);
        return "redirect:/admin/products";
    }

    @PostMapping("/products/update")
    public String updateProduct(HttpSession s,
                                @RequestParam String id,
                                @RequestParam String name,
                                @RequestParam int price,
                                @RequestParam int stock) {
        if (!isAdmin(s)) return "redirect:/login";
        id.univ.uaspbo.model.Product p = productService.findById(id);
        if (p != null) {
            p.setName(name);
            p.setPrice(price);
            p.setStock(stock);
            productService.update(p);
        }
        return "redirect:/admin/products";
    }

    @PostMapping("/products/delete")
    public String deleteProduct(HttpSession s,
                                @RequestParam String id) {
        if (!isAdmin(s)) return "redirect:/login";
        productService.delete(id);
        return "redirect:/admin/products";
    }
}
