package com.gerenciamento.curso.service.event;

import com.gerenciamento.curso.model.Aluno;

public class AlunoCadastradoEvent {
    private Long id;
    private String nome;

    public AlunoCadastradoEvent(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
