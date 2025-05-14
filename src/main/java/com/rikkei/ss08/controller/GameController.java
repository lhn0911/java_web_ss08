package com.rikkei.ss08.controller;

import com.rikkei.ss08.model.Player;
import com.rikkei.ss08.service.SeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {
    private List<Player> players = new ArrayList<>();

    @Autowired
    private SeedsService seedsService;

    @GetMapping("/game")
    public String home(HttpSession session) {
        if (session.getAttribute("player") == null) {
            return "redirect:/register";
        }
        return "Bai8910/home";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "Bai8910/register";
    }

    @PostMapping("/register")
    public String doRegister(Player player, Model model) {
        players.add(player);
        model.addAttribute("message", "Đăng ký thành công. Vui lòng đăng nhập.");
        return "Bai8910/login";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "Bai8910/login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {
        for (Player p : players) {
            if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                session.setAttribute("player", p);
                return "redirect:/";
            }
        }
        model.addAttribute("message", "Sai tài khoản hoặc mật khẩu!");
        return "Bai8910/login";
    }

    @GetMapping("/shop")
    public String showShop(Model model, HttpSession session) {
        if (session.getAttribute("player") == null) {
            return "redirect:/register";
        }
        model.addAttribute("seeds", seedsService.getAllSeeds());
        return "Bai8910/shop";
    }
}
