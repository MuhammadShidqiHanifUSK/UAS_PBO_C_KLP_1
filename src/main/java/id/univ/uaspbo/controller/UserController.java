package id.univ.uaspbo.controller;

import id.univ.uaspbo.model.Product;
import id.univ.uaspbo.model.Transaction;
import id.univ.uaspbo.model.User;
import id.univ.uaspbo.service.ProductService;
import id.univ.uaspbo.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final ProductService productService;
    private final TransactionService transactionService;

    public UserController(ProductService productService, TransactionService transactionService) {
        this.productService = productService;
        this.transactionService = transactionService;
    }

    private boolean isUser(HttpSession s) {
        var u = s.getAttribute("user");
        return u != null && ((User) u).getRole().equalsIgnoreCase("USER");
    }
    
    @GetMapping
    public String dashboard(HttpSession s, Model m,
                            @RequestParam(required = false) String search,
                            @RequestParam(required = false) String sort) {
        if (s.getAttribute("user") == null) return "redirect:/login";
        List<Product> products = productService.searchProducts(search);
        products = productService.sortProducts(products, sort);
        m.addAttribute("products", products);
        m.addAttribute("search", search);
        m.addAttribute("sort", sort);
        return "user/dashboard";
    }

    @PostMapping("/checkout")
    public String checkout(HttpSession s,
                           @RequestParam(name = "productId") String[] productIds,
                           @RequestParam(name = "qty") int[] qtys,
                           Model m) {
        var u = (User) s.getAttribute("user");
        if (u == null) return "redirect:/login";

        List<Transaction.TransactionItem> items = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < productIds.length; i++) {
            String pid = productIds[i];
            int q = qtys[i];
            if (q <= 0) continue;
            Product p = productService.findById(pid);
            if (p == null) continue;
            Transaction.TransactionItem it = new Transaction.TransactionItem(p.getId(), p.getName(), q, p.getPrice());
            items.add(it);
            total += p.getPrice() * q;
        }
        if (items.isEmpty()) {
            m.addAttribute("error", "Tidak ada item yang dipilih");
            m.addAttribute("products", productService.getAll());
            return "user/dashboard";
        }

        Transaction t = new Transaction();
        t.setUserId(u.getId());
        t.setItems(items);
        t.setTotal(total);
        transactionService.createTransaction(t);

        return "redirect:/user/history";
    }
    
    @GetMapping("/history")
    public String history(HttpSession s, Model m) {
        var u = (User) s.getAttribute("user");
        if (u == null) return "redirect:/login";
        m.addAttribute("transactions", transactionService.getByUserId(u.getId()));
        return "user/history";
    }
 }
