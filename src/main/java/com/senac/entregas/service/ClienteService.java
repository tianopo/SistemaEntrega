package com.senac.entregas.service;

import com.senac.entregas.data.ClienteEntity;
import com.senac.entregas.data.ClienteRepository;
import com.senac.entregas.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    
    public ClienteEntity criarCliente(ClienteEntity cliente) {
        cliente.setId(null);
        clienteRepository.save(cliente);
        
        return cliente;
    }
    
    public ClienteEntity atualizarCliente(Integer clienteId, ClienteEntity clienteRequest) { 
        ClienteEntity cliente = getClienteId(clienteId); 
        cliente.setNome(clienteRequest.getNome()); 
        cliente.setCpf(clienteRequest.getCpf()); 
        cliente.setTelefone(clienteRequest.getTelefone());
        cliente.setLogradouro(clienteRequest.getLogradouro());
        cliente.setCep(clienteRequest.getCep());
        cliente.setNumero(clienteRequest.getNumero());
        cliente.setComplemento(clienteRequest.getComplemento());
        clienteRepository.save(cliente); 

        return cliente;
    }
    
    public ClienteEntity getClienteId(Integer clienteId) { 
        return clienteRepository.findById(clienteId).orElseThrow(() -> 
            new ResourceNotFoundException("Cliente não encontrada " + clienteId));
    } 

    public List<ClienteEntity> listarTodosClientes() { 
        return clienteRepository.findAll(); 
    } 

    public void deletarCliente(Integer clienteId) { 
        ClienteEntity cliente = getClienteId(clienteId); 
        clienteRepository.deleteById(cliente.getId()); 
    }
}
