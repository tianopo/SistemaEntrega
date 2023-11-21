package com.senac.entregas.controller;

import com.senac.entregas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PedidoController {
    @Autowired
    PedidoService pedidoService;
    
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("pagina", "pedidos");
        return "index";
    }
}
