package com.senac.entregas.controller;

import com.senac.entregas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/cliente")
    public String cliente(Model model){
        model.addAttribute("pagina", "cliente");
        return "index";
    }
}
