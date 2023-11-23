package com.senac.entregas.controller;

import com.senac.entregas.data.ClienteEntity;
import com.senac.entregas.service.ClienteService;
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
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/cliente")
    public String cliente(Model model){
        //index indica a página
        model.addAttribute("pagina", "cliente");
        //lista os clientes
        model.addAttribute("listarCliente", clienteService.listarTodosClientes());
        //adiciona entidade cliente
        ClienteEntity cliente = new ClienteEntity();
        model.addAttribute("cliente", cliente);

        return "index";
    }
    
    @GetMapping("/deletarCliente/{id}")
    public String deletarCliente(@PathVariable(value = "id") Integer id) {
        clienteService.deletarCliente(id);
        return "redirect:/cliente";
    }

    @PostMapping("/salvarCliente")
    public String salvarCliente(@Valid @ModelAttribute("cliente") ClienteEntity cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        if (cliente.getId() == null) {
            clienteService.criarCliente(cliente);
        } else {
            clienteService.atualizarCliente(cliente.getId(), cliente);
        }
        return "redirect:/cliente";
    }

    @GetMapping("/atualizarClienteForm/{id}")
    public String atualizarClienteForm(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("pagina", "clienteAtualizar");
        ClienteEntity cliente = clienteService.getClienteId(id);
        model.addAttribute("cliente", cliente);

        return "index";
    }
}
