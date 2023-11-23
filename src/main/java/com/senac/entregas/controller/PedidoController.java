package com.senac.entregas.controller;

import com.senac.entregas.data.PedidoEntity;
import com.senac.entregas.service.ClienteService;
import com.senac.entregas.service.MotoboyService;
import com.senac.entregas.service.PedidoService;
import com.senac.entregas.service.PedidoService;
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
public class PedidoController {
    @Autowired
    PedidoService pedidoService;
    
    @Autowired
    ClienteService clienteService;
    
    @Autowired
    MotoboyService motoboyService;
    
    @GetMapping("/pedido")
    public String pedido(Model model){
        //index indica a página
        model.addAttribute("pagina", "pedido");
        //lista os pedidos
        model.addAttribute("listarPedido", pedidoService.listarTodosPedidos());
        //lista os clientes
        model.addAttribute("listarCliente", clienteService.listarTodosClientes());
        //lista os motoboys
        model.addAttribute("listarMotoboy", motoboyService.listarTodosMotoboys());
        //adiciona entidade pedido
        PedidoEntity pedido = new PedidoEntity();
        model.addAttribute("pedido", pedido);

        return "index";
    }
    
    @GetMapping("/deletarPedido/{id}")
    public String deletarPedido(@PathVariable(value = "id") Integer id) {
        pedidoService.deletarPedido(id);
        return "redirect:/pedido";
    }

    @PostMapping("/salvarPedido")
    public String salvarPedido(@Valid @ModelAttribute("pedido") PedidoEntity pedido, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        if (pedido.getId() == null) {
            pedidoService.criarPedido(pedido);
        } else {
            pedidoService.atualizarPedido(pedido.getId(), pedido);
        }
        return "redirect:/pedido";
    }

    @GetMapping("/atualizarPedidoForm/{id}")
    public String atualizarPedidoForm(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("pagina", "pedidoAtualizar");
        PedidoEntity pedido = pedidoService.getPedidoId(id);
        model.addAttribute("pedido", pedido);

        return "index";
    }
}
