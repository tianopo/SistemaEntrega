package com.senac.entregas.controller;

import com.senac.entregas.service.MotoboyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MotoboyController {
    @Autowired
    MotoboyService motoboyService;
    
    @GetMapping("/motoboy")
    public String motoboy(Model model){
        model.addAttribute("pagina", "motoboy");
        model.addAttribute("listarMotoboy", motoboyService.listarTodosMotoboys());
        return "index";
    }
}
