package com.senac.entregas.controller;

import com.senac.entregas.data.MotoboyEntity;
import com.senac.entregas.service.MotoboyService;
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
@RequestMapping("/motoboy")
public class MotoboyRestController {
    @Autowired
    MotoboyService motoboyService;

    @GetMapping("/listar")
    public ResponseEntity<List> getAllMotoboys() {
        List<MotoboyEntity> motoboys = motoboyService.listarTodosMotoboys();

        return new ResponseEntity<>(motoboys, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<MotoboyEntity> getMotoboyById(@PathVariable Integer id) {
        MotoboyEntity motoboy = motoboyService.getMotoboyId(id);

        return new ResponseEntity<>(motoboy, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<MotoboyEntity> addMotoboy(@Valid @RequestBody MotoboyEntity motoboy) {
        var novoMotoboy = motoboyService.criarMotoboy(motoboy);

        return new ResponseEntity<>(novoMotoboy, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")

    public ResponseEntity<MotoboyEntity> atualizarMotoboy(@Valid @PathVariable Integer id, @RequestBody MotoboyEntity motoboy) {
        var motoboyAtualizado = motoboyService.atualizarMotoboy(id, motoboy);

        return new ResponseEntity<>(motoboyAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarMotoboy(@PathVariable Integer id) {
        motoboyService.deletarMotoboy(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
