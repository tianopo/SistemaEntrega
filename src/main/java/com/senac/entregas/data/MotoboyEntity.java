package com.senac.entregas.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name="Motoboy")
public class MotoboyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message="Nome de cliente obrigatório")
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String moto;
    private String placa;
}
