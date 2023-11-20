package com.senac.entregas.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntregasController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("pagina", "pedidos");
        return "index";
    }

    @GetMapping("/motoboy")
    public String motoboy(Model model){
        model.addAttribute("pagina", "motoboy");
        return "index";
    }
    
    @GetMapping("/cliente")
    public String cliente(Model model){
        model.addAttribute("pagina", "cliente");
        return "index";
    }
}
