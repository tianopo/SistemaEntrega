package com.senac.entregas.controller;

import com.senac.entregas.data.MotoboyEntity;
import com.senac.entregas.service.MotoboyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MotoboyController {
    @Autowired
    MotoboyService motoboyService;
    
    @GetMapping("/motoboy")
    public String motoboy(Model model){
        //index indica a página
        model.addAttribute("pagina", "motoboy");
        //lista os motoboys
        model.addAttribute("listarMotoboy", motoboyService.listarTodosMotoboys());
        //adiciona entidade motoboy
        MotoboyEntity motoboy = new MotoboyEntity();
        model.addAttribute("motoboy", motoboy);

        return "index";
    }
    
    @GetMapping("/deletarMotoboy/{id}")
    public String deletarMotoboy(@PathVariable(value = "id") Integer id) {
        motoboyService.deletarMotoboy(id);
        return "redirect:/motoboy";
    }

    @PostMapping("/salvarMotoboy")
    public String salvarMotoboy(@Valid @ModelAttribute("motoboy") MotoboyEntity motoboy, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        if (motoboy.getId() == null) {
            motoboyService.criarMotoboy(motoboy);
        } else {
            motoboyService.atualizarMotoboy(motoboy.getId(), motoboy);
        }
        return "redirect:/motoboy";
    }

    @GetMapping("/atualizarMotoboyForm/{id}")
    public String atualizarMotoboyForm(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("pagina", "motoboyAtualizar");
        MotoboyEntity motoboy = motoboyService.getMotoboyId(id);
        model.addAttribute("motoboy", motoboy);

        return "index";
    }
}
