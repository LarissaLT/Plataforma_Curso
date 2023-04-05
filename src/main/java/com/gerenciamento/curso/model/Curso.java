package com.gerenciamento.curso.model;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({MostreQuemTemATag.TagCadastrar.class, MostreQuemTemATag.TagListar.class, MostreQuemTemATag.TagBuscar.class, MostreQuemTemATag.TagAtualizar.class})
    private Long id;

    @JsonView({MostreQuemTemATag.TagCadastrar.class, MostreQuemTemATag.TagCadastrarAlunoNoCurso.class, MostreQuemTemATag.TagListar.class, MostreQuemTemATag.TagBuscar.class, MostreQuemTemATag.TagAtualizar.class, MostreQuemTemATag.TagBuscarAlunoCurso.class, MostreQuemTemATag.TagBuscarNotaFinal.class})
    @Column(nullable = false)
    private String nome;

    @JsonView({MostreQuemTemATag.TagCadastrar.class, MostreQuemTemATag.TagListar.class, MostreQuemTemATag.TagBuscar.class, MostreQuemTemATag.TagAtualizar.class})
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    //@JsonView({MostreQuemTemATag.TagListar.class}) com isso causa recursao e stackoverflow
//    @OneToMany(mappedBy = "curso")
//    private List<AlunoCurso> alunosMatriculados = new ArrayList<>();


}
