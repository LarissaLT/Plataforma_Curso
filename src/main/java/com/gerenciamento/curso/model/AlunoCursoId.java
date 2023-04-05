package com.gerenciamento.curso.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serial;
import java.io.Serializable;


public class AlunoCursoId implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long aluno;
    private Long curso;


    public Long getAluno() {
        return aluno;
    }

    public void setAluno(Long aluno) {
        this.aluno = aluno;
    }

    public Long getCurso() {
        return curso;
    }

    public void setCurso(Long curso) {
        this.curso = curso;
    }
}

