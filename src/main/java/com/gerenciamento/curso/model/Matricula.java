package com.gerenciamento.curso.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Embeddable
public class Matricula {

    @JsonView({MostreQuemTemATag.TagCadastrar.class, MostreQuemTemATag.TagListar.class, MostreQuemTemATag.TagBuscar.class, MostreQuemTemATag.TagCadastrarAlunoNoCurso.class, MostreQuemTemATag.TagCadastrarAv1.class, MostreQuemTemATag.TagCadastrarAv2.class})
    private long numero;

    @JsonView(MostreQuemTemATag.TagCadastrar.class)
    private boolean status;
}
