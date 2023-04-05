package com.gerenciamento.curso.notification;

import com.gerenciamento.curso.model.Aluno;
import org.springframework.stereotype.Component;


public interface Notificador {

    void notificar(Aluno aluno, String mensagem);
}
