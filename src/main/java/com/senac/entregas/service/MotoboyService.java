package com.senac.entregas.service;

import com.senac.entregas.data.MotoboyEntity;
import com.senac.entregas.data.MotoboyRepository;
import com.senac.entregas.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import java.util.List;

@Service
public class MotoboyService {
    @Autowired
    MotoboyRepository motoboyRepository;
    
    public MotoboyEntity criarMotoboy(MotoboyEntity motoboy) {
        motoboy.setId(null);
        motoboyRepository.save(motoboy);
        
        return motoboy;
    }
    
    public MotoboyEntity atualizarMotoboy(Integer motoboyId, MotoboyEntity motoboyRequest) { 
        MotoboyEntity motoboy = getMotoboyId(motoboyId); 
        motoboy.setNome(motoboyRequest.getNome()); 
        motoboy.setCpf(motoboyRequest.getCpf());
        motoboy.setDataNascimento(motoboyRequest.getDataNascimento());
        motoboy.setTelefone(motoboyRequest.getTelefone());
        motoboy.setMoto(motoboyRequest.getMoto());
        motoboy.setPlaca(motoboyRequest.getPlaca());
        motoboyRepository.save(motoboy); 

        return motoboy;
    }
    
    public MotoboyEntity getMotoboyId(Integer motoboyId) { 
        return motoboyRepository.findById(motoboyId).orElseThrow(() -> 
            new ResourceNotFoundException("Motoboy não encontrada " + motoboyId));
    } 

    public List<MotoboyEntity> listarTodosMotoboys() { 
        return motoboyRepository.findAll(); 
    } 

    public void deletarMotoboy(Integer motoboyId) { 
        MotoboyEntity motoboy = getMotoboyId(motoboyId); 
        motoboyRepository.deleteById(motoboy.getId()); 
    }
}
