package com.senac.entregas.service;

import com.senac.entregas.data.PedidoEntity;
import com.senac.entregas.data.PedidoRepository;
import com.senac.entregas.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;
    
    public PedidoEntity criarPedido(PedidoEntity pedido) {
        pedido.setId(null);
        pedidoRepository.save(pedido);
        
        return pedido;
    }
    
    public PedidoEntity atualizarPedido(Integer pedidoId, PedidoEntity pedidoRequest) { 
        PedidoEntity pedido = getPedidoId(pedidoId); 
        pedido.setNome(pedidoRequest.getNome()); 
        pedido.setData(pedidoRequest.getData());
        pedido.setMotoboy(pedidoRequest.getMotoboy());
        pedido.setCliente(pedidoRequest.getCliente());
        pedido.setLogradouro(pedidoRequest.getLogradouro());
        pedido.setCep(pedidoRequest.getCep());
        pedido.setNumero(pedidoRequest.getNumero());
        pedido.setDescricao(pedidoRequest.getDescricao());
        pedidoRepository.save(pedido); 

        return pedido;
    }
    
    public PedidoEntity getPedidoId(Integer pedidoId) { 
        return pedidoRepository.findById(pedidoId).orElseThrow(() -> 
            new ResourceNotFoundException("Pedido não encontrada " + pedidoId));
    } 

    public List<PedidoEntity> listarTodosPedidos() { 
        return pedidoRepository.findAll(); 
    } 

    public void deletarPedido(Integer pedidoId) { 
        PedidoEntity pedido = getPedidoId(pedidoId); 
        pedidoRepository.deleteById(pedido.getId()); 
    }
}
