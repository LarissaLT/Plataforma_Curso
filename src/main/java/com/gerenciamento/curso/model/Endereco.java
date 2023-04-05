package com.gerenciamento.curso.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@JsonView({MostreQuemTemATag.TagAtualizar.class, MostreQuemTemATag.TagBuscar.class})
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long cep;
    private String rua;
    private long numero;
    private String complemento;

}
