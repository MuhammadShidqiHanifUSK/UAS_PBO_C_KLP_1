package id.univ.uaspbo.controller;

import id.univ.uaspbo.model.User;
import id.univ.uaspbo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) { this.userService = userService; }

    @GetMapping({"/", "/login"})
    public String loginPage() { return "login"; }

    @PostMapping("/login")
    public String doLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model m) {
        User u = userService.authenticate(email, password);
        if (u == null) {
            m.addAttribute("error", "Login gagal: email atau password salah");
            return "login";
        }
        session.setAttribute("user", u);
        if ("ADMIN".equalsIgnoreCase(u.getRole())) return "redirect:/admin";
        return "redirect:/user";
    }

    @PostMapping("/logout")
    public String logout(HttpSession s) {
        s.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    
    @PostMapping("/register")
    public String doRegister(@RequestParam String email, @RequestParam String password,
                           @RequestParam String confirmPassword, Model m) {
        if (!password.equals(confirmPassword)) {
            m.addAttribute("error", "Password dan konfirmasi password tidak cocok");
            return "register";
        }

        if (userService.registerUser(email, password)) {
            m.addAttribute("success", "Registrasi berhasil! Silakan login.");
            return "login";
        } else {
            m.addAttribute("error", "Email sudah terdaftar");
            return "register";
        }
    }
}
