package com.example.brinquedos.controller;

import com.example.brinquedos.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Retorna a página login.html da pasta templates
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup"; // Retorna a página signup.html da pasta templates
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user) {
        // Aqui você adiciona a lógica de salvar o novo usuário no banco
        // Por enquanto, apenas redireciona para o login
        return "redirect:/login"; // Redireciona para a página de login após o cadastro
    }
}
