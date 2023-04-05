package com.gerenciamento.curso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Aluno {

    @JsonView({MostreQuemTemATag.TagCadastrar.class, MostreQuemTemATag.TagListar.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonView({MostreQuemTemATag.TagCadastrar.class, MostreQuemTemATag.TagListar.class, MostreQuemTemATag.TagBuscar.class, MostreQuemTemATag.TagAtualizar.class, MostreQuemTemATag.TagCadastrarAlunoNoCurso.class, MostreQuemTemATag.TagBuscarNotaFinal.class})
    private String nome;

    @JsonView({MostreQuemTemATag.TagCadastrar.class, MostreQuemTemATag.TagListar.class, MostreQuemTemATag.TagBuscar.class, MostreQuemTemATag.TagCadastrarAlunoNoCurso.class, MostreQuemTemATag.TagCadastrarAv1.class, MostreQuemTemATag.TagCadastrarAv2.class})
    @Embedded
    private Matricula matricula;

    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<AlunoCurso> cursos = new ArrayList<>();

    //    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonView({MostreQuemTemATag.TagAtualizar.class, MostreQuemTemATag.TagBuscar.class})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToMany
    @JoinTable(name = "aluno_historico",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "historico_id"))
    private List<Curso> historico = new ArrayList<>();

}