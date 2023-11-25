package com.senac.entregas.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name="Pedido")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message="Nome de cliente obrigatório")
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private String motoboy;
    private String cliente;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String descricao;
}
