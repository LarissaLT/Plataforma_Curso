package com.gerenciamento.curso.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@IdClass(AlunoCursoId.class)
public class AlunoCurso  {

    @Id
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    @JsonView({MostreQuemTemATag.TagCadastrarAlunoNoCurso.class, MostreQuemTemATag.TagCadastrarAv1.class, MostreQuemTemATag.TagBuscarNotaFinal.class})
    private Aluno aluno;

    @Id
    @ManyToOne
    @JoinColumn(name = "curso_id")
    @JsonView({MostreQuemTemATag.TagBuscarAlunoCurso.class, MostreQuemTemATag.TagCadastrarAlunoNoCurso.class, MostreQuemTemATag.TagBuscarNotaFinal.class})
    private Curso curso;

    @Embedded
    @JsonView({MostreQuemTemATag.TagCadastrarAv1.class, MostreQuemTemATag.TagCadastrarAv2.class, MostreQuemTemATag.TagBuscarNotaFinal.class})
    private Nota nota;

    private boolean aprovado;

}
