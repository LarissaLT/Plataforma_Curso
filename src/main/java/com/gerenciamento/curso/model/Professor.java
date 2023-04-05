package com.gerenciamento.curso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonView({MostreQuemTemATag.TagAtualizar.class})
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({MostreQuemTemATag.TagCadastrar.class, MostreQuemTemATag.TagBuscar.class, MostreQuemTemATag.TagAtualizar.class})
    private Long id;

    @JsonView({MostreQuemTemATag.TagCadastrar.class, MostreQuemTemATag.TagListar.class, MostreQuemTemATag.TagBuscar.class, MostreQuemTemATag.TagAtualizar.class})
    @Column(nullable = false)
    private String nome;
    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    @JsonView({MostreQuemTemATag.TagBuscar.class})
    private List<Curso> cursos = new ArrayList<>();

}
