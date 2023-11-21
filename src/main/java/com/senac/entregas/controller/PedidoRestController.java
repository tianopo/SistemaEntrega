package com.senac.entregas.controller;

import com.senac.entregas.data.PedidoEntity;
import com.senac.entregas.service.PedidoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoRestController {
    @Autowired
    PedidoService pedidoService;

    @GetMapping("/listar")
    public ResponseEntity<List> getAllPedidos() {
        List<PedidoEntity> pedidos = pedidoService.listarTodosPedidos();

        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PedidoEntity> getPedidoById(@PathVariable Integer id) {
        PedidoEntity pedido = pedidoService.getPedidoId(id);

        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<PedidoEntity> addPedido(@Valid @RequestBody PedidoEntity pedido) {
        var novoPedido = pedidoService.criarPedido(pedido);

        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")

    public ResponseEntity<PedidoEntity> atualizarPedido(@Valid @PathVariable Integer id, @RequestBody PedidoEntity pedido) {
        var pedidoAtualizado = pedidoService.atualizarPedido(id, pedido);

        return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarPedido(@PathVariable Integer id) {
        pedidoService.deletarPedido(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
